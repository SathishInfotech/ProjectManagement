package com.demo.authorizer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.authorizer.dao.ProjectDAO;
import com.demo.authorizer.dao.ProjectUserDAO;
import com.demo.authorizer.dao.TaskDAO;
import com.demo.authorizer.dvo.ProjectDVO;
import com.demo.authorizer.dvo.TaskDVO;
import com.demo.authorizer.dvo.UserDVO;
import com.demo.authorizer.entity.Project;
import com.demo.authorizer.entity.ProjectUser;
import com.demo.authorizer.entity.Task;
import com.demo.authorizer.entity.User;

@Service
public class TaskServiceImpl  {
	
	@Autowired
	private ProjectDAO projectDAOImpl;
	
	@Autowired
	private ProjectUserDAO projectUserDAOImpl;
	
	@Autowired
	private TaskDAO TaskDAOImpl;

	@Transactional
	public TaskDVO initTask() {
		TaskDVO taskDVO =new TaskDVO();
		List<Project> projects = projectDAOImpl.findAll();
		if(projects!=null && !projects.isEmpty()){
			List<ProjectDVO> dvos = new ArrayList<>();
			for (Project project : projects) {
				ProjectDVO projectDVO = new ProjectDVO();
				projectDVO.setProjectId(project.getProjectId());
				projectDVO.setProjectName(project.getProjectName());
				dvos.add(projectDVO);
			}
			taskDVO.setProjectDVOs(dvos);
		}
		return taskDVO;
	}

	@Transactional
	public TaskDVO getUsers(String projectId) {
		TaskDVO taskDVO =new TaskDVO();
		List<ProjectUser> projectUsers = projectUserDAOImpl.findByProjectId(Integer.valueOf(projectId));
		if(projectUsers!=null && !projectUsers.isEmpty()){
			List<UserDVO> dvos = new ArrayList<>();
			for (ProjectUser project : projectUsers) {
				UserDVO userDVO = new UserDVO();
				userDVO.setUserId(project.getUser().getId());
				userDVO.setUserName(project.getUser().getUsername());
				dvos.add(userDVO);
			}	
			taskDVO.setUserDVOs(dvos);
		}
		return taskDVO;
	}

	@Transactional
	public void create(TaskDVO taskDVO) {
		Task task = new Task();
		User user = new User();
		user.setId(taskDVO.getUserId());
		task.setTaskName(taskDVO.getTaskName());
		task.setUser(user);
		TaskDAOImpl.save(task);
		
	}

}
