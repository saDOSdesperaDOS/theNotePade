package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;

@Route("login")
public class MyLoginForm extends Div {

	public MyLoginForm() {
	  
		final Button loginButton = new Button("Login"); 
	    final EmailField userEmailField = new EmailField("Email"); 
	    final PasswordField userPasswordField = new PasswordField("Password"); 	
	    final FormLayout formLayout = new FormLayout();
	    formLayout.add(userEmailField,userPasswordField,loginButton);
	    add(formLayout);
	    loginButton.addClickListener(click -> {
	    	if(loginCheck()) {
	    		loginButton.getUI().ifPresent(ui -> ui.navigate("grid"));
	    	}
	    });
		setWidth("25%");
		setHeight("65%");
		getElement().getStyle().set("position", "absolute");
		getElement().getStyle().set("margin-top", "5%");
		getElement().getStyle().set("margin-left", "37%");
		
		//Notification.show(lgF.getElement().getComponent().se);
	}
	
	public boolean loginCheck() {
		return true;
	}
	
}
