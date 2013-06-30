package com.project.Alloco.client;




import com.project.Alloco.client.event.GoToSignUpEvent;
import com.project.Alloco.client.event.GoToSignUpEventHandler;
import com.project.Alloco.client.presenter.LoginPresenter;
import com.project.Alloco.client.presenter.Presenter;
import com.project.Alloco.client.presenter.SignUpPresenter;
import com.project.Alloco.client.service.UserAccessServiceAsync;
import com.project.Alloco.client.view.login.LoginView;
import com.project.Alloco.client.view.signup.SignUpView;


import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
  private final HandlerManager eventBus;
  private final UserAccessServiceAsync rpcService; 
  private HasWidgets container;
  private LoginView LoginView = null;
  private SignUpView signupview = null;
 
  
  public AppController(UserAccessServiceAsync rpcService, 
  		HandlerManager eventBus) {
    this.eventBus = eventBus;
    this.rpcService = rpcService;
    bind();
  }
  
  private void bind() {
    History.addValueChangeHandler(this);
   
    
    eventBus.addHandler(GoToSignUpEvent.TYPE,
            new GoToSignUpEventHandler() {
              public void onGoToSignUp(GoToSignUpEvent event) {
                goToSignUpPage();
              }
            }); 
    
  }
  
 
 
  protected void goToSignUpPage() {
	  History.newItem("signup");	
}

public void go(final HasWidgets container) {
    this.container = container;
    
    System.out.println("[TRACE] .AppController.go");
    if ("".equals(History.getToken())) {
      History.newItem("list");
      System.out.println("[TRACE] .AppController.go : History.newItem(\"list\")");
    }
    else {
      History.fireCurrentHistoryState();
      System.out.println("[TRACE] .AppController.go : History.fireCurrentHistoryState");
    }
  }

  public void onValueChange(ValueChangeEvent<String> event) {
    String token = event.getValue();
    
    if (token != null) {
      if (token.equals("list")) {
        GWT.runAsync(new RunAsyncCallback() {
          public void onFailure(Throwable caught) {
          }
      
          public void onSuccess() {
            // lazily initialize our views, and keep them around to be reused
            //
            if (LoginView == null) {
            	LoginView = new LoginView("jmp");
              
            }
            new LoginPresenter(rpcService, eventBus, LoginView).
            go(container);
          }
        });
      }
      else if (token.equals("signup")) {
        GWT.runAsync(new RunAsyncCallback() {
          public void onFailure(Throwable caught) {
          }
      
          public void onSuccess() {
           
			// lazily initialize our views, and keep them around to be reused
            //
        	  if (signupview == null) {
        		  signupview = new SignUpView();
                
              }
              new SignUpPresenter(rpcService, eventBus, signupview).
              go(container);
          }
        });
      }
    }
  } 
}
