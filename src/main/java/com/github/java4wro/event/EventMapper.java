package com.github.java4wro.event;

import com.github.java4wro.dto.EventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Created by RENT on 2017-11-13.
 */
@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EventMapper {

    EventDTO toEventDTO(Event event);

}
