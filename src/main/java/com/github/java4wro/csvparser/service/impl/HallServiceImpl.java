package com.github.java4wro.csvparser.service.impl;


import com.github.java4wro.csvparser.model.Seat;
import com.github.java4wro.csvparser.repository.HallRepository;
import com.github.java4wro.csvparser.service.HallService;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepository hallRepository;

    @Override
    public List<Seat> findAllSeats() {
        return hallRepository.findAll();
    }

    @Override
    public void readFile(InputStream is) throws IOException {

        CSVReader reader = null;
        try {
            reader = new CSVReader(new InputStreamReader(is, "UTF-8"));
            String[] line;

            int row = 1;
            while ((line = reader.readNext()) != null) {
                for (int i = 0; i < line.length; i++) {
                    if (Float.valueOf(line[i]) > 0) {
                        Character r = (char) (row + 64);
                        Seat newSeat = new Seat();
                        newSeat.setSeat(r.toString() + String.valueOf(i + 1));
                        newSeat.setValue(Float.valueOf(line[i]));
                        hallRepository.save(newSeat);
                    }
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(String seat) {
        return hallRepository.existsBySeat(seat);
    }
}
