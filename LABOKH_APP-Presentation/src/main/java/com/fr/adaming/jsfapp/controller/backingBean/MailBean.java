/**

 *
 */

package com.fr.adaming.jsfapp.controller.backingBean;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fr.adaming.jsfapp.model.Utilisateur;
import com.fr.adaming.jsfapp.services.IUtilisateurService;
import com.fr.adaming.jsfapp.utils.EnvoiMailUtil;
import com.fr.adaming.jsfapp.utils.lmd5;

/**
 * @author cdridi
 *
 */
@ManagedBean
@Controller("mailBean")
@Scope("session")
public class MailBean {
	@Autowired(required = true)
	@Qualifier("utilisateurService")
	private IUtilisateurService userService;

	private Utilisateur userExiste;
	private Utilisateur userInitPassword;
	private List<Utilisateur> utilisateurs;
	private String token;
	private String pwd1;
	private String pwd2;
	private String login;
	private static SecureRandom random = new SecureRandom();

	public String EnvoyerPassWord() {
		userExiste = userService.findByLogin(login);

		if (userExiste == null) {

			FacesContext.getCurrentInstance().addMessage(
					"form:email",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"adresse mail invalide Veuillez vérifier votre addresse", "mail inexistant"));
			return null;
		}

		else if (userExiste != null) {

			token = nextSessionId();
			String password = nextSessionId();
			userExiste.setToken(token);
			userExiste.setPassword(lmd5.md5(password));
			userService.saveOrUpdateService(userExiste, null);
			try {

				String content = " Ce lien est utilisable une seul fois ";
				String lien = "http://localhost:8080/LABOKH/passwordEntre.jsf?token=" + token;
				String subject = "Cliquer sur ce lien afin de réinitialiser votre mot de passe. " + lien;
				EnvoiMailUtil.envoiMail(userExiste.getEmail(), " Initialisation de mot de passe ", subject, content);

				FacesContext.getCurrentInstance().addMessage(
						"form:email",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notification", "Utilisateur "
								+ userExiste.getLogin() + " s'il vous plait ouvrir votre boite mail "));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public String changeInitPassword() {

		if (userInitPassword != null) {
			if (pwd1.equals(pwd2) & validatePassWord() & validateConfirmPassWord()) {
				userInitPassword.setPassword(lmd5.md5(pwd1));
				userInitPassword.setToken(null);
				userService.saveOrUpdateService(userInitPassword, null);

				return "/login.jsf";
			}
		}

		return null;

	}

	public boolean validateConfirmPassWord() {

		if (pwd1 != null || pwd2 != null) {
			if (pwd1.equals(pwd2)) {

				return true;
			}
			if (!pwd1.equals(pwd2)) {
				FacesContext context = FacesContext.getCurrentInstance();

				context.addMessage("nodouble", new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
						"Ces mots de passes ne correspondent pas."));
				return false;
			}
		}
		return false;
	}

	/**
	 *
	 * @return boolean
	 *
	 */

	public boolean validatePassWord() {
		if (pwd1 != null) {
			if (pwd1.length() >= 4) {
				return true;

			} else if (pwd1.length() < 4) {
				FacesContext context = FacesContext.getCurrentInstance();

				context.addMessage("nodouble", new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
						"Mot de passe doit contenir au moins 4 caractères"));
				return false;

			}

		}
		return false;
	}

	public void readUser() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		token = request.getParameter("token");
		System.out.println(token);
		utilisateurs = userService.findUtilisateToken(token);
		if (utilisateurs.size() > 0) {
			userInitPassword = utilisateurs.get(0);
		}

	}

	public static String nextSessionId() {
		return new BigInteger(32, random).toString(32).toUpperCase();
	}

	public Utilisateur getUserExiste() {
		return userExiste;
	}

	public void setUserExiste(Utilisateur userExiste) {
		this.userExiste = userExiste;
	}

	public Utilisateur getUserInitPassword() {
		return userInitPassword;
	}

	public void setUserInitPassword(Utilisateur userInitPassword) {
		this.userInitPassword = userInitPassword;
	}

	public String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}
