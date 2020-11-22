package com.fr.adaming.jsfapp.controller.backingBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fr.adaming.jsfapp.controller.SuperFacade;
import com.fr.adaming.jsfapp.model.Automate;
import com.fr.adaming.jsfapp.services.IAutomateService;
import com.fr.adaming.jsfapp.util.IBean;

@ManagedBean
@Controller("automateBean")
@Scope("session")
public class AutomateBean extends SuperFacade implements IBean {

	/**
	 *
	 */
	private static final long serialVersionUID = -5649605117843320597L;

	@Autowired(required = true)
	private IAutomateService automateService;

	List<Automate> automates;

	@PostConstruct
	public String init() {
		automates = new ArrayList<>(automateService.findAll(Automate.class));
		return null;
	}

	@Override
	public String nouveauEnregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editEnregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String detailsEnregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEnregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rechercher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveEnregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

}
