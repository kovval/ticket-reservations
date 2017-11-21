package com.github.java4wro.ticket;

import com.github.java4wro.csvparser.mapper.SeatMapper;
import com.github.java4wro.event.EventMapper;
import com.github.java4wro.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring" ,uses = {EventMapper.class, SeatMapper.class, UserMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

    @Mappings({
            @Mapping(source = "seat.seat", target = "hallSeat"),
            @Mapping(source = "event.uuid", target = "eventUuid"),
            @Mapping(source = "user.email", target = "userEmail")
    })
    TicketDTO toTicketDTO(Ticket ticket);
    List<TicketDTO> toTicketListDTO(List<Ticket> tickets);

    @Mappings({
            @Mapping(source = "hallSeat", target = "seat.seat"),
            @Mapping(source = "eventUuid", target = "event.uuid"),
            @Mapping(source = "userEmail", target = "user.email")
    })
    Ticket toTicket(TicketDTO ticketDTO);
    List<Ticket> toTicketList(List<TicketDTO> ticketDTOS);
}