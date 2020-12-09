package be.ipl.pfe.repositories;

import be.ipl.pfe.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, String> {

    @Query(value = "SELECT DISTINCT c2.notification_token " +
            "FROM citizens c1, citizens c2, locations_scans l1, locations_scans l2 " +
            "WHERE c1.id=?1 AND c1.id=l1.citizen_id AND l1.visit_date_time BETWEEN NOW() - INTERVAL '10 DAY' AND NOW() " +
            "AND c2.id<>c1.id AND l2.citizen_id=c2.id AND l2.location_id=l1.location_id " +
            "AND l2.visit_date_time BETWEEN l1.visit_date_time AND l1.visit_date_time + INTERVAL '1 HOUR' ", nativeQuery = true)
    List<String> getPotentialInfectedCitizens(String citizenId);
}
