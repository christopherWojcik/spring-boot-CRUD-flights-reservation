package pl.wojcik.airlinereservationsystem.model.mapper;

import pl.wojcik.airlinereservationsystem.model.aircraft.AirCraft;
import pl.wojcik.airlinereservationsystem.model.aircraft.CreateAircraftRequest;
import pl.wojcik.airlinereservationsystem.model.aircraft.UpdateAircraftRequest;
import pl.wojcik.airlinereservationsystem.model.dto.AirCraftDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AirCraftMapper {

    public static AirCraftDTO entityToDTO(AirCraft entity) {
        return AirCraftDTO.builder()
                .dto_id(entity.getId())
                .aircraftNumber(entity.getAircraftNumber())
                .capacity(entity.getCapacity())
                .isOperable(entity.isOperable())
                .build();
    }

    public static List<AirCraftDTO> convertToDTOList(List<AirCraft> list) {
        return list.stream()
                .map(AirCraftMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    public static AirCraft updateToEntityById(UpdateAircraftRequest dto) {
        return AirCraft.builder()
                .id(dto.getId())
                .aircraftNumber(dto.getAircraftNumber())
                .capacity(dto.getCapacity())
                .operable(dto.isOperable())
                .build();
    }

    public static AirCraft requestToEntity(CreateAircraftRequest request) {
        return AirCraft.builder()
                .aircraftNumber(request.getAircraftNumber())
                .capacity(request.getCapacity())
                .operable(request.isOperable())
                .build();
    }
}
