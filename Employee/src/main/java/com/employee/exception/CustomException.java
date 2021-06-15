package com.employee.exception;

import org.springframework.http.HttpStatus;

/**
 * ExceptionController advice class
 * 
 * @author Vivekananda
 *
 */

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;
	private final HttpStatus httpStatus;

	/**
	 * @param message
	 * @param httpStatus
	 * 
	 */
	public CustomException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}