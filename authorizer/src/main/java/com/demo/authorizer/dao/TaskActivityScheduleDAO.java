package com.demo.authorizer.dao;

import com.demo.authorizer.entity.TaskActivitySchedule;

public interface TaskActivityScheduleDAO extends GenericDAO<TaskActivitySchedule, Integer> {
	
	TaskActivitySchedule findByTaskActivityId(Integer taskId);

	
}
