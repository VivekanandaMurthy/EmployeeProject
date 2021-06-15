package com.employee.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * ExceptionController advice class
 * 
 * @author Vivekananda
 *
 */

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * @returns a response entity with custom error message, date with time, HttpStatus, HttpCode message, exception message
	 * 
	 */

	@org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
	public ResponseEntity<ExceptionResponse> notFoundException(CustomException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date().toString(), ex.getHttpStatus().value(),
				ex.getHttpStatus().getReasonPhrase(), ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, ex.getHttpStatus());
	}

}
