package com.project.Alloco.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.project.Alloco.shared.model.allocoUser;

@RemoteServiceRelativePath("VlpController")
public interface AllocoControllerService extends RemoteService {
	
		allocoUser getAllocoUser(String username, String password) throws Exception;
		boolean getAllocoUserMembre (String username, String password) throws Exception;
		
		
}
