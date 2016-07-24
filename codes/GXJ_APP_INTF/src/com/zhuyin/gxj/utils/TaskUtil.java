package com.zhuyin.gxj.utils;

import java.util.UUID;

/**
 * Created by Tom on 16/7/21.
 */
public class TaskUtil {

    public static String getTaskActionId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
