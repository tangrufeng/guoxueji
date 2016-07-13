package com.zhuyin.gxj.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/10.
 */
@Component("deviceDAO")
public interface DeviceDAO {

    @Insert("INSERT INTO `user_device_relation` (`userId`, `deviceId`, `binding_time`, `birth_month`, " +
            "`name`,`city`) VALUES (#{userId}, #{deviceId}, DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'), #{birthDay}, " +
            "#{name},#{cityId});")
    public int bandDevice(Map<String, String> params);

    @Select("select count(1) from device where device_number= #{deviceSN}")
    public int isExist(String deviceSN);
    
    @Select("select d.id,d.device_number sn,udr.name,udr.birth_month as birthMonth,udr.city,c.city_id as cityId from city c,device d, user_device_relation udr where c.city_id=udr.city and d.id=udr.deviceId and udr.userId=#{userId}")
    public List<Map<String,String>> getDeviceList(String userId);
    

    @Select("select id from device where device_number= #{deviceSN}")
	public String getDeviceIdBySN(String sn);

    @Select("select 1 from user_device_relation where userId=#{userId} and deviceId=#{deviceId} limit 1")
	public String hasBand(@Param("userId") String userId,@Param("deviceId") String deviceId);
}
