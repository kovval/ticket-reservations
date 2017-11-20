package com.github.java4wro.event.exception;

/**
 * Created by RENT on 2017-11-20.
 */
public class EventNotFoundException extends RuntimeException {
    private String eventUuid;

    public String getEventUuid() {
        return eventUuid;
    }

    public void setEventUuid(String eventUuid) {
        this.eventUuid = eventUuid;
    }

    public EventNotFoundException(String eventUuid) {
        this.eventUuid = eventUuid;


    }
}
