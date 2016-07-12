package com.demo.authorizer.service;

import java.util.List;

import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;

public interface TimeTrackerService {
    
    void saveTimeTrackerDetails(List<TimeTrackerDetailsDVO> timeTrackerDetailsDVO);

}
