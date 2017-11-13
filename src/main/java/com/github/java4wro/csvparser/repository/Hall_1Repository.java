package com.github.java4wro.csvparser.repository;

import com.github.java4wro.csvparser.model.Hall_1_seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Hall_1Repository extends JpaRepository<Hall_1_seat, Long> {
    Hall_1_seat findOneBySeat(String seat);

}
