package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;
import net.mike.notepad.dbase.entyties.UserDataSet;
import net.mike.notepad.dbase.services.CodeGenerator;
import net.mike.notepad.dbase.services.UserService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Route("check")
public class EmailCheckView extends Div {
	
	public EmailCheckView() {
	  
		EmailField email = new EmailField("email");
		Button checkEmailButton = new Button("check");
		String a = "a"; 
		
		add(email, checkEmailButton);
	//ТАК ОБРАБОТЧИК СОБЫТИЯ РАБОТАЕТ С ПЕРВОГО РАЗА	 
		   checkEmailButton.addClickListener( e-> {
			   										if(check(email.getValue())) {
			   											new UserDataSet(email.getValue());
			   											checkEmailButton.getUI().ifPresent(ui -> ui.navigate("confirm"));
			   										}
	      	    							  	  }
		    );
		     			setWidth("25%");
		     			setHeight("65%");
		     			getElement().getStyle().set("position", "absolute");
		     			getElement().getStyle().set("margin-top", "5%");
		     			getElement().getStyle().set("margin-left", "37%");
   }
	
	//Проверяем email на regex и на busy 
		public boolean check(String email) {
			UserService userService = new UserService();
	     		if(regExpValidator(email)&&!userService.getUsersList().contains(email)) {
						send(email);
	              Notification.show("Verification code sent to your email");
	              return true;
	     		} else {
	              Notification.show("Email busy or There was a mistake while entering Email");
                return false;
	     		}
	     }

		public boolean regExpValidator(String email) {
			Pattern p = Pattern.compile("^(.+)@(.+)$");
			Matcher m = p.matcher(email);
			return m.matches();
			}
		
		public void send(String email) {
			
		    //System.out.println("Подтвердите проверочный код:  - " + cD.getVerifyCode());
			  //String password = "<vc39hec";
			  String password = "QrTdj9eryh";
		      final String to = email;
		      final String from = "sendersignal@gmail.com";

		      Properties properties = new Properties();
		      properties.put("mail.smtp.starttls.enable", "true");
		      properties.put("mail.smtp.auth", "true");
		      properties.put("mail.smtp.host", "smtp.gmail.com");
		      properties.put("mail.smtp.port", "587");

		      Session session = Session.getInstance(properties,
		              new javax.mail.Authenticator() {
		                  protected PasswordAuthentication getPasswordAuthentication() {
		                      return new PasswordAuthentication(from, password);
		                  }
		               }
		      );
		      MimeMessage message = new MimeMessage(session);
		      
		      try {
				   message.setFrom(new InternetAddress(from));
				   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			       message.setSubject("Veryfing your email");
			       message.setText(CodeGenerator.getInstance().getCode());//!!!отсылает адрес обьекта в памяти, а не сам код
			       Transport.send(message);
			       } catch (AddressException e) {
				            e.printStackTrace();
				            Notification.show("AddressExeption");
			       } catch (MessagingException e) {
				           e.printStackTrace();
				           Notification.show("MessagingException");
			       }
		     
		      
		}
}
