package com.zhuyin.gxj.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Tom on 16/7/10.
 */
@Component("deviceDAO")
public interface DeviceDAO {

    @Insert("INSERT INTO `user_device_relation` (`userId`, `deviceSN`, `status`, `binding_time`, `birth_month`, " +
            "`name`) VALUES (#{userId}, #{deviceSN}, '1', DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'), #{birth_month}, " +
            "#{name},);")
    public int bandDevice(Map<String, String> params);

    @Select("select count(1) from device where device_number= #{deviceSN}")
    public int isExist(String deviceSN);
}
