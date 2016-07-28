package com.zhuyin.gxj.dao;

import com.zhuyin.gxj.entity.PlayItemBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/25.
 */
@Repository
public interface PlayerDAO {


    @Select("SELECT a.id,a.name,a.duration,a.path as url FROM soundsystem.task_audio ta,audio a where ta.audio_id=a.id and ta.status=0 and task_id=#{taskId}")
    public List<PlayItemBean> getCornPlayItems(String taskId);

    @Select("SELECT SEC_TO_TIME(sum(TIME_TO_SEC(a.duration))) FROM soundsystem.task_audio ta,audio a where ta.audio_id=a.id and ta.status=0 and task_id=#{taskId}")
    public String getTaskDuration(String taskId);

    @Select("select id,begin,weekDay from device_task where status=0")
    public List<Map<String,String>> getPlayTasks(String deviceId);


    @Select("SELECT a.id,a.name,a.duration,a.path as url FROM soundsystem.playlist_audio pa,audio a where pa.audioId=a.id and pa.deviceId=#{deviceId}")
    public List<PlayItemBean> getPlayListItems(String deviceId);

    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("insert ignore into playlist_audio(audioId,deviceId) values");
        sb.deleteCharAt(sb.length()-1);
        System.out.println("args = [" + sb + "]");
    }
}
