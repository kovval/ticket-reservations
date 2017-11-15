//package com.github.java4wro.generator;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//@Service
//public class EmailSenderImpl implements EmailSender {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Override
//    public void sendEmail(String to, String subject, String content, String path) {
//       MimeMessage  mail = javaMailSender.createMimeMessage();
//       try {
//           MimeMessageHelper helper = new MimeMessageHelper(mail, true);
//           helper.setReplyTo("tiket.java@gmail.com");
//           helper.setFrom("tiket.java@gmail.com");
//           helper.setSubject("tytul");
//           helper.setText(content, true);
//           FileSystemResource file = new FileSystemResource(path);
//           helper.addAttachment(file.getFilename(), file);
//       } catch (MessagingException e) {
//           e.printStackTrace();
//       }
//
//
//       javaMailSender.send(mail);
//
//    }
//
//}
