package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.mike.notepad.dbase.services.UserService;
import net.mike.notepad.utils.Mailer;

@Route("signup")
public class SignUpFormView extends VerticalLayout {
	Mailer mailer;
	UserService userService;
	public SignUpFormView() {
		
		final FormLayout form = new FormLayout();
		TextField userName = new TextField("UserName");
		EmailField email = new EmailField("Email");
		PasswordField pass = new PasswordField("Password");
		PasswordField confirmPass = new PasswordField("Confirm Password");
		/*create an instance that provides methods for servicing the Account entity*/
		Button b = new Button("Greate Account");

		  form.add(userName, email ,pass, confirmPass, b);
		  b.addClickListener( e-> {
			   mailer = new Mailer();
			   userService = new UserService();
			  if(mailer.regExpValidator(email.getValue()) && !userService.isRegistered(email.getValue())) {
				  mailer.send(email.getValue());
				  Notification.show()
				  b.getUI().ifPresent(ui -> ui.navigate("confirm"));
			  }
		  });
		  
		  setWidth("25%");
		  setHeight("65%");
		  getElement().getStyle().set("position", "absolute");
		  getElement().getStyle().set("margin-top", "5%");
		  getElement().getStyle().set("margin-left", "37%");
		  add(form);
		
	}

}
