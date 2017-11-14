package com.github.java4wro.event;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

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

    @Mappings({
            @Mapping(source = "dateAndTime", target = "dateTime"),
            @Mapping(source = "eventName", target = "title"),
            @Mapping(source = "eventDescription", target = "description"),
            @Mapping(source = "eventPrice", target = "basicPrice"),

    })
    Event toEvent (EventDTO eventDTO);
}