package com.demo.authorizer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.authorizer.dao.TimeTrackerDAO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;
import com.demo.authorizer.entity.PhaseSubPhaseMapper;
import com.demo.authorizer.entity.TimeTracker;
import com.demo.authorizer.service.TimeTrackerService;

@Service
public class TimeTrackerServiceImpl implements TimeTrackerService {
    
    @Autowired
    private TimeTrackerDAO timeTrackerDAO;

    @Override
    public void saveTimeTrackerDetails(List<TimeTrackerDetailsDVO> timeTrackerDetailsDVO) {
	List<TimeTracker> timeTrackerList=new ArrayList<TimeTracker>();
	if(timeTrackerDetailsDVO!=null){
	    int listSize=timeTrackerDetailsDVO.size();
	    for(int i=0;i<listSize;i++){
		/*TimeTracker timeTracker=new TimeTracker();
		timeTracker.setComments(comments);
		timeTracker.setHoursSpent(hoursSpent);
		timeTracker.setId(id);
		timeTracker.setTimeDate(timeTrackerDetailsDVO.get(i));		
		timeTracker.setPhaseSubPhaseMapper(phaseSubPhaseMapper);
		timeTracker.setTaskActivityMapper(taskActivityMapper);*/
				
	    }
	}
	timeTrackerDAO.saveList(timeTrackerList);
    }

}
