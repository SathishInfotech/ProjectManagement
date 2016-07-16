package com.demo.authorizer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.authorizer.dao.PhaseDAO;
import com.demo.authorizer.dao.TaskDAO;
import com.demo.authorizer.dao.UsersDAO;
import com.demo.authorizer.entity.Phas;
import com.demo.authorizer.entity.PhaseSubPhaseMapper;
import com.demo.authorizer.entity.SubPhas;
import com.demo.authorizer.entity.Task;
import com.demo.authorizer.entity.User;
import com.demo.authorizer.service.TaskInfoService;

@Service
public class TaskInfoServiceImpl implements TaskInfoService{

	@Autowired
	private PhaseDAO phaseDAO;
	
	@Autowired
	private TaskDAO taskDAO;
	
	@Autowired
	private UsersDAO userDAO;
	
	@Transactional(readOnly=true)
	public Map<Integer,String> fetchPhases(){
		Map<Integer,String> phaseMap  = new HashMap<>();
		List<Phas> phases = phaseDAO.findAll();
		for(Phas phase:phases){
			phaseMap.put(phase.getPhaseId(), phase.getPhaseName());
		}
		return phaseMap;
	}
	
	@Transactional(readOnly=true)
	public Map<Integer,String> fetchSubPhases(Integer phaseId){
		Phas phase = phaseDAO.findById(phaseId, false);
		List<PhaseSubPhaseMapper> subPhaseMappers = phase.getPhaseSubPhaseMappers();
		Map<Integer,String> subPhaseMap  = new HashMap<>();
		for(PhaseSubPhaseMapper subPhaseMapper:subPhaseMappers){
			SubPhas subPhase = subPhaseMapper.getSubPhas();
			subPhaseMap.put(subPhase.getSubPhaseId(), subPhase.getSubPhaseName());
		}
		return subPhaseMap;
	}
	
	@Transactional(readOnly=true)
	public void initHome(String userName){
		
		User user = userDAO.findByName(userName);
		List<Task> tasks = user.getTasks();
	}
	
	
}
