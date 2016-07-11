package com.demo.authorizer.dvo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TaskSheetDVO {
	
	private String sheetDate;
	private List<TaskDetailsDVO> taskDetailsDVOs;
	
	public String getSheetDate() {
		return sheetDate;
	}
	public void setSheetDate(String sheetDate) {
		this.sheetDate = sheetDate;
	}
	public List<TaskDetailsDVO> getTaskDetailsDVOs() {
		return taskDetailsDVOs;
	}
	public void setTaskDetailsDVOs(List<TaskDetailsDVO> taskDetailsDVOs) {
		this.taskDetailsDVOs = taskDetailsDVOs;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskSheetDVO [sheetDate=");
		builder.append(sheetDate);
		builder.append(", taskDetailsDVOs=");
		builder.append(taskDetailsDVOs);
		builder.append("]");
		return builder.toString();
	}
	
	
}
