package com.github.java4wro.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class EventDTO {

    private BigDecimal eventPrice;
    private String eventName;
    private String eventDescription;
    private LocalDateTime eventDateTime;

}
