package com.zhuyin.gxj.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhuyin.gxj.entity.ActionBean;
import com.zhuyin.gxj.entity.DeviceRedisBean;
import com.zhuyin.gxj.utils.DeviceActionEnum;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("taskActionRedisDAO")
public class TaskActionRedisDAO {
	private static final Logger logger = Logger
			.getLogger(TaskActionRedisDAO.class.getSimpleName());

	@Autowired
	RedisTemplate<String, DeviceRedisBean> redisTemplate;
	
	public long addAction(String deviceId, String deviceSN, String actionId,
			String action) {
		return addAction(deviceId, deviceSN, actionId, action);
	}
	
	@Transactional
	public long addAction(String deviceId, String deviceSN, String actionId,
			String action, Map<String, String> params) {
		logger.info("deviceSN = [" + deviceId + "], deviceSN = [" + deviceSN
				+ "], actionId = [" + actionId + "], action =" + " [" + action
				+ "],params=["+params+"]");
		ActionBean actionBean = new ActionBean();
		actionBean.setAction(action);
		actionBean.setId(actionId);
		if (params != null && !params.isEmpty()) {
			actionBean.getParams().putAll(params);
		}

		DeviceRedisBean device = getDevice(deviceSN);
		if (device == null) {
			device = new DeviceRedisBean();
			device.setDeviceId(deviceId);
			device.setDeviceSN(deviceSN);
		} else {
			redisTemplate.opsForSet().remove(deviceSN, device);
		}
		if (device.getActions().indexOf(actionBean) != -1) {
			device.getActions().remove(actionBean);
		}
		device.getActions().add(actionBean);
		logger.info(device);
		return redisTemplate.opsForSet().add(deviceSN, device);
	}

	public DeviceRedisBean getDevice(String deviceSN) {
		Set<DeviceRedisBean> devices = redisTemplate.opsForSet().members(
				deviceSN);
		if (devices == null || devices.isEmpty()) {
			return null;
		} else {
			return devices.iterator().next();
		}
	}

	public List<ActionBean> getDeviceAction(DeviceRedisBean newDevice) {
		logger.info("newDevice = " + newDevice);
		List<ActionBean> actions = new ArrayList<ActionBean>();
		DeviceRedisBean device = getDevice(newDevice.getDeviceSN());
		if (device != null) {
			actions.addAll(device.getActions());
			redisTemplate.opsForSet().remove(newDevice.getDeviceSN(), device);
			BeanUtils.copyProperties(newDevice, device);
			device.setLastPingTime(System.currentTimeMillis());
			redisTemplate.opsForSet().add(newDevice.getDeviceSN(), device);
		}
		return actions;
	}

	public void deleteAction(String deviceId, String actionId) {
		redisTemplate.opsForSet().remove(deviceId, actionId);
	}

}
