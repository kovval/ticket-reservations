package com.github.java4wro.event;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EventDTO {

    private BigDecimal eventPrice;
    private String eventName;
    private String eventDescription;
    private String dateAndTime;
//    private LocalDateTime eventDateTime;

//    public LocalDateTime getEventDateTime() {
//        return eventDateTime;
//    }
//
//    public void setEventDateTime(LocalDateTime eventDateTime) {
//        this.eventDateTime = eventDateTime;
//    }
}
