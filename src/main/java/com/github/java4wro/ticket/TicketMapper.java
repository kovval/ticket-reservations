package com.github.java4wro.ticket;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

    @Mappings({
            @Mapping(source = "seat", target = "ticketSeat"),
            @Mapping(source = "price", target = "ticketPrice")
    })
    TicketDTO toTicketDTO (Ticket ticket);
    List<TicketDTO> toTicketListDTO (List<Ticket> tickets);


}
