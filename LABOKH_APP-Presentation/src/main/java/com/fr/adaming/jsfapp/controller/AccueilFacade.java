package com.fr.adaming.jsfapp.controller;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Date;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Utilisateur;
import com.fr.adaming.jsfapp.services.IUtilisateurService;

@ManagedBean
@Controller("accueilFacade")
@Scope("session")
public class AccueilFacade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Utilisateur utilisateur;
	public Utilisateur connetedUser;

	private String userConnectedName;
	private String host;
	private Journal journal;
	private String nomAppParProfil;

	private User springSecurityUser;
	private Collection<GrantedAuthority> listRole;
	private boolean[] tabApplication;
	private ResourceBundle messageBundle;

	private String Password;
	private String Password2;
	private String oldPassword;

	@Autowired(required = true)
	@Qualifier("utilisateurService")
	private IUtilisateurService utilisateurService;

	public AccueilFacade() {

		SecurityContext securityContext = SecurityContextHolder.getContext();
		Object obj = securityContext.getAuthentication().getPrincipal();
		if (obj instanceof User) {
			springSecurityUser = (User) obj;
			userConnectedName = springSecurityUser.getUsername();
			listRole = securityContext.getAuthentication().getAuthorities();
			tabApplication = new boolean[15];

		}
	}

	@PostConstruct
	public void createJournalObjectSession() {

		messageBundle = ResourceBundle.getBundle("MessageResource");
		connetedUser = new Utilisateur();
		connetedUser = utilisateurService.findByLoginPass(springSecurityUser.getUsername(),
				springSecurityUser.getPassword());

		connetedUser.setDateLastLogin(new Date());
		utilisateurService.saveOrUpdateService(connetedUser, journal);

		journal = new Journal();

		HttpServletRequest request = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest());
		String ip = request.getRemoteAddr();
		String host = request.getRemoteHost();
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		journal.setUtilisateur(connetedUser);
		journal.setLastConnDate(new Date());
		journal.setTimeaction(new Date());
		String browserType = (String) req.getHeader("User-Agent");

		journal.setNavigateurInfo(browserType);
		journal.setIpprovenance("IP Server NAT:" + ip);
		try {
			InetAddress thisIp = InetAddress.getLocalHost();
			journal.setZl1("IP Host Address:" + thisIp.getHostAddress());
			journal.setZl2("IP Host Name:" + thisIp.getHostName());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String home() {
		return "/pages/index.xhtml";

	}

	public String editProfil() {

		return "toMyProfil";
	}

	public String saveProfil() {
		if (connetedUser != null) {
			// oldPassword = lmd5.md5(oldPassword);
			if (connetedUser.getPassword().equals(oldPassword)) {
				// Password2 = lmd5.md5(Password2);
				connetedUser.setPassword(Password2);
				utilisateurService.saveOrUpdateService(connetedUser, journal);
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Mot de passe incorrect"));
			}
		}

		return editProfil();
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public User getSpringSecurityUser() {
		return springSecurityUser;
	}

	public void setSpringSecurityUser(User springSecurityUser) {
		this.springSecurityUser = springSecurityUser;
	}

	public String getUserConnectedName() {
		return userConnectedName;
	}

	public void setUserConnectedName(String userConnectedName) {
		this.userConnectedName = userConnectedName;
	}

	public Collection<GrantedAuthority> getListRole() {
		return listRole;
	}

	public void setListRole(Collection<GrantedAuthority> listRole) {
		this.listRole = listRole;
	}

	public boolean[] getTabApplication() {
		return tabApplication;
	}

	public void setTabApplication(boolean[] tabApplication) {
		this.tabApplication = tabApplication;
	}

	public ResourceBundle getMessageBundle() {
		return messageBundle;
	}

	public void setMessageBundle(ResourceBundle messageBundle) {
		this.messageBundle = messageBundle;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Utilisateur getConnetedUser() {
		return connetedUser;
	}

	public void setConnetedUser(Utilisateur connetedUser) {
		this.connetedUser = connetedUser;
	}

	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public String getNomAppParProfil() {
		return nomAppParProfil;
	}

	public void setNomAppParProfil(String nomAppParProfil) {
		this.nomAppParProfil = nomAppParProfil;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPassword2() {
		return Password2;
	}

	public void setPassword2(String password2) {
		Password2 = password2;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

}
