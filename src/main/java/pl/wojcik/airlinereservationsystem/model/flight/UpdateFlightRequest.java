package pl.wojcik.airlinereservationsystem.model.flight;

import lombok.Builder;
import lombok.Data;
import pl.wojcik.airlinereservationsystem.model.passenger.Passenger;
import pl.wojcik.airlinereservationsystem.model.aircraft.AirCraft;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class UpdateFlightRequest {

    private long id;
    private LocalDate flightDate;
    private LocalDate flightDeparture;
    private LocalDate flightArrival;
    private String airport;
    private String destination;
    private AirCraft flightAirCraft;
    private List<Passenger> flightPassengers;
}
