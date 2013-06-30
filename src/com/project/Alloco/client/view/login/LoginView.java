package com.project.Alloco.client.view.login;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.project.Alloco.client.service.UserAccessService;
import com.project.Alloco.client.service.UserAccessServiceAsync;
import com.project.Alloco.shared.model.allocoUser;
import com.project.Alloco.client.presenter.Presenter;
//import com.project.Alloco.view.signup.SignUp;


public class LoginView extends Composite  {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);
	//private final AllocoControllerServiceAsync allocoService= GWT.create(AllocoControllerService.class);
	private UserAccessServiceAsync  userAccessService= GWT.create(UserAccessService.class);

	  private Presenter presenter;

	@UiField(provided = true)
	final LoginResources res;
	@UiField
	TextBox loginBox;
	@UiField
	TextBox passwordBox;
	@UiField
	Anchor completionAnchor;

	public interface Presenter {
		    void onLoginButtonClicked(String sUsername, String sPassw);
		    void onSignUpButtonClicked();		    
		  }
	  
	  /*
	 * @UiTemplate is not mandatory but allows multiple XML templates
	 * to be used for the same widget. 
	 * Default file loaded will be <class-name>.ui.xml
	 */
	@UiTemplate("Login.ui.xml")
	interface LoginUiBinder extends UiBinder<Widget, LoginView> {
	}

	public LoginView() {
		this.res = GWT.create(LoginResources.class);
		res.style().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		userAccessService= GWT.create(UserAccessService.class);
	}

	public LoginView(String i) {
		this.res = GWT.create(LoginResources.class);
		res.style().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		userAccessService= GWT.create(UserAccessService.class);
		
		loginBox.setText(i);
	}

	public Widget asWidget() {
	    return this;
	  }
	
	//@UiField
	//Label completionLabel1;

	//@UiField
	//Label completionLabel2;

	private Boolean tooShort = false;

	public void setPresenter(Presenter presenter) {
	    this.presenter = presenter;
	  }
	/*
	 * Method name is not relevant, the binding is done according to the class
	 * of the parameter.
	 */
	@UiHandler("buttonSubmit")
	void doClickSubmit(ClickEvent event) {
		System.out.println("[TRACE] Login: doClickSubmit");
		
		if (!tooShort) {
			System.out.println("[TRACE] Login: doClickSubmit !tooShort");
			
			if (presenter != null) {
			      presenter.onLoginButtonClicked(loginBox.getText(), passwordBox.getText());
			    }
			
		} else {
			System.out.println("[TRACE] Login: doClickSubmit tooShort");
			Window.alert("Login or Password is too short! x");
		}
	}
	
	
	/*
	 * Method name is not relevant, the binding is done according to the class
	 * of the parameter.
	 */
	@UiHandler("completionAnchor")
	void onClickSignUp(ClickEvent event) {
		System.out.println("[TRACE] Login: onClickSignUp");
		
		if (!tooShort) {
			System.out.println("[TRACE] Login: onClickSignUp !tooShort");
			
			if (presenter != null) {
			      presenter.onSignUpButtonClicked();
			    }
			
		} else {
			System.out.println("[TRACE] Login: doClickSubmit tooShort");
			Window.alert("Login or Password is too short! x");
		}				
	}
	

	@UiHandler("loginBox")
	void handleLoginChange(ValueChangeEvent<String> event) {
		if (event.getValue().length() < 6) {
			//completionLabel1.setText("Login too short (Size must be > 6)");
			tooShort = true;
		} else {
			tooShort = false;
			//completionLabel1.setText("");
		}
	}

	@UiHandler("passwordBox")
	void handlePasswordChange(ValueChangeEvent<String> event) {
		if (event.getValue().length() < 6) {
			tooShort = true;
			//completionLabel2.setText("Password too short (Size must be > 6)");
		} else {
			tooShort = false;
			//completionLabel2.setText("");
		}
	}


}