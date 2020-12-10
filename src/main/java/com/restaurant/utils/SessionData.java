package com.restaurant.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.restaurant.model.eo.Users;

@Component
@SessionScope
public class SessionData {

	private Users loggedUser;

	public Users getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(Users loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	
}
