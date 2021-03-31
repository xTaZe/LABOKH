package com.fr.adaming.jsfapp.controller.backingBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fr.adaming.jsfapp.controller.SuperFacade;
import com.fr.adaming.jsfapp.model.Reactif;
import com.fr.adaming.jsfapp.services.IReactifService;
import com.fr.adaming.jsfapp.util.IBean;

@ManagedBean
@Controller("reactifBean")
@Scope("session")
public class ReactifBean extends SuperFacade implements IBean {

	/**
	 *
	 */
	private static final long serialVersionUID = -5649605117843320597L;

	@Autowired(required = true)
	private IReactifService reactifService;

	private List<Reactif> reactifs;
	private Reactif reactif;

	@PostConstruct
	public String init() {
		reactifs = (new ArrayList<>(reactifService.findAll(Reactif.class)));
		return "/pages/reactifs/index.jsf?faces-redirect=true";
	}

	@Override
	public String nouveauEnregistrement() {
		this.reactif = new Reactif();
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
		reactifService.saveOrUpdateService(reactif);
		return init();
	}

	public List<Reactif> getReactifs() {
		return reactifs;
	}

	public void setReactifs(List<Reactif> reactifs) {
		this.reactifs = reactifs;
	}

	public Reactif getReactif() {
		return reactif;
	}

	public void setReactif(Reactif reactif) {
		this.reactif = reactif;
	}

}
