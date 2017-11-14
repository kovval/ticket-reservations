package com.github.java4wro.csvparser.controller;

import com.github.java4wro.csvparser.model.Hall;
import com.github.java4wro.csvparser.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class HallController {

    @Autowired
    HallService hallService;

    @GetMapping("/api/table")
    public void createTable () throws FileNotFoundException {
//        (@RequestParam("file")MultipartFile file)
//        file.getInputStream();
        hallService.readFile();
    }

    @GetMapping("/api/findall")
    public List<Hall> findAll (){
        return hallService.findAllSeats();
    }
}
