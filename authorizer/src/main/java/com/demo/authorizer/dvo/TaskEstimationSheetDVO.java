package com.demo.authorizer.dvo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TaskEstimationSheetDVO {
	
	private List<TaskInfoDVO> taskInfoDVOs;

	public List<TaskInfoDVO> getTaskInfoDVOs() {
		return taskInfoDVOs;
	}

	public void setTaskInfoDVOs(List<TaskInfoDVO> taskInfoDVOs) {
		this.taskInfoDVOs = taskInfoDVOs;
	}
	
	

}
