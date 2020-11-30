package be.ipl.pfe.exceptions.handlers;

import be.ipl.pfe.exceptions.NotFoundException;
import be.ipl.pfe.utils.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class NotFoundExceptionHandler {

	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	Map<String, String> notFoundExceptionHandler(NotFoundException ex) {
		return JsonUtils.errorToJson(ex.getMessage());
	}

}
