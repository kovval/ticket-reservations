package com.github.java4wro.csvparser.repository;

import com.github.java4wro.csvparser.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HallRepository extends JpaRepository<Seat, Long> {
    Seat findOneBySeat(String seat);
}
