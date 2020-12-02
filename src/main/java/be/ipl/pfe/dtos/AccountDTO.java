package be.ipl.pfe.dtos;

import lombok.Data;

@Data
public class AccountDTO {
    private String username;
    private DoctorDTO doctorDTO;
    private EstablishmentDTO establishmentDTO;
}
