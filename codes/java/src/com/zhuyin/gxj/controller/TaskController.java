package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.entity.ResultBean;
import com.zhuyin.gxj.entity.ResultListBean;
import com.zhuyin.gxj.service.TaskService;
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

    @RequestMapping("/user/addPlayTask")
    @ResponseBody
    public ResultBean addPlayTask(@RequestBody Map<String,Object> params){
        ResultBean rb=new ResultBean();
        taskService.addTask(params);
        return rb;
    }

    @RequestMapping("/user/getPlayTaskList")
    public ResultListBean getPlayTaskList(@RequestParam("userToken") String userToken,@RequestParam("deviceId")
            String deviceId){
        ResultListBean rlb=new ResultListBean();
        List<Map<String,Object>> list=taskService.getPlayTaskList(userToken,deviceId);
        rlb.getList().addAll(list);
        rlb.setCnt(list.size());
        return rlb;
    }
}