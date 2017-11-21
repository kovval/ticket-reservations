package com.github.java4wro.csvparser.repository;

import com.github.java4wro.csvparser.model.Seat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class HallRepositoryTests {

    @Autowired
    private HallRepository hallRepository;

    @Test
    public void checkIfFindAllSeatsWorkCorrect() {
        // given
        Seat seat1 = new Seat();
        seat1.setSeat("A1");
        seat1.setValue(2f);
        hallRepository.save(seat1);

        Seat seat2 = new Seat();
        seat2.setSeat("A2");
        seat2.setValue(1.5f);
        hallRepository.save(seat2);

        // then
        Assert.assertEquals(2f, seat1.getValue(), 0.1f);
    }
}

