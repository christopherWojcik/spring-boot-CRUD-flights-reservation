package pl.wojcik.airlinereservationsystem.model.flight;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SearchFlightRequest {

    private String airport;
    private String destination;

}
