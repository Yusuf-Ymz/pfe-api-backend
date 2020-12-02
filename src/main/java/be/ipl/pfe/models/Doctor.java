package be.ipl.pfe.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {
    @Id
    @Setter(value = AccessLevel.NONE)
    private String id;

    @JsonProperty(required = true, value = "first_name")
    @Column(name = "first_name", nullable = false)
    public String firstName;

    @JsonProperty(required = true, value = "last_name")
    @Column(name = "last_name", nullable = false)
    public String lastName;

    public Doctor() {
    }

    @JsonCreator
    public Doctor(String firstName, String lastName) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + this.id + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                '}';
    }
}
