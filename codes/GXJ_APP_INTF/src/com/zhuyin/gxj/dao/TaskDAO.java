package com.zhuyin.gxj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository("taskDAO")
public interface TaskDAO {

	@Insert("insert into device_task (`tag`,`deviceId`,`weekday`,`begin`,`userId`,`createtime`,`updatetime`) values (#{tag},#{deviceId},#{weekDay},#{begin},#{userId},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'))")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public int addTask(Map<String,Object> params);

	@Insert("INSERT INTO `task_audio` ( `task_id`, `audio_id`) VALUES (#{task_id}, #{audio_id}) on DUPLICATE KEY UPDATE status = 0;")
	public int addTaskAudio(Map<String,String> params);

	@Select("select id,tag,weekday,begin from device_task where userId=#{userId} and deviceId=#{deviceId} and status=0")
	public List<Map<String,Object>> getPlayTaskList(@Param("userId") String userId, @Param("deviceId") String deviceId);

	@Select("SELECT c.id,c.name,c.path as url,c.duration  FROM audio c,task_audio t where c.id=t.audio_id and t" +
			".task_id=#{taskId} order by id")
	public List<Map<String,String>> getTaskAudio(String taskId);
	
	@Update("update device_task set status=1 where userId=#{userId} and id=#{taskId}")
	public int deleteTask(@Param("userId") String userId, @Param("taskId") String taskId);

	@Update("update task_audio set status=1 where task_id=#{taskId} and audio_id=#{audioId}")
	public int deleteTaskAudio(@Param("taskId") String taskId,@Param("audioId") String audioId);

	@InsertProvider(type = TaskSQL.class,method = "insertPlayList")
	@Options(flushCache =true, timeout =20000)
	public int addDevicePlayList(Map<String,Object> params);


	public class TaskSQL {
		public String insertPlayList(final Map<String,Object> params){
			List<Integer> audioIds=(List<Integer>)params.get("audioIds");
			Integer deviceId=(Integer)params.get("deviceId");
			StringBuilder sb=new StringBuilder("insert ignore into playlist_audio(audioId,deviceId) values");
			for(int audioId:audioIds){
				sb.append("("+audioId+","+deviceId+"),");
			}
			sb.deleteCharAt(sb.length()-1);
			return sb.toString();
		}

	}

}
