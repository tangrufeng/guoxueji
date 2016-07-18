package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.DeviceDAO;
import com.zhuyin.gxj.service.DeviceSerivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/10.
 */
@Service("deviceService")
public class DeviceServiceImpl implements DeviceSerivce {

    @Autowired
    DeviceDAO deviceDAO;

    @Override
    public int bandDevice(Map<String, String> params) {
        return deviceDAO.bandDevice(params);
    }

    @Override
    public int isExist(String deviceSN) {
        return deviceDAO.isExist(deviceSN);
    }

	@Override
	public List<Map<String, String>> getDeviceList(String userId) {
		return deviceDAO.getDeviceList(userId);
	}

	@Override
	public String getDeviceIdBySN(String sn) {
		return deviceDAO.getDeviceIdBySN(sn);
	}

	@Override
	public String hasBand(String userId, String deviceId) {
		return deviceDAO.hasBand(userId, deviceId);
	}

	@Override
	public int delDevice(String userId, String deviceId) {
		return deviceDAO.delDevice(userId, deviceId);
	}

	
}
