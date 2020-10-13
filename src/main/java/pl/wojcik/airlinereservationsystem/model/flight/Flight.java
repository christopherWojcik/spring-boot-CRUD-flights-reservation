package pl.wojcik.airlinereservationsystem.model.flight;

import lombok.*;
import pl.wojcik.airlinereservationsystem.model.passenger.Passenger;
import pl.wojcik.airlinereservationsystem.model.aircraft.AirCraft;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "flights")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String airport;
    private String destination;
    private LocalDate flightDate;
    private LocalDate flightDeparture;
    private LocalDate flightArrival;

    @ManyToOne
    @JoinColumn(name = "flightList")
    private AirCraft flightAirCraft;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "flightList")
    private final List<Passenger> flightPassengers = new ArrayList<>();

}
