package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.DeviceDAO;
import com.zhuyin.gxj.dao.PlayerDAO;
import com.zhuyin.gxj.entity.*;
import com.zhuyin.gxj.entity.Timer;
import com.zhuyin.gxj.service.PlayerService;
import com.zhuyin.gxj.utils.TaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Tom on 16/7/25.
 */
@Service("playService")
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private PlayerDAO playerDAO;

    public static void main(String[] args) {

        String strBegin = "60:50:19";
        String strEnd = "00:10:22";
        TaskUtil.getTaskEndTime(strBegin, strEnd);
    }

    @Override
    public PlayListInfoBean getPlayListInfo(String mac) {

        String deviceId = deviceDAO.getDeviceIdByMAC(mac);
        List<PlayItemBean> items = playerDAO.getPlayListItems(deviceId);

        PlayListBean playListBean = new PlayListBean();
        playListBean.setId(deviceId);
        playListBean.getMusics().addAll(items);

        List<PlayListBean> playList = new ArrayList<PlayListBean>();
        playList.add(playListBean);

        PlayListInfoBean pliBean = new PlayListInfoBean();
        pliBean.getClassItems().addAll(playList);
        pliBean.setFileType("0");
        return pliBean;
    }

    @Override
    public PlayListInfoBean getCornList(String mac) {
        PlayListInfoBean pliBean = new PlayListInfoBean();
        String deviceId = deviceDAO.getDeviceIdByMAC(mac);
        List<Map<String, String>> tasks = playerDAO.getPlayTasks(deviceId);
        List<PlayListBean> playList = new ArrayList<PlayListBean>();
        for (Map<String, String> task : tasks) {
            PlayListBean playListBean = new PlayListBean();
            String id = String.valueOf(task.get("id"));
            String begin = String.valueOf(task.get("begin"));
            String weekDay = task.get("weekDay");
            List<PlayItemBean> items = playerDAO.getCornPlayItems(id);
            String taskDuration = playerDAO.getTaskDuration(id);
            String endTime = TaskUtil.getTaskEndTime(begin, taskDuration);
            playListBean.setId(id);
            playListBean.getMusics().addAll(items);

            String[] weekDayArr = weekDay.split(",");
            List<Timer> timers = new ArrayList<Timer>();
            for (String day : weekDayArr) {
                Timer timer = new Timer();
                timer.setBgTime(begin);
                timer.setEndTime(endTime);
                timer.setWeekDay(day);
                timers.add(timer);
            }
            if (timers.size() > 0) {
                playListBean.setTimers(timers);
            }

            playList.add(playListBean);

        }
        pliBean.getClassItems().addAll(playList);
        pliBean.setFileType("1");
        return pliBean;
    }
}
