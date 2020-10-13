package pl.wojcik.airlinereservationsystem.model.aircraft;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAircraftRequest {

    private long id;
    private String aircraftNumber;
    private long capacity;
    private boolean isOperable;
}
