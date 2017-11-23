package com.github.java4wro.ticket;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO{

    private String seat;
    private BigDecimal price;
    private String eventUuid;
    private String userEmail;

}
