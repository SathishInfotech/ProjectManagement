package com.demo.authorizer.service;

import java.util.List;

import com.demo.authorizer.dvo.TimeTrackerDVO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;

public interface TimeTrackerService {

    TimeTrackerDVO getInitDetails(int userId, String projectId);

    TimeTrackerDVO getAllTaskDetailsByUserIdandProjectId(int userId,String date);
    
    TimeTrackerDVO getActicitiesByTaskId(int taskId);
    
    TimeTrackerDVO getSubphasesByPhasId(int phaseId);

    TimeTrackerDVO getAlProjects();
    
    TimeTrackerDVO getUserByProject(int projectId);

    boolean saveTimeTrackerDetails(List<TimeTrackerDetailsDVO> timeTrackerDetailsDVO,int userid);

}
