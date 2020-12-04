package be.ipl.pfe.controllers;

import be.ipl.pfe.services.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/establishments")
@RestController
public class EstablishmentController {

	@Autowired
	private EstablishmentService establishmentService;

}
