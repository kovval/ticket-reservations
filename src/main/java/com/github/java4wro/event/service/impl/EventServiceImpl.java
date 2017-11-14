package com.github.java4wro.event.service.impl;

import com.github.java4wro.event.EventDTO;
import com.github.java4wro.event.Event;
import com.github.java4wro.event.EventMapper;
import com.github.java4wro.event.EventRepository;
import com.github.java4wro.event.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//        event.setBasicPrice(eventDTO.getEventPrice());
//        event.setDateTime(eventDTO.getEventDateTime());
//        event.setTitle(eventDTO.getEventName());


        event = eventRepository.save(event);

        return eventMapper.toEventDTO(event);
    }

    @Override
    public List<EventDTO> findByDateTimeEquals(String dateAndTime) throws RuntimeException {
        Event event = eventRepository.findByDateTimeEquals(dateAndTime);

        return eventMapper.toEventDTO(event);
    }

    @Override
    public EventDTO getEventByUuid(String eventUuid) {
        return null;
    }

}