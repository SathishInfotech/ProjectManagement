package com.demo.authorizer.dvo;

import java.util.HashMap;
import java.util.List;

public class TimeTrackerDVO {

    private List<TimeTrackerDetailsDVO> timeTrackerDetailsDVOs;

    private HashMap<Integer, String> tasks;

    private HashMap<Integer, String> phases;

    private HashMap<Integer, String> projects;

    private HashMap<Integer, String> users;
    
    private HashMap<Integer, String> activities;
    
    private HashMap<Integer, String> subPhases;
    
    

    public HashMap<Integer, String> getActivities() {
        return activities;
    }

    public void setActivities(HashMap<Integer, String> activities) {
        this.activities = activities;
    }

    public HashMap<Integer, String> getSubPhases() {
        return subPhases;
    }

    public void setSubPhases(HashMap<Integer, String> subPhases) {
        this.subPhases = subPhases;
    }

    public HashMap<Integer, String> getUsers() {
	return users;
    }

    public void setUsers(HashMap<Integer, String> users) {
	this.users = users;
    }

    public HashMap<Integer, String> getProjects() {
	return projects;
    }

    public void setProjects(HashMap<Integer, String> projects) {
	this.projects = projects;
    }

    public List<TimeTrackerDetailsDVO> getTimeTrackerDetailsDVOs() {
	return timeTrackerDetailsDVOs;
    }

    public void setTimeTrackerDetailsDVOs(List<TimeTrackerDetailsDVO> timeTrackerDetailsDVOs) {
	this.timeTrackerDetailsDVOs = timeTrackerDetailsDVOs;
    }

    public HashMap<Integer, String> getTasks() {
	return tasks;
    }

    public void setTasks(HashMap<Integer, String> tasks) {
	this.tasks = tasks;
    }

    public HashMap<Integer, String> getPhases() {
	return phases;
    }

    public void setPhases(HashMap<Integer, String> phases) {
	this.phases = phases;
    }

}
