package com.demo.authorizer.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.PhaseDAO;
import com.demo.authorizer.entity.Phas;

@Repository
public class PhaseDAOImpl extends GenericDAOImpl<Phas, Integer> implements PhaseDAO {
    public PhaseDAOImpl() {
	super.setEntityClass(Phas.class);
    }

}
