package com.github.java4wro.event;

import com.github.java4wro.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findByDate/{date1}/{date2}")
    public List<Event> findAllByDateTimeBetween(@PathVariable(value = "date1", required = false) String date1,
                                                @PathVariable(value = "date2", required = false) String date2) {

        return eventService.findAllByDateTimeBetween(date1, date2);
    }
}
