package com.project.Alloco.controller;

import com.project.Alloco.shared.bd.DatabaseQuery;
import com.project.Alloco.shared.model.allocoUser;



public class UserAccessController {
	private DatabaseQuery dbQuery;

	public UserAccessController() throws Exception {
		System.out.println("[TRACE] UserAccessController: UserAccessController()");
		dbQuery = new DatabaseQuery();
	}

	public allocoUser authentify(String username, String password)
			throws Exception {
		System.out.println("[TRACE] UserAccessController: authentify");
		String usernameLowerCase = username.toLowerCase();
		allocoUser user = null;
		
		user = dbQuery.validateUser(usernameLowerCase, password);
		
		return user;

	}


}
