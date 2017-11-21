package com.github.java4wro.ticket;

import com.github.java4wro.csvparser.mapper.SeatMapper;
import com.github.java4wro.event.EventMapper;
import com.github.java4wro.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring", uses = {EventMapper.class, SeatMapper.class, UserMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

    @Mappings({
            @Mapping(source = "seat.seat", target = "seat"),
            @Mapping(source = "event.uuid", target = "eventUuid"),
            @Mapping(source = "user.email", target = "userEmail")
    })
    TicketDTO toTicketDTO(Ticket ticket);

    List<TicketDTO> toTicketDTO(List<Ticket> tickets);
}