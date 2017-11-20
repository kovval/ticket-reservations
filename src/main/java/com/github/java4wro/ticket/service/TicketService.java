package com.github.java4wro.ticket.service;

import com.github.java4wro.ticket.TicketDTO;

import java.util.List;

public interface TicketService {

    TicketDTO getTicketByUuid (String ticketUuid);
    TicketDTO getAllTicketByEvent(String eventName);
    List<TicketDTO> findAllByIdIsNotNull();

}
