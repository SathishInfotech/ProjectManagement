package com.demo.authorizer.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.SubPhaseDAO;
import com.demo.authorizer.entity.SubPhas;

@Repository
public class SubPhaseDAOImpl extends GenericDAOImpl<SubPhas, Integer> implements SubPhaseDAO {
    public SubPhaseDAOImpl() {
	super.setEntityClass(SubPhas.class);
    }

}
