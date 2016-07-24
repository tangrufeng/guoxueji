package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.entity.ActionResultListBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Tom on 16/7/22.
 */
@Controller
public class PingController {

    public ActionResultListBean ping(@RequestParam("device_id") String deviceId,
                                     @RequestParam("sd_size") long sdSize,
                                     @RequestParam("sd_used") long sdUsed,
                                     @RequestParam("sd_state") int state,
                                     @RequestParam("net_ip") String ip,
                                     @RequestParam("net_gw") String gw,
                                     @RequestParam("net_dns") String dns,
                                     @RequestParam("net_mac") String mac,
                                     @RequestParam("fw_version") String fw_version,
                                     @RequestParam("rand") String rand) {
        return null;
    }
}
