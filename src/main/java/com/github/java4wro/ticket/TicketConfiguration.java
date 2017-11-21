package com.github.java4wro.ticket;

import com.github.java4wro.csvparser.repository.HallRepository;
import com.github.java4wro.event.EventRepository;
import com.github.java4wro.ticket.service.TicketService;
import com.github.java4wro.ticket.service.impl.TicketServiceImpl;
import com.github.java4wro.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketConfiguration {


    @Bean
    public TicketService ticketService(TicketRepository ticketRepository, TicketMapper ticketMapper, EventRepository eventRepository, HallRepository hallRepository, UserRepository userRepository) {
        return new TicketServiceImpl(ticketRepository, ticketMapper, eventRepository, hallRepository, userRepository);
    }
}
