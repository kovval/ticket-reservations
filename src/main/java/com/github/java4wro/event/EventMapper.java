package com.github.java4wro.event;

import com.github.java4wro.dto.EventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * Created by RENT on 2017-11-13.
 */

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EventMapper {

    @Mappings({
            @Mapping(source = "title", target = "eventName"),
            @Mapping(source = "description", target = "eventDescription"),
            @Mapping(source = "basicPrice", target = "eventPrice"),
            @Mapping(source = "dateTime", target = "eventDateTime")
    })

    EventDTO toEventDTO(Event event);

}
