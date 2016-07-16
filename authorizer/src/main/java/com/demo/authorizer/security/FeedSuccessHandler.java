package com.demo.authorizer.security;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class FeedSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		String page = "";
		if (roles.contains("MANAGER")) {
			page = "homeManager";
		} else {
			page = "home";
		}
		for (String string : roles) {
			if(string.contains("userId_")){
				String userIdString = string;
				String userId = userIdString.split("_")[1];
				session.setAttribute("userId", userId);
			}
			
		}
		
		RequestDispatcher dd = request.getRequestDispatcher(page);
		dd.forward(request, response);
	}

}
