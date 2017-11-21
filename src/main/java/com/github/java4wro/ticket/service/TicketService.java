package com.github.java4wro.ticket.service;

import com.github.java4wro.ticket.AddTicketDTO;
import com.github.java4wro.ticket.TicketDTO;


public interface TicketService {
    TicketDTO addTicket(AddTicketDTO addTicketDTO);
//    TicketDTO getTicketByUuid (String ticketUuid);
//    TicketDTO getAllTicketByEvent(String eventName);
//    List<TicketDTO> findAllByIdIsNotNull();
}
