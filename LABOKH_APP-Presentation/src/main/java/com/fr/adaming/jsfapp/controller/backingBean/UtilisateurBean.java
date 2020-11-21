package com.fr.adaming.jsfapp.controller.backingBean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fr.adaming.jsfapp.controller.AccueilFacade;
import com.fr.adaming.jsfapp.controller.SuperFacade;
import com.fr.adaming.jsfapp.dto.ObjectSearchUtilisateur;
import com.fr.adaming.jsfapp.model.Profil;
import com.fr.adaming.jsfapp.model.Utilisateur;
import com.fr.adaming.jsfapp.services.IProfilService;
import com.fr.adaming.jsfapp.services.IUtilisateurService;
import com.fr.adaming.jsfapp.util.IBean;
import com.fr.adaming.jsfapp.utils.lmd5;

@ManagedBean
@Controller("utilisateurBean")
@Scope("session")
public class UtilisateurBean extends SuperFacade implements IBean {

	/**
	 *
	 */
	private static final long serialVersionUID = -5649605117843320597L;

	@Autowired(required = true)
	private IUtilisateurService utilisateurService;

	@Autowired(required = true)
	private IProfilService profilService;

	@Autowired(required = true)
	@Qualifier("accueilFacade")
	private AccueilFacade accueilFacade;

	private List<Profil> profils;
	private Utilisateur utilisateurOld;
	private Utilisateur utilisateur;

	private List<Utilisateur> utilisateurs;
	private String pass1;
	private String pass2;
	private boolean activ;
	private boolean modif;

	@PostConstruct
	public String init() {
		utilisateurs = utilisateurService.findAll(Utilisateur.class);
		profils = profilService.findAll(Profil.class);
		return "toUtilisateurIndex";
	}

	@Override
	public String nouveauEnregistrement() {
		modif = false;
		activ = true;
		utilisateurOld = new Utilisateur();
		utilisateur = new Utilisateur();
		return null;
	}

	@Override
	public String editEnregistrement() {
		System.err.println("edit");
		utilisateurOld = utilisateurService.findByIDService(Utilisateur.class, utilisateur.getIdUser());
		modif = true;
		activ = false;
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

		if (!modif) {
			utilisateur.setFActif(true);

			utilisateur.setDateCreation(new Date());
			pass2 = lmd5.md5(pass2);
			utilisateur.setPassword(pass2);
			accueilFacade.getJournal().setTimeaction(new Date());
			accueilFacade.getJournal().setActionDesc("utilisateur connecté : "
					+ this.accueilFacade.connectedUser.getNom() + " Mode Ajout GESTION UTILISATEUR ");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Notification", " UTILISATEUR :  " + utilisateur.getLogin() + " ajouté avec succès"));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		} else {
			accueilFacade.getJournal().setTimeaction(new Date());
			accueilFacade.getJournal().setActionDesc("utilisateur connecté : "
					+ this.accueilFacade.connectedUser.getNom() + " Mode Modif GESTION UTILISATEUR ");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Notification", " UTILISATEUR :  " + utilisateur.getLogin() + " modifié  avec succès"));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
		utilisateurService.saveOrUpdateService(utilisateur);
		return init();

	}

	public String activerDesactiver() {
		if (utilisateur != null) {
			if (utilisateur.getFActif() == true) {
				utilisateur.setFActif(false);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Notification", " UTILISATEUR :  " + utilisateur.getLogin() + " Désactivé avec succès"));
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
				accueilFacade.getJournal().setTimeaction(new Date());
				accueilFacade.getJournal().setActionDesc("utilisateur connecté : "
						+ this.accueilFacade.connectedUser.getNom() + " Mode  Déasctiver GESTION UTILISATEUR ");

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Notification", " UTILISATEUR :  " + utilisateur.getLogin() + " Activé  avec succès"));
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
				utilisateur.setFActif(true);
				accueilFacade.getJournal().setTimeaction(new Date());
				accueilFacade.getJournal().setActionDesc("utilisateur connecté : "
						+ this.accueilFacade.connectedUser.getNom() + " Mode Activer  GESTION UTILISATEUR ");
			}
		}
		utilisateurService.saveOrUpdateService(utilisateur);
		return init();
	}

	public String name() {
		if (modif) {
			modif = false;
		} else {
			modif = true;
		}

		return null;

	}

	public Boolean veriflog() {
		if (utilisateur != null) {

			ObjectSearchUtilisateur Objec = new ObjectSearchUtilisateur();
			Objec.setLogin(utilisateur.getLogin());

			if (!utilisateurService.verifimputText(Objec)
					&& !utilisateur.getLogin().equals(utilisateurOld.getLogin())) {
				FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						" ERROR", "le nom d'utilisateur  existe déjà !!"));
				activ = true;
				return true;
			} else {
				activ = false;
				return false;
			}

		} else {
			activ = false;
			return false;
		}
	}

	public Boolean verifmail() {
		if (utilisateur != null) {

			ObjectSearchUtilisateur Objec = new ObjectSearchUtilisateur();
			Objec.setMail(utilisateur.getEmail());

			if (!utilisateurService.verifimputText(Objec)
					&& !utilisateur.getEmail().equals(utilisateurOld.getEmail())) {
				FacesContext.getCurrentInstance().addMessage("email",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, " ERROR", "Email Utilisateur  existe déjà !!"));
				activ = true;
				return true;
			} else {
				activ = false;
				return false;
			}

		} else {
			activ = false;
			return false;
		}
	}

	public Boolean verifcin() {
		if (utilisateur != null) {

			ObjectSearchUtilisateur Objec = new ObjectSearchUtilisateur();
			Objec.setCin(utilisateur.getCin());

			if (!utilisateurService.verifimputText(Objec) && !utilisateur.getCin().equals(utilisateurOld.getCin())) {
				FacesContext.getCurrentInstance().addMessage("cin",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, " ERROR", "CIN  Utilisateur  existe déjà !!"));

				activ = true;
				return true;
			} else {
				activ = false;
				return false;
			}

		} else {
			activ = false;
			return false;
		}
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public List<Profil> getProfils() {
		return profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

	public boolean isModif() {
		return modif;
	}

	public void setModif(boolean modif) {
		this.modif = modif;
	}

	public Utilisateur getUtilisateurOld() {
		return utilisateurOld;
	}

	public void setUtilisateurOld(Utilisateur utilisateurOld) {
		this.utilisateurOld = utilisateurOld;
	}

	public boolean isActiv() {
		return activ;
	}

	public void setActiv(boolean activ) {
		this.activ = activ;
	}

}
