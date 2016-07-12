package com.demo.authorizer.dvo;

import java.util.List;

public class TimeTrackerDVO {
    private List<TimeTrackerDetailsDVO> timeTrackerDetailsDVOs;

    public List<TimeTrackerDetailsDVO> getTimeTrackerDetailsDVOs() {
	return timeTrackerDetailsDVOs;
    }

    public void setTimeTrackerDetailsDVOs(
	    List<TimeTrackerDetailsDVO> timeTrackerDetailsDVOs) {
	this.timeTrackerDetailsDVOs = timeTrackerDetailsDVOs;
    }

}
