package pl.wojcik.airlinereservationsystem.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.wojcik.airlinereservationsystem.model.aircraft.CreateAircraftRequest;
import pl.wojcik.airlinereservationsystem.model.aircraft.SearchAircraftRequest;
import pl.wojcik.airlinereservationsystem.model.aircraft.UpdateAircraftRequest;
import pl.wojcik.airlinereservationsystem.model.dto.AirCraftDTO;
import pl.wojcik.airlinereservationsystem.service.AirCraftService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/aircrafts")
public class AirCraftAPI {

    public final AirCraftService service;

    @GetMapping
    public List<AirCraftDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public void createAirCraft(@RequestBody CreateAircraftRequest request) {
        service.createAirCraft(request);
    }

    @PostMapping("/specification")
    public List<AirCraftDTO> findBySpecs(@RequestBody SearchAircraftRequest request) {
        return service.findBySpec(request);
    }

    @PostMapping("/JPQL")
    public List<AirCraftDTO> findByJPQL(@RequestBody SearchAircraftRequest request) {
        return service.findByJPQL(request);
    }

    @GetMapping("/id/{id}")
    public AirCraftDTO findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public void updateBydId(@PathVariable Long id, @RequestBody UpdateAircraftRequest request) {
        service.updateOfGivenId(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/number/{number}")
    public AirCraftDTO findByNumber(@PathVariable String number) {
        return service.findByNumber(number);
    }

    @GetMapping("/operable")
    public List<AirCraftDTO> findByNumber() {
        return service.findByOperableParam();
    }

    @GetMapping("/capacity/{capacity}")
    public List<AirCraftDTO> findByNumber(@PathVariable long capacity) {
        return service.findByCapacityParam(capacity);
    }

}
