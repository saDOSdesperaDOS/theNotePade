package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;
import net.mike.notepad.dbase.services.UserService;

@Route("signup")
public class SignUpFormView extends VerticalLayout {
	
	public SignUpFormView() {
		
		final FormLayout form = new FormLayout();
		EmailField email = new EmailField("Email");
		PasswordField pass = new PasswordField("Password");
		PasswordField confirmPass = new PasswordField("Confirm Password");
		/*create an instance that provides methods for servicing the Account entity*/
		UserService userService = new UserService();
		Button b = new Button("Register");
		
		  form.add(email ,pass, confirmPass, b);
		  b.addClickListener( e-> {
					userService.addUser(email.getValue(), pass.getValue());
					Notification.show("Your account created.");
					b.getUI().ifPresent(ui -> ui.navigate("login"));
			  });
		  
		  setWidth("25%");
		  setHeight("65%");
		  getElement().getStyle().set("position", "absolute");
		  getElement().getStyle().set("margin-top", "5%");
		  getElement().getStyle().set("margin-left", "37%");
		  add(form);
		
	}

}
