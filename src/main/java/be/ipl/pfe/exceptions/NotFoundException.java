package be.ipl.pfe.exceptions;

public class NotFoundException extends BusinessException {

	public NotFoundException(String resource, String parameter, String value) {
		super(resource + " with value " + value + " for " + parameter + " was not found");
	}

}
