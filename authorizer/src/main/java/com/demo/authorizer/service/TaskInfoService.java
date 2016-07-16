package com.demo.authorizer.service;

import java.util.Map;

public interface TaskInfoService {

	public Map<Integer,String> fetchPhases();
	
	public Map<Integer,String> fetchSubPhases(Integer phaseId);
}
