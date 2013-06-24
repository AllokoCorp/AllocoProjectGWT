package com.project.Alloco.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.project.Alloco.shared.model.allocoUser;

public interface UserAccessServiceAsync {

	void logIn(String username, String password,
			AsyncCallback<allocoUser> callback);

	void logInFromSession(AsyncCallback<allocoUser> callback);

	void logOut(AsyncCallback<Void> callback);

}
