package com.project.Alloco.client;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.core.client.GWT;

import com.project.Alloco.client.AppController;
import com.project.Alloco.client.service.UserAccessService;
import com.project.Alloco.client.service.UserAccessServiceAsync;
import com.project.Alloco.client.view.login.LoginView;

public class Alloco implements EntryPoint {
   public void onModuleLoad() {
	   //RootPanel.get("gwtContainer").add(new LoginView());   
	   UserAccessServiceAsync rpcService = GWT.create(UserAccessService.class);    
	   HandlerManager eventBus = new HandlerManager(null);
	   AppController appViewer = new AppController(rpcService, eventBus);
	   appViewer.go(RootPanel.get());
   }    
} 