package com.github.java4wro.csvparser.service;
import com.github.java4wro.csvparser.model.Seat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface HallService {
    List<Seat> findAllSeats();
    void readFile(InputStream is) throws IOException;
    boolean exists(String seat);


}
