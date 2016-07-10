package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.UserDAO;
import com.zhuyin.gxj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Service("userService")
public class UserSerivceImpl implements UserService {

    @Autowired
    UserDAO userDAO=null;

    @Override
    public Map<String, String> getAgeFromBirthday(String userToken) {
        return userDAO.getAgeFromBirthday(userToken);
    }

    @Override
    public int isExist(String userToken) {
        return userDAO.isExist(userToken);
    }
}