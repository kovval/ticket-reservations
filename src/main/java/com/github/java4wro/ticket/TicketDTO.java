package com.github.java4wro.ticket;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TicketDTO{

    private String hallSeat;

    private BigDecimal price;

    private String eventUuid;

    private String userEmail;

}
