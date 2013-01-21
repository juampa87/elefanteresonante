package com.elefante.editors;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringUtils;

import com.elefante.domain.Item;

public class ItemCustomEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		String[] parts = StringUtils.split(text, "-");
		Item item = new Item();
		item.setDescription(parts[0]);
		item.setAmmount(Double.parseDouble(parts[1]));
		this.setValue(item);
	}
}
