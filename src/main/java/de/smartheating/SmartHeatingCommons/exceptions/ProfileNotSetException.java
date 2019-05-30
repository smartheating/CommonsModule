package de.smartheating.SmartHeatingCommons.exceptions;

public class ProfileNotSetException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProfileNotSetException() {
	}

	public ProfileNotSetException(String message) {
		super(message);
	}

	public ProfileNotSetException(Throwable cause) {
		super(cause);
	}

	public ProfileNotSetException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
