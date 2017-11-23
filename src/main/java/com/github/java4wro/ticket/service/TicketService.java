package com.github.java4wro.ticket.service;

import com.github.java4wro.ticket.AddTicketDTO;
import com.github.java4wro.ticket.TicketDTO;

import java.util.List;


public interface TicketService {

    TicketDTO addTicket(AddTicketDTO addTicketDTO);

    TicketDTO getTicketByUuid(String ticketUuid);

    List<TicketDTO> findAllTicketByEvent(String eventName);

    List<TicketDTO> findAll();

    void deleteTicketByUuid(String ticketUuid);
}
