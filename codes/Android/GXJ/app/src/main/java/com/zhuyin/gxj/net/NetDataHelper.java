package com.zhuyin.gxj.net;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zhuyin.gxj.entity.Audio;
import com.zhuyin.gxj.entity.Cata;
import com.zhuyin.gxj.entity.Course;
import com.zhuyin.gxj.utils.JSONUtil;
import com.zhuyin.gxj.utils.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Tom on 16/7/14.
 */
public class NetDataHelper {
    static final String TAG = NetDataHelper.class.getSimpleName();
    private static String baseUrl = "http://120.25.195.8:8088";

    public static List<Course> getRecommendList(String userToken, String page, String pageSize) {
        String params = buildParams(userToken, page, pageSize, "");
        params = URLEncoder.encode(params);
        String rstJson = NetUtils.doGet(baseUrl + "/app/recommendList", params);
        if (StringUtil.isNotEmpty(rstJson)) {
            return getCourses(rstJson);
        } else {
            return null;
        }

    }

    public static List<Course> getHotList(String userToken, String page, String pageSize) {
        String params = buildParams(userToken, page, pageSize, "");
        params = URLEncoder.encode(params);
        String rstJson = NetUtils.doGet(baseUrl + "/app/hotList", params);
        if (StringUtil.isNotEmpty(rstJson)) {
            return getCourses(rstJson);
        } else {
            return null;
        }
    }


    public static List<Course> getNewestList(String userToken, String page, String pageSize) {
        String params = buildParams(userToken, page, pageSize, "");
        params = URLEncoder.encode(params);
        String rstJson = NetUtils.doGet(baseUrl + "/app/newestList", params);
        if (StringUtil.isNotEmpty(rstJson)) {
            return getCourses(rstJson);
        } else {
            return null;
        }
    }

    public static List<Course> search(String userToken, String page, String pageSize, String key) {
        String params = buildParams(userToken, page, pageSize, key);
        params = URLEncoder.encode(params);
        String rstJson = NetUtils.doGet(baseUrl + "/app/search", params);
        if (StringUtil.isNotEmpty(rstJson)) {
            return getCourses(rstJson);
        } else {
            return null;
        }
    }


    public static List<Course> getCourseList(String page, String pageSize, String cataId) {
        String params = buildParams("", page, pageSize, "", cataId);
        params = URLEncoder.encode(params);
        String rstJson = NetUtils.doGet(baseUrl + "/app/courseList", params);
        if (StringUtil.isNotEmpty(rstJson)) {
            return getCourses(rstJson);
        } else {
            return null;
        }
    }

    public static List<Cata> getCataList() {
        String rstJson = NetUtils.doGet(baseUrl + "/app/cataList", "");
        try {
            JSONObject jsonObject = new JSONObject(rstJson);
            int errCode = JSONUtil.getInt(jsonObject, "errCode");
            if (errCode == 0) {
                JSONArray jsonArray = JSONUtil.getJSONArray(jsonObject, "list");
                List<Cata> list = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject cataJson = JSONUtil.getJSONObject(jsonArray, i);
                    Cata c = new Cata();
                    c.id = JSONUtil.getString(cataJson, "id");
                    c.name = JSONUtil.getString(cataJson, "name");
                    c.path = JSONUtil.getString(cataJson, "path");
                    list.add(c);
                }

                return list;
            }
        } catch (JSONException e) {
            Log.e(TAG, rstJson, e);
        }
        return null;
    }

    @Nullable
    private static List<Course> getCourses(String rstJson) {
        try {
            JSONObject jsonObject = new JSONObject(rstJson);
            int errCode = JSONUtil.getInt(jsonObject, "errCode");
            if (errCode == 0) {
                JSONArray jsonArray = JSONUtil.getJSONArray(jsonObject, "list");
                List<Course> list = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject courseJSON = JSONUtil.getJSONObject(jsonArray, i);
                    Course c = new Course();
                    c.id = JSONUtil.getString(courseJSON, "id");
                    c.age_max = JSONUtil.getString(courseJSON, "age_max");
                    c.age_min = JSONUtil.getString(courseJSON, "age_min");
                    c.collect = JSONUtil.getString(courseJSON, "collect");
                    c.create_time = JSONUtil.getString(courseJSON, "create_time");
                    c.describe = JSONUtil.getString(courseJSON, "describe");
                    c.icon = JSONUtil.getString(courseJSON, "icon");
                    c.name = JSONUtil.getString(courseJSON, "name");
                    c.shares = JSONUtil.getString(courseJSON, "shares");
                    c.status = JSONUtil.getString(courseJSON, "status");
                    c.times = JSONUtil.getString(courseJSON, "times");
                    list.add(c);
                }
                return list;
            }
        } catch (JSONException e) {
            Log.e(TAG, rstJson, e);
        }
        return null;
    }

    public static String addDevice(@NonNull String userToken, @NonNull String sn, @NonNull String name, @NonNull String cityId, @NonNull String birthDay) {
        JSONObject json = new JSONObject();
        try {
            json.put("userToken", userToken).put("sn", sn).put("name", name).put("cityId", cityId).put("birthDay", birthDay);
            String rst= NetUtils.doPost(baseUrl,json.toString());
            JSONObject rstJSON=new JSONObject(rst);
            return JSONUtil.getString(rstJSON,"errCode");
        } catch (JSONException e) {
            Log.e(TAG, json.toString(), e);
        }

        return "";
    }

    public static Map<String,Object> getAudioList(@NonNull String courseId){
        Map<String,Object> rst=new HashMap<>();
        String rstJson = NetUtils.doGet(baseUrl + "/app/audioList", "courseId="+courseId);
        try {
            JSONObject jsonObject = new JSONObject(rstJson);
            int errCode = JSONUtil.getInt(jsonObject, "errCode");
            if (errCode == 0) {
                rst.put("durationSum",JSONUtil.getString(jsonObject,"durationSum"));
                JSONArray jsonArray = JSONUtil.getJSONArray(jsonObject, "list");
                List<Audio> list = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject courseJSON = JSONUtil.getJSONObject(jsonArray, i);
                    Audio audio = new Audio();
                    audio.id = JSONUtil.getString(courseJSON, "id");
                    audio.name = JSONUtil.getString(courseJSON, "name");
                    audio.duration = JSONUtil.getString(courseJSON, "duration");
                    audio.path = JSONUtil.getString(courseJSON, "path");
                    list.add(audio);
                }
                rst.put("list",list);
            }
        } catch (JSONException e) {
            Log.e(TAG, rstJson, e);
        }

        return rst;
    }

    @NonNull
    private static String buildParams(String userToken, String page, String pageSize, String key) {
        return buildParams(userToken, page, pageSize, key, "");
    }

    @NonNull
    private static String buildParams(String userToken, String page, String pageSize, String key, String cataId) {
        String params = "";
        if (!StringUtil.isNotEmpty(userToken)) {
            params += "&userToken=" + userToken;
        }
        if (!StringUtil.isNotEmpty(page)) {
            params += "&page=" + page;
        }
        if (!StringUtil.isNotEmpty(pageSize)) {
            params += "&pageSize=" + pageSize;
        }
        if (!StringUtil.isNotEmpty(key)) {
            params += "&key=" + key;
        }
        if (!StringUtil.isNotEmpty(cataId)) {
            params += "&cataId=" + cataId;
        }
        params.replaceFirst("\\&", "?");
        return params;
    }

}
