package com.github.java4wro.event.service.impl;

import com.github.java4wro.event.EventDTO;
import com.github.java4wro.event.Event;
import com.github.java4wro.event.EventMapper;
import com.github.java4wro.event.EventRepository;
import com.github.java4wro.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    @Override
    public EventDTO addEvent(EventDTO eventDTO) {

        Event event = eventMapper.toEvent(eventDTO);
        event = eventRepository.save(event);

        return eventMapper.toEventDTO(event);
    }

    @Override
    public List<EventDTO> findAllByDateTimeBetween(String date1, String date2) {
        Instant instant1 = Instant.parse(date1);
        Instant instant2 = Instant.parse(date2);
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneId.of(ZoneOffset.UTC.getId()));
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant2, ZoneId.of(ZoneOffset.UTC.getId()));

        List<Event> eventsByDate = eventRepository.findAllByDateTimeBetween(localDateTime1, localDateTime2);
        return eventMapper.toEventsDTO(eventsByDate);
    }

    @Override
    public EventDTO getEventByUuid(String eventUuid) {
        Event event = eventRepository.findOneByUuid(eventUuid);
        return eventMapper.toEventDTO(event);
    }

    @Override
    public List<EventDTO> getEventsByTitle(String eventTitle) {
        List<Event> listEvents = eventRepository.findByTitle(eventTitle);
        return eventMapper.toEventsDTO(listEvents);
    }

    @Override
    public void deleteEventByUuid(String eventUuid) {
        Event event = eventRepository.findOneByUuid(eventUuid);
        eventRepository.delete(event);
    }
}