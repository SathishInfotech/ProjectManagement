package com.demo.authorizer.dvo;

import org.springframework.stereotype.Component;

@Component
public class TaskInfoDVO extends TaskDetailsDVO{

	private int estimatedHour;
	private boolean completionStatus;
	
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
	
	
}
