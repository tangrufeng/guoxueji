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
            " where userId=#{userToken}) AS a")
    public Map<String, String> getAgeFromBirthday(String userToken);

    @Select("select count(1) from user_info where token=#{token}")
    public int isExist(String token);
}
