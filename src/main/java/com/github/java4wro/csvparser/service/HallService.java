package com.github.java4wro.csvparser.service;


import com.github.java4wro.csvparser.model.Hall;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface HallService {
    List<Hall> findAllSeats();
    void readFile(InputStream is) throws FileNotFoundException, UnsupportedEncodingException;

}
