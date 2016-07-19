package com.zhuyin.gxj.redis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository("taskActionRedisDAO")
public class TaskActionRedisDAO {

	@Autowired
	RedisTemplate redisTemplate;
	
	public void addAction(String deviceId,String actionId){
		redisTemplate.opsForSet().add(deviceId, actionId);
	}
	
	public Set<String> getActions(String deviceId){
		return redisTemplate.opsForSet().members(deviceId);
	}
	
	public void deleteAction(String deviceId,String actionId){
		redisTemplate.opsForSet().remove(deviceId, actionId);
	}
	
}
