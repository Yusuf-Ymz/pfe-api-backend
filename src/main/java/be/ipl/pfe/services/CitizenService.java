package be.ipl.pfe.services;

import be.ipl.pfe.exceptions.NotFoundException;
import be.ipl.pfe.models.Citizen;
import be.ipl.pfe.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;

    public Citizen getCitizenById(String citizenId) {
        return this.citizenRepository.findById(citizenId).orElseThrow(() -> new NotFoundException("citizen", "id", citizenId));
    }
}
