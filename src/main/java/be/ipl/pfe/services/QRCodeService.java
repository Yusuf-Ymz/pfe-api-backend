package be.ipl.pfe.services;

import be.ipl.pfe.utils.JwtUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QRCodeService {

	public List<String> generate(Integer amount, String doctorId, String qrCodeId) {
		List<String> hashes = new ArrayList<>();
		for (int i = 0; i < amount; i++)
			hashes.add(JwtUtils.createQRCodeContentToken(doctorId, qrCodeId));
		return hashes;
	}

}
