package com.github.java4wro.event;

import com.github.java4wro.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by RENT on 2017-11-13.
 */
@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/add")
    private EventDTO add(@RequestBody EventDTO eventDTO) {
        return eventService.addEvent(eventDTO);
    }

    @GetMapping("/{uuid}")
    public EventDTO findAllEvent(@PathVariable("uuid") String eventUuid) {
        return eventService.getEventByUuid(eventUuid);
    }

    @GetMapping("/sortByTitle")
    public List<EventDTO> findAllEventsByTitle(@RequestParam("title") String eventTitle) {
        return eventService.getEventsByTitle(eventTitle);
    }

    @GetMapping("/sortByDate")
    public List<Event> findByDateTimeEquals(@RequestParam("date") String dateAndTime) {
        return eventService.findByDateTimeEquals(dateAndTime);
    }
}
