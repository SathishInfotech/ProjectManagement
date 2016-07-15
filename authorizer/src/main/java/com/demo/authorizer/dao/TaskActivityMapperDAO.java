package com.demo.authorizer.dao;

import java.util.List;

import com.demo.authorizer.entity.TaskActivityMapper;

public interface TaskActivityMapperDAO extends GenericDAO<TaskActivityMapper, Integer> {
	
	List<TaskActivityMapper> findByTaskId(Integer taskId);

	
}
