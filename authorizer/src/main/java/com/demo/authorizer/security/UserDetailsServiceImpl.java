package com.demo.authorizer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.authorizer.dao.UsersDAO;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailsAssembler userDetailsAssembler;
	
	@Autowired
	private UsersDAO userDAO;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {

		UserDetails userDetails = null;
		com.demo.authorizer.entity.User userEntity = userDAO.findByName(userName);
		userDetails = userDetailsAssembler.fetchUserDetails(userEntity);
		if (userDetails == null) {
			throw new UsernameNotFoundException("Username or Password is incorrect");
		}
		return userDetails;
		
	}

}
