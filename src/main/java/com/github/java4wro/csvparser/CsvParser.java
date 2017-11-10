package com.github.java4wro.csvparser;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CsvParser {
    private File file;

    public CsvParser(File file) throws FileNotFoundException {
        this.file = file;
    }

    FileReader fis = new FileReader(file);
    BufferedReader br = new BufferedReader(fis);


    public void readFile(){




    }
}
