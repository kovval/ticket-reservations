package com.github.java4wro.csvparser.model;

import com.github.java4wro.commons.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "hall")
public class Seat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String seat;
    private Float value;

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
