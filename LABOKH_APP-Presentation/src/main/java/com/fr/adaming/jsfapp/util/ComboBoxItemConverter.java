package com.fr.adaming.jsfapp.util;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.fr.adaming.jsfapp.dto.UtilBeanUI;

public class ComboBoxItemConverter implements javax.faces.convert.Converter {

	@SuppressWarnings("unchecked")
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		List<UtilBeanUI> selectItems = (List<UtilBeanUI>) component.getAttributes().get("selectItems");
		if (selectItems == null) {
			return null;
		}
		Iterator<UtilBeanUI> iterator = selectItems.iterator();
		while (iterator.hasNext()) {
			UtilBeanUI comboBoxItem = (UtilBeanUI) iterator.next();
			if (comboBoxItem != null && comboBoxItem.getId() != null
					&& comboBoxItem.getDes().trim().replaceAll("^([\\W]+)<", "<").equalsIgnoreCase(value)) {

				return comboBoxItem;
			}
		}
		return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "..";
		}
		UtilBeanUI comboBoxItem = (UtilBeanUI) value;
		return comboBoxItem.getDes();
	}

}
