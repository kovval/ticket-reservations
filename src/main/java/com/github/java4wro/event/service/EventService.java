package com.github.java4wro.event.service;

import com.github.java4wro.event.Event;
import com.github.java4wro.event.EventDTO;

import java.util.List;

public interface EventService {

    EventDTO addEvent(EventDTO eventDTO);

    List<Event> findByDateTimeEquals(String dateAndTime);

    EventDTO getEventByUuid(String eventUuid);

    List<EventDTO> getEventsByTitle(String eventTitle);
}
