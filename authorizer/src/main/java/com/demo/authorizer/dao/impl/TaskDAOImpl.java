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
    public List<Task> findTasksByUserIdAndProjectId(int userId, int projectId) {
	List<Task> taskList = findByCriteria(Restrictions.eq("user.id",Integer.valueOf(userId)),Restrictions.eq("project.projectId",Integer.valueOf(projectId)));
	if (taskList != null && taskList.size() > 0) {
	    return taskList;
	} else
	    return null;
    }


}
