package com.demo.authorizer.dao;

import java.util.List;

import com.demo.authorizer.entity.ProjectUser;

public interface ProjectUserDAO extends GenericDAO<ProjectUser, Integer> {
	
	List<ProjectUser> findByProjectId(Integer projectId);

	
}
