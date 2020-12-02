package be.ipl.pfe.controllers;

import be.ipl.pfe.models.Doctor;
import be.ipl.pfe.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/doctors")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    public List<Doctor> getAll() {
        return this.doctorService.getAll();
    }

}
