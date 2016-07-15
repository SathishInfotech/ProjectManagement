package com.demo.authorizer.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.TaskActivityScheduleDAO;
import com.demo.authorizer.entity.TaskActivitySchedule;

@Repository
public class TaskActivityScheduleDAOImpl extends GenericDAOImpl<TaskActivitySchedule, Integer> implements TaskActivityScheduleDAO {

	public TaskActivityScheduleDAOImpl() {
		super.setEntityClass(TaskActivitySchedule.class);
	}

	@Override
	public TaskActivitySchedule findByTaskActivityId(Integer taskId) {
		
		 return findByCriteria(Restrictions.eq("taskActivityMapper.id", taskId)).get(0);
	}
	
}
