package com.fr.adaming.jsfapp.validator;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
			+ "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" + "(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;
	public static final ResourceBundle messageBundle = ResourceBundle.getBundle("ResourceBundle");

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, messageBundle.getString("msg.erreur"),
					messageBundle.getString("msg.valid.email"));
			throw new ValidatorException(msg);

		}

	}

}
