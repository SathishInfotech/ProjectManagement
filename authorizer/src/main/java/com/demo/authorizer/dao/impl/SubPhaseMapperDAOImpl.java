package com.demo.authorizer.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.SubPhaseMapperDAO;
import com.demo.authorizer.entity.PhaseSubPhaseMapper;

@Repository
public class SubPhaseMapperDAOImpl extends GenericDAOImpl<PhaseSubPhaseMapper, Integer> implements SubPhaseMapperDAO{
	public SubPhaseMapperDAOImpl() {
		super.setEntityClass(PhaseSubPhaseMapper.class);
	    }
}
