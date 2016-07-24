package com.zhuyin.gxj.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 16/7/22.
 */
public class ActionBean implements Serializable{

    private String action;

    private String id;

    private List<Object> params=new ArrayList<>();

    @Override
    public String toString() {
        return "ActionBean{" +
                "action='" + action + '\'' +
                ", id='" + id + '\'' +
                ", params=" + params +
                '}';
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }
}
