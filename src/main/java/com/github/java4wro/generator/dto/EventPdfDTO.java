package com.github.java4wro.generator.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventPdfDTO {

    private String eventName;
    private LocalDateTime eventDateAndTime;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventDateAndTime() {
        return eventDateAndTime;
    }

    public void setEventDateAndTime(LocalDateTime eventDateAndTime) {
        this.eventDateAndTime = eventDateAndTime;
    }
}
