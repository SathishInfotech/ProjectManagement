package com.demo.authorizer.service;

import java.util.List;

import com.demo.authorizer.dvo.TaskEstimationSheetDVO;
import com.demo.authorizer.dvo.TaskInfoDVO;


public interface TaskSheetService {

	List<TaskInfoDVO> generateSheet(TaskEstimationSheetDVO taskEstSheet);
}
