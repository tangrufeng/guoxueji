package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.common.Common;
import com.zhuyin.gxj.entity.ResultBean;
import com.zhuyin.gxj.entity.ResultListBean;
import com.zhuyin.gxj.service.AudioService;
import com.zhuyin.gxj.service.DeviceSerivce;
import com.zhuyin.gxj.service.TaskService;
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
 * Created by Tom on 16/7/11.
 */
@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeviceSerivce deviceSerivce;

    @Autowired
    private AudioService audioService;

    @RequestMapping("/app/user/addPlayTask")
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

    @RequestMapping("/app/user/getPlayTaskList")
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
    
    @RequestMapping("/app/user/delTask")
    @ResponseBody
    public ResultBean delTask(@RequestBody Map<String,Object> params){
        ResultBean rb=new ResultBean();
        String userToken=String.valueOf(params.get("userToken"));
        String userId=userService.getUserIdByToken(userToken);
        if(StringUtils.isNotEmpty(userId)){
        	params.put("userId", userId);
            taskService.deleteTask(userId, String.valueOf(params.get("taskId")));
        }else{
        	rb.setErrCode(Common.ERRCODE_NEEDLOGIN);
        	rb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
        }
        
        return rb;
    }
    

    @RequestMapping("/app/user/delTaskAudio")
    @ResponseBody
    public ResultBean delTaskAudio(@RequestBody Map<String,Object> map){
    	ResultBean rb = new ResultBean();
		if (!map.containsKey("userToken") || !map.containsKey("taskId")|| !map.containsKey("music")) {
			rb.setErrCode(Common.ERRCODE_COMMON);
			rb.setErrMsg("参数不全");
			return rb;
		}
		String userToken = String.valueOf(map.get("userToken"));
		String userId = userService.getUserIdByToken(userToken);
		if (StringUtils.isEmpty(userId)) {
			rb.setErrCode(Common.ERRCODE_NEEDLOGIN);
			rb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
			return rb;
		}
		String taskId=String.valueOf(map.get("taskId"));
		List<Map<String,String>> musics=(List<Map<String, String>>) map.get("music");
		for(Map<String,String> m:musics){
			String id=m.get("id");
			taskService.deleteTaskAudio(taskId, id);
		}
		return rb;
    }


    @RequestMapping("/app/user/addPlayList")
    @ResponseBody
    public ResultBean addAudio(@RequestBody Map<String, Object> map) {
        ResultBean rb = new ResultBean();
        if (!map.containsKey("userToken") || !map.containsKey("deviceId")|| !map.containsKey("musics")) {
            rb.setErrCode(Common.ERRCODE_COMMON);
            rb.setErrMsg("参数不全");
            return rb;
        }
        String userToken = String.valueOf(map.get("userToken"));
        String userId = userService.getUserIdByToken(userToken);
        if (StringUtils.isEmpty(userId)) {
            rb.setErrCode(Common.ERRCODE_NEEDLOGIN);
            rb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
            return rb;
        }

        String deviceId = String.valueOf(map.get("deviceId"));
        String hasBand=deviceSerivce.hasBand(userId,deviceId);
        if(!StringUtils.equals(hasBand,"1")){
            rb.setErrCode(Common.ERRCODE_NEEDBAND);
            rb.setErrMsg(Common.ERRMSG_NEEDBAND);
            return rb;
        }

        List<Map<String,String>> musics=(List<Map<String, String>>) map.get("musics");
        List<Integer> audioIds=new ArrayList<>();
        for(Map<String,String> m:musics){
            String id=m.get("id");
            String type=m.get("type");
            if("1".equals(type)){
                audioIds.add(Integer.parseInt(id));
            }else if("2".equals(type)){
                List<Map<String,String>> audios=audioService.getAudioList(id);
                for(Map<String,String> a:audios){
                    audioIds.add(Integer.parseInt(String.valueOf(a.get("id"))));
                }
            }

        }
        taskService.addPlayList(Integer.parseInt(deviceId),audioIds);
        return rb;
    }
}
