package com.demo.authorizer.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.ProjectUserDAO;
import com.demo.authorizer.entity.ProjectUser;

@Repository
public class ProjectUserDAOImpl extends GenericDAOImpl<ProjectUser, Integer> implements ProjectUserDAO {

	public ProjectUserDAOImpl() {
		super.setEntityClass(ProjectUser.class);
	}

	@Override
	public List<ProjectUser> findByProjectId(Integer projectId) {
		
		 return findByCriteria(Restrictions.eq("project.projectId", projectId));
	}
	
}
