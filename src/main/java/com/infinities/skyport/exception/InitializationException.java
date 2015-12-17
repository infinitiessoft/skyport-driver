package com.infinities.skyport.exception;

public class InitializationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InitializationException() {
	}

	public InitializationException(String message) {
		super(message);
	}

	public InitializationException(Throwable cause) {
		super(cause);
	}

	public InitializationException(String message, Throwable cause) {
		super(message, cause);
	}

}
