package com.demo.authorizer.dvo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TaskDVO {
	
	private String taskName;
	private List<ProjectDVO> projectDVOs;
	private List<UserDVO> userDVOs;
	private int projectId;
	private int userId;
	private int taskId;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public List<ProjectDVO> getProjectDVOs() {
		return projectDVOs;
	}
	public void setProjectDVOs(List<ProjectDVO> projectDVOs) {
		this.projectDVOs = projectDVOs;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<UserDVO> getUserDVOs() {
		return userDVOs;
	}
	public void setUserDVOs(List<UserDVO> userDVOs) {
		this.userDVOs = userDVOs;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	
	
}
