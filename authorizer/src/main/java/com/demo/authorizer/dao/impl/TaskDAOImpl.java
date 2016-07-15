package com.demo.authorizer.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.TaskDAO;
import com.demo.authorizer.entity.Task;

@Repository
public class TaskDAOImpl extends GenericDAOImpl<Task, Integer> implements TaskDAO {

<<<<<<< HEAD
	public TaskDAOImpl() {
		super.setEntityClass(Task.class);
	}

	@Override
	public List<Task> getTaskByUser(int userId) {
		 return findByCriteria(Restrictions.eq("user.id", userId));
	}
	
=======
    public TaskDAOImpl() {
	super.setEntityClass(Task.class);
}
    
    @Override
    public List<Task> findTasksByUserId(int userId) {
	List<Task> taskList = findByCriteria(Restrictions.eq("user.id",Integer.valueOf(userId)));
	if (taskList != null && taskList.size() > 0) {
	    return taskList;
	} else
	    return null;
    }

>>>>>>> branch 'master' of https://github.com/SathishInfotech/ProjectManagement.git
}
