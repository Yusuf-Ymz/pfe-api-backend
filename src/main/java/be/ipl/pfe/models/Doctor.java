package be.ipl.pfe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	private String id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "username", nullable = false)
	private String username;
	@JsonIgnore
	@Column(name = "password", nullable = false)
	private String password;

	public Doctor() {}

	public Doctor(String username, String password, String firstName, String lastName) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.password = BCrypt.hashpw(password, BCrypt.gensalt(10));
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public boolean checkPassword(String password) {
		return BCrypt.checkpw(password, this.password);
	}

	public String getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Doctor{" + "id='" + this.id + '\'' + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", username='" + this.username + '\'' + ", password='" + this.password + '\'' + '}';
	}
}
