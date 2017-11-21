package com.github.java4wro.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByTitle(String title);
    Event findOneByUuid(String eventUuid);
    List<Event> findAllByDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
