package com.zhuyin.gxj.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuyin.gxj.dao.CourseDAO;
import com.zhuyin.gxj.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO=null;
	
	@Override
	public Map<String, String> getNewestList(Map<String, String> params) {
		return courseDAO.getNewestList(params);
	}

}
