package pl.wojcik.airlinereservationsystem.model.passenger;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePassengerRequest {

    private String firstName;
    private String surname;
    private String street;
    private String streetNumber;
    private String city;
    private String country;
    private String postalCode;
    private String email;
    private String telephone;
}
