package be.ipl.pfe.exceptions.handlers;

import be.ipl.pfe.exceptions.AlreadyExistsException;
import be.ipl.pfe.utils.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class AlreadyExistsExceptionHandler {

	@ResponseBody
	@ExceptionHandler(AlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	Map<String, String> alreadyExistsExceptionHandler(AlreadyExistsException ex) {
		return JsonUtils.errorToJson(ex.getMessage());
	}

}
