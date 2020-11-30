package be.ipl.pfe.exceptions;

public class LoginException extends BusinessException {

	public LoginException() {
		super("invalid credentials");
	}

}