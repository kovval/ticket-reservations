package com.github.java4wro.ticket;

import com.github.java4wro.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PutMapping("/add")
    private TicketDTO add (@RequestBody AddTicketDTO addTicketDTO){

        return ticketService.addTicket(addTicketDTO);
    }

}


