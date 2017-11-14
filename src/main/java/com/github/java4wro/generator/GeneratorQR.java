package com.github.java4wro.generator;


import com.github.java4wro.generator.dto.EventPdfDTO;
import com.github.java4wro.generator.dto.OwnerPdfDTO;
import com.github.java4wro.generator.dto.TicketPdfDTO;
import net.glxn.qrgen.core.image.ImageType;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class GeneratorQR{

    private String qr_text = "Hello World!";
    private String path = "QRCod.jpg";

    public GeneratorQR() {
    }

    public String getQr_text() {
        return qr_text;
    }

    public void setQr_text(String qr_text) {
        this.qr_text = qr_text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



    public void generateQRCode(EventPdfDTO eventPdfDTO, OwnerPdfDTO ownerPdfDTO, TicketPdfDTO ticketPdfDTO){

        ByteArrayOutputStream out = net.glxn.qrgen.javase.QRCode.from()
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


    public static void main(String[] args) {
        GeneratorQR qr = new GeneratorQR();
        qr.generateQRCode();


    }

}
