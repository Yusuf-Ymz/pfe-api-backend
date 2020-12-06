package be.ipl.pfe.services;

import be.ipl.pfe.exceptions.AlreadyExistsException;
import be.ipl.pfe.models.DoctorScan;
import be.ipl.pfe.ports.IdGenerator;
import be.ipl.pfe.repositories.DoctorScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DoctorScanService {

    @Autowired
    private DoctorScanRepository doctorScanRepository;

    @Autowired
    @Qualifier("UuidGenerator")
    private IdGenerator idGenerator;

    public DoctorScan createScan(DoctorScan doctorScan) {
        if (this.doctorScanRepository.existsById(doctorScan.getDoctorQRCode()))
            throw new AlreadyExistsException(doctorScan.getDoctorQRCode());
        doctorScan.setDoctorQRCode(this.idGenerator.generate());
        return this.doctorScanRepository.save(doctorScan);
    }
}
