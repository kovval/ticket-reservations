package com.github.java4wro.ticket.service.impl;

import com.github.java4wro.ticket.Ticket;
import com.github.java4wro.ticket.TicketDTO;
import com.github.java4wro.ticket.TicketMapper;
import com.github.java4wro.ticket.TicketRepository;
import com.github.java4wro.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketMapper ticketMapper;


    @Override
    public TicketDTO getTicketByUuid(String ticketUuid) {
        Ticket ticket = ticketRepository.getTicketByUuid(ticketUuid);

        return ticketMapper.toTicketDTO(ticket);
    }
}
