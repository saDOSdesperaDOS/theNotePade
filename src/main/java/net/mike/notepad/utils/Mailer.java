package net.mike.notepad.utils;

import com.vaadin.flow.component.notification.Notification;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mailer {

    public void send(String email) {
        //System.out.println("Подтвердите проверочный код:  - " + cD.getVerifyCode());
        //String password = "<vc39hec";
        String password = "QrTdj9eryh";
        final String to = email;
        final String from = "sendersignal@gmail.com";

<<<<<<< HEAD
        Properties properties = new Properties();
=======
        Properties properties = System.getProperties();
>>>>>>> emb
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
<<<<<<< HEAD

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                }
        );
=======
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.user", from);
        properties.put("user.name", "mike");


        Session session = Session.getDefaultInstance(properties, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

>>>>>>> emb
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Veryfing your email");
            message.setText(CodeGenerator.getInstance().getCode());//!!!отсылает адрес обьекта в памяти, а не сам код
<<<<<<< HEAD
            Transport.send(message);
=======
            Transport.send(message, from, password);
>>>>>>> emb
        } catch (AddressException e) {
            e.printStackTrace();
            Notification.show("AddressExeption");
        } catch (MessagingException e) {
            e.printStackTrace();
            Notification.show("MessagingException");
        }
    }
    public boolean regExpValidator(String email) {
        Pattern p = Pattern.compile("^(.+)@(.+)$");
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
