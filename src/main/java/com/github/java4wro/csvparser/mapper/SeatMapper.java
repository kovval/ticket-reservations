package com.github.java4wro.csvparser.mapper;

import com.github.java4wro.csvparser.dto.SeatDTO;
import com.github.java4wro.csvparser.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SeatMapper {

    SeatDTO toSeatDTO(Seat seat);
    List<SeatDTO> toSeatDTO(Collection<Seat> seat);

}
