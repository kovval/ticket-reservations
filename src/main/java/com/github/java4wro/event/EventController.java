package com.github.java4wro.event;

import com.github.java4wro.dto.EventDTO;
import com.github.java4wro.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RENT on 2017-11-13.
 */
@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PutMapping("/add")
    private EventDTO add(@RequestBody EventDTO eventDTO ){
        return eventService.addEvent(eventDTO);
    }


}
