package com.zhuyin.gxj.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Tom on 16/7/21.
 */
@Repository
public interface DeviceActionDAO {

    @Insert("insert into decive_action (id,deviceId,action,taskId,createTime,updateTime) values(#{id},#{deviceId}," +
            "#{action},#{taskId},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'))")
    public int addDeviceAction(Map<String,String> map);

    @Update("update decive_action set status=#{status},updateTime=DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s') where id=#{actionId}")
    public int updateActionStatus(Map<String,String> map);
}
