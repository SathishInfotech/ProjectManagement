package com.demo.authorizer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.authorizer.dao.TimeTrackerDAO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;
import com.demo.authorizer.service.TimeTrackerService;

@Service
public class TimeTrackerServiceImpl implements TimeTrackerService {
    
    @Autowired
    private TimeTrackerDAO timeTrackerDAO;

    @Override
    public void saveTimeTrackerDetails(List<TimeTrackerDetailsDVO> timeTrackerDetailsDVO) {
	timeTrackerDAO.saveList(timeTrackerDetailsDVO);
    }

}
