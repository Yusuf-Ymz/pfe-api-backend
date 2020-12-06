package be.ipl.pfe.services;

import be.ipl.pfe.utils.JwtUtils;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService {

    public String generate(String doctorId, String qrCodeId) {
        return JwtUtils.createQRCodeContentToken(doctorId, qrCodeId);
    }

}
