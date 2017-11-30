package com.github.java4wro.generator;

import com.github.java4wro.emailService.EmailSender;
import com.github.java4wro.generator.dto.EventPdfDTO;
import com.github.java4wro.generator.dto.OwnerPdfDTO;
import com.github.java4wro.generator.dto.TicketPdfDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;


@Service
public class GeneratorPDF {

    @Autowired
    private EmailSender emailSender;

    public void generateAndSendTicket(EventPdfDTO eventPdfDTO, OwnerPdfDTO ownerPdfDTO, TicketPdfDTO ticketDTO) throws IOException, MessagingException {

        PDDocument document = new PDDocument();

        //Nowy dokument
        PDPage page = new PDPage();
        document.addPage(page);


        GeneratorQR generatorQR = new GeneratorQR();
        generatorQR.generateQRCode(eventPdfDTO, ownerPdfDTO, ticketDTO);
        String imageQR = "QRCode.jpg";

        PDType0Font font = PDType0Font.load(document, new File("arial.ttf"));


        //content i obraz QR
        PDImageXObject image = PDImageXObject.createFromFile(imageQR, document);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);


        contentStream.beginText();
        contentStream.setFont(font, 25);
        contentStream.newLineAtOffset(180, 750);
        contentStream.showText("NARODOWE FORUM MUZYKI ");
        contentStream.endText();

        //Nazwa wydarzenia
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.newLineAtOffset(100, 700);
        contentStream.showText("Event: " + eventPdfDTO.getEventName());
        contentStream.endText();

        //data
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.newLineAtOffset(100, 650);
        String dataEvent = eventPdfDTO.getEventDateAndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        contentStream.showText("Data: " + dataEvent);
        contentStream.endText();

        //cena wydarzenia
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.newLineAtOffset(400, 600);
        contentStream.showText("Price: " + ticketDTO.getPrice());
        contentStream.endText();

        //Email
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.newLineAtOffset(400, 550);
        contentStream.showText("Ticket for: " + ownerPdfDTO.getEmail());
        contentStream.endText();

        // Miejsce i Rząd
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.newLineAtOffset(100, 600);
        contentStream.showText("seat: "
                + ticketDTO.getSeat()
                + " row: "
                + ticketDTO.getRow());
        contentStream.endText();

        //Id
        contentStream.beginText();
        contentStream.setFont(font, 14);
        contentStream.newLineAtOffset(400, 650);
        contentStream.showText("id: " + ticketDTO.getTicketId().hashCode());
        contentStream.endText();

        //kod QR
        contentStream.drawImage(image, 200, 350, 200, 200);

        //zapisywanie dokumentu
        contentStream.close();
        document.save(eventPdfDTO.getEventName() + ticketDTO.getTicketId().hashCode() + ".pdf");
        document.close();

        emailSender.sendEmail(ownerPdfDTO.getEmail(),
                "Bilet", "bilet w załączniku",
                eventPdfDTO.getEventName() + ticketDTO.getTicketId().hashCode() + ".pdf");
    }

}