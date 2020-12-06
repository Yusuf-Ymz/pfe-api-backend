package be.ipl.pfe.controllers;

import be.ipl.pfe.services.AuthService;
import be.ipl.pfe.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/doctors")
@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private AuthService authService;

	@PostMapping(value = "/generateQRCode", produces = MediaType.APPLICATION_JSON_VALUE)
	public void generateQRCode(@Valid @RequestParam("id") String id) {

	}

}
