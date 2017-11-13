package com.github.java4wro.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventDTO {

    private Integer eventPrice;
    private String eventName;
    private String eventDescription;
    private LocalDateTime eventDateTime;

}
