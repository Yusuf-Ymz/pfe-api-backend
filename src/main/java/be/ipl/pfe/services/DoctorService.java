package be.ipl.pfe.services;

import be.ipl.pfe.models.Doctor;
import be.ipl.pfe.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll() {
        return this.doctorRepository.findAll();
    }

}
