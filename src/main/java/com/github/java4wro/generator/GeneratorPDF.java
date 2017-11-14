package com.github.java4wro.generator;

import com.github.java4wro.generator.dto.EventPdfDTO;
import com.github.java4wro.generator.dto.OwnerPdfDTO;
import com.github.java4wro.generator.dto.TicketPdfDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;


@Service
public class GeneratorPDF {


    public void generateAndSendTicket(EventPdfDTO eventPdfDTO, OwnerPdfDTO ownerPdfDTO, TicketPdfDTO ticketDTO) throws IOException, MessagingException {

        PDDocument document = new PDDocument();

        //Nowy dokument
        PDPage page = new PDPage();
        document.addPage(page);

        String imageQR = "QR.jpg";

        PDFont font = PDType1Font.TIMES_ROMAN;

        //content i obraz QR
        PDImageXObject image = PDImageXObject.createFromFile(imageQR, document);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);


        contentStream.beginText();
        contentStream.setFont(font, 25);
        contentStream.moveTextPositionByAmount(180, 750);
        contentStream.drawString("NARODOWE FORUM MUZYKI ");
        contentStream.endText();

        //Nazwa wydarzenia
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(100, 700);
        contentStream.drawString("Event: " + eventPdfDTO.getEventName());
        contentStream.endText();

        //data
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(100, 650);
        String dataEvent = eventPdfDTO.getEventDateAndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        contentStream.drawString("Data: " + dataEvent);
        contentStream.endText();

        //cena wydarzenia
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(400, 600);
        contentStream.drawString("Price: " + ticketDTO.getPrice());
        contentStream.endText();

        //Email
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(400, 700);
        contentStream.drawString("Ticket for: " + ownerPdfDTO.getEmail());
        contentStream.endText();

        // Miejsce i Rząd
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(100, 600);
        contentStream.drawString("seat: "
                + ticketDTO.getSeat()
                + " row: "
                + ticketDTO.getRow());
        contentStream.endText();

        //Id
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.moveTextPositionByAmount(400, 650);
        contentStream.drawString("id: " + ticketDTO.getTicketId().hashCode());
        contentStream.endText();

        //kod QR
        contentStream.drawImage(image, 250, 450, 100, 100);

        //zapisywanie dokumentu
        contentStream.close();
        document.save(eventPdfDTO.getEventName() + ticketDTO.getTicketId().hashCode() + ".pdf");
        document.close();


        // Wysyła wiadomosc, ma ustawionego maila na tego co trzeba brakuje jeszcze wstawienia załącznika
//        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
        //wysyłanie wiadomości
//        MailMail ticketMail = (MailMail) context.getBean("mailMail");
//        ticketMail.sendMail(ownerPdfDTO.getEmail(),
//                "Bilet w załącznikut",
//                (eventPdfDTO.getEventName() + ticketDTO.getTicketId().hashCode() + ".pdf"),
//                ownerPdfDTO.getEmail());

        EmailSender ticketMail = new EmailSenderImpl();
        ticketMail.sendEmail(ownerPdfDTO.getEmail(),
                "Bilet", "bilet w zalacnziku",
                (eventPdfDTO.getEventName() + ticketDTO.getTicketId().hashCode() + ".pdf"));


    }

}
