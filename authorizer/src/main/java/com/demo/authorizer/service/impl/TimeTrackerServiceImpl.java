package com.demo.authorizer.service.impl;

import java.math.BigDecimal;
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
import com.demo.authorizer.utils.DateUtils;

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
    @Transactional
    public boolean saveTimeTrackerDetails(List<TimeTrackerDetailsDVO> timeTrackerDetailsDVOs, int userid) {
	try {
	    List<TimeTracker> timeTrackerList = new ArrayList<TimeTracker>();
	    if (timeTrackerDetailsDVOs != null) {
		for (TimeTrackerDetailsDVO timeTrackerDetailsDVO : timeTrackerDetailsDVOs) {
		    if (timeTrackerDetailsDVO.getTaskId()!=null && !"".equals(timeTrackerDetailsDVO.getTaskId().trim())) {
			TimeTracker timeTracker = new TimeTracker();
			timeTracker.setComments(timeTrackerDetailsDVO.getRemark());
			timeTracker.setHoursSpent(BigDecimal.valueOf(Long.parseLong(timeTrackerDetailsDVO.getHoursSpent())));
			timeTracker.setTimeDate(DateUtils.parseStringtoDateddmmyyyy(timeTrackerDetailsDVO.getTimeDate()));
			User user = new User();
			user.setId(userid);
			timeTracker.setUser(user);
			timeTracker = populateTimeTracker(timeTrackerDetailsDVO, timeTracker);
			timeTrackerList.add(timeTracker);
		    }
		}
	    }
	    return timeTrackerDAO.saveList(timeTrackerList);
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }

    private TimeTracker populateTimeTracker(TimeTrackerDetailsDVO timeTrackerDetailsDVO, TimeTracker timeTracker) {
	Phas phase = phaseDAO.findById(Integer.valueOf(timeTrackerDetailsDVO.getPhaseId().trim()), false);
	Integer subphaseId = Integer.valueOf(timeTrackerDetailsDVO.getSubphaseId());
	List<PhaseSubPhaseMapper> phasesubphaseList = phase.getPhaseSubPhaseMappers();
	for (PhaseSubPhaseMapper phaseMapper : phasesubphaseList) {
	    if (phaseMapper.getSubPhas().getSubPhaseId() == subphaseId) {
		timeTracker.setPhaseSubPhaseMapper(phaseMapper);
	    }
	}
	SubPhas subPhase = new SubPhas();
	subPhase.setSubPhaseId(Integer.valueOf(timeTrackerDetailsDVO.getSubphaseId().trim()));
	Task task = taskDAO.findById(Integer.valueOf(timeTrackerDetailsDVO.getTaskId().trim()), false);
	Integer activityId = Integer.valueOf(timeTrackerDetailsDVO.getActivityId().trim());
	List<TaskActivityMapper> taskActivityMapperList = task.getTaskActivityMappers();
	for (TaskActivityMapper taskActivityMapper : taskActivityMapperList) {
	    if (taskActivityMapper.getActivity().getActivityId() == activityId) {
		timeTracker.setTaskActivityMapper(taskActivityMapper);
	    }
	}
	return timeTracker;
    }

    @Override
    @Transactional
    public TimeTrackerDVO getInitDetails(int userId,String projectId) {
    int projId= Integer.parseInt(projectId);
	TimeTrackerDVO timeTrackerDVO = new TimeTrackerDVO();
	HashMap<Integer, String> phaseMap = new HashMap<Integer, String>();
	HashMap<Integer, String> taskMap = new HashMap<Integer, String>();
	List<Phas> phasesList = phaseDAO.findAll();
	if (phasesList != null && phasesList.size() > 0) {
	    for (Phas phase : phasesList) {
		phaseMap.put(phase.getPhaseId(), phase.getPhaseName());
	    }
	}
	List<Task> taskList = taskDAO.findTasksByUserIdAndProjectId(userId, projId);
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

    @Override
    @Transactional
    public TimeTrackerDVO getAllTaskDetailsByUserIdandProjectId(int userId, String date) {
	TimeTrackerDVO timeTrackerDVO = new TimeTrackerDVO();
	List<TimeTrackerDetailsDVO> timeTrackerDetailsDVOList = new ArrayList<TimeTrackerDetailsDVO>();
	List<TimeTracker> timetrackerList = timeTrackerDAO.getTimeTrackerDetailsByProjectandUser(userId, Integer.valueOf(date));
	if (timetrackerList != null) {
	    for (TimeTracker timeTracker : timetrackerList) {
		TimeTrackerDetailsDVO timeTrackerDetails = new TimeTrackerDetailsDVO();
		timeTrackerDetails.setTimeDate(DateUtils.parseDatetoStringddmmyyy(timeTracker.getTimeDate()));
		timeTrackerDetails.setActivityId(timeTracker.getTaskActivityMapper().getActivity().getActivityName());
		timeTrackerDetails.setTaskId(timeTracker.getTaskActivityMapper().getTask().getTaskName());
		timeTrackerDetails.setPhaseId(timeTracker.getPhaseSubPhaseMapper().getPhas().getPhaseName());
		timeTrackerDetails.setSubphaseId(timeTracker.getPhaseSubPhaseMapper().getSubPhas().getSubPhaseName());
		timeTrackerDetails.setHoursSpent(String.valueOf(timeTracker.getHoursSpent()));
		timeTrackerDetails.setUserId(timeTracker.getUser().getUsername());
		timeTrackerDetails.setRemark(timeTracker.getComments());
		timeTrackerDetailsDVOList.add(timeTrackerDetails);
	    }
	    timeTrackerDVO.setTimeTrackerDetailsDVOs(timeTrackerDetailsDVOList);
	    return timeTrackerDVO;
	} else {
	    return timeTrackerDVO;
	}
    }

    @Override
    @Transactional
    public TimeTrackerDVO getActicitiesByTaskId(int taskId) {
	TimeTrackerDVO timeTrackerDVO = new TimeTrackerDVO();
	Task task = taskDAO.findById(taskId, false);
	if (task != null) {
	    List<TaskActivityMapper> taskActivityMapperList = task.getTaskActivityMappers();
	    HashMap<Integer, String> userActivity = new HashMap<Integer, String>();
	    for (TaskActivityMapper taskActivityMapper : taskActivityMapperList) {
		userActivity.put(taskActivityMapper.getActivity().getActivityId(), taskActivityMapper.getActivity().getActivityName());
	    }
	    timeTrackerDVO.setActivities(userActivity);
	}
	return timeTrackerDVO;
    }

    @Override
    @Transactional
    public TimeTrackerDVO getSubphasesByPhasId(int phaseId) {
	TimeTrackerDVO timeTrackerDVO = new TimeTrackerDVO();
	Phas phase = phaseDAO.findById(phaseId, false);
	if (phase != null) {
	    List<PhaseSubPhaseMapper> subphaseList = phase.getPhaseSubPhaseMappers();
	    HashMap<Integer, String> subPhases = new HashMap<Integer, String>();
	    for (PhaseSubPhaseMapper phaseSubPhaseMapper : subphaseList) {
		subPhases.put(phaseSubPhaseMapper.getSubPhas().getSubPhaseId(), phaseSubPhaseMapper.getSubPhas().getSubPhaseName());
	    }
	    timeTrackerDVO.setSubPhases(subPhases);
	}
	return timeTrackerDVO;
    }
}