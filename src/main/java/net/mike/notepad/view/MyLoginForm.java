package net.mike.notepad.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.UIInitEvent;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinServletRequest;

import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Route("login")
public class MyLoginForm extends Div {

	public MyLoginForm() {
		final EmailField userEmailField = new EmailField("Email");
		final PasswordField userPasswordField = new PasswordField("Password");
		final Button loginButton = new Button("Login");
		final FormLayout formLayout = new FormLayout();
		String email = VaadinServletRequest.getCurrent().getHttpServletRequest().getQueryString().split("=")[1];
		if (email.contains("ui")) {
			UI.getCurrent().getPage().reload();
			return;
		}
	    formLayout.add(userEmailField,userPasswordField,loginButton);
	    add(formLayout);

	    setWidth("25%");
		setHeight("65%");
		getElement().getStyle().set("position", "absolute");
		getElement().getStyle().set("margin-top", "5%");
		getElement().getStyle().set("margin-left", "37%");

		userEmailField.setValue(email);

	    loginButton.addClickListener(click -> {
	    	if(loginCheck()) {
				Map<String, String> param = new HashMap<>();
				param.put("email", userEmailField.getValue());
	    		loginButton.getUI().ifPresent(ui -> ui.navigate("grid", QueryParameters.simple(param)));
	    	}
	    });
	}
	
	public boolean loginCheck() {
		return true;
	}

}
