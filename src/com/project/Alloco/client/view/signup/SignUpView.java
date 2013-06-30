package com.project.Alloco.client.view.signup;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.project.Alloco.client.service.AllocoControllerService;
import com.project.Alloco.client.service.AllocoControllerServiceAsync;
import com.project.Alloco.client.service.UserAccessService;
import com.project.Alloco.client.service.UserAccessServiceAsync;
import com.project.Alloco.client.view.login.LoginView.Presenter;
import com.project.Alloco.shared.model.allocoUser;


public class SignUpView extends Composite  {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);
	//private final AllocoControllerServiceAsync allocoService= GWT.create(AllocoControllerService.class);
	private UserAccessServiceAsync  userAccessService= GWT.create(UserAccessService.class);

	
	 public interface Presenter {
		    void onLoginButtonClicked(String sUsername, String sPassw);		    
		  }
	  
	  public Widget asWidget() {
		    return this;
		  }
	 
	 private Presenter presenter;
	/*
	 * @UiTemplate is not mandatory but allows multiple XML templates
	 * to be used for the same widget. 
	 * Default file loaded will be <class-name>.ui.xml
	 */
	@UiTemplate("SignUp.ui.xml")
	interface LoginUiBinder extends UiBinder<Widget, SignUpView> {
	}

	@UiField(provided = true)
	final SignUpResources res;

	public SignUpView() {
		this.res = GWT.create(SignUpResources.class);
		res.style().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		userAccessService= GWT.create(UserAccessService.class);
	}

	@UiField
	TextBox nameBox;

	@UiField
	TextBox sexBox;
	
	@UiField
	TextBox birthBox;

	@UiField
	TextBox eMailBox;
	
	@UiField
	TextBox passwordBox;

	@UiField
	TextBox passwordVerBox;


	private Boolean tooShort = false;

	/*
	 * Method name is not relevant, the binding is done according to the class
	 * of the parameter.
	 */
	@UiHandler("buttonSubmit")
	void doClickSubmit(ClickEvent event) {
		System.out.println("[TRACE] SignUp: doClickSubmit");
		
		Window.alert("STORING IN THE BD ");
		/*
		if (!tooShort) {
			System.out.println("[TRACE] Login: doClickSubmit !tooShort");
			userAccessService.logIn(loginBox.getText(), passwordBox.getText(), new AsyncCallback<allocoUser>() {
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
						Window.alert("Login Failed! ");
					}
					
				}

				public void onFailure(Throwable caught) {
					Window.alert("Login Failed! ");
				}
			});
			
		} else {
			System.out.println("[TRACE] Login: doClickSubmit tooShort");
			Window.alert("Login or Password is too short!");
		}
		*/
	}
	
	
	/*
	 * Method name is not relevant, the binding is done according to the class
	 * of the parameter.
	 */	

	@UiHandler("nameBox")
	void handleNameBoxChange(ValueChangeEvent<String> event) {
		System.out.println("[TRACE] SignUp: handleNameBoxChange");
		if (event.getValue().length() < 6) {
			//completionLabel1.setText("Login too short (Size must be > 6)");
			tooShort = true;
		} else {
			tooShort = false;
			//completionLabel1.setText("");
		}
	}
	
	@UiHandler("sexBox")
	void handleSexBoxChange(ValueChangeEvent<String> event) {
		System.out.println("[TRACE] SignUp: handleSexBoxChange");
		if (event.getValue().length() < 6) {
			//completionLabel1.setText("Login too short (Size must be > 6)");
			tooShort = true;
		} else {
			tooShort = false;
			//completionLabel1.setText("");
		}
	}
	
	@UiHandler("birthBox")
	void handleBirthBoxChange(ValueChangeEvent<String> event) {
		System.out.println("[TRACE] SignUp: handleBirthBoxChange");
		if (event.getValue().length() < 6) {
			//completionLabel1.setText("Login too short (Size must be > 6)");
			tooShort = true;
		} else {
			tooShort = false;
			//completionLabel1.setText("");
		}
	}
	
	@UiHandler("eMailBox")
	void handleEMailBoxChange(ValueChangeEvent<String> event) {
		System.out.println("[TRACE] SignUp: handleEMailBoxChange");
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
		System.out.println("[TRACE] SignUp: handlePasswordChange");
		if (event.getValue().length() < 6) {
			//completionLabel1.setText("Login too short (Size must be > 6)");
			tooShort = true;
		} else {
			tooShort = false;
			//completionLabel1.setText("");
		}
	}
	

	@UiHandler("passwordVerBox")
	void handlePasswordVerChange(ValueChangeEvent<String> event) {
		System.out.println("[TRACE] SignUp: handlePasswordChange");
		if (event.getValue().length() < 6) {
			tooShort = true;
			//completionLabel2.setText("Password too short (Size must be > 6)");
		} else {
			tooShort = false;
			//completionLabel2.setText("");
		}
	}

	public void setPresenter(Presenter presenter) {
	    this.presenter = presenter;
	  }
}