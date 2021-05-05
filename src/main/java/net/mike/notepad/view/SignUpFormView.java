package net.mike.notepad.view;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.mike.notepad.dbase.entyties.UserDataSet;
import net.mike.notepad.dbase.services.UserService;
import net.mike.notepad.utils.CodeGenerator;
import net.mike.notepad.utils.Mailer;

@Route("signup")
public class SignUpFormView extends VerticalLayout {
	Mailer mailer;
	UserService userService;
	public SignUpFormView() {
		final FormLayout form = new FormLayout();
		EmailField email = new EmailField("Email");
		PasswordField pass = new PasswordField("Password");
		PasswordField confirmPass = new PasswordField("Confirm Password");
		Button b = new Button("Greate Account");

		  form.add(email ,pass, confirmPass, b);

		  b.addClickListener( e-> {
			  if(!confirmPass.getValue().equals(pass.getValue())) {
				  Notification.show("passwords don't match").setPosition(Notification.Position.BOTTOM_CENTER);
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
						  userService.addUser(email.getValue(), pass.getValue());
						  dialog.close();
						  Notification.show("Your email is verifyng").setPosition(Notification.Position.BOTTOM_CENTER);
						  confirmButton.getUI().ifPresent(ui -> ui.navigate("login"));
					  }
					  else {
						  textField.clear();
						  Notification.show("Your email is NOT verifyng").setPosition(Notification.Position.BOTTOM_CENTER);

					  }

				  });
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
