package be.ipl.pfe.exceptions;

public class AlreadyExistsException extends BusinessException {

	public AlreadyExistsException(String value) {
		super(value + " must be unique");
	}
}
