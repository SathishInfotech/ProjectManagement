package com.demo.authorizer.dvo;

import org.springframework.stereotype.Component;

@Component
public class TaskInfoDVO{

	private String phase;
	private String activity;
	private String remark;
	private int estimatedHour;
	private boolean completionStatus;
	private String startDate;
	private String endDate;
	
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
	public int getEstimatedHour() {
		return estimatedHour;
	}
	public void setEstimatedHour(int estimatedHour) {
		this.estimatedHour = estimatedHour;
	}
	public boolean getCompletionStatus() {
		return completionStatus;
	}
	public void setCompletionStatus(boolean completionStatus) {
		this.completionStatus = completionStatus;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + ((phase == null) ? 0 : phase.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskInfoDVO other = (TaskInfoDVO) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (phase == null) {
			if (other.phase != null)
				return false;
		} else if (!phase.equals(other.phase))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskInfoDVO [phase=");
		builder.append(phase);
		builder.append(", activity=");
		builder.append(activity);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", estimatedHour=");
		builder.append(estimatedHour);
		builder.append(", completionStatus=");
		builder.append(completionStatus);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
