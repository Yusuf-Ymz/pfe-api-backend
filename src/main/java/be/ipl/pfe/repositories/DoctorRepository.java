package be.ipl.pfe.repositories;

import be.ipl.pfe.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {

    @Query(value = "SELECT EXISTS (SELECT * FROM doctors WHERE username = ?1)", nativeQuery = true)
    boolean existsByUsername(String username);

    @Query(value = "SELECT * FROM doctors WHERE username = ?1", nativeQuery = true)
    Doctor findByUsername(String username);

}
