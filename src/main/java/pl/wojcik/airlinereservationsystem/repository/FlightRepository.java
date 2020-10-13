package pl.wojcik.airlinereservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.wojcik.airlinereservationsystem.model.dto.FlightDTO;
import pl.wojcik.airlinereservationsystem.model.flight.Flight;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {

    List<FlightDTO> findByAirport(String airport);

    List<FlightDTO> findByDestination(String destination);

    List<FlightDTO> findByFlightDate(LocalDate date);

    List<FlightDTO> findByAirportAndDestinationAndFlightDate(String airport, String destination, LocalDate date);

    Flight getById(long id);

    @Query(value = "SELECT airport FROM flights")
    List<String> getCities();

    @Query(value = "SELECT airport FROM flights WHERE destination = :destination")
    List<String> getAirportByDestination(@Param("destination") String destination);

    @Query(value = "SELECT destination FROM flights WHERE airport = :airport")
    List<String> getDestinationByAirport(@Param("airport") String airport);

    List<Flight> getFlightsByFlightAirCraft_Id(Long id);

}
