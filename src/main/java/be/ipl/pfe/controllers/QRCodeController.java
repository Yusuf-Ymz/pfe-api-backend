package be.ipl.pfe.controllers;

import be.ipl.pfe.ports.IdGenerator;
import be.ipl.pfe.services.AuthService;
import be.ipl.pfe.services.QRCodeService;
import be.ipl.pfe.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

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

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> generateQRCode(@Valid @RequestHeader("Authorization") String token) {
        String doctorId = this.authService.checkIfDoctor(token);
        String qrCodeId = this.idGenerator.generate();

        return JsonUtils.stringToJson("content", this.qrCodeService.generate(doctorId, qrCodeId));
    }

}
