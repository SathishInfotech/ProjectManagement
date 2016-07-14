package com.demo.authorizer.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.TimeTrackerDAO;
import com.demo.authorizer.entity.TimeTracker;

@Repository
public class TimeTrackerDAOImpl extends GenericDAOImpl<TimeTracker, Integer> implements TimeTrackerDAO {
    
    public TimeTrackerDAOImpl() {
	super.setEntityClass(TimeTracker.class);
    }
    
    @Override
    public List<TimeTracker> getTimeTrackerDetailsByProjectandUser(int projectId, int userId, Date date) {
	/*List<TimeTracker> timeTrackerList = findByCriteria(Restrictions.eq("time_date",date),Restrictions.eq("time_date",date),Restrictions.eq("time_date",date));
	if (timeTrackerList != null && timeTrackerList.size() > 0) {
	    return timeTrackerList;
	} else*/
	    return null;
    }
}
