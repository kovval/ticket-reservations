package com.github.java4wro.ticket.service.impl;

import com.github.java4wro.csvparser.model.Seat;
import com.github.java4wro.csvparser.repository.HallRepository;
import com.github.java4wro.event.Event;
import com.github.java4wro.event.EventMapper;
import com.github.java4wro.event.EventRepository;
import com.github.java4wro.ticket.Ticket;
import com.github.java4wro.ticket.TicketDTO;
import com.github.java4wro.ticket.TicketMapper;
import com.github.java4wro.ticket.TicketRepository;
import com.github.java4wro.ticket.service.TicketService;
import com.github.java4wro.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override //TODO
    public TicketDTO addTicket (String eventUuid, String seat, Integer price, String email ){
        Ticket ticket = ticketMapper.toTicket();
        ticket = ticketRepository.save(ticket);

        String  eventUuid = new String();
        eventRepository.getEventByUuid(eventUuid);
        return ticketMapper.toTicketDTO(ticket);
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
