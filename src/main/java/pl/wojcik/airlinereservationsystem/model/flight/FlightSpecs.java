package pl.wojcik.airlinereservationsystem.model.flight;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FlightSpecs {

    private String airport;
    private String destination;

    public FlightSpecs(String airport, String destination) {
        this.airport = airport;
        this.destination = destination;
    }

    public List<Predicate> predicates = new ArrayList<>();

    public Specification<Flight> getFlightByCriteria = new Specification<>() {

        @Override
        public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

            if (airport != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("airport"), airport)));
            }

            if (destination != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("destination"), destination)));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        }
    };

}
