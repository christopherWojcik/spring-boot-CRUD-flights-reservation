package pl.wojcik.airlinereservationsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.wojcik.airlinereservationsystem.model.aircraft.AirCraft;
import pl.wojcik.airlinereservationsystem.model.passenger.Passenger;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private long dto_id;
    private String airport;
    private String destination;
    private String flightDate;
    private String flightDeparture;
    private String flightArrival;
    private String flightAirCraft;

    private List<Passenger> flightPassengers;
}
