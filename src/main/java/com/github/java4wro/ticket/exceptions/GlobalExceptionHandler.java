package com.github.java4wro.ticket.exceptions;

import com.github.java4wro.event.exception.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by RENT on 2017-11-20.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TicketNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleTicketNotFoundException(TicketNotFoundException e){
        return new ResponseEntity<>
                (String.format("Event with uuid: %s doesn't exist",e.getTicketUuid()),
                        HttpStatus.BAD_REQUEST);
    }
}
