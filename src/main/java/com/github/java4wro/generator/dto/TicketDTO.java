package com.github.java4wro.generator.dto;


import com.github.java4wro.commons.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TicketDTO {

    private String ticketId; // TODO uuid -> extends BaseEntity #Janek
    private String row;
    private String seat;
    private BigDecimal price;
}
