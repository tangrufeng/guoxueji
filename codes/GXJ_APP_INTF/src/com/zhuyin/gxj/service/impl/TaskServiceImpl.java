package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.TaskDAO;
import com.zhuyin.gxj.service.TaskService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/11.
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    private final static Logger logger = Logger.getLogger(TaskService.class);

    @Autowired
    TaskDAO taskDAO;

    @Override
    public int addTask(Map<String, Object> params) {
        logger.debug("before====>" + params);
        int i = taskDAO.addTask(params);
        if (i == 1) {
            long taskId = (Long) params.get("id");
            ArrayList<Map<String, String>> musics = (ArrayList<Map<String, String>>) params.get("musics");
            for (Map<String, String> music : musics) {
                music.put("task_id", taskId + "");
                taskDAO.addTaskAudio(music);
            }
        }
        logger.debug("after=====>" + params);
        return 0;
    }

    @Override
    public List<Map<String, Object>> getPlayTaskList(String userId, String deviceId) {

        List<Map<String,Object>> list=taskDAO.getPlayTaskList(userId,deviceId);

        for(Map<String,Object> task:list){

            String taskId=String.valueOf(task.get("id"));
            List<Map<String,String>> musics =taskDAO.getTaskAudio(taskId);
            task.put("musics",musics);
        }

        return list;
    }

	@Override
	public int deleteTask(String userId, String taskId) {
		return taskDAO.deleteTask(userId, taskId);
	}

	@Override
	public int deleteTaskAudio(String taskId, String audioId) {
		return taskDAO.deleteTaskAudio(taskId, audioId);
	}
    
    
}
