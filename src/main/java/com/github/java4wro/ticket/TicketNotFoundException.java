package com.github.java4wro.ticket;

/**
 * Created by RENT on 2017-11-20.
 */
public class TicketNotFoundException extends RuntimeException {
    private String ticketUuid;
    public TicketNotFoundException(String ticketUuid) {
        this.ticketUuid = ticketUuid;
    }
    public String getTicketUuid() {
        return ticketUuid;
    }



}
