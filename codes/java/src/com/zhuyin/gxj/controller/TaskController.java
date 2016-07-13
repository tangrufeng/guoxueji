package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.common.Common;
import com.zhuyin.gxj.entity.ResultBean;
import com.zhuyin.gxj.entity.ResultListBean;
import com.zhuyin.gxj.service.TaskService;
import com.zhuyin.gxj.service.UserService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/11.
 */
@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;
    
    @RequestMapping("/user/addPlayTask")
    @ResponseBody
    public ResultBean addPlayTask(@RequestBody Map<String,Object> params){
        ResultBean rb=new ResultBean();
        String userToken=String.valueOf(params.get("userToken"));
        String userId=userService.getUserIdByToken(userToken);
        if(StringUtils.isNotEmpty(userId)){
        	params.put("userId", userId);
            taskService.addTask(params);
        }else{
        	rb.setErrCode(Common.ERRCODE_NEEDLOGIN);
        	rb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
        }
        return rb;
    }

    @RequestMapping("/user/getPlayTaskList")
    @ResponseBody
    public ResultListBean getPlayTaskList(@RequestParam("userToken") String userToken,@RequestParam("deviceId")
            String deviceId){
        ResultListBean rlb=new ResultListBean();
        String userId=userService.getUserIdByToken(userToken);
        List<Map<String,Object>> list=taskService.getPlayTaskList(userId,deviceId);
        rlb.getList().addAll(list);
        rlb.setCnt(list.size());
        return rlb;
    }
}
