package com.demo.authorizer.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.demo.authorizer.entity.UserRole;

@Service
public class UserDetailsAssembler {
	
	User fetchUserDetails(com.demo.authorizer.entity.User userEntity) {
		
		String username = userEntity.getUsername();
	    String password = userEntity.getPassword();
	    boolean enabled = userEntity.isEnabled();
	    boolean accountNonExpired = userEntity.isEnabled();
	    boolean credentialsNonExpired = userEntity.isEnabled();
	    boolean accountNonLocked = userEntity.isEnabled();

	    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (UserRole role : userEntity.getUserRoles()) {
	      authorities.add(new SimpleGrantedAuthority(role.getRole().getRole()));
	    }
	    
	    User user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	    return user;
	}

}
