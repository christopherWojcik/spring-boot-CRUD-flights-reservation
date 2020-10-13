package pl.wojcik.airlinereservationsystem.model.reservation;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Reservation {

    Long id;
    String airport;
    String destination;
    String flightDate;
    String flightDeparture;
    String flightArrival;
    String flightAirCraft;
    String email;

}
