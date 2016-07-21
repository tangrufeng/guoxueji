package com.zhuyin.gxj.entity;

/**
 * Created by Tom on 16/7/14.
 */
public class Audio {
    public String id="";
    public String name="";
    public String duration="";
    public String path="";

    @Override
    public String toString() {
        return "Audio{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
