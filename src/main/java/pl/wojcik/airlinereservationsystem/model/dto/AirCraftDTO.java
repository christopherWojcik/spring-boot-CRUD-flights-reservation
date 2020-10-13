package pl.wojcik.airlinereservationsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.wojcik.airlinereservationsystem.model.flight.Flight;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirCraftDTO {

    private long dto_id;
    private String aircraftNumber;
    private long capacity;
    private boolean isOperable;
    private List<Flight> flightList = new ArrayList<>();

}
