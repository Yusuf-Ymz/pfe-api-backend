package be.ipl.pfe.controllers;

import be.ipl.pfe.models.*;
import be.ipl.pfe.services.*;
import be.ipl.pfe.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citizens/scans")
public class ScanController {
    @Autowired
    private DoctorScanService doctorScanService;

    @Autowired
    private LocationScanService locationScanService;

    @Autowired
    private AuthService authService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CitizenService citizenService;

    @GetMapping(value = "/doctor", produces = MediaType.APPLICATION_JSON_VALUE)
    public DoctorScan create(@RequestBody String qrCodeContentToken, @RequestHeader("Authorization") String token) {
        this.authService.checkIfCitizen(token);
        Claims claims = JwtUtils.decodeQRCodeContentToken(qrCodeContentToken);
        String doctorId = claims.getId();
        String qrCodeContent = claims.getSubject();
        Doctor doctor = this.doctorService.getDoctorById(doctorId);
        Citizen citizen = this.citizenService.getCitizenById(doctorId);
        return this.doctorScanService.createScan(new DoctorScan(qrCodeContent, doctor, citizen));
    }

    @PostMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public LocationScan create(@RequestBody Location location, @RequestHeader("Authorization") String token) {
        this.authService.checkIfCitizen(token);
        Location retrievedLocation = this.locationService.getLocationById(location.getId());
        Citizen citizen = this.citizenService.getCitizenById(token);
        return this.locationScanService.createLocationScan(new LocationScan(retrievedLocation, citizen));
    }
}
