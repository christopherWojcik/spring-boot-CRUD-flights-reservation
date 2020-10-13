package pl.wojcik.airlinereservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.wojcik.airlinereservationsystem.model.passenger.Passenger;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>, JpaSpecificationExecutor<Passenger> {

    Optional<Passenger> findById(Long id);

    Optional<Passenger> findByEmail(String email);

    Optional<Passenger> findByEmailIsContaining(String email);

    Optional<Passenger> findByFirstName(String firstname);

    Optional<Passenger> findBySurname(String surname);

    Optional<Passenger> findByTelephone(String telephone);

}
