package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.common.Common;
import com.zhuyin.gxj.dao.UserDAO;
import com.zhuyin.gxj.entity.ResultListBean;
import com.zhuyin.gxj.service.CourseService;
import com.zhuyin.gxj.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Controller
public class CourseController {

    private final static Logger logger = Logger.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @RequestMapping("/app/recommendList")
    @ResponseBody
    public ResultListBean getRecommendList(@RequestParam(value = "userToken", required = false) String userToken,
                                        @RequestParam(value = "page", required = false, defaultValue = Common
                                                .PAGE_DEFAULT) int page,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = Common
                                                .PAGESIZE_DEFAULT) int pageSize) {
        //TODO 完成推荐列表
        ResultListBean rsb = new ResultListBean();
        Map<String, String> params = new HashMap<String, String>();
        if (!StringUtils.isEmpty(userToken)) {
            Map<String, String> map = userService.getAgeFromBirthday(userToken);
            params.putAll(map);
        }
        params.put("page", String.valueOf(page));
        params.put("pageSize", String.valueOf(pageSize));
        List<Map<String, String>> list = courseService.getNewestList(params);
        logger.debug(list);
        rsb.getList().addAll(list);
        rsb.setCnt(list.size());

        return rsb;
    }



    @RequestMapping("/app/newestList")
    @ResponseBody
    public ResultListBean getNewestList(@RequestParam(value = "userToken", required = false) String userToken,
                                        @RequestParam(value = "page", required = false, defaultValue = Common
                                                .PAGE_DEFAULT) int page,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = Common
                                                .PAGESIZE_DEFAULT) int pageSize) {
        ResultListBean rsb = new ResultListBean();
        Map<String, String> params = new HashMap<String, String>();
        if (!StringUtils.isEmpty(userToken)) {
            Map<String, String> map = userService.getAgeFromBirthday(userToken);
            params.putAll(map);
        }
        params.put("page", String.valueOf(page));
        params.put("pageSize", String.valueOf(pageSize));
        List<Map<String, String>> list = courseService.getNewestList(params);
        logger.debug(list);
        rsb.getList().addAll(list);
        rsb.setCnt(list.size());

        return rsb;
    }


    @RequestMapping("/app/hotList")
    @ResponseBody
    public ResultListBean getHotList(@RequestParam(value = "userToken", required = false) String userToken,
                                        @RequestParam(value = "page", required = false, defaultValue = Common
                                                .PAGE_DEFAULT) int page,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = Common
                                                .PAGESIZE_DEFAULT) int pageSize) {
        ResultListBean rlb = new ResultListBean();
        Map<String, String> params = new HashMap<String, String>();
        if (!StringUtils.isEmpty(userToken)) {
            Map<String, String> map = userService.getAgeFromBirthday(userToken);
            params.putAll(map);
        }
        params.put("page", String.valueOf(page));
        params.put("pageSize", String.valueOf(pageSize));
        List<Map<String, String>> list = courseService.getHotList(params);
        logger.debug(list);
        rlb.getList().addAll(list);
        rlb.setCnt(list.size());

        return rlb;
    }

    @RequestMapping("/app/cataList")
    @ResponseBody
    public ResultListBean getHotList(){
        ResultListBean rlb = new ResultListBean();
        List<Map<String,String>> list = courseService.getCataList();
        rlb.getList().addAll(list);
        rlb.setCnt(list.size());
        return rlb;
    }


    @RequestMapping("/app/courseList")
    @ResponseBody
    public ResultListBean getCourseList(@RequestParam(value = "cataId", required = false) int cataId,
                                     @RequestParam(value = "page", required = false, defaultValue = Common
                                             .PAGE_DEFAULT) int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = Common
                                             .PAGESIZE_DEFAULT) int pageSize) {
        ResultListBean rlb = new ResultListBean();
        Map<String, String> params = new HashMap<String, String>();
        params.put("cataId",String.valueOf(cataId));
        params.put("page", String.valueOf(page));
        params.put("pageSize", String.valueOf(pageSize));
        List<Map<String, String>> list = courseService.getCourseList(params);
        logger.debug(list);
        rlb.getList().addAll(list);
        rlb.setCnt(list.size());

        return rlb;
    }


    @RequestMapping("/app/search")
    @ResponseBody
    public ResultListBean search(@RequestParam(value = "userToken", required = false) String userToken,
                                           @RequestParam(value = "page", required = false, defaultValue = Common
                                                   .PAGE_DEFAULT) int page,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = Common
                                                   .PAGESIZE_DEFAULT) int pageSize,@RequestParam("key") String key) {
        ResultListBean rsb = new ResultListBean();
        Map<String, String> params = new HashMap<String, String>();
        if (!StringUtils.isEmpty(userToken)) {
            Map<String, String> map = userService.getAgeFromBirthday(userToken);
            params.putAll(map);
        }
        params.put("page", String.valueOf(page));
        params.put("pageSize", String.valueOf(pageSize));
        List<Map<String, String>> list = courseService.getNewestList(params);
        logger.debug(list);
        rsb.getList().addAll(list);
        rsb.setCnt(list.size());

        return rsb;
    }

}
