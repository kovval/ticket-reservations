package com.github.java4wro.event;

import com.github.java4wro.commons.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by RENT on 2017-11-10.
 */

@Getter
@Setter
@ToString
@Entity
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private BigDecimal basicPrice;
    private LocalDateTime dateTime;
}

