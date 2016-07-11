package com.demo.authorizer.dao;

import com.demo.authorizer.entity.User;

public interface UsersDAO extends GenericDAO<User, Integer> {

	User findByName(String userName);
	
}
