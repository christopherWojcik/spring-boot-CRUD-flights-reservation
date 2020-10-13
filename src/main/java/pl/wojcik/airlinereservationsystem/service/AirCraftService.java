package pl.wojcik.airlinereservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wojcik.airlinereservationsystem.model.aircraft.*;
import pl.wojcik.airlinereservationsystem.model.dto.AirCraftDTO;
import pl.wojcik.airlinereservationsystem.model.mapper.AirCraftMapper;
import pl.wojcik.airlinereservationsystem.repository.AirCraftRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirCraftService {

    private final AirCraftRepository repository;

    public List<AirCraftDTO> findBySpec(SearchAircraftRequest request) {
        return AirCraftMapper.convertToDTOList(
                repository.findAll(new AircraftSpecs(
                request.getCapacity(),
                request.isOperable())
                .getAircraftByCriteria));
    }

    public List<AirCraftDTO> findByJPQL(SearchAircraftRequest request) {
        return AirCraftMapper.convertToDTOList(
                repository.findByOperableAndCapacity(
                        request.isOperable(), request.getCapacity()));
    }

    public void createAirCraft(CreateAircraftRequest request) {
        repository.save(AirCraftMapper.requestToEntity(request));
    }

    public List<AirCraftDTO> findAll() {
        return AirCraftMapper.convertToDTOList(repository.findAll());
    }

    public AirCraftDTO findById(long id) {
        return repository
                .findById(id)
                .map(AirCraftMapper::entityToDTO)
                .orElseThrow(() -> new RuntimeException("Sorry, aircraft of id " + id + ", doesn't exist in database."));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void updateOfGivenId(Long id, UpdateAircraftRequest dto) {
        AirCraft byId = repository.findById(id).orElseThrow();
        byId.setAircraftNumber(dto.getAircraftNumber());
        byId.setCapacity(dto.getCapacity());
        byId.setOperable(dto.isOperable());
        repository.save(byId);
    }

    public AirCraftDTO findByNumber(String number) {
        return repository.findByAircraftNumber(number)
                .map(AirCraftMapper::entityToDTO)
                .orElseThrow(() -> new RuntimeException("Sorry, aircraft of number " + number + ", doesn't exist in database."));
    }

    public List<AirCraftDTO> findByOperableParam() {
        return repository.findByOperableIsTrue()
                .stream()
                .map(AirCraftMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    public List<AirCraftDTO> findByCapacityParam(long capacity) {
        return repository.findByCapacity(capacity)
                .stream()
                .map(AirCraftMapper::entityToDTO)
                .collect(Collectors.toList());
    }
}