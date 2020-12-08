package be.ipl.pfe.controllers;

import be.ipl.pfe.exceptions.InvalidParameterException;
import be.ipl.pfe.ports.IdGenerator;
import be.ipl.pfe.services.AuthService;
import be.ipl.pfe.services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/doctors/qrcodes")
@RestController
public class QRCodeController {

	@Autowired
	private QRCodeService qrCodeService;

	@Autowired
	private AuthService authService;

	@Autowired
	@Qualifier("UuidGenerator")
	private IdGenerator idGenerator;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> generateQRCode(@RequestParam(value = "amount") Integer amount, @Valid @RequestHeader("Authorization") String token) {
		if (amount == null || amount <= 0 || amount > 20)
			throw new InvalidParameterException("amount", "non-null integer, between 1 and 20.");
		String doctorId = this.authService.checkIfDoctor(token);
		String qrCodeId = this.idGenerator.generate();
		return this.qrCodeService.generate(amount, doctorId, qrCodeId);
	}

}
