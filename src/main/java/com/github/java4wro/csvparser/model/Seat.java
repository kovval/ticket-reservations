package com.github.java4wro.csvparser.model;

import com.github.java4wro.commons.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "hall")
public class Seat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String seat;

    private Float value;

}
