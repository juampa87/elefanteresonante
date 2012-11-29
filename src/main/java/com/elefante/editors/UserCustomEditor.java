package com.elefante.editors;

import java.beans.PropertyEditorSupport;

import com.elefante.domain.User;
import com.elefante.service.UserService;

public class UserCustomEditor extends PropertyEditorSupport {

	UserService userService;

	public UserCustomEditor(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setAsText(String text) {
		User user = this.userService.getUser(Integer.parseInt(text));
		this.setValue(user);
	}
}
