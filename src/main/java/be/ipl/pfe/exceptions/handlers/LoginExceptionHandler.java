package be.ipl.pfe.exceptions.handlers;

import be.ipl.pfe.exceptions.LoginException;
import be.ipl.pfe.utils.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class LoginExceptionHandler {

	@ResponseBody
	@ExceptionHandler(LoginException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	Map<String, String> loginExceptionHandler(LoginException ex) {
		return JsonUtils.errorToJson(ex.getMessage());
	}

}
