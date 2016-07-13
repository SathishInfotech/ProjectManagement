package com.demo.authorizer.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.TaskDAO;
import com.demo.authorizer.entity.Task;

@Repository
public class TaskDAOImpl extends GenericDAOImpl<Task, Integer> implements TaskDAO {

	public TaskDAOImpl() {
		super.setEntityClass(Task.class);
	}

	@Override
	public List<Task> getTaskByUser(int userId) {
		 return findByCriteria(Restrictions.eq("user.is", userId));
	}
	
}
