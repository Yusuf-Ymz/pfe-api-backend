package be.ipl.pfe.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "accounts", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Data
public class Account {
	@Id
	private String id;

	@JsonProperty(required = true)
	@Column(name = "username", nullable = false)
	private String username;

	@JsonProperty(required = true, access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "password", nullable = false)
	private String password;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id")
	private Establishment establishment;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id")
	private Doctor doctor;

	public Account() {}

	@JsonCreator
	public Account(String id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
