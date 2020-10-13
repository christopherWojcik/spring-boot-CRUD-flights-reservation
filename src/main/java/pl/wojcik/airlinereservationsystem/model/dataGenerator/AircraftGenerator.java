package pl.wojcik.airlinereservationsystem.model.dataGenerator;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import pl.wojcik.airlinereservationsystem.model.aircraft.AirCraft;
import pl.wojcik.airlinereservationsystem.repository.AirCraftRepository;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@ConditionalOnProperty(value = "aircraft.generate", havingValue = "true")
public class AircraftGenerator implements InitializingBean {

    private final AirCraftRepository airCraftRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        addToDB(GeneratorCommonUtils.getRowList(GeneratorCommonUtils.AIRCRAFT_PATH));
    }

    public AirCraft createAircraft(String number, Long capacity, boolean operable) {
        return AirCraft.builder()
                .aircraftNumber(number)
                .capacity(capacity)
                .operable(operable)
                .build();
    }

    public void saveToDB(AirCraft a) {
        airCraftRepository.save(a);
    }


    public void addToDB(List<String[]> list) {
        list.forEach(s -> {

            String[] str = Arrays.toString(s).split(",");

            saveToDB(createAircraft(
                    str[0].trim().replace("[", ""),
                    Long.parseLong(str[1].trim(), 10),
                    Boolean.parseBoolean(str[2].trim().replace("]", ""))));
        });
    }
}