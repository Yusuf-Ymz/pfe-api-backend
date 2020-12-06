package be.ipl.pfe.controllers;

import be.ipl.pfe.models.Location;
import be.ipl.pfe.services.AuthService;
import be.ipl.pfe.services.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/establishments")
@RestController
public class EstablishmentController {

	@Autowired
	private EstablishmentService establishmentService;

	@Autowired
	private AuthService authService;

	@PostMapping(value = "/generateQRCode", produces = MediaType.APPLICATION_JSON_VALUE)
	public void generateQRCode(@Valid @RequestBody Location location, @RequestHeader(required = false, value = "Authorization") String token) {
		this.authService.checkIfEstablishment(token);
		this.establishmentService.generateQRCodeLocation(location);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getQRCodes(@RequestHeader(required = false, value = "Authorization") String token) {
		String id = this.authService.checkIfEstablishment(token);
		return this.establishmentService.getLocations(id);
	}
}
