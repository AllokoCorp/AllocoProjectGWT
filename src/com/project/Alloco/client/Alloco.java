package com.project.Alloco.client;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.project.Alloco.view.login.Login;

public class Alloco implements EntryPoint {
   public void onModuleLoad() {
	   RootPanel.get("gwtContainer").add(new Login());   
   }    
} 