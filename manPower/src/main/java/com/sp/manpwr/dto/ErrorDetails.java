package com.sp.manpwr.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;
	private Throwable error;

	private String response_id;
	private String error_code;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ErrorDetails(Date timestamp, String message, String details, String response_id, String error_code) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.response_id = response_id;
		this.error_code = error_code;
	}

	public ErrorDetails(Date timestamp, Throwable error, String details, String response_id, String error_code) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.details = details;
		this.response_id = response_id;
		this.error_code = error_code;
	}

	public String getResponse_id() {
		return response_id;
	}

	public void setResponse_id(String response_id) {
		this.response_id = response_id;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public Throwable getError() {
		return error;
	}

	public void setError(Throwable error) {
		this.error = error;
	}

}
