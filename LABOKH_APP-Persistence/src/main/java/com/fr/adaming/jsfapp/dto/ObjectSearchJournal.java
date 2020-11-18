package com.fr.adaming.jsfapp.dto;

import java.util.Date;

public class ObjectSearchJournal {

	private UtilBeanUI utilisateur;
	private Date dateDeb;
	private Date dateFin;
	private String action;

	public ObjectSearchJournal() {

	}

	public UtilBeanUI getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilBeanUI utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
