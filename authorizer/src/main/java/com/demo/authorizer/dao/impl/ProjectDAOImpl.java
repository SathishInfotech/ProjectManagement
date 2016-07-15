package com.demo.authorizer.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.ProjectDAO;
import com.demo.authorizer.entity.Project;

@Repository
public class ProjectDAOImpl extends GenericDAOImpl<Project, Integer> implements ProjectDAO {
<<<<<<< HEAD

	public ProjectDAOImpl() {
		super.setEntityClass(Project.class);
	}
	
=======
    public ProjectDAOImpl() {
	super.setEntityClass(Project.class);
    }
>>>>>>> branch 'master' of https://github.com/SathishInfotech/ProjectManagement.git
}
