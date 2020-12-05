package be.ipl.pfe.repositories;

import be.ipl.pfe.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends JpaRepository<Location, String> {


}
