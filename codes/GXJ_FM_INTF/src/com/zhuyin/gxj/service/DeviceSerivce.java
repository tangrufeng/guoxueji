package com.zhuyin.gxj.service;

import java.util.List;
import java.util.Map;

import com.zhuyin.gxj.entity.ActionBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Tom on 16/7/10.
 */
public interface DeviceSerivce {


    public int bandDevice(Map<String, String> params);

    public int isExist(String deviceSN);
    
    public String getDeviceIdBySN(String sn);
    
    public List<Map<String,String>> getDeviceList(String userId);
    
    public String hasBand(String userId,String deviceId);
    
    public int delDevice(String userId,String deviceId);

    public List<ActionBean> getDeviceAction(String deviceSN);
}
