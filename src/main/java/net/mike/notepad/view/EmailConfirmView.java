package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.mike.notepad.utils.CodeGenerator;

@Route("confirm")
public class EmailConfirmView extends Div {
  
	public EmailConfirmView() {
	    TextField clientCode = new TextField("Insert verify code");
	    Button button = new Button("Verify");

	    add(clientCode, button);
	    
	    button.addClickListener(click -> {
	    	if (clientCode.getValue().equals(CodeGenerator.getInstance().getCode())) {
				Notification.show("Your email is verifyng");
	    		button.getUI().ifPresent(ui -> ui.navigate("signin"));
	    		}
	    	else {
	    		clientCode.clear();
	    		Notification.show("Your email is NOT verifyng");
	    	}
	    });
		setWidth("25%");
		setHeight("65%");
		getElement().getStyle().set("position", "absolute");
		getElement().getStyle().set("margin-top", "5%");
		getElement().getStyle().set("margin-left", "37%");
    }
}
