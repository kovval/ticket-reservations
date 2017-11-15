package com.github.java4wro.event;

import com.github.java4wro.dto.EventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Created by RENT on 2017-11-13.
 */
@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    @Mappings({
            @Mapping(source = "title", target = "eventName"),
            @Mapping(source = "description", target = "eventDescription"),
            @Mapping(source = "basicPrice", target = "eventPrice"),
            @Mapping(source = "dateTime", target = "dateAndTime")
    })
    EventDTO toEventDTO(Event event);
    List<EventDTO> toEvents (List<Event> events);

    @Mappings({
            @Mapping(source = "dateAndTime", target = "dateTime"),
            @Mapping(source = "eventName", target = "title"),
            @Mapping(source = "eventDescription", target = "description"),
            @Mapping(source = "eventPrice", target = "basicPrice")

    })

    Event toEvent (EventDTO eventDTO);



}
