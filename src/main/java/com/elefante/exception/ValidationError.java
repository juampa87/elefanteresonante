package com.elefante.exception;

/**
 * This class represents a validation error. The message is an abstract message
 * that may be util to the programmer while the code is a generic code that may
 * be used on the GUI to show an actual i18n message
 * 
 */
public class ValidationError {
	private String message;
	private String args;

	public ValidationError() {
	}

	public ValidationError(String message) {
		this.message = message;
		this.args = "";
	}

	public ValidationError(String message, String args) {
		this.message = message;
		this.args = args;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getArgs() {
		return this.args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
