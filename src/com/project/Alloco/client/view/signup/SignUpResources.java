package com.project.Alloco.client.view.signup;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface SignUpResources extends ClientBundle {
   /**
   * Sample CssResource.
   */
   public interface MyCss extends CssResource {
      String blackText();

      String redText();

      String loginButton();

      String box();

      String background();
   }

   @Source("SignUp.css")
   MyCss style();
}