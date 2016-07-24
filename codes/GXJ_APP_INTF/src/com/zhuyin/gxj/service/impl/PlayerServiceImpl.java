package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.DeviceDAO;
import com.zhuyin.gxj.dao.PlayerDAO;
import com.zhuyin.gxj.entity.PlayListInfoBean;
import com.zhuyin.gxj.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/25.
 */
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    public PlayListInfoBean getPlayListInfo(String deviceSN) {
        String deviceId=deviceDAO.getDeviceIdBySN(deviceSN);
        List<Map<String,String>> tasks= playerDAO.getPlayTasks(deviceId);

        return null;
    }
}
