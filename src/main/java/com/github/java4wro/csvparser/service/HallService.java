package com.github.java4wro.csvparser.service;


import com.github.java4wro.csvparser.model.Hall_1_seat;

import java.util.List;

public interface HallService {
    List<Hall_1_seat> findAllSeats();
    void readFile();

}
