package be.ipl.pfe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends RuntimeException {

	public InvalidParameterException(String parameter, String shouldBe) {
		super(parameter + " is invalid, should be " + shouldBe);
	}
}
