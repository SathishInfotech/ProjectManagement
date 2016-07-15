package com.demo.authorizer.service;

import java.util.Date;
import java.util.List;

import com.demo.authorizer.dvo.TimeTrackerDVO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;

public interface TimeTrackerService {

    TimeTrackerDVO getInitDetails(int userId);

    TimeTrackerDVO getAllTaskDetailsByUserIdandProjectId(int projectId,int userId,Date date);

    // List<Phas> getAlPhases();

    TimeTrackerDVO getAlProjects();
    
    TimeTrackerDVO getUserByProject(int projectId);

    boolean saveTimeTrackerDetails(List<TimeTrackerDetailsDVO> timeTrackerDetailsDVO);

}
