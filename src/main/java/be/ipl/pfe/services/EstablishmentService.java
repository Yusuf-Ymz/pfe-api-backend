package be.ipl.pfe.services;

import be.ipl.pfe.repositories.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentService {

	@Autowired
	private EstablishmentRepository establishmentRepository;

}