package com.fr.adaming.jsfapp.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/*
 * 
 * validateur des dates
 */
public class DateValidator implements Validator {

	Date dateDebut;
	Date dateFin;
	UIInput dateDebutInput = null;

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String dateDebutId = (String) component.getAttributes().get("dateDebut");

		dateDebutInput = (UIInput) context.getViewRoot().findComponent(dateDebutId);
		if (dateDebutInput != null) {
			dateDebut = (Date) dateDebutInput.getValue();
		}
		dateFin = (Date) value;

		if (dateDebut != null && dateFin != null) {
			if (dateDebut.after(dateFin)) {
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", ""));
			}
		}

	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public UIInput getDateDebutInput() {
		return dateDebutInput;
	}

	public void setDateDebutInput(UIInput dateDebutInput) {
		this.dateDebutInput = dateDebutInput;
	}

}
