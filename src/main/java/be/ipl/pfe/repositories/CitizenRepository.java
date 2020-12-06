package be.ipl.pfe.repositories;

import be.ipl.pfe.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, String> {
}
