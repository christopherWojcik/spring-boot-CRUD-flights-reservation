package pl.wojcik.airlinereservationsystem.model.aircraft;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchAircraftRequest {

    private Long capacity;
    private boolean operable;

}
