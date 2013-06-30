package com.project.Alloco.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback; 
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.Window;
import com.project.Alloco.client.event.GoToSignUpEvent;
import com.project.Alloco.client.service.UserAccessServiceAsync;
import com.project.Alloco.client.view.login.LoginView;
import com.project.Alloco.shared.model.allocoUser;

public class LoginPresenter implements Presenter, LoginView.Presenter{  
   
 
  private final UserAccessServiceAsync rpcService;
  private final HandlerManager eventBus;
  private final LoginView view;
  
  public LoginPresenter(UserAccessServiceAsync rpcService, HandlerManager eventBus, LoginView view) {
    this.rpcService = rpcService;
    this.eventBus = eventBus;
    
    this.view = view;
    this.view.setPresenter(this);
  }
  
 
  public void go(final HasWidgets container) {
	  container.clear();
	  container.add(view.asWidget());
  }

  private void doTestRefresh() {
       
//    rpcService.updateContact(contact, new AsyncCallback<Contact>() {
//        public void onSuccess(Contact result) {
//          eventBus.fireEvent(new ContactUpdatedEvent(result));
//        }
//        public void onFailure(Throwable caught) {
//          Window.alert("Error updating contact");
//        }
//    });
  }

  
  public void onSignUpButtonClicked()
  {
	  eventBus.fireEvent(new GoToSignUpEvent());	  
  }
  

	@Override
	public void onLoginButtonClicked(String sUsername, String sPassw)	 {
		rpcService.logIn(sUsername, sPassw, new AsyncCallback<allocoUser>() {
			public void onSuccess(allocoUser result) {
				System.out.println("[TRACE] userAccessService.logIn");
				if(result != null ){
					String message = "\n Login: " + result.getName();
					message += "\n Password: " + result.getPassword();
					message += "\n Birth: " + result.getBirth();
					message += "\n Sex: " + result.getSex();
					message += "\n Email: " + result.getEmail();
					Window.alert("Login Successful! " + message);
					
				}else{
					Window.alert("Login Failed x! ");
					System.out.println("Login Failed x! ");
				}
				
			}

			public void onFailure(Throwable caught) {
				Window.alert("Login Failed x! ");
				System.out.println("Login Failed x! ");
			}
		});
		
	}
  
}
