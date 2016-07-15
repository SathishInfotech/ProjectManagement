package com.demo.authorizer.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.TaskActivityMapperDAO;
import com.demo.authorizer.entity.TaskActivityMapper;

@Repository
public class TaskActivityMapperDAOImpl extends GenericDAOImpl<TaskActivityMapper, Integer> implements TaskActivityMapperDAO {

	public TaskActivityMapperDAOImpl() {
		super.setEntityClass(TaskActivityMapper.class);
	}

	@Override
	public List<TaskActivityMapper> findByTaskId(Integer taskId) {
		
		 return findByCriteria(Restrictions.eq("task.taskId", taskId));
	}
	
}
