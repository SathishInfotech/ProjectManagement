package com.demo.authorizer.dao;

import java.util.Date;
import java.util.List;

import com.demo.authorizer.entity.TimeTracker;

public interface TimeTrackerDAO extends GenericDAO<TimeTracker, Integer> {
List<TimeTracker> getTimeTrackerDetailsByProjectandUser(int projectId,int userId,Date date);
}
