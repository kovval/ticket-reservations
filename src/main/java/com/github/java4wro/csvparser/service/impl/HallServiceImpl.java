package com.github.java4wro.csvparser.service.impl;


import com.github.java4wro.csvparser.model.Hall_1_seat;
import com.github.java4wro.csvparser.repository.Hall_1Repository;
import com.github.java4wro.csvparser.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class HallServiceImpl implements HallService {
    private File file;
    private HashMap<String, Float> hall_1 = new HashMap<>();
    private String line;
    private final String UTF8_BOM = "\uFEFF";
    FileReader fis = new FileReader("src/main/java/com.github.java4wro/csvparser/hall_1.csv");
    BufferedReader br = new BufferedReader(fis);
    @Autowired
    private Hall_1Repository hall_1Repository;

    public HallServiceImpl() throws FileNotFoundException {
    }

    @Override
    public List<Hall_1_seat> findAllSeats() {
        return hall_1Repository.findAll();
    }

    @Override
    public void readFile() {
        int row = 1;
        try {
            while ((line = br.readLine()) != null) {
                if (line.startsWith(UTF8_BOM)) {
                    line = line.substring(1);
                }
                String[] singleRow = line.split(",");
                for (int i = 0; i < singleRow.length; i++) {
                    if (Float.valueOf(singleRow[i]) > 0) {
                        Character r = (char) (row + 64);
                        StringBuilder sB = new StringBuilder();
                        sB.append(r);
                        sB.append(String.valueOf(i + 1));
                        hall_1.put(sB.toString(), Float.valueOf(singleRow[i]));
                    }
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
