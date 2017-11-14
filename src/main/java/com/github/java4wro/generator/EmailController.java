package com.github.java4wro.generator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmailController {
    private final EmailSender emailSender;


    @Autowired
    public EmailController(EmailSender emailSender){
        this.emailSender = emailSender;

    }

//    @RequestMapping("/")
//    public String send() {
//        Context context = new Context();
//        context.setVariable("header", "Nowy artykuł na CodeCouple");
//        context.setVariable("title", "#8 Spring Boot – email - szablon i wysyłanie");
//        context.setVariable("description", "Tutaj jakis opis...");
//
//        String body = templateEngine.process("template", context);
//        emailSender.sendEmail("javawro4@gmail.com", "CodeCouple Newsletter", body);
//        return "index";
//    }

}
