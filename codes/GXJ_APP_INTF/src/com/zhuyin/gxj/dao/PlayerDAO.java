package com.zhuyin.gxj.dao;

import com.zhuyin.gxj.entity.PlayItemBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/25.
 */
@Repository
public interface PlayerDAO {


    @Select("SELECT a.id,a.name,a.duration,a.path FROM soundsystem.task_audio ta,audio a where ta.audio_id=a.id and ta.status=0 and task_id=#{taskId}")
    public List<PlayItemBean> getPlayItems(String taskId);

    @Select("select id,begin,weekDay from device_task where status=0")
    public List<Map<String,String>> getPlayTasks(String deviceId);

}
