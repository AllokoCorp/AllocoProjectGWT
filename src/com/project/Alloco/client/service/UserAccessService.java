package com.project.Alloco.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.project.Alloco.shared.model.allocoUser;

@RemoteServiceRelativePath("UserAccess")
public interface UserAccessService extends RemoteService {
	allocoUser logIn(String username, String password) throws Exception;
	void logOut();
	allocoUser logInFromSession();
}
