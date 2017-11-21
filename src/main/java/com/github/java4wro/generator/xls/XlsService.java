package com.github.java4wro.generator.xls;

import com.github.java4wro.generator.dto.EventDTO;
import com.github.java4wro.generator.dto.TicketDTO;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XlsService {


    public HSSFWorkbook createXlsReport(int row, EventDTO eventDTO, List<TicketDTO> ticketDTOs) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Zestawienie");

        List<HSSFRow> rows = new ArrayList<>();
        rows.add(createHeader(sheet));
        rows.addAll(createContent(sheet, row, eventDTO, ticketDTOs));

        return workbook;
    }

    private HSSFRow createHeader(HSSFSheet sheet) {

        final HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("Zestawienie");
        row.createCell(1).setCellValue("Event Name");
        row.createCell(2).setCellValue("Event Date");
        row.createCell(3).setCellValue("Ticket Id");
        row.createCell(4).setCellValue("Ticket Price");
        return row;
    }

    private List<HSSFRow> createContent(HSSFSheet sheet, int r,EventDTO eventDTO, List<TicketDTO> ticketDTOs) {
        List<HSSFRow> rows = new ArrayList<>();
        int currentrow = r;
        for (TicketDTO t :ticketDTOs) {
            final HSSFRow row = sheet.createRow(currentrow);
            row.createCell(1).setCellValue(eventDTO.getEventName());
            row.createCell(2).setCellValue(eventDTO.getEventDateAndTime().toString());
            row.createCell(3).setCellValue(t.getTicketId());
            row.createCell(4).setCellValue(t.getPrice().toString());
            rows.add(row);
            currentrow++;
        }
        return rows;
    }

}
