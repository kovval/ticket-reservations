package com.github.java4wro.csvparser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hall_1_seat {
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
