package pl.wojcik.airlinereservationsystem.model.passenger;

import lombok.Builder;
import lombok.Data;
import pl.wojcik.airlinereservationsystem.model.flight.Flight;

import java.util.List;

@Data
@Builder
public class UpdatePassengerRequest {

    private long id;
    private String firstName;
    private String surname;
    private String street;
    private String streetNumber;
    private String city;
    private String country;
    private String postalCode;
    private String email;
    private String telephone;

    private List<Flight> flightList;

}
