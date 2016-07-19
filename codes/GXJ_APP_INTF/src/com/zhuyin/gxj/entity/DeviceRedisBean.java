package com.zhuyin.gxj.entity;

import java.io.Serializable;

public class DeviceRedisBean implements Serializable{

	private String deviceId;
	
	private String action;
	
	private int status;
	
	private String actionId;
	
	
	public String getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getActionId() {
		return actionId;
	}


	public void setActionId(String actionId) {
		this.actionId = actionId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actionId == null) ? 0 : actionId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceRedisBean other = (DeviceRedisBean) obj;
		if (actionId == null) {
			if (other.actionId != null)
				return false;
		} else if (!actionId.equals(other.actionId))
			return false;
		return true;
	}


	public enum ControlAction{
		play,pause,resume,stop,setPingInterval
	}
}
