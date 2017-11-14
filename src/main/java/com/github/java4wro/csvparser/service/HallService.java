package com.github.java4wro.csvparser.service;


import com.github.java4wro.csvparser.model.Hall;

import java.io.FileNotFoundException;
import java.util.List;

public interface HallService {
    List<Hall> findAllSeats();
    void readFile() throws FileNotFoundException;

}
