package com.github.java4wro.csvparser.controller;

import com.github.java4wro.csvparser.model.Seat;
import com.github.java4wro.csvparser.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class HallController {

    @Autowired
    HallService hallService;

    @PostMapping("/upload")
    public void createTable(@RequestParam("file") MultipartFile file) throws IOException {
        hallService.readFile(file.getInputStream());
    }

    @GetMapping
    public List<Seat> findAll() {
        return hallService.findAllSeats();
    }

    @RequestMapping(value = "/{seat}", method = RequestMethod.HEAD)
    public ResponseEntity<String> findSeat(@PathVariable String seat) {
        return new ResponseEntity<>(hallService.exists(seat) ? HttpStatus.OK : HttpStatus.I_AM_A_TEAPOT);
    }
}
