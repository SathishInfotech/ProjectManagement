package com.demo.authorizer.dvo;

import org.springframework.stereotype.Component;

@Component
public class TaskDetailsDVO {

	private String taskName;
	private String phase;
	private String activity;
	private String remark;
	private int hour;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskSheetDVO [taskName=");
		builder.append(taskName);
		builder.append(", phase=");
		builder.append(phase);
		builder.append(", activity=");
		builder.append(activity);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", hour=");
		builder.append(hour);
		builder.append("]");
		return builder.toString();
	}

}
