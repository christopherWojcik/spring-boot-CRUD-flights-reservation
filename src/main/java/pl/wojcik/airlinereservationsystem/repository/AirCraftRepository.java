package pl.wojcik.airlinereservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.wojcik.airlinereservationsystem.model.aircraft.AirCraft;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirCraftRepository extends JpaRepository<AirCraft, Long>, JpaSpecificationExecutor<AirCraft> {

    Optional<AirCraft> findByAircraftNumber(String number);

    List<AirCraft> findByCapacity(long capacity);

    List<AirCraft> findByOperableIsTrue();

    List<AirCraft> findByOperableAndCapacity(boolean operable, long capacity);
}
