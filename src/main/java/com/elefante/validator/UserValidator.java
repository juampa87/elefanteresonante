package com.elefante.validator;

import java.util.ArrayList;
import java.util.List;

import com.elefante.domain.User;
import com.elefante.exception.ValidationError;
import com.elefante.exception.ValidationException;

public class UserValidator implements Validator<User> {

	public void validate(User object) throws ValidationException {
		List<ValidationError> errors = new ArrayList<ValidationError>();
		if (object.getUsername() == null
				|| org.apache.commons.lang3.StringUtils.isEmpty((object
						.getUsername())) || object.getUsername().length() >= 50) {
			errors.add(new ValidationError(
					"El nombre de usuario no puede estar vacio y debe tener menos de 50 caracteres"));
		}

		if (errors.size() != 0) {
			throw new ValidationException(errors);
		}
	}

}
