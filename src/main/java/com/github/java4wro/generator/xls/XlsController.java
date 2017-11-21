package com.github.java4wro.generator.xls;


import com.github.java4wro.generator.dto.EventDTO;
import com.github.java4wro.generator.dto.TicketDTO;
import com.github.java4wro.ticket.Ticket;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/xls-report")
public class XlsController {

    @Autowired
    XlsService xlsService;


    @GetMapping
    public void getXlsReportByEvent(HttpServletResponse response) {

        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventName("ABC");
        eventDTO.setEventDateAndTime(LocalDateTime.now());

        HSSFWorkbook workbook = xlsService.createXlsReport(1, eventDTO, Collections.emptyList());
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String filename = "Repot.xls";
        response.setHeader("Content-disposition", "fileName");
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
