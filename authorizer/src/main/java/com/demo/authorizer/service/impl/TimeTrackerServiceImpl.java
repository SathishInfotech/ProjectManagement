package com.demo.authorizer.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.authorizer.dao.PhaseDAO;
import com.demo.authorizer.dao.ProjectDAO;
import com.demo.authorizer.dao.TaskDAO;
import com.demo.authorizer.dao.TimeTrackerDAO;
import com.demo.authorizer.dvo.TimeTrackerDVO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;
import com.demo.authorizer.entity.Activity;
import com.demo.authorizer.entity.Phas;
import com.demo.authorizer.entity.PhaseSubPhaseMapper;
import com.demo.authorizer.entity.Project;
import com.demo.authorizer.entity.ProjectUser;
import com.demo.authorizer.entity.SubPhas;
import com.demo.authorizer.entity.Task;
import com.demo.authorizer.entity.TaskActivityMapper;
import com.demo.authorizer.entity.TimeTracker;
import com.demo.authorizer.entity.User;
import com.demo.authorizer.service.TimeTrackerService;

@Service
public class TimeTrackerServiceImpl implements TimeTrackerService {

    @Autowired
    private TimeTrackerDAO timeTrackerDAO;

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private PhaseDAO phaseDAO;

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public boolean saveTimeTrackerDetails(List<TimeTrackerDetailsDVO> timeTrackerDetailsDVO) {
	List<TimeTracker> timeTrackerList = new ArrayList<TimeTracker>();
	if (timeTrackerDetailsDVO != null) {
	    int listSize = timeTrackerDetailsDVO.size();
	    for (int i = 0; i < listSize; i++) {
		TimeTracker timeTracker = new TimeTracker();
		timeTracker.setComments(timeTrackerDetailsDVO.get(i).getRemark());
		/*
		 * timeTracker.setHoursSpent(Double.valueOf(timeTrackerDetailsDVO
		 * .get(i).getHoursSpent())); timeTracker.setId(id);
		 * timeTracker.setTimeDate(timeTrackerDetailsDVO.get(i));
		 */
		timeTracker = populateTimeTracker(timeTrackerDetailsDVO.get(i), timeTracker);
		timeTrackerList.add(timeTracker);
	    }
	}
	return timeTrackerDAO.saveList(timeTrackerList);
    }

    private TimeTracker populateTimeTracker(TimeTrackerDetailsDVO timeTrackerDetailsDVO, TimeTracker timeTracker) {
	Phas phase = new Phas();
	phase.setPhaseId(Integer.valueOf(timeTrackerDetailsDVO.getPhaseId().trim()));
	SubPhas subPhase = new SubPhas();
	subPhase.setSubPhaseId(Integer.valueOf(timeTrackerDetailsDVO.getSubphaseId().trim()));
	PhaseSubPhaseMapper phaseMapper = new PhaseSubPhaseMapper();
	phaseMapper.setPhas(phase);
	phaseMapper.setSubPhas(subPhase);
	timeTracker.setPhaseSubPhaseMapper(phaseMapper);
	Task task = new Task();
	task.setTaskId(Integer.valueOf(timeTrackerDetailsDVO.getTaskId().trim()));
	Activity activity = new Activity();
	activity.setActivityId(Integer.valueOf(timeTrackerDetailsDVO.getActivityId().trim()));
	TaskActivityMapper taskActivityMapper = new TaskActivityMapper();
	taskActivityMapper.setActivity(activity);
	taskActivityMapper.setTask(task);
	timeTracker.setTaskActivityMapper(taskActivityMapper);
	return timeTracker;
    }

    @Override
    @Transactional
    public TimeTrackerDVO getInitDetails(int userId) {
	TimeTrackerDVO timeTrackerDVO = new TimeTrackerDVO();
	HashMap<Integer, String> phaseMap = new HashMap<Integer, String>();
	HashMap<Integer, String> taskMap = new HashMap<Integer, String>();
	List<Phas> phasesList = phaseDAO.findAll();
	if (phasesList != null && phasesList.size() > 0) {
	    for (Phas phase : phasesList) {
		taskMap.put(phase.getPhaseId(), phase.getPhaseName());
	    }
	}
	List<Task> taskList = taskDAO.findTasksByUserId(userId);
	if (taskList != null && taskList.size() > 0) {
	    for (Task task : taskList) {
		taskMap.put(task.getTaskId(), task.getTaskName());
	    }
	}
	timeTrackerDVO.setTasks(taskMap);
	timeTrackerDVO.setPhases(phaseMap);
	return timeTrackerDVO;
    }

    @Override
    @Transactional
    public TimeTrackerDVO getAlProjects() {
	TimeTrackerDVO timeTrackerDVO = new TimeTrackerDVO();
	HashMap<Integer, String> projectMap = new HashMap<Integer, String>();
	List<Project> projectList = projectDAO.findAll();
	if (projectList != null && projectList.size() > 0) {
	    for (Project project : projectList) {
		projectMap.put(project.getProjectId(), project.getProjectName());
	    }
	}
	timeTrackerDVO.setProjects(projectMap);
	return timeTrackerDVO;
    }

    @Override
    @Transactional
    public TimeTrackerDVO getUserByProject(int projectId) {
	TimeTrackerDVO timeTrackerDVO = new TimeTrackerDVO();
	HashMap<Integer, String> userMap = new HashMap<Integer, String>();
	Project project = projectDAO.findById(projectId, false);
	if (project != null) {
	    for (ProjectUser user : project.getProjectUsers()) {
		userMap.put(user.getUser1().getId(), user.getUser1().getUsername());
	    }
	}
	timeTrackerDVO.setUsers(userMap);
	return timeTrackerDVO;
    }
}