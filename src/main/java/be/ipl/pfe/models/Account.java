package be.ipl.pfe.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "accounts", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Data
public class Account {
    @Id
    @Getter
    @Setter(value = AccessLevel.NONE)
    private String id;

    @JsonProperty(required = true)
    @Column(name = "username", nullable = false)
    @Getter
    private String username;

    @JsonProperty(required = true, access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    @Getter
    private Establishment establishment;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    @Getter
    private Doctor doctor;

    public Account() {

    }

    @JsonCreator
    public Account(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }

    public void hashPassword() {
        this.setPassword(BCrypt.hashpw(this.password, BCrypt.gensalt(10)));
    }

}
