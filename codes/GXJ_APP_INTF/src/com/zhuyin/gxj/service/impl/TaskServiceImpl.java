package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.DeviceActionDAO;
import com.zhuyin.gxj.dao.DeviceDAO;
import com.zhuyin.gxj.dao.TaskDAO;
import com.zhuyin.gxj.dao.UserDAO;
import com.zhuyin.gxj.redis.TaskActionRedisDAO;
import com.zhuyin.gxj.service.TaskService;
import com.zhuyin.gxj.utils.DeviceActionEnum;
import com.zhuyin.gxj.utils.TaskUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Tom on 16/7/11.
 */
@PropertySource("classpath:config/gxj.properties")
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    private final static Logger logger = Logger.getLogger(TaskService.class);

    @Autowired
    TaskDAO taskDAO;

    @Autowired
    TaskActionRedisDAO taskActionRedisDAO;

    @Autowired
    DeviceDAO deviceDAO;

    @Autowired
    DeviceActionDAO deviceActionDAO;

    @Autowired
    UserDAO userDAO;

    @Value("${cronjobListUrl}")
    String cronjobListUrl;

    @Value("${playListUrl}")
    String playListUrl;

    @Value("${pingInterval}")
    String pingInterval;


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    @Transactional
    public int addTask(Map<String, Object> params) {
        int i = taskDAO.addTask(params);
        if (i == 1) {
            long taskId = (Long) params.get("id");
            ArrayList<Map<String, String>> musics = (ArrayList<Map<String, String>>) params.get("musics");
            for (Map<String, String> music : musics) {
                music.put("task_id", taskId + "");
                taskDAO.addTaskAudio(music);
            }
            String deviceId=String.valueOf(params.get("deviceId"));
            String action = DeviceActionEnum.setCronJob.name();
            String mac=deviceDAO.getDeviceMACById(deviceId);

            String actionId = saveActionToDB(taskId, deviceId, action);
            
            cronjobListUrl=cronjobListUrl.replace("#(deviceMAC)", mac).replace("#(taskId)", String.valueOf(taskId));
            Map<String, String> p=new HashMap<String, String>();
            p.put("url", cronjobListUrl);
            taskActionRedisDAO.addAction(deviceId,mac,actionId, action,p);
        }
        return 0;
    }

    private String saveActionToDB(long taskId, String deviceId, String action) {
        String actionId= TaskUtil.getTaskActionId();
        Map<String,String> map=new HashMap<String,String>();
        map.put("id",actionId);
        map.put("deviceId",deviceId);
        map.put("taskId",String.valueOf(taskId));
        map.put("action", action);
        deviceActionDAO.addDeviceAction(map);
        return actionId;
    }

    @Override
    public List<Map<String, Object>> getPlayTaskList(String userId, String deviceId) {

        List<Map<String,Object>> list=taskDAO.getPlayTaskList(userId,deviceId);

        for(Map<String,Object> task:list){

            String taskId=String.valueOf(task.get("id"));
            List<Map<String,String>> musics =taskDAO.getTaskAudio(taskId);
            task.put("musics",musics);
        }

        return list;
    }

	@Override
	public int deleteTask(String userId, String taskId) {
		return taskDAO.deleteTask(userId, taskId);
	}

	@Override
	public int deleteTaskAudio(String taskId, String audioId) {
		return taskDAO.deleteTaskAudio(taskId, audioId);
	}


    @Override
    @Transactional
    public void addPlayList(int deviceId, List<Integer> audioIds) {
        Map<String,Object> params=new HashMap<>();
        params.put("deviceId",deviceId);
        params.put("audioIds",audioIds);
        taskDAO.addDevicePlayList(params);

        String strDeviceId=String.valueOf(deviceId);
        String action = DeviceActionEnum.play.name();
        String actionId=saveActionToDB(0l,strDeviceId,action);

        String mac=deviceDAO.getDeviceMACById(strDeviceId);
        playListUrl=playListUrl.replace("#(deviceMAC)", mac);
        Map<String, String> p=new HashMap<String, String>();
        p.put("url", playListUrl);
        taskActionRedisDAO.addAction(strDeviceId,mac,actionId, action,p);
    }

    @Override
    public void addSetPingInterval(String usrToken) {
        if(StringUtils.isEmpty(usrToken)){
            return;
        }

        String userId=userDAO.getUserIdByToken(usrToken);
        if(StringUtils.isEmpty(userId)){
            return ;
        }

        String action = DeviceActionEnum.setPingInterval.name();
        List<Map<String,String>> deivces=deviceDAO.getDeviceList(userId);
        for(Map<String,String> device:deivces){
            String id=String.valueOf(device.get("id"));
            String mac=device.get("mac");
            String actionId=saveActionToDB(0l,id,action);

            Map<String, String> p=new HashMap<String, String>();
            p.put("interval", pingInterval);
            taskActionRedisDAO.addAction(id,mac,actionId, action,p);
        }
    }

    public static void main(String[] args) {
        System.out.println(DeviceActionEnum.setCronJob.name());
    }
    
}
