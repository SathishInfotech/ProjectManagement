package com.demo.authorizer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.authorizer.dao.TimeTrackerDAO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;
import com.demo.authorizer.entity.Activity;
import com.demo.authorizer.entity.Phas;
import com.demo.authorizer.entity.PhaseSubPhaseMapper;
import com.demo.authorizer.entity.SubPhas;
import com.demo.authorizer.entity.Task;
import com.demo.authorizer.entity.TaskActivityMapper;
import com.demo.authorizer.entity.TimeTracker;
import com.demo.authorizer.service.TimeTrackerService;

@Service
public class TimeTrackerServiceImpl implements TimeTrackerService {

    @Autowired
    private TimeTrackerDAO timeTrackerDAO;

    @Override
    public void saveTimeTrackerDetails(
	    List<TimeTrackerDetailsDVO> timeTrackerDetailsDVO) {
	List<TimeTracker> timeTrackerList = new ArrayList<TimeTracker>();
	if (timeTrackerDetailsDVO != null) {
	    int listSize = timeTrackerDetailsDVO.size();
	    for (int i = 0; i < listSize; i++) {
		TimeTracker timeTracker=new TimeTracker();
		 timeTracker.setComments(timeTrackerDetailsDVO.get(i).getRemark());
	/*	 timeTracker.setHoursSpent(Double.valueOf(timeTrackerDetailsDVO.get(i).getHoursSpent())); 
		  timeTracker.setId(id);
		  timeTracker.setTimeDate(timeTrackerDetailsDVO.get(i));
	*/
		timeTracker=populateTimeTracker(timeTrackerDetailsDVO.get(i),timeTracker);
		timeTrackerList.add(timeTracker);
	    }
	}
	timeTrackerDAO.saveList(timeTrackerList);
    }

    private TimeTracker populateTimeTracker(TimeTrackerDetailsDVO timeTrackerDetailsDVO,TimeTracker timeTracker) {
	Phas phase=new Phas();
	phase.setPhaseId(Integer.valueOf(timeTrackerDetailsDVO.getPhaseId().trim()));
	SubPhas subPhase=new SubPhas();
	subPhase.setSubPhaseId(Integer.valueOf(timeTrackerDetailsDVO.getSubphaseId().trim()));
	PhaseSubPhaseMapper phaseMapper=new PhaseSubPhaseMapper();
	phaseMapper.setPhas(phase);
	phaseMapper.setSubPhas(subPhase);
	timeTracker.setPhaseSubPhaseMapper(phaseMapper);
	Task task=new Task();
	task.setTaskId(Integer.valueOf(timeTrackerDetailsDVO.getTaskId().trim()));
	Activity activity=new Activity();
	activity.setActivityId(Integer.valueOf(timeTrackerDetailsDVO.getActivityId().trim()));
	TaskActivityMapper taskActivityMapper=new TaskActivityMapper();
	taskActivityMapper.setActivity(activity);
	taskActivityMapper.setTask(task);
	timeTracker.setTaskActivityMapper(taskActivityMapper);
	return timeTracker;
    }
}