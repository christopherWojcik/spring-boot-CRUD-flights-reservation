package pl.wojcik.airlinereservationsystem.model.passenger;

import lombok.*;
import pl.wojcik.airlinereservationsystem.model.flight.Flight;

import javax.persistence.*;
import java.util.List;

@Entity(name = "passengers")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    private List<Flight> flightList;

}
