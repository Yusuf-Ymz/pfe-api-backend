package be.ipl.pfe.controllers;

import be.ipl.pfe.dtos.DoctorDTO;
import be.ipl.pfe.exceptions.InvalidParameterException;
import be.ipl.pfe.models.Doctor;
import be.ipl.pfe.services.DoctorService;
import be.ipl.pfe.utils.JsonUtils;
import be.ipl.pfe.utils.JwtUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
