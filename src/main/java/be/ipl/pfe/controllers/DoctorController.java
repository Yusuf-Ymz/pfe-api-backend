package be.ipl.pfe.controllers;

import be.ipl.pfe.services.AuthService;
import be.ipl.pfe.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/doctors")
@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private AuthService authService;

}
