package com.elefante.exception;

import java.util.List;

public class ValidationException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<ValidationError> errors;

	public ValidationException(List<ValidationError> errors) {
		this.errors = errors;
	}

	public ValidationException(List<ValidationError> errors, Exception e) {
		super(e);
		this.errors = errors;
	}

	public List<ValidationError> getErrors() {
		return this.errors;
	}
}
