package com.fabric.ilearn.exception;

public class IdentifierNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IdentifierNotFound(String exception) {
		super(exception);
	}
}
