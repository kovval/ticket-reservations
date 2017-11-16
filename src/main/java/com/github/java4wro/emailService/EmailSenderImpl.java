package com.github.java4wro.emailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderImpl implements EmailSender {

    @Autowired
    private final JavaMailSender javaMailSender;

    private static final Logger log = LoggerFactory.getLogger(EmailSenderImpl.class);

    @Autowired
    public EmailSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo("ticket.java@gmail.com");
            helper.setFrom("ticket.java@gmail.com");
            helper.setSubject(subject);
            helper.setText(content, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }

    @Override
    public void sendEmail(String to, String subject, String content, String path) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
                messageHelper.setTo(to);
                messageHelper.setFrom("javawro4@gmail.com");
                messageHelper.setSubject(subject);
                messageHelper.setText(content);
                FileSystemResource file = new FileSystemResource(path);
                messageHelper.addAttachment(file.getFilename(), file);
            }
        };

        this.javaMailSender.send(preparator);

    }

}