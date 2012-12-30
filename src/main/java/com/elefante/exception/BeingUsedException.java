package com.elefante.exception;

public class BeingUsedException extends Exception {
	private static final long serialVersionUID = 1L;

	public BeingUsedException() {

	}

	public BeingUsedException(Exception e) {
		super(e);

	}
}
