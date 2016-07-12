package com.demo.authorizer.dao.impl;

import org.springframework.stereotype.Service;

import com.demo.authorizer.dao.TimeTrackerDAO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;
@Service
public class TimeTrackerDAOImpl extends GenericDAOImpl<TimeTrackerDetailsDVO, Integer> implements TimeTrackerDAO {

}
