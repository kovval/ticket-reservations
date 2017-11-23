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


    @PutMapping("/add")
    private TicketDTO add (@RequestBody AddTicketDTO addTicketDTO){

        return ticketService.addTicket(addTicketDTO);
    }

    @GetMapping("/{uuid}")
    public TicketDTO findAllTicket(@PathVariable("uuid") String ticketUuid) {
        return ticketService.getTicketByUuid(ticketUuid);
    }

    @GetMapping("/findByEvent")
    public List<TicketDTO> findAllTicketByEvent (@RequestParam ("Event") String eventName){
        return ticketService.findAllTicketByEvent(eventName);
    }

    @GetMapping("/findAll")
    public List<TicketDTO> findAll() {
        return ticketService.findAll();
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


