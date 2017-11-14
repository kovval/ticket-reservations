package com.github.java4wro.generator;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

    public class MailMail {
        private JavaMailSender mailSender;
        private SimpleMailMessage simpleMailMessage;
        private String mailTo;
        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getMailTo() {
            return mailTo;
        }

        public void setMailTo(String mailTo) {
            this.mailTo = mailTo;
        }


        public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
            this.simpleMailMessage = simpleMailMessage;
        }

        public void setMailSender(JavaMailSender mailSender) {
            this.mailSender = mailSender;
        }


        public void sendMail(String dear, String content, String path, String mailTo) throws MessagingException {

            MimeMessage message = mailSender.createMimeMessage();


                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setFrom(simpleMailMessage.getFrom());
                helper.setTo(mailTo);
                helper.setSubject(simpleMailMessage.getSubject());
                helper.setText(String.format(
                        simpleMailMessage.getText(), dear, content));


                FileSystemResource file = new FileSystemResource(path);
                helper.addAttachment(file.getFilename(), file);


            mailSender.send(message);
        }
    }

