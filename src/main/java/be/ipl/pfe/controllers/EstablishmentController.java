package be.ipl.pfe.controllers;

import be.ipl.pfe.models.Location;
import be.ipl.pfe.services.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/establishments")
@RestController
public class EstablishmentController {

	@Autowired
	private EstablishmentService establishmentService;


	@PostMapping(value = "/generateQRCode", produces = MediaType.APPLICATION_JSON_VALUE)
	public void generateQRCode(@Valid @RequestBody Location location) {
		System.out.println("la location controller " + location);
		this.establishmentService.generateQRCodeLocation(location);
		System.out.println("done");
	}

}
