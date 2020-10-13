package pl.wojcik.airlinereservationsystem.model.aircraft;

import lombok.Builder;
import lombok.Data;
import pl.wojcik.airlinereservationsystem.model.flight.Flight;

import java.util.List;

@Data
@Builder
public class CreateAircraftRequest {

    private String aircraftNumber;
    private long capacity;
    private boolean isOperable;
    private List<Flight> flightList;
}
