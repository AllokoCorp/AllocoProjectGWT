package com.project.Alloco.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoToSignUpEvent extends GwtEvent<GoToSignUpEventHandler> {
  public static Type<GoToSignUpEventHandler> TYPE = new Type<GoToSignUpEventHandler>();
  
  @Override
  public Type<GoToSignUpEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(GoToSignUpEventHandler handler) {
    handler.onGoToSignUp(this);
  }
}
