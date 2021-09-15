package com.jijo.assignment.exception;

/**
 * Custom created exception to handle when resource not found
 * 
 * @author Jijo Jose
 *
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}