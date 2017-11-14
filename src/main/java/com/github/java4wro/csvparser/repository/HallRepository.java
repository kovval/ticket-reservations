package com.github.java4wro.csvparser.repository;

import com.github.java4wro.csvparser.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    Hall findOneBySeat(String seat);
}
