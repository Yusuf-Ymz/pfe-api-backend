package be.ipl.pfe.controllers;

import be.ipl.pfe.exceptions.InvalidParameterException;
import be.ipl.pfe.models.Location;
import be.ipl.pfe.services.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/establishments")
@RestController
public class EstablishmentController {

	@Autowired
	private EstablishmentService establishmentService;


	@PostMapping(value = "/generateQRCode", produces = MediaType.APPLICATION_JSON_VALUE)
	public void generateQRCode(@Valid @RequestBody Location location) {
		//Ajouter le fait que c'est bien un etablissement qui fait la demande


		if (location.getEstablishment() == null)
			throw new InvalidParameterException("establishment", "provided");

		System.out.println("la location controller " + location);
		this.establishmentService.generateQRCodeLocation(location);
		System.out.println("done");
	}

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<Location>> getQRCodes(@Valid @RequestParam("id") String id) {
		Map<String, List<Location>> response = new HashMap<>();
		List<Location> list = this.establishmentService.getLocations(id);
		response.put("locations", list);
		return response;
	}


}
