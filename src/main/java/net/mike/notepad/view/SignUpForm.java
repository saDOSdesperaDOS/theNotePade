package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.mike.notepad.controller.Role;
import net.mike.notepad.dbase.services.UserService;
import net.mike.notepad.utils.CodeGenerator;
import net.mike.notepad.utils.Mailer;

import java.util.HashMap;
import java.util.Map;

@Route("signup")
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class SignUpForm extends FormLayout {
	Mailer mailer;
	UserService userService;

	public SignUpForm() {
		EmailField email = new EmailField("Email");
		PasswordField pass = new PasswordField("Password");
		PasswordField confirmPass = new PasswordField("Confirm Password");
		Button greateAccount = new Button("Greate Account");

		  add(email ,pass, confirmPass, greateAccount);
		  setWidth("25%");
		  setHeight("65%");
		  getElement().getStyle().set("position", "absolute");
		  getElement().getStyle().set("margin-top", "5%");
		  getElement().getStyle().set("margin-left", "37%");

		  greateAccount.addClickListener( e-> {
			  if(!confirmPass.getValue().equals(pass.getValue())) {
				  Notification.show("Passwords don't match").setPosition(Notification.Position.BOTTOM_CENTER);
				  return;
			  }
			   mailer = new Mailer();
			   userService = new UserService();
			  if(mailer.regExpValidator(email.getValue()) && !userService.isRegistered(email.getValue())) {
				  mailer.send(email.getValue());
				  Notification.show("A verification code has been sent to your email address").setPosition(Notification.Position.BOTTOM_CENTER);
				  Dialog dialog = new Dialog();
				  TextField textField = new TextField();
				  Button confirmButton = new Button("Verify");
				  dialog.add(textField, confirmButton);
				  dialog.open();
				  textField.focus();
				  confirmButton.addClickListener(event -> {
					  if (textField.getValue().equals(CodeGenerator.getInstance().getCode())) {
						  userService.addUser(email.getValue(), pass.getValue(), Role.USER.toString(), VaadinRequest.getCurrent().getWrappedSession().getId());
						  dialog.close();
						  Notification.show("Your email is verifyng").setPosition(Notification.Position.BOTTOM_CENTER);
						  Map<String, String> param = new HashMap<>();
						  param.put("email", email.getValue());
						  confirmButton.getUI().ifPresent(ui -> ui.navigate("signin", QueryParameters.simple(param)));
					  }
					  else {
						  textField.clear();
						  Notification.show("Your email is NOT verifyng").setPosition(Notification.Position.BOTTOM_CENTER);
					  }
				  });
			  }
		  });
	}
}
