package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.common.Common;
import com.zhuyin.gxj.entity.*;
import com.zhuyin.gxj.service.AudioService;
import com.zhuyin.gxj.service.DeviceSerivce;
import com.zhuyin.gxj.service.PlayerService;
import com.zhuyin.gxj.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/22.
 */
@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @RequestMapping("/player/getCornList")
    @ResponseBody
    public PlayListInfoBean getCornTaskInfo(@RequestParam("device_mac") String mac, @RequestParam("taskId") String taskId) {
        return playerService.getCornList(mac);
    }


    @RequestMapping("/player/getPlayList")
    @ResponseBody
    public PlayListInfoBean getPlayList(@RequestParam("device_mac") String mac) {
        return playerService.getPlayListInfo(mac);
    }



}
