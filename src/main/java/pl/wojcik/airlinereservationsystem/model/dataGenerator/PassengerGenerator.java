package pl.wojcik.airlinereservationsystem.model.dataGenerator;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import pl.wojcik.airlinereservationsystem.model.passenger.Passenger;
import pl.wojcik.airlinereservationsystem.repository.PassengerRepository;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@ConditionalOnProperty(value = "passenger.generate", havingValue = "true")
public class PassengerGenerator implements InitializingBean {

    private final PassengerRepository repository;

    @Override
    public void afterPropertiesSet() throws Exception {
        addToDB(GeneratorCommonUtils.getRowList(GeneratorCommonUtils.PASSENGER_PATH));
    }

    public Passenger createPassenger(String firstName,
                                     String surname,
                                     String street,
                                     String streetNumber,
                                     String city,
                                     String country,
                                     String postalCode,
                                     String email,
                                     String telephone) {
        return Passenger.builder()
                .firstName(firstName)
                .surname(surname)
                .street(street)
                .streetNumber(streetNumber)
                .city(city)
                .country(country)
                .postalCode(postalCode)
                .email(email)
                .telephone(telephone)
                .build();
    }

    public void saveToDB(Passenger p) {
        repository.save(p);
    }

    public void addToDB(List<String[]> list) {
        list.forEach(s -> {

            String[] str = Arrays.toString(s).split(",");

            saveToDB(createPassenger(
                    str[0].trim().replace("[", ""),
                    str[1].trim(),
                    str[2].trim(),
                    str[3].trim(),
                    str[4].trim(),
                    str[5].trim(),
                    str[6].trim(),
                    str[0].trim().replace("[", "").toLowerCase() + "." + str[1].trim().toLowerCase() + "@gmail.com",
                    str[8].trim().replace("]", "")
            ));
        });
    }
}