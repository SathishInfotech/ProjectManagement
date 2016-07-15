package com.demo.authorizer.dvo;

public class TaskActivityDetailsDVO {
	
	private String task;
	private String activity;
	private String phase;
	private String subPhase;
	private String plannedStartDate;
	private String plannedEndDate;
	private String actualStartDate;
	private String actualEndDate;
	private String status;
	private int estimatedHour;
	
	
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getSubPhase() {
		return subPhase;
	}
	public void setSubPhase(String subPhase) {
		this.subPhase = subPhase;
	}
	public String getPlannedStartDate() {
		return plannedStartDate;
	}
	public void setPlannedStartDate(String plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}
	public String getPlannedEndDate() {
		return plannedEndDate;
	}
	public void setPlannedEndDate(String plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}
	public String getActualStartDate() {
		return actualStartDate;
	}
	public void setActualStartDate(String actualStartDate) {
		this.actualStartDate = actualStartDate;
	}
	public String getActualEndDate() {
		return actualEndDate;
	}
	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEstimatedHour() {
		return estimatedHour;
	}
	public void setEstimatedHour(int estimatedHour) {
		this.estimatedHour = estimatedHour;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	
}
