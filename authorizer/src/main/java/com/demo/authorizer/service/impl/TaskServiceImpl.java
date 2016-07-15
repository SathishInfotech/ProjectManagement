package com.demo.authorizer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.authorizer.dao.PhaseDAO;
import com.demo.authorizer.dao.ProjectDAO;
import com.demo.authorizer.dao.ProjectUserDAO;
import com.demo.authorizer.dao.SubPhaseDAO;
import com.demo.authorizer.dao.TaskActivityMapperDAO;
import com.demo.authorizer.dao.TaskActivityScheduleDAO;
import com.demo.authorizer.dao.TaskDAO;
import com.demo.authorizer.dvo.ProjectDVO;
import com.demo.authorizer.dvo.TaskActivityDetailsDVO;
import com.demo.authorizer.dvo.TaskDVO;
import com.demo.authorizer.dvo.UserDVO;
import com.demo.authorizer.entity.Phas;
import com.demo.authorizer.entity.Project;
import com.demo.authorizer.entity.ProjectUser;
import com.demo.authorizer.entity.SubPhas;
import com.demo.authorizer.entity.Task;
import com.demo.authorizer.entity.TaskActivityMapper;
import com.demo.authorizer.entity.TaskActivitySchedule;
import com.demo.authorizer.entity.User;

@Service
public class TaskServiceImpl  {
	
	@Autowired
	private ProjectDAO projectDAOImpl;
	
	@Autowired
	private ProjectUserDAO projectUserDAOImpl;
	
	@Autowired
	private TaskDAO TaskDAOImpl;
	
	@Autowired
	private TaskActivityMapperDAO taskActivityMapperDAOImpl;
	
	@Autowired
	private TaskActivityScheduleDAO taskActivityScheduleDAOImpl;
	
	@Autowired
	private PhaseDAO phaseDAOImpl;
	
	@Autowired
	private SubPhaseDAO subPhaseDAOImpl;

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
				userDVO.setUserId(project.getUser1().getId());
				userDVO.setUserName(project.getUser1().getUsername());
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

	@Transactional
	public List<TaskDVO> getTaskDetails(TaskDVO taskDVO) {
		List<Task> tasks =TaskDAOImpl.findTasksByUserId(taskDVO.getUserId());
		List<TaskDVO> taskDVOs = new ArrayList<>();
		for (Task task : tasks) {
			TaskDVO dvo = new TaskDVO();
			dvo.setTaskName(task.getTaskName());
			dvo.setTaskId(task.getTaskId());
			taskDVOs.add(dvo);
		}
		
		return taskDVOs;
	}

	public List<TaskActivityDetailsDVO> viewActivity(TaskDVO taskDVO) {
		List<TaskActivityDetailsDVO> taskActivityDetailsDVOs = new ArrayList<>();
		List<TaskActivityMapper> taskActivityMappers = taskActivityMapperDAOImpl.findByTaskId(taskDVO.getTaskId());
		if(taskActivityMappers!=null && !taskActivityMappers.isEmpty()){
			for (TaskActivityMapper taskActivityMapper : taskActivityMappers) {
				TaskActivitySchedule taskActivitySchedule = taskActivityScheduleDAOImpl.findByTaskActivityId(taskActivityMapper.getId());
				TaskActivityDetailsDVO taskActivityDetailsDVO = new TaskActivityDetailsDVO();
				Phas phas = phaseDAOImpl.findById(taskActivityMapper.getPhaseSubPhaseMapper().getPhas().getPhaseId(), false);
				SubPhas subPhas = subPhaseDAOImpl.findById(taskActivityMapper.getPhaseSubPhaseMapper().getSubPhas().getSubPhaseId(), false);
				
				taskActivityDetailsDVO.setActivity(taskActivityMapper.getActivity().getActivityName());
				taskActivityDetailsDVO.setTask(taskActivityMapper.getTask().getTaskName());
				taskActivityDetailsDVO.setEstimatedHour(Integer.parseInt(taskActivityMapper.getEstimate()+""));
				taskActivityDetailsDVO.setPhase(phas.getPhaseName());
				taskActivityDetailsDVO.setSubPhase(subPhas.getSubPhaseName());
				taskActivityDetailsDVO.setPlannedStartDate(taskActivitySchedule.getPlannedStartDate()+"");
				taskActivityDetailsDVO.setPlannedEndDate(taskActivitySchedule.getPlannedEndDate()+"");
				taskActivityDetailsDVO.setActualStartDate(taskActivitySchedule.getActualStartDate()+"");
				taskActivityDetailsDVO.setActualEndDate(taskActivitySchedule.getActualEndDate()+"");
				if("C".equalsIgnoreCase(taskActivitySchedule.getTaskActivityStatus())){
					taskActivityDetailsDVO.setStatus("Completed");
				}else{
					taskActivityDetailsDVO.setStatus("In Progress");
				}
				taskActivityDetailsDVOs.add(taskActivityDetailsDVO);
			}
			
		}
		
		return taskActivityDetailsDVOs;
	}

}
