package com.github.java4wro.generator;


import com.github.java4wro.generator.dto.EventPdfDTO;
import com.github.java4wro.generator.dto.OwnerPdfDTO;
import com.github.java4wro.generator.dto.TicketPdfDTO;
import net.glxn.qrgen.core.image.ImageType;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class GeneratorQR{

    private String path = "QRCode.jpg";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



    public void generateQRCode(EventPdfDTO eventPdfDTO, OwnerPdfDTO ownerPdfDTO, TicketPdfDTO ticketPdfDTO){

        String prepareText = eventPdfDTO.getEventName()+eventPdfDTO.getEventDateAndTime()
                +ownerPdfDTO.getEmail()+ticketPdfDTO.getTicketuuid()+ticketPdfDTO.getRow()
                +ticketPdfDTO.getSeat()+ticketPdfDTO.getPrice();

        ByteArrayOutputStream out = net.glxn.qrgen.javase.QRCode.from(prepareText)
                .to(ImageType.JPG)
                .stream();

        try {
            FileOutputStream fout = new FileOutputStream(new File(getPath()));

            fout.write(out.toByteArray());

            fout.flush();
            fout.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
