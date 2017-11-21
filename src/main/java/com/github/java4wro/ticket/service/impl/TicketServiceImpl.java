package com.github.java4wro.ticket.service.impl;

import com.github.java4wro.csvparser.model.Seat;
import com.github.java4wro.csvparser.repository.HallRepository;
import com.github.java4wro.event.Event;
import com.github.java4wro.event.EventRepository;
import com.github.java4wro.ticket.*;
import com.github.java4wro.ticket.service.TicketService;
import com.github.java4wro.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private HallRepository hallRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public TicketDTO addTicket (AddTicketDTO addTicketDTO ){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Event event = eventRepository.findOneByUuid(addTicketDTO.getEventUuid());
        Seat seat = hallRepository.findOneBySeat(addTicketDTO.getSeat());
        BigDecimal seatPrice = new BigDecimal(Float.toString(seat.getValue()));
        BigDecimal price = event.getBasicPrice().multiply(seatPrice);

        Ticket ticket = Ticket.builder()
                .event(eventRepository.findOneByUuid(addTicketDTO.getEventUuid()))
                .user(userRepository.findOneByEmail(auth.getName()))
                .seat(hallRepository.findOneBySeat(addTicketDTO.getSeat()))
                .price(price)
                .build();

        ticket = ticketRepository.save(ticket);
        return ticketMapper.toTicketDTO(ticket);
    }
}
