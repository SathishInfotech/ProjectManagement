package com.demo.authorizer.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.TaskDAO;
import com.demo.authorizer.entity.Task;

@Repository
public class TaskDAOImpl extends GenericDAOImpl<Task, Integer> implements TaskDAO {

	public TaskDAOImpl() {
		super.setEntityClass(Task.class);
	}
	
}
