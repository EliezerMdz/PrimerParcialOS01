package Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by EliezerMdz on 29/09/2016.
 */
@SessionScoped
@ManagedBean (name = "Mailer")

public class EmailSenderController {

    public void sendMail(){

        String username = "eliezermdz7@gmail.com";
        String password = "*****";
        String to = "yeffryv@gmail.com";
        String from = "rifaOP@gmail.com";
        String host = "localhost";

        Properties prop = System.getProperties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("");
            msg.setText("");

            Transport.send(msg);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
