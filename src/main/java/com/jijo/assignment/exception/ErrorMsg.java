package com.jijo.assignment.exception;

import java.util.Date;

/**
 * Custom created class to send the error response
 * 
 * @author Jijo Jose
 *
 */
public class ErrorMsg {
	private int statusCode;
	private Date timestamp;
	private String message;

	public ErrorMsg(int statusCode, Date timestamp, String message) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}
}