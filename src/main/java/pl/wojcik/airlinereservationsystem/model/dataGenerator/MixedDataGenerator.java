package pl.wojcik.airlinereservationsystem.model.dataGenerator;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wojcik.airlinereservationsystem.model.aircraft.AirCraft;
import pl.wojcik.airlinereservationsystem.model.flight.Flight;
import pl.wojcik.airlinereservationsystem.repository.AirCraftRepository;
import pl.wojcik.airlinereservationsystem.repository.FlightRepository;

@Service
@AllArgsConstructor
@ConditionalOnProperty(value = "mixedData.generate", havingValue = "true")
public class MixedDataGenerator implements InitializingBean {

    private final AirCraftRepository airCraftRepository;
    private final FlightRepository flightRepository;

    @Override
    public void afterPropertiesSet() {
        addFLightsToAircrafts();
    }

    @Transactional
    public void addFLightsToAircrafts() {
        int iter = 1;
        int numberOfAirCrafts = 30;
        int numberOfFlights = 420; // 14 routes * 30 aircrafts = 420 flights
        int databaseFlightLeap = 30;

        /*
            iteration on every aircraft - adding 14 flights from DB
            1 ... - aircraft ONE
            2 ... - aircraft TWO
            ...
            30 ... - aircraft ONE
            31 ... - aircraft TWO
         */
        for (int i = 1; i <= numberOfAirCrafts; i++) {

            if (airCraftRepository.findById((long) i).isPresent()) {
                AirCraft airCraft = airCraftRepository.findById((long) i).get();

                /*
                    adding 14 flights for single aircraft
                 */
                for (int j = iter; j <= numberOfFlights; j = j + databaseFlightLeap) {

                    if (flightRepository.findById((long) j).isPresent()){

                        Flight flight = flightRepository.findById((long) j).get();
                        airCraft.addFlight(flight);
                        flight.setFlightAirCraft(airCraft);
                        airCraftRepository.save(airCraft);

                    } else {
                        throw new RuntimeException("Something with flights went wrong ...");
                    }
                }
                iter += 1;
            } else {
                throw new RuntimeException("Something with aircrafts went wrong ...");
            }
        }
    }
}
