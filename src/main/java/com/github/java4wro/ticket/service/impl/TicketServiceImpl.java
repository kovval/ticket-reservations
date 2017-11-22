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

import java.math.BigDecimal;
import java.util.List;

public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final EventRepository eventRepository;
    private final HallRepository hallRepository;
    private final UserRepository userRepository;

    //Autowiring via constructor - allows to avoid nesting in Autowired components
    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TicketMapper ticketMapper, EventRepository eventRepository, HallRepository hallRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.eventRepository = eventRepository;
        this.hallRepository = hallRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TicketDTO addTicket (AddTicketDTO addTicketDTO ){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Event event = eventRepository.findOneByUuid(addTicketDTO.getEventUuid());
        Seat seat = hallRepository.findOneBySeat(addTicketDTO.getSeat());
        BigDecimal finalPrice = event.getBasicPrice().multiply(seat.getValue());

        //Ticket object creation via builder() and stream approach
        Ticket ticket = Ticket.builder()
                .event(eventRepository.findOneByUuid(addTicketDTO.getEventUuid()))
                .user(userRepository.findOneByEmail(auth.getName()))
                .seat(hallRepository.findOneBySeat(addTicketDTO.getSeat()))
                .price(finalPrice)
                .build();

        //ToDo Zapytać Adama o unique na parze event_id i hall_id
        ticket = ticketRepository.save(ticket);

        //ToDo wyołać Jankową metodę do wydruku biletów

        return ticketMapper.toTicketDTO(ticket);
    }

    @Override
    public TicketDTO getTicketByUuid(String ticketUuid) {
        Ticket ticket = ticketRepository.getTicketByUuid(ticketUuid);

        return ticketMapper.toTicketDTO(ticket);
    }

    @Override
    public List<TicketDTO> findAllTicketByEvent(String eventName) {
        List<Ticket> listTicket = ticketRepository.findAllTicketByEvent(eventName);
        return ticketMapper.toTicketListDTO(listTicket);
    }

    @Override
    public List<TicketDTO> findAll(){
        return ticketMapper.toTicketListDTO(ticketRepository.findAll());
    }

}
