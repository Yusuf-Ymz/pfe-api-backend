package be.ipl.pfe.services;

import be.ipl.pfe.exceptions.InvalidParameterException;
import be.ipl.pfe.models.Location;
import be.ipl.pfe.ports.IdGenerator;
import be.ipl.pfe.repositories.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentService {

	@Autowired
	private EstablishmentRepository establishmentRepository;

	@Autowired
	@Qualifier("UuidGenerator")
	private IdGenerator idGenerator;

	public void generateQRCodeLocation(Location location) {
		if (location.getEstablishment() == null)
			throw new InvalidParameterException("establishment", "provided");

		location.setId(this.idGenerator.generate());
		System.out.println("la location" + location);
		this.establishmentRepository.save(location);
	}

}