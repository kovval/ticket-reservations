package com.github.java4wro.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket getTicketByUuid(String ticketUuid);

    List<Ticket> findAllByIdIsNotNull();

}
