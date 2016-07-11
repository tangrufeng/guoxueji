package com.zhuyin.gxj.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Component("userDAO")
public interface UserDAO {


    @Select("SELECT  convert(MAX(a.age),char(3)) AS maxAge, convert(MIN(a.age),char(3)) AS minAge FROM (SELECT  " +
            "DATE_FORMAT(FROM_DAYS(TO_DAYS(NOW()) - TO_DAYS(birth_month)), '%Y') + 0 AS age FROM user_device_relation" +
            " where userId=#{userId}) AS a")
    public Map<String, String> getAgeFromBirthday(String userId);

    @Select("select id from user_info where token=#{token}")
    public String getUserIdByToken(String token);
}
