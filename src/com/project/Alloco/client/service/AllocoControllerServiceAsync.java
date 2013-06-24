package com.project.Alloco.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.project.Alloco.shared.model.allocoUser;

public interface AllocoControllerServiceAsync {

	void getAllocoUser(String username, String password,
			AsyncCallback<allocoUser> callback);

	void getAllocoUserMembre(String username, String password,
			AsyncCallback<Boolean> callback);

}
