package be.ipl.pfe.services;

import be.ipl.pfe.exceptions.InvalidParameterException;
import be.ipl.pfe.models.Location;
import be.ipl.pfe.models.QRCode;
import be.ipl.pfe.ports.IdGenerator;
import be.ipl.pfe.repositories.EstablishmentRepository;
import be.ipl.pfe.repositories.QRCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {

	@Autowired
	private EstablishmentRepository establishmentRepository;

	@Autowired
	private QRCodeRepository qrCodeRepository;

	@Autowired
	private QRCode qrCodeToInsert;

	@Autowired
	@Qualifier("UuidGenerator")
	private IdGenerator idGenerator;

	public void generateQRCodeLocation(Location location) {
		if (location.getEstablishment() == null)
			throw new InvalidParameterException("establishment", "provided");

		location.setId(this.idGenerator.generate());
		this.qrCodeToInsert.setId(this.idGenerator.generate());
		this.qrCodeToInsert.setLocation(location);

		System.out.println("la location" + location);
		this.establishmentRepository.save(location);
		System.out.println("qr code " + this.qrCodeToInsert);
		this.qrCodeRepository.save(this.qrCodeToInsert);
	}

	public List<Location> getLocations(String id) {
		//Add exception ex : no establishment exist

		return this.establishmentRepository.findLocationByEstablishment(id);
	}

}