package com.demo.authorizer.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.UsersDAO;
import com.demo.authorizer.entity.User;

@Repository
public class UsersDAOImpl extends GenericDAOImpl<User, Integer> implements UsersDAO {

	public UsersDAOImpl() {
		super.setEntityClass(User.class);
	}
	
	public User findByName(String userName){
		return findByCriteria(Restrictions.eq("username", userName)).get(0);
	}
}
