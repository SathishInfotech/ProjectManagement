package com.demo.authorizer.dvo;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TaskEstimationSheetDVO {
	
	private List<TaskInfoDVO> taskInfoDVOs;
	private Date beginDate;

	public List<TaskInfoDVO> getTaskInfoDVOs() {
		return taskInfoDVOs;
	}

	public void setTaskInfoDVOs(List<TaskInfoDVO> taskInfoDVOs) {
		this.taskInfoDVOs = taskInfoDVOs;
	}
	
	
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskEstimationSheetDVO [taskInfoDVOs=");
		builder.append(taskInfoDVOs);
		builder.append(", beginDate=");
		builder.append(beginDate);
		builder.append("]");
		return builder.toString();
	}
	
	

}
