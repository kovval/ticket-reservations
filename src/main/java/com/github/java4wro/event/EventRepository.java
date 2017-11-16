package com.github.java4wro.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by RENT on 2017-11-10.
 */
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTitle(String title);

    Event getEventByUuid (String eventUuid);

    List<Event> findByDateTimeEquals(LocalDate dateAndTime);

}
