//package com.github.java4wro.generator;
//
//import com.sun.xml.internal.ws.api.message.Attachment;
//import com.sun.xml.internal.ws.api.message.AttachmentSet;
//import com.sun.xml.internal.ws.message.AttachmentSetImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailParseException;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMailMessage;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import sun.plugin.javascript.navig.Document;
//
//import javax.activation.DataHandler;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import javax.xml.bind.attachment.AttachmentMarshaller;
//import java.io.File;
//import java.util.Iterator;
//import java.util.Properties;
//
///**
// * @author Crunchify.com
// *
// */
//
//@Service("crunchifyEmail")
//public class CrunchifyEmailAPI {
//
//    @Autowired
//    private MailSender crunchifymail; // MailSender interface defines a strategy
//    // for sending simple mails
//
//    public void crunchifyReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody)  {
//
//
//
//
//        SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
//        crunchifyMsg.setFrom(fromAddress);
//        crunchifyMsg.setTo(toAddress);
//        crunchifyMsg.setSubject(subject);
//        crunchifyMsg.setText(msgBody);
//        crunchifymail.send(crunchifyMsg);
//    }
//
//    }
//
//
