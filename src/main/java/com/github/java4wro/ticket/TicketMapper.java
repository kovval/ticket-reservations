package com.github.java4wro.ticket;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

//    @Mappings({
//            @Mapping(source = "seat", target = "ticketSeat"),
//            @Mapping(source = "price", target = "ticketPrice")
//    })
    TicketDTO toTicketDTO (Ticket ticket);

    List<TicketDTO> toTicketListDTO (List<Ticket> tickets);

}

// Ticket
//    private BigDecimal price;
//    private Event event;
//    private User user;
//    private Seat seat;
//
//TicketTDTO
//    private String ticketSeat;
//    private BigDecimal ticketPrice;