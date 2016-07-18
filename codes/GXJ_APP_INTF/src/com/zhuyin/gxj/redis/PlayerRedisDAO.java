package com.zhuyin.gxj.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository("playerRedisDAO")
public class PlayerRedisDAO {

	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	public void control(String action,String deviceId){
//		redisTemplate.d
	}
}
