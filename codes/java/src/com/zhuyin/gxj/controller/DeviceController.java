package com.zhuyin.gxj.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuyin.gxj.common.Common;
import com.zhuyin.gxj.entity.ResultBean;
import com.zhuyin.gxj.entity.ResultListBean;
import com.zhuyin.gxj.service.DeviceSerivce;
import com.zhuyin.gxj.service.UserService;

/**
 * Created by Tom on 16/7/10.
 */
@Controller
public class DeviceController {

	@Autowired
	UserService userService;

	@Autowired
	DeviceSerivce deviceSerivce;

	@RequestMapping("/user/addDevice")
	@ResponseBody
	public ResultBean bandDevice(@RequestBody Map<String, String> map) {
		ResultBean rb = new ResultBean();
		if (!map.containsKey("userToken") || !map.containsKey("sn")
				|| !map.containsKey("name") || !map.containsKey("cityId")
				|| !map.containsKey("birthDay")) {
			rb.setErrCode(Common.ERRCODE_COMMON);
			rb.setErrMsg("参数不全");
			return rb;
		}

		// String userToken=map.get("userToken");
		// if(userService.isExist(userToken)<=0){
		// rb.setErrCode(Common.ERRCODE_NEEDLOGIN);
		// rb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
		// return rb;
		// }
		//
		// String deviceSN=map.get("sn");
		// if(deviceSerivce.isExist(deviceSN)<=0){
		// rb.setErrCode(Common.ERRCODE_COMMON);
		// rb.setErrMsg("没有找到对应的音响设备信息");
		// return rb;
		// }

		int i = deviceSerivce.bandDevice(map);

		return rb;
	}

	
	@RequestMapping("/user/getMyDevices")
	@ResponseBody
	public ResultListBean getMyDevices(
			@RequestParam("userToken") String userToken) {
		ResultListBean rlb = new ResultListBean();
		if (StringUtils.isNotBlank(userToken)) {
			String userId = userService.getUserIdByToken(userToken);
			if (StringUtils.isNotBlank(userId)) {
				List<Map<String, String>> list = deviceSerivce
						.getDeviceList(userId);
				rlb.getList().addAll(list);
				rlb.setCnt(list.size());
				return rlb;
			}
		}
		rlb.setErrCode(Common.ERRCODE_NEEDLOGIN);
		rlb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
		return rlb;
	}
}
