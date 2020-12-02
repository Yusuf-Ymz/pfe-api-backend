package be.ipl.pfe.dtos;

public class DoctorDTO {
    public String firstName;
    public String lastName;
    public String username;

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
