package com.zhuyin.gxj.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/10.
 */
public interface DeviceSerivce {


    public int bandDevice(Map<String, String> params);

    public int isExist(String deviceSN);
    
    public List<Map<String,String>> getDeviceList(String userId);
}
