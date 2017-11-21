package com.github.java4wro.generator.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;


@Getter
@Setter
public class TicketPdfDTO {

    private String ticketuuid; // TODO uuid -> extends BaseEntity #Janek
    private String row;

    public String getTicketId() {
        return ticketuuid;
    }

    public void setTicketId(String ticketUuid) {
        this.ticketuuid = ticketUuid;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    private String seat;
    private BigDecimal price;

}
