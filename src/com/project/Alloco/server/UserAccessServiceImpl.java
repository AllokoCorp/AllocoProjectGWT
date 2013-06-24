package com.project.Alloco.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.project.Alloco.client.service.UserAccessService;
import com.project.Alloco.controller.UserAccessController;
import com.project.Alloco.shared.Enumerations;
import com.project.Alloco.shared.model.allocoUser;

public class UserAccessServiceImpl extends RemoteServiceServlet implements
	UserAccessService {
	
	private static final long serialVersionUID = 5176658728192819412L;
	private UserAccessController ctrl = null;

	@Override
	public allocoUser logIn(String username, String password) throws Exception {
		System.out.println("[TRACE] UserAccessServiceImpl: logIn");
		if (ctrl == null) {
			ctrl = new UserAccessController();
		}

		allocoUser user = ctrl.authentify(username, password);
		
		if( user != null ){
			System.out.println("[TRACE] UserAccessServiceImpl: logIn user != null  " + user.toString() );
		}else{
			System.out.println("[TRACE] UserAccessServiceImpl: logIn user == null");
			System.out.println( "FAIL to log the user" ) ;
		}
		
		this.storeUserFromSession(user);
		return user;
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		deleteUserFromSession();
	}

	@Override
	public allocoUser logInFromSession() {
		System.out.println("[TRACE] UserAccessServiceImpl: logInFromSession");
		return retrieveUserFromSession();
	}
	
	private allocoUser retrieveUserFromSession() {
		System.out.println("[TRACE] UserAccessServiceImpl: retrieveUserFromSession");
		HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
		HttpSession session = httpServletRequest.getSession();
		Object currentUser = session
				.getAttribute(Enumerations.CookieAttribute.ALLOCOUSER.toString());
		if (currentUser instanceof allocoUser) {
			return (allocoUser) currentUser;
		} else {
			return null;
		}

	}
	
	private void storeUserFromSession(allocoUser user) {
		System.out.println("[TRACE] UserAccessServiceImpl: storeUserFromSession");
		HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
		HttpSession session = httpServletRequest.getSession(true);
		session.setAttribute(Enumerations.CookieAttribute.ALLOCOUSER.toString(), user);
	}

	private void deleteUserFromSession() {
		System.out.println("[TRACE] UserAccessServiceImpl: deleteUserFromSession");
		HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
		HttpSession session = httpServletRequest.getSession(false);
		session.removeAttribute(Enumerations.CookieAttribute.ALLOCOUSER.toString());
	}

}
