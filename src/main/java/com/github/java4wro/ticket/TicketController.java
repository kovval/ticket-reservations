package com.github.java4wro.ticket;

import com.github.java4wro.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @GetMapping("/{uuid}")
    public TicketDTO findAllTicket(@PathVariable("uuid") String ticketUuid) {
        return ticketService.getTicketByUuid(ticketUuid);
    }
}
