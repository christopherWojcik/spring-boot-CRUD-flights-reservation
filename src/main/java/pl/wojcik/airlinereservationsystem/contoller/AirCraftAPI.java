package pl.wojcik.airlinereservationsystem.contoller;

import io.swagger.annotations.*;
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
@Api(value = "Airplanes API", protocols = "http")
public class AirCraftAPI {

    public final AirCraftService service;

    @ApiOperation(value = "Find all airplanes.",
            response = AirCraftDTO.class,
            notes = "Provide information about all airplanes in DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK :)"),
            @ApiResponse(code = 401, message = "Unauthorized request! Check once again authentication data."),
            @ApiResponse(code = 403, message = "Forbidden!!!"),
            @ApiResponse(code = 404, message = "Data not found ... something possibly went wrong with the configuration")})
    @GetMapping
    public List<AirCraftDTO> findAll() {
        return service.findAll();
    }

    @ApiOperation(value = "Add airplane",
            httpMethod = "POST",
            notes = "Creates and adds airplane into DB")
    @PostMapping
    public void createAirCraft(
            @ApiParam(required = true,
                    name = "JSON object with fields: aircraftNumber, capacity, isOperable",
                    example = "{ \"aircraftNumber\" : \"A1200\"," +
                            " \"capacity\" : \"200\"," +
                            " \"isOperable\" : \"true\"  }")
            @RequestBody CreateAircraftRequest request) {
        service.createAirCraft(request);
    }


    @ApiOperation(value = "Find by Specs",
            httpMethod = "POST",
            response = AirCraftDTO.class)
    @PostMapping("/specification")
    public List<AirCraftDTO> findBySpecs(
            @ApiParam(value = "", example =
                    "{\"capacity\" : \"200\", \"operable\" : \"true\"}")
            @RequestBody SearchAircraftRequest request) {
        return service.findBySpec(request);
    }

    @ApiOperation(value = "Find by JPQL",
            notes = "Find by capacity and operable as a @RequestBody JSON object fields",
            httpMethod = "POST",
            response = AirCraftDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK :)"),
            @ApiResponse(code = 201, message = "Airplane has been created successfully!"),
            @ApiResponse(code = 401, message = "Unauthorized request! Check once again authentication data."),
            @ApiResponse(code = 403, message = "Forbidden!!!"),
            @ApiResponse(code = 404, message = "Data not found ... something possibly went wrong with the configuration")})
    @PostMapping("/JPQL")
    public List<AirCraftDTO> findByJPQL(
            @ApiParam(required = true,
                    example = "{ \"capacity\" : \"100\", \"operable\" : \"true\" }")
            @RequestBody SearchAircraftRequest request) {
        return service.findByJPQL(request);
    }


    @ApiOperation(value = "Find airplane by ID.",
            response = AirCraftDTO.class,
            notes = "Provides information about all airplanes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK :)"),
            @ApiResponse(code = 401, message = "Unauthorized request! Check once again authentication data."),
            @ApiResponse(code = 403, message = "OK :)"),
            @ApiResponse(code = 404, message = "Data not found ... something possibly went wrong with the configuration")})
    @GetMapping("/id/{id}")
    public AirCraftDTO findById(@PathVariable long id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Update by ID",
            httpMethod = "PUT",
            notes = "Updates airplane by ID as a @PathVariable param and updated fields in RequestBody")
    @PutMapping("/update/{id}")
    public void updateBydId(
            @ApiParam(required = true, example = "2")
            @PathVariable Long id,
            @ApiParam(example = "{\"id\" : \"2\"," +
                    "\"aircraftNumber\" : \"A1200 EDITED\"," +
                    "\"capacity\" : \"201\"," +
                    "\"isOperable\" : \"true\" }")
            @RequestBody UpdateAircraftRequest request) {
        service.updateOfGivenId(id, request);
    }

    @ApiOperation(value = "Delete by ID",
            httpMethod = "DELETE",
            notes = "Delete airplane by ID as a @PathVariable param")
    @DeleteMapping("/{id}")
    public void delete(
            @ApiParam(required = true, example = "2")
            @PathVariable Long id) {
        service.deleteById(id);
    }

    @ApiOperation(value = "Find by number",
            httpMethod = "GET",
            response = AirCraftDTO.class,
            notes = "Finds airplane by number as a @PathVariable param")
    @GetMapping("/number/{number}")
    public AirCraftDTO findByNumber(@ApiParam(required = true, example = "5")
                                    @PathVariable String number) {
        return service.findByNumber(number);
    }

    @ApiOperation(value = "Find operable airplanes",
            httpMethod = "GET",
            response = AirCraftDTO.class,
            notes = "Finds operable (\"true\") airplanes")
    @GetMapping("/operable")
    public List<AirCraftDTO> findByOperable() {
        return service.findByOperableParam();
    }

    @ApiOperation(value = "Find by Capacity",
            httpMethod = "GET",
            response = AirCraftDTO.class,
            notes = "Finds airplanes by capacity param as a @PathVariable")
    @GetMapping("/capacity/{capacity}")
    public List<AirCraftDTO> findByCapacity(
            @ApiParam(required = true, example = "200")
            @PathVariable long capacity) {
        return service.findByCapacityParam(capacity);
    }

}
