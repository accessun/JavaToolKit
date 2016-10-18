package io.github.accessun.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.Test;

public class SendEmailTest {
    
    @Test
    public void testSendEmail() throws AddressException, MessagingException {
        String username = "gaccessun";
        String password = "";
        String recipientEmail = "accessun@hotmail.com";
        String title = "JavaMail Test Email Title";
        String message = "In Reset Password page, the field 'email address' is filled automatically and it ... You have to save it in DB before sending email by using token";
        
        GoogleMail.Send(username, password, recipientEmail, title, message);
    }
}
