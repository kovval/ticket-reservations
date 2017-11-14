package com.github.java4wro.generator;

import com.github.java4wro.generator.dto.EventDTO;
import com.github.java4wro.generator.dto.OwnerDTO;
import com.github.java4wro.generator.dto.TicketDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import javax.mail.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class GeneratorPDF {


    public void generateAndSendTicket(EventDTO eventDTO, OwnerDTO ownerDTO, TicketDTO ticketDTO) throws IOException, MailAuthenticationException, MailParseException, MessagingException, MailSendException {

        PDDocument document = new PDDocument();

        PDPage page = new PDPage();
        String imageQR = "ticket-reservations/QR.jpg";

        document.addPage(page);


        PDFont font = PDType1Font.TIMES_ROMAN;


        PDImageXObject image = PDImageXObject.createFromFile(imageQR, document);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.beginText();
        contentStream.setFont(font, 25);
        contentStream.moveTextPositionByAmount(180, 750);
        contentStream.drawString("NARODOWE FORUM MUZYKI ");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(100, 700);
        contentStream.drawString("Event: " + eventDTO.getEventName());          // Wydarzenie + nazwa
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(100, 650);

        String dataEvent = eventDTO.getEventDateAndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        contentStream.drawString("Data: " + dataEvent);  // data wydarzenia
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(400, 600);
        contentStream.drawString("Price: " + ticketDTO.getPrice());                // cena wydarzenia
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(400, 700);
        contentStream.drawString("Ticket for: " + ownerDTO.getEmail());           // email
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(100, 600);
        contentStream.drawString("seat: "
                + ticketDTO.getSeat()
                + " row: "
                + ticketDTO.getRow());      // miejsce i rząd
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(400, 650);
        contentStream.drawString("id: " + ticketDTO.getTicketId().hashCode());           // id
        contentStream.endText();

        contentStream.drawImage(image, 250, 450, 100, 100);


        contentStream.close();
        document.save(eventDTO.getEventName() + ticketDTO.getTicketId().hashCode() + ".pdf");
        document.close();


        // Wysyła wiadomosc, ma ustawionego maila na tego co trzeba brakuje jeszcze wstawienia załącznika
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

        MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("Teraz trzeba jeszcze poprzestawiac ustawienia",
                "This is text content",
                "Wydarzenie miesiaca1569.pdf",
                "jan.kisiel22@gmail.com");


        /* Dzialajacy mail bez wiadomosci

        String crunchifyConfFile = "Spring-Mail.xml";
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);


        CrunchifyEmailAPI crunchifyEmailAPI = (CrunchifyEmailAPI) context.getBean("crunchifyEmail");
        String toAddr = "javawro4@gmail.com";
        String fromAddr = "javawro4@gmail.com";


        String subject = "Kolejny test, Dupa?";
        String body = "Test";
        crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
        */

    }


    public static void main(String[] args) throws IOException, MessagingException {

        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventName("Wydarzenie miesiaca");
        eventDTO.setEventDateAndTime(LocalDateTime.now());

        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setEmail("kovval@pl");

        TicketDTO ticket = new TicketDTO();
        ticket.setPrice(BigDecimal.valueOf(12.99));
        ticket.setRow("12");
        ticket.setSeat("10");
        ticket.setTicketId("12");


        GeneratorPDF generator = new GeneratorPDF();
        generator.generateAndSendTicket(eventDTO, ownerDTO, ticket);
    }

}
