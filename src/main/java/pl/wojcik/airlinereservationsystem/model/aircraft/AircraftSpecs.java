package pl.wojcik.airlinereservationsystem.model.aircraft;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Data
public class AircraftSpecs {

    private String craftNumber;
    private long capacity;
    private boolean operable;

    public AircraftSpecs(String craftNumber, long capacity, boolean operable) {
        this.craftNumber = craftNumber;
        this.capacity = capacity;
        this.operable = operable;
    }

    public AircraftSpecs(long capacity, boolean operable) {
        this.capacity = capacity;
        this.operable = operable;
    }

    public List<Predicate> predicates = new ArrayList<>();

    public Specification<AirCraft> getAircraftByCriteria = new Specification<>() {

        @Override
        public Predicate toPredicate(Root<AirCraft> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

            if (craftNumber != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("aircraftNumber"), craftNumber)));
            }

            if (capacity > 0) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("capacity"), capacity)));
            }

            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("operable"), operable)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        }
    };
}