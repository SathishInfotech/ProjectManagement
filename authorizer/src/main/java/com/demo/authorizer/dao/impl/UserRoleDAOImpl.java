package com.demo.authorizer.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.UserRoleDAO;
import com.demo.authorizer.entity.UserRole;

@Repository
public class UserRoleDAOImpl extends GenericDAOImpl<UserRole, Integer> implements UserRoleDAO{

}
