package com.zhuyin.gxj.entity;

import java.io.Serializable;

public class DeviceRedisBean implements Serializable{

	private String deviceId;
	
	private String action;
	
	
	public enum ControlAction{
		play,pause,resume,stop
	}
}
