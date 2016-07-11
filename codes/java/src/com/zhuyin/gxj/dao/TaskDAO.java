package com.zhuyin.gxj.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface TaskDAO {

	@Insert("insert into device_task (`tag`,`deviceId`,`begin`,`userId`,`createtime`,`updatetime`) values (#{tag},#{deviceId},#{begin},#{userId},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'))")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public int addTask(Map<String,String> params);
	
	public int addTaskAudio();
	
}
