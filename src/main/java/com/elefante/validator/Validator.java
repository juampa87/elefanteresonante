package com.elefante.validator;

import com.elefante.exception.ValidationException;

public interface Validator<T> {
	void validate(T object) throws ValidationException;
}
