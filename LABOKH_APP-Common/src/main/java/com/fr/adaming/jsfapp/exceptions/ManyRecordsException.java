package com.fr.adaming.jsfapp.exceptions;

public class ManyRecordsException extends Throwable implements Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
