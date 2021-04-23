package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;
import net.mike.notepad.dbase.entyties.UserDataSet;
import net.mike.notepad.dbase.services.UserService;
import net.mike.notepad.utils.Mailer;

@Route("check")
public class EmailCheckView extends Div {
	Mailer mailer;
	UserService userService;

	public EmailCheckView() {
	  	EmailField email = new EmailField("email");
		Button checkEmailButton = new Button("check");
		add(email, checkEmailButton);
		   checkEmailButton.addClickListener( e-> {
			   mailer = new Mailer();
			   userService = new UserService();
			   if(mailer.regExpValidator(email.getValue()) && !userService.isRegistered(email.getValue())) {
			   	mailer.send(email.getValue());
			   	checkEmailButton.getUI().ifPresent(ui -> ui.navigate("confirm"));
			   } else {
				   Notification.show("The user with this email is already registered or you entered the email incorrectly");
				   email.clear();
			   }
		   });
		setWidth("25%");
		setHeight("65%");
		getElement().getStyle().set("position", "absolute");
		getElement().getStyle().set("margin-top", "5%");
		getElement().getStyle().set("margin-left", "37%");
   }
}
