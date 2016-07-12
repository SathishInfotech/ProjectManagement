package com.demo.authorizer.dao.impl;

import org.springframework.stereotype.Service;

import com.demo.authorizer.dao.TimeTrackerDAO;
import com.demo.authorizer.entity.TimeTracker;
@Service
public class TimeTrackerDAOImpl extends GenericDAOImpl<TimeTracker, Integer> implements TimeTrackerDAO {

}
