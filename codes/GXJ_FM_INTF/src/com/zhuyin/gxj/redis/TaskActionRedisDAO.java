package com.zhuyin.gxj.redis;

import com.zhuyin.gxj.entity.ActionBean;
import com.zhuyin.gxj.entity.DeviceRedisBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository("taskActionRedisDAO")
public class TaskActionRedisDAO {
	private static final Logger logger= Logger.getLogger(TaskActionRedisDAO.class.getSimpleName());

	@Autowired
	RedisTemplate<String,DeviceRedisBean> redisTemplate;


    @Transactional
	public long addAction(String deviceId,String deviceSN,String actionId,String action){
		logger.info(
				"deviceSN = [" + deviceId + "], deviceSN = [" + deviceSN + "], actionId = [" + actionId + "], action =" +
						" [" + action + "]");
		ActionBean actionBean=new ActionBean();
		actionBean.setAction(action);
		actionBean.setId(actionId);


        DeviceRedisBean device=getDevice(deviceSN);
		if(device==null){
			device=new DeviceRedisBean();
			device.setDeviceId(deviceId);
			device.setDeviceSN(deviceSN);
		}else{
			redisTemplate.opsForSet().remove(deviceSN,device);
		}
        device.getActions().add(actionBean);
		logger.info(device);
		return redisTemplate.opsForSet().add(deviceSN,device);
	}



	public DeviceRedisBean getDevice(String deviceSN){
        Set<DeviceRedisBean> devices=redisTemplate.opsForSet().members(deviceSN);
        if(devices==null || devices.isEmpty()){
            return null;
        }else{
            return devices.iterator().next();
        }
	}

	public List<ActionBean> getDeviceAction(String deviceSN){
		logger.info("deviceSN = " + deviceSN);
		List<ActionBean> actions=new ArrayList<>();
		DeviceRedisBean device=getDevice(deviceSN);
		if(device!=null){
			actions.addAll(device.getActions());
			redisTemplate.opsForSet().remove(deviceSN,device);;
			device.setLastPingTime(System.currentTimeMillis());
			device.getActions().clear();
			redisTemplate.opsForSet().add(deviceSN,device);
		}
		return actions;
	}

	public void deleteAction(String deviceId,String actionId){
		redisTemplate.opsForSet().remove(deviceId, actionId);
	}
	
}
