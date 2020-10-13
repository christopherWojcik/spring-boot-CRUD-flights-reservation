package pl.wojcik.airlinereservationsystem.model.flight;

import lombok.Builder;
import lombok.Data;
import pl.wojcik.airlinereservationsystem.model.aircraft.AirCraft;

import java.time.LocalDate;

@Data
@Builder
public class CreateFlightRequest {

    private LocalDate flightDate;
    private LocalDate flightDeparture;
    private LocalDate flightArrival;
    private String airport;
    private String destination;
    private AirCraft flightAirCraft;
}
