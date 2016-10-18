package io.github.accessun.mail;

import org.junit.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SpringMail {
    
    @Test
    public void sendMail() throws MailException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.exmail.qq.com");
        mailSender.setUsername("xin.sun@myhealthgene.com");
        mailSender.setPassword("sX123321");
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSender.getUsername());
        message.setTo("accessun@hotmail.com");
        message.setSubject("Spring JavaMailSenderImpl Test Message");
        message.setText("Hello world!");
        
        mailSender.send(message);
    }
}
