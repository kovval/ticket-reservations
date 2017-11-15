package com.github.java4wro.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by RENT on 2017-11-10.
 */
public interface EventRepository extends JpaRepository<Event,Long> {
    Event findByTitle(String title);
    List<EventDTO> findByDateTimeEquals(String dateAndTime);
}
