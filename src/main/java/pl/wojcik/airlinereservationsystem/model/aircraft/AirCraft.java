package pl.wojcik.airlinereservationsystem.model.aircraft;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;
import pl.wojcik.airlinereservationsystem.model.flight.Flight;

import javax.persistence.*;
import java.util.List;

@Entity(name = "aircrafts")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirCraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String aircraftNumber;

    private long capacity;

    private boolean operable;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "flightAirCraft",
            orphanRemoval = true)
    private List<Flight> flightList;

    public void addFlight(Flight flight) {
        flightList.add(flight);
        flight.setFlightAirCraft(this);
    }

    public void removeFlight(Flight flight) {
        flightList.remove(flight);
        flight.setFlightAirCraft(null);
    }

}
