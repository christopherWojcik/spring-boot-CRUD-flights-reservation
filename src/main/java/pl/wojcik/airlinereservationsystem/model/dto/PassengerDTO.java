package pl.wojcik.airlinereservationsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {

    private long dto_id;
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
