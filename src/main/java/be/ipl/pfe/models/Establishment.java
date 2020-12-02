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
@Table(name = "establishments")
@Data
public class Establishment {
    @Id
    @Setter(value = AccessLevel.NONE)
    private String id;

    @Column(name = "name", nullable = false)
    @JsonProperty(required = true)
    private String name;

    public Establishment() {

    }

    @JsonCreator
    public Establishment(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
