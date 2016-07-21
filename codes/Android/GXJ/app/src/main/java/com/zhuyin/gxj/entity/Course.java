package com.zhuyin.gxj.entity;

/**
 * Created by Tom on 16/7/14.
 */
public class Course {
    public String id = "";
    public String name = "";
    public String create_time = "";
    public String status = "";
    public String describe = "";
    public String times = "";
    public String icon = "";
    public String age_max = "";
    public String age_min = "";
    public String shares = "";
    public String collect = "";

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", create_time='" + create_time + '\'' +
                ", status='" + status + '\'' +
                ", describe='" + describe + '\'' +
                ", times='" + times + '\'' +
                ", icon='" + icon + '\'' +
                ", age_max='" + age_max + '\'' +
                ", age_min='" + age_min + '\'' +
                ", shares='" + shares + '\'' +
                ", collect='" + collect + '\'' +
                '}';
    }
}
