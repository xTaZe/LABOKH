package com.fr.adaming.jsfapp.controller;

import java.io.File;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Utilisateur;
import com.fr.adaming.jsfapp.services.IUtilisateurService;

@Controller("superFacade")
@Scope("session")
public class SuperFacade implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5666124542575623924L;

	@Autowired
	@Qualifier("utilisateurService")
	private IUtilisateurService utilisateurService;

	public Journal journal;
	public ResourceBundle messageBundle;
	public Utilisateur userConnecte;
	// private Boolean f_Patient;
	// private Boolean f_Professional;
	// private Boolean f_Biologiste;

	private boolean access;
	private boolean ajouter;
	private boolean modifier;
	private boolean supprimer;
	private int niveau;

	@PostConstruct
	public void initSuperFacade() {

		niveau = 0;

	}

	public boolean vrifExisteFolder(String url) {

		if (!new File(url).exists()) {
			new File(url).mkdirs();
			return false;
		} else {
			return true;
		}

	}

	/**
	 * @return the journal
	 */
	public Journal getJournal() {
		return journal;
	}

	/**
	 * @param journal
	 *            the journal to set
	 */
	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	/**
	 * @return the messageBundle
	 */
	public ResourceBundle getMessageBundle() {
		return messageBundle;
	}

	/**
	 * @param messageBundle
	 *            the messageBundle to set
	 */
	public void setMessageBundle(ResourceBundle messageBundle) {
		this.messageBundle = messageBundle;
	}

	/**
	 * @return the userConnecte
	 */
	public Utilisateur getUserConnecte() {
		return userConnecte;
	}

	/**
	 * @param userConnecte
	 *            the userConnecte to set
	 */
	public void setUserConnecte(Utilisateur userConnecte) {
		this.userConnecte = userConnecte;
	}

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	public boolean isAjouter() {
		return ajouter;
	}

	public void setAjouter(boolean ajouter) {
		this.ajouter = ajouter;
	}

	public boolean isModifier() {
		return modifier;
	}

	public void setModifier(boolean modifier) {
		this.modifier = modifier;
	}

	public boolean isSupprimer() {
		return supprimer;
	}

	public void setSupprimer(boolean supprimer) {
		this.supprimer = supprimer;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the paramMontantSeuil
	 */

}
