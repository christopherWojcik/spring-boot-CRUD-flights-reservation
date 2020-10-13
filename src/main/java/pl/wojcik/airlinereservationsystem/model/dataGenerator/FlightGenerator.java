package pl.wojcik.airlinereservationsystem.model.dataGenerator;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import pl.wojcik.airlinereservationsystem.model.flight.Flight;
import pl.wojcik.airlinereservationsystem.repository.FlightRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@ConditionalOnProperty(value = "flight.generate", havingValue = "true")
public class FlightGenerator implements InitializingBean {

    private final FlightRepository repository;

    @Override
    public void afterPropertiesSet() throws Exception {
        addToDB(GeneratorCommonUtils.getRowList(GeneratorCommonUtils.FLIGHT_PATH));
    }

    public Flight createFlight(String airport,
                               String destination,
                               LocalDate flightDate,
                               LocalDate flightDeparture,
                               LocalDate flightArrival) {
        return Flight.builder()
                .airport(airport)
                .destination(destination)
                .flightDate(flightDate)
                .flightDeparture(flightDeparture)
                .flightArrival(flightArrival)
                .build();
    }

    public void saveToDB(Flight f) {
        repository.save(f);
    }

    public void addToDB(List<String[]> list) {
        list.forEach(s -> {
            for (int i = 0; i < 30; i++){
                int iterator = 0;

                String[] str = Arrays.toString(s).split(",");
                saveToDB(createFlight(
                        str[0].trim().replace("[", ""),
                        str[1].trim(),
                        LocalDate.parse(str[2].trim()).plusDays(i),
                        LocalDate.parse(str[3].trim()).plusDays(i),
                        LocalDate.parse(str[4].trim().replace("]", "")).plusDays(i)));
                iterator = iterator + 16;
            }
        });
    }
}