package be.ipl.pfe.controllers;

import be.ipl.pfe.exceptions.InvalidParameterException;
import be.ipl.pfe.models.Doctor;
import be.ipl.pfe.services.DoctorService;
import be.ipl.pfe.utils.JsonUtils;
import be.ipl.pfe.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/doctors")
@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/")
	public List<Doctor> getAll() {
		return this.doctorService.getAll();
	}

	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> register(@RequestBody Map<String, String> body) {
		String username = body.getOrDefault("username", "");
		String password = body.getOrDefault("password", "");
		String firstName = body.getOrDefault("first_name", "");
		String lastName = body.getOrDefault("last_name", "");
		if (username.isBlank()) throw new InvalidParameterException("username", "a non empty string");
		if (password.isBlank()) throw new InvalidParameterException("password", "a non empty string");
		if (firstName.isBlank()) throw new InvalidParameterException("first_name", "a non empty string");
		if (lastName.isBlank()) throw new InvalidParameterException("last_name", "a non empty string");
		Doctor doctor = this.doctorService.register(new Doctor(username, password, firstName, lastName));
		Map<String, Object> response = new HashMap<>();
		response.put("token", JwtUtils.createJWT(doctor.getId(), doctor.getUsername()));
		response.put("doctor", doctor);
		return response;
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody Map<String, String> body) {
		String username = body.getOrDefault("username", "");
		String password = body.getOrDefault("password", "");
		if (username.isBlank()) throw new InvalidParameterException("username", "a non empty string");
		if (password.isBlank()) throw new InvalidParameterException("password", "a non empty string");
		Doctor doctor = this.doctorService.login(username, password);
		return JsonUtils.stringToJson("token", JwtUtils.createJWT(doctor.getId(), doctor.getUsername()));
	}

}
