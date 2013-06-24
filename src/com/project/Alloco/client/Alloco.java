package com.project.Alloco.client;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Alloco implements EntryPoint {
   public void onModuleLoad() {
      RootPanel.get().add(new Login());   
   }    
} 