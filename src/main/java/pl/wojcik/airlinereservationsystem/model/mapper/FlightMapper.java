package pl.wojcik.airlinereservationsystem.model.mapper;

import pl.wojcik.airlinereservationsystem.model.dto.FlightDTO;
import pl.wojcik.airlinereservationsystem.model.flight.CreateFlightRequest;
import pl.wojcik.airlinereservationsystem.model.flight.Flight;
import pl.wojcik.airlinereservationsystem.model.flight.UpdateFlightRequest;

import java.util.List;
import java.util.stream.Collectors;

public class FlightMapper {

    public static Flight convertCreateRequestToEntity(CreateFlightRequest request) {
        return Flight.builder()
                .airport(request.getAirport())
                .destination(request.getDestination())
                .flightArrival(request.getFlightArrival())
                .flightDate(request.getFlightDate())
                .flightDeparture(request.getFlightDeparture())
                .build();
    }

    public static List<FlightDTO> convertListOfEntitiesToDTOList(List<Flight> list) {
        return list.stream()
                .map(FlightMapper::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public static FlightDTO convertEntityToDTO(Flight entity) {
        return FlightDTO.builder()
                .dto_id(entity.getId())
                .airport(entity.getAirport())
                .destination(entity.getDestination())
                .flightAirCraft(entity.getFlightAirCraft().getAircraftNumber())
                .flightArrival(entity.getFlightArrival().toString())
                .flightDate(entity.getFlightDate().toString())
                .flightDeparture(entity.getFlightDeparture().toString())
                .flightPassengers(entity.getFlightPassengers())
                .build();
    }

    public static Flight convertUpdateReqToEntityById(Long id, UpdateFlightRequest dto) {
        return Flight.builder()
                .id(id)
                .airport(dto.getAirport())
                .destination(dto.getDestination())
                .flightArrival(dto.getFlightArrival())
                .flightDate(dto.getFlightDate())
                .flightDeparture(dto.getFlightDeparture())
                .build();
    }
}
