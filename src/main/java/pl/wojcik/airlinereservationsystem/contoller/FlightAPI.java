package pl.wojcik.airlinereservationsystem.contoller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.wojcik.airlinereservationsystem.model.dto.FlightDTO;
import pl.wojcik.airlinereservationsystem.model.flight.CreateFlightRequest;
import pl.wojcik.airlinereservationsystem.model.flight.SearchFlightRequest;
import pl.wojcik.airlinereservationsystem.model.flight.UpdateFlightRequest;
import pl.wojcik.airlinereservationsystem.model.reservation.Reservation;
import pl.wojcik.airlinereservationsystem.service.FlightService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(
        path = "/api/flights")
public class FlightAPI {

    public final FlightService service;

    @ApiOperation(
            value = "Get all flights.",
            response = FlightDTO.class,
            notes = "Provide information of all flights in DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Well done! You got it :)"),
            @ApiResponse(code = 403, message = "Forbidden! Check once again authorization and authentication in Your request!"),
            @ApiResponse(code = 404, message = "Something went wrong with DB or configuration")
    })
    @GetMapping
    public List<FlightDTO> findAll() {
        return service.findAll();
    }

    @ApiOperation(
            value = "Creates flight and saves in SQL DB.",
            httpMethod = "POST",
            notes = "Adds flight in MySQL DB from request  - simple form.")
    @PostMapping
    public void createFlight(
            @ApiParam(required = true)
            @RequestBody CreateFlightRequest request) {
        service.createFlight(request);
    }

    @PostMapping("/specification")
    public List<FlightDTO> findBySpecs(@RequestBody SearchFlightRequest request) {
        return service.findBySpec(request);
    }

    @PostMapping("/reservation")
    public void findBySpecs(@RequestBody Reservation reservation) {
        service.makeReservation(reservation);
    }

    @GetMapping("/id/{id}")
    public FlightDTO findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/id/{id}")
    public void updateBydId(@PathVariable Long id, @RequestBody UpdateFlightRequest request) {
        service.updateOfGivenId(id, request);
    }

    @GetMapping("/airport/{airport}")
    public List<String> findDestinationsByAirport(@PathVariable String airport) {
        return service.findByAirport(airport);
    }

    @GetMapping("/airports")
    public List<String> findAllAirports() {
        return service.findAllAirports();
    }

    @GetMapping("/destination/{destination}")
    public List<String> findAirportByDestination(@PathVariable String destination) {
        return service.findByDestination(destination);
    }

    @GetMapping("/{airport}/{destination}/{date}")
    public List<FlightDTO> findByFlightDate(@PathVariable("airport") String airport,
                                            @PathVariable("destination") String destination,
                                            @PathVariable("date") LocalDate date) {
        return service.findByAirportAndDestinationAndFlightDate(airport, destination, date);
    }

    @GetMapping("/searchbyaircraft/{id}")
    public List<FlightDTO> findByAircraftID(@PathVariable("id") long id) {
        return service.getFlightsByAircraftID(id);
    }


    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

}
