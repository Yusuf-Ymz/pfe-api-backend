package be.ipl.pfe.services;

import be.ipl.pfe.exceptions.AlreadyExistsException;
import be.ipl.pfe.exceptions.LoginException;
import be.ipl.pfe.exceptions.NotFoundException;
import be.ipl.pfe.models.Doctor;
import be.ipl.pfe.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> getAll() {
		return this.doctorRepository.findAll();
	}

	public Doctor register(Doctor doctor) {
		if (this.doctorRepository.existsByUsername(doctor.getUsername())) throw new AlreadyExistsException("username");
		return this.doctorRepository.save(doctor);
	}

	public Doctor login(String username, String password) {
		Doctor doctor = this.doctorRepository.findByUsername(username);
		if (doctor == null) throw new NotFoundException("doctor", "username", username);
		if (!doctor.checkPassword(password)) throw new LoginException();
		return doctor;
	}
}
