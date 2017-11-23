package com.github.java4wro.ticket;

import com.github.java4wro.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    private TicketDTO add(@RequestBody TicketDTO ticketDTO) {
        return ticketService.addTicket(ticketDTO);
    }


    @DeleteMapping("/deleteByUuid")
    public void deleteTicketByUUid(@RequestParam("uuid") String ticketUuid) {
       TicketDTO deleteTicket =  ticketService.getTicketByUuid(ticketUuid);
        if(deleteTicket==null){
            throw new TicketNotFoundException(ticketUuid);
        }
        ticketService.deleteTicketByUuid(ticketUuid);
    }
}


