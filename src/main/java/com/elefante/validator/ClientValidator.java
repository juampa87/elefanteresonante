package com.elefante.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.elefante.domain.Client;
import com.elefante.exception.ValidationError;
import com.elefante.exception.ValidationException;

public class ClientValidator implements Validator<Client> {

	public void validate(Client object) throws ValidationException {
		List<ValidationError> errors = new ArrayList<ValidationError>();

		if (object.getAddress() != null && object.getAddress().length() >= 200) {
			errors.add(new ValidationError(
					"La direccion debe tener menos de 200 caracteres"));
		}

		if (object.getDescription() != null
				&& object.getDescription().length() >= 1000) {
			errors.add(new ValidationError(
					"La descripcion debe tener menos de 1000 caracteres"));
		}

		if (object.getEmail() != null && object.getEmail().length() >= 50) {
			errors.add(new ValidationError(
					"La descripcion debe tener menos de 50 caracteres"));
		}

		if (object.getName() == null || StringUtils.isEmpty((object.getName()))
				|| object.getName().length() >= 50) {
			errors.add(new ValidationError(
					"El nombre no puede estar vacio y debe contener menos de 50 caracteres"));
		}

		if (object.getTel() != null && object.getTel().length() >= 50) {
			errors.add(new ValidationError(
					"El telefono debe tener menos de 50 caracteres"));
		}

		if (object.getTel2() != null && object.getTel2().length() >= 50) {
			errors.add(new ValidationError(
					"El telefono 2 debe tener menos de 50 caracteres"));
		}

		if (errors.size() != 0) {
			throw new ValidationException(errors);
		}
	}

}
