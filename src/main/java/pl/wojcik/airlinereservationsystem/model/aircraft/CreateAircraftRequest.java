package pl.wojcik.airlinereservationsystem.model.aircraft;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(hidden = true)
    private List<Flight> flightList;
}
