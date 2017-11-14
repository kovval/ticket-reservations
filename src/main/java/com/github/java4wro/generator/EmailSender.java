package com.github.java4wro.generator;

public interface EmailSender  {

    void sendEmail(String to, String subject, String content, String path);

}
