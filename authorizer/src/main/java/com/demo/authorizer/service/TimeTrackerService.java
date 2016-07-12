package com.demo.authorizer.service;

import java.util.List;

import com.demo.authorizer.dvo.TimeTrackerDVO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;
import com.demo.authorizer.entity.Phas;
import com.demo.authorizer.entity.Task;

public interface TimeTrackerService {
    
    TimeTrackerDVO getInitDetails(int userId);
    
    //List<Task> getAllTaskDetailsByUserId(String userId);
    
    //List<Phas> getAlPhases();
    
    boolean saveTimeTrackerDetails(List<TimeTrackerDetailsDVO> timeTrackerDetailsDVO);

}
