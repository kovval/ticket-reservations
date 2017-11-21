package com.github.java4wro.ticket.service.impl;

import com.github.java4wro.csvparser.repository.HallRepository;
import com.github.java4wro.event.Event;
import com.github.java4wro.event.EventDTO;
import com.github.java4wro.event.EventMapper;
import com.github.java4wro.event.EventRepository;
import com.github.java4wro.ticket.Ticket;
import com.github.java4wro.ticket.TicketDTO;
import com.github.java4wro.ticket.TicketMapper;
import com.github.java4wro.ticket.TicketRepository;
import com.github.java4wro.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private Event event;


    @Override //TODO
    public TicketDTO addTicket (String eventUuid, String seat, Integer price, String email ){

        eventRepository.getEventByUuid(eventUuid);
        hallRepository.findOneBySeat(seat);
        price = event.

//        Ticket ticket = ticketMapper.toTicket(addTicket(eventUuid, seat, price, email));
//        ticket = ticketRepository.save(ticket);
//        return ticketMapper.toTicketDTO(ticket);
    }

//    @Override
//    public TicketDTO getTicketByUuid(String ticketUuid) {
//        Ticket ticket = ticketRepository.getTicketByUuid(ticketUuid);
//
//        return ticketMapper.toTicketDTO(ticket);
//    }
//
//    @Override
//    public TicketDTO getAllTicketByEvent(String eventName) {
//        List<Ticket> listTicket = ticketRepository.findAllTicketByEvent(eventName);
//        return  ticketMapper.toTicketDTO((Ticket) listTicket);
//    }
//
//    @Override
//    public List<TicketDTO> findAllByIdIsNotNull() {
//        return null;
//    }
}
