package com.demo.authorizer.dvo;

import org.springframework.stereotype.Component;

@Component
public class TimeTrackerDetailsDVO {
    private String timeDate;
    private String taskId;
    private String activityId;
    private String phaseId;
    private String subphaseId;
    private String hoursSpent;
    private String remark;
    private String projectId;
    private String userId;

    public String getProjectId() {
	return projectId;
    }

    public void setProjectId(String projectId) {
	this.projectId = projectId;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getTimeDate() {
	return timeDate;
    }

    public void setTimeDate(String timeDate) {
	this.timeDate = timeDate;
    }

    public String getTaskId() {
	return taskId;
    }

    public void setTaskId(String taskId) {
	this.taskId = taskId;
    }

    public String getActivityId() {
	return activityId;
    }

    public void setActivityId(String activityId) {
	this.activityId = activityId;
    }

    public String getPhaseId() {
	return phaseId;
    }

    public void setPhaseId(String phaseId) {
	this.phaseId = phaseId;
    }

    public String getSubphaseId() {
	return subphaseId;
    }

    public void setSubphaseId(String subphaseId) {
	this.subphaseId = subphaseId;
    }

    public String getHoursSpent() {
	return hoursSpent;
    }

    public void setHoursSpent(String hoursSpent) {
	this.hoursSpent = hoursSpent;
    }

    public String getRemark() {
	return remark;
    }

    public void setRemark(String remark) {
	this.remark = remark;
    }
}
