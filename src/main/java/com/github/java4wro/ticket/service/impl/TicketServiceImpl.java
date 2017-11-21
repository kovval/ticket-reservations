package com.github.java4wro.ticket.service.impl;

import com.github.java4wro.csvparser.repository.HallRepository;
import com.github.java4wro.event.EventMapper;
import com.github.java4wro.event.EventRepository;
import com.github.java4wro.ticket.Ticket;
import com.github.java4wro.ticket.TicketDTO;
import com.github.java4wro.ticket.TicketMapper;
import com.github.java4wro.ticket.TicketRepository;
import com.github.java4wro.ticket.service.TicketService;
import com.github.java4wro.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private HallRepository hallRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public TicketDTO addTicket (TicketDTO ticketDTO ){
        Ticket ticket = Ticket.builder()
                .event(eventRepository.findOneByUuid(ticketDTO.getEventUuid()))
                .price(ticketDTO.getPrice())
                .user(userRepository.findOneByEmail(ticketDTO.getUserEmail()))
                .build();

        ticket = ticketRepository.save(ticket);
        return ticketMapper.toTicketDTO(ticket);
    }
}
