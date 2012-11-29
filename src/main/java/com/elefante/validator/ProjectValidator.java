package com.elefante.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.elefante.domain.Project;
import com.elefante.exception.ValidationError;
import com.elefante.exception.ValidationException;

public class ProjectValidator implements Validator<Project> {

	public void validate(Project object) throws ValidationException {
		List<ValidationError> errors = new ArrayList<ValidationError>();

		if (object.getDescription() != null
				&& object.getDescription().length() >= 1000) {
			errors.add(new ValidationError(
					"La descripcion debe tener menos de 1000 caracteres"));
		}

		if (object.getName() == null || StringUtils.isEmpty((object.getName()))
				|| object.getName().length() >= 100) {
			errors.add(new ValidationError(
					"El nombre no puede estar vacio y debe contener menos de 100 caracteres"));
		}

		if (object.getProduct() == null
				|| StringUtils.isEmpty((object.getProduct()))
				|| object.getProduct().length() >= 100) {
			errors.add(new ValidationError(
					"El producto no puede estar vacio y debe contener menos de 100 caracteres"));
		}

		if (object.getReferenceNumber() == null
				|| StringUtils.isEmpty((object.getReferenceNumber()))
				|| object.getReferenceNumber().length() >= 10) {
			errors.add(new ValidationError(
					"El numero de referencia no puede estar vacio y debe contener menos de 10 caracteres"));
		}

		if (object.getState() == null) {
			errors.add(new ValidationError("El estado no puede estar vacio"));
		}

		if (object.getService() == null) {
			errors.add(new ValidationError("El servicio no puede estar vacio"));
		}

		if (object.getClient() == null) {
			errors.add(new ValidationError("El cliente no puede estar vacio"));
		}

		if (object.getResponsable() == null) {
			errors.add(new ValidationError(
					"El responsable no puede estar vacio"));
		}

		if (errors.size() != 0) {
			throw new ValidationException(errors);
		}
	}

}
