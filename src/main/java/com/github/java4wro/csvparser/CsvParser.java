package com.github.java4wro.csvparser;
import java.io.*;
import java.util.HashMap;

public class CsvParser {
    private File file;
    private HashMap<String, Float> hall_1 = new HashMap<>();
    private String line;
    private final String UTF8_BOM = "\uFEFF";
    FileReader fis = new FileReader("src/main/java/com.github.java4wro/csvparser/hall_1.csv");
    BufferedReader br = new BufferedReader(fis);
    public CsvParser() throws FileNotFoundException {
    }
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