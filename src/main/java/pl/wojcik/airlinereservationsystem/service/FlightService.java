package pl.wojcik.airlinereservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wojcik.airlinereservationsystem.model.dto.FlightDTO;
import pl.wojcik.airlinereservationsystem.model.flight.*;
import pl.wojcik.airlinereservationsystem.model.mapper.FlightMapper;
import pl.wojcik.airlinereservationsystem.model.reservation.Reservation;
import pl.wojcik.airlinereservationsystem.repository.FlightRepository;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository repository;
    private final MailService mailService;

    public void createFlight(CreateFlightRequest request) {
        repository.save(FlightMapper.convertCreateRequestToEntity(request));
    }

    public List<FlightDTO> findAll() {
        return FlightMapper.convertListOfEntitiesToDTOList(repository.findAll());
    }

    public List<String> findAllAirports() {
        return repository.findAll().stream()
                .map(Flight::getAirport).distinct().collect(Collectors.toCollection(LinkedList::new));
    }

    public FlightDTO findById(long id) {
        return repository
                .findById(id)
                .map(FlightMapper::convertEntityToDTO)
                .orElseThrow(() -> new RuntimeException("Sorry, flight of id " + id + ", doesn't exist in database."));
    }

    public List<String> findByAirport(String airport) {
        return repository.findAll()
                .stream()
                .filter(flight -> flight.getAirport().equals(airport))
                .map(Flight::getDestination)
                .distinct()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public List<String> findByDestination(String destination) {
        return repository.findAll()
                .stream()
                .filter(flight -> flight.getDestination().equals(destination))
                .map(Flight::getAirport)
                .distinct()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public List<FlightDTO> findByAirportAndDestinationAndFlightDate(String airport,
                                                                    String destination,
                                                                    LocalDate date) {
        return repository.findByAirportAndDestinationAndFlightDate(airport, destination, date);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void updateOfGivenId(Long id, UpdateFlightRequest dto) {
        findById(id); // to check if it will throw exception
        repository.save(FlightMapper.convertUpdateReqToEntityById(id, dto));
    }

    public List<FlightDTO> findBySpec(SearchFlightRequest request) {
        return FlightMapper.convertListOfEntitiesToDTOList(repository.findAll(new FlightSpecs(
                request.getAirport(),
                request.getDestination())
                .getFlightByCriteria));
    }

    public void makeReservation(Reservation reservation) {
        sendMail(reservation);
    }

    public void sendMail(Reservation reservation) {
        try {
            mailService.sendMail(reservation.getEmail(),
                    reservation.getDestination() + " flight!",
                    "<b>reservation on flight to <b>" + reservation.getDestination());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public List<FlightDTO> getFlightsByAircraftID(Long id) {
        return FlightMapper
                .convertListOfEntitiesToDTOList(repository.getFlightsByFlightAirCraft_Id(id));
    }

}
