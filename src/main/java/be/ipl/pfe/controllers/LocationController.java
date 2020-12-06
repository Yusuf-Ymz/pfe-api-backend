package be.ipl.pfe.controllers;

import be.ipl.pfe.models.Location;
import be.ipl.pfe.services.AuthService;
import be.ipl.pfe.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/establishments/locations")
@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@Valid @RequestBody Location location, @RequestHeader(required = false, value = "Authorization") String token) {
        this.authService.checkIfEstablishment(token);
        this.locationService.createLocation(location);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> getAll(@RequestHeader(required = false, value = "Authorization") String token) {
        String id = this.authService.checkIfEstablishment(token);
        return this.locationService.getEstablishmentLocations(id);
    }
}