package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.common.Common;
import com.zhuyin.gxj.entity.*;
import com.zhuyin.gxj.service.DeviceActionService;
import com.zhuyin.gxj.service.DeviceSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/22.
 */
@Controller
public class PingController {

    @Autowired
    DeviceSerivce deviceSerivce;

    @Autowired
    DeviceActionService deviceActionService;

    @RequestMapping("/rest/ping")
    @ResponseBody
    public ActionResultListBean ping(@RequestParam("device_mac") String deviceMAC,
                                     @RequestParam(value = "sd_size",required = false) Long sdSize,
                                     @RequestParam(value = "sd_used",required = false) Long sdUsed,
                                     @RequestParam(value = "sd_state",required = false) Integer state,
                                     @RequestParam(value = "net_ip",required = false) String ip,
                                     @RequestParam(value = "net_gw",required = false) String gw,
                                     @RequestParam(value = "net_dns",required = false) String dns,
                                     @RequestParam(value = "fw_version",required = false) String fw_version,
                                     @RequestParam("rand") String rand) {

        ActionResultListBean arlb = new ActionResultListBean();

        DeviceRedisBean drb = new DeviceRedisBean();
        drb.setDeviceSN(deviceMAC);
        drb.setSdSize(sdSize==null?0l:sdSize.longValue());
        drb.setSdUsed(sdUsed==null?0l:sdUsed.longValue());
        drb.setState(state==null?-1:state.intValue());
        drb.setIp(ip);
        drb.setGw(gw);
        drb.setDns(dns);
        drb.setMac(deviceMAC);
        drb.setVersion(fw_version);
        drb.setLastPingTime(System.currentTimeMillis());
        List<ActionBean> actions = deviceSerivce.getDeviceAction(drb);
        arlb.getActions().addAll(actions);
        arlb.setTimestamp(System.currentTimeMillis());
        return arlb;
    }

    @RequestMapping("/rest/receipt")
    @ResponseBody
    public ResultBean receipt(@RequestParam("action_id") String actionId,
                              @RequestParam("type") int status,
                              @RequestParam("device_mac")String mac){
        ResultBean rb=new ResultBean();
        if(status!=1 && status!=2){
            rb.setErrCode(Common.ERRCODE_COMMON);
            rb.setErrMsg("参数有误");
        }

        Map<String,String> params=new HashMap<>();
        params.put("actionId",actionId);
        params.put("status",""+status);
        deviceActionService.updateActionStatus(params);
        return rb;
    }
}
