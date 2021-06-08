package net.mike.notepad.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.*;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.mike.notepad.dbase.entyties.UserDataSet;
import net.mike.notepad.dbase.services.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Route("signin")
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class SignInForm extends LoginForm {

	public SignInForm() {

		/*final FormLayout formLayout = new FormLayout();

		if(VaadinServletRequest.getCurrent().getHttpServletRequest().getQueryString() != null) {
			String email = VaadinServletRequest.getCurrent().getHttpServletRequest().getQueryString().split("=")[1];
			if (email.contains("ui")) {
				UI.getCurrent().getPage().reload();
				return;
			}
			userEmailField.setValue(email);
		}*/

		//formLayout.add(userEmailField,userPasswordField,loginButton);
	    /*add(formLayout);

	    setWidth("25%");
		setHeight("65%");*/
		getElement().getStyle().set("position", "absolute");
		getElement().getStyle().set("margin-top", "5%");
		getElement().getStyle().set("margin-left", "37%");
		
			addLoginListener(click -> {
				boolean isAuthenticated = authenticate(click.getUsername(), click.getPassword());
				if(isAuthenticated) {
					Map<String, String> param = new HashMap<>();
					param.put("email", click.getUsername());
					getUI().ifPresent(ui -> ui.navigate("grid", QueryParameters.simple(param)));
				} else {
					Notification.show("You could not be authenticated. Try again.").setPosition(Notification.Position.BOTTOM_CENTER);
				}
			});
	   /* loginButton.addClickListener(click -> {
	    	boolean isAuthenticated = authenticate(userEmailField, userPasswordField);
	    	if(isAuthenticated) {
				Map<String, String> param = new HashMap<>();
				param.put("email", userEmailField.getValue());
	    		loginButton.getUI().ifPresent(ui -> ui.navigate("grid", QueryParameters.simple(param)));
	    	} else {
				Notification.show("You could not be authenticated. Try again.").setPosition(Notification.Position.BOTTOM_CENTER);
			}
	    });*/
	}
	
	public boolean authenticate(String email, String password) {
		UserService userService = new UserService();
		if (userService.isRegistered(email) && userService.isValid(email, password)) {
			return true;
		}
		return false;
	}

	/*@Override
	public void beforeEnter(BeforeEnterEvent event) {
		Cookie[] cookies = VaadinServletRequest.getCurrent().getHttpServletRequest().getCookies();
		String cookie = null;
		for(Cookie c : cookies) {
			cookie = c.getValue();
		}
		if (cookie != null) {
			event.forwardTo("grid", VaadinSession.getCurrent());
		}
	}*/
}
