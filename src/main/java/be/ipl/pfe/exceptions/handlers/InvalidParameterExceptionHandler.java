package be.ipl.pfe.exceptions.handlers;

import be.ipl.pfe.exceptions.InvalidParameterException;
import be.ipl.pfe.utils.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class InvalidParameterExceptionHandler {

	@ResponseBody
	@ExceptionHandler(InvalidParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	Map<String, String> invalidParameterExceptionHandler(InvalidParameterException ex) {
		return JsonUtils.errorToJson(ex.getMessage());
	}

}
