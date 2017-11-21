package com.github.java4wro.ticket;


import com.github.java4wro.commons.BaseEntity;
import com.github.java4wro.csvparser.model.Seat;
import com.github.java4wro.event.Event;
import com.github.java4wro.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Ticket extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Seat seat;

}
