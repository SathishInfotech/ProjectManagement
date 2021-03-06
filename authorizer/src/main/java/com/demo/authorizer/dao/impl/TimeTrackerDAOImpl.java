package com.demo.authorizer.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.TimeTrackerDAO;
import com.demo.authorizer.entity.TimeTracker;

@Repository
public class TimeTrackerDAOImpl extends GenericDAOImpl<TimeTracker, Integer> implements TimeTrackerDAO {
    
    public TimeTrackerDAOImpl() {
	super.setEntityClass(TimeTracker.class);
    }
   
    @SuppressWarnings("unchecked")
    @Override
    public List<TimeTracker> getTimeTrackerDetailsByProjectandUser(int userId, Integer monthId) {
	String queryUrl="FROM TimeTracker T WHERE T.user = "+userId+" and month(T.timeDate) = "+monthId;	
	Query q=getSession().createQuery(queryUrl);
	List<TimeTracker> list=q.list();
	return list;
    }
}
