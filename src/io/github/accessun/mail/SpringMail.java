package io.github.accessun.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SpringMail {

    public static void sendSimpleMail(String host, int port, String username, String password, String to, String title,
            String content) throws MailException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSender.getUsername());
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);

        mailSender.send(message);
    }

    public static void sendHtmlMail(String host, int port, String username, String password, String to, String title,
            String htmlContent) throws MailException, MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setFrom(mailSender.getUsername());
        messageHelper.setTo(to);
        messageHelper.setSubject(title);
        messageHelper.setText(htmlContent, true); // set the second parameter to true if the content is of html format

        mailSender.send(message);
    }
}
