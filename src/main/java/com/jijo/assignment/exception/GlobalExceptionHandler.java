package com.jijo.assignment.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * A common class that handles all the exception thrown from the application
 * 
 * @author Jijo Jose
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMsg handleResourceNotFoundException(ResourceNotFoundException ex) {
		ErrorMsg message = new ErrorMsg(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage());
		return message;
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMsg handleException(Exception ex) {
		ErrorMsg message = new ErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ExceptionMessages.MSG_INERTNAL_SERVER_ERROR);
		return message;
	}

}
