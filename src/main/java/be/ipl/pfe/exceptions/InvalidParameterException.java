package be.ipl.pfe.exceptions;

public class InvalidParameterException extends BusinessException {

	public InvalidParameterException(String parameter, String shouldBe) {
		super(parameter + " is invalid, should be " + shouldBe);
	}

}
