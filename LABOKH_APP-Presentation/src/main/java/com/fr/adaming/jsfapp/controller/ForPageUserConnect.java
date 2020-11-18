package com.fr.adaming.jsfapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.fr.adaming.jsfapp.model.Utilisateur;
import com.fr.adaming.jsfapp.services.IUtilisateurService;

@Service
@Scope("singleton")
public class ForPageUserConnect extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired(required = true)
	@Qualifier("utilisateurService")
	private IUtilisateurService utilisateurService;

	/**
	 * redirect espace utilisateur selon profil user
	 *
	 * @param HttpServletRequest
	 *            request, HttpServletResponse response
	 * @return String modidied by adjoda to perform commercial authentication
	 */
	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {

		User springSecurityUser = null;
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Object obj = securityContext.getAuthentication().getPrincipal();
		Utilisateur utilisateur = null;
		if (obj instanceof User) {
			springSecurityUser = (User) obj;
			utilisateur = utilisateurService.findByLoginPass(springSecurityUser.getUsername(),
					springSecurityUser.getPassword());
		}
		String url = request.getRequestURL().toString();

		String returnPath = "";
		if (utilisateur != null && utilisateur.getFActif()) {

			return "/pages/index.jsf";

		}

		else {
			returnPath = "/login.jsf";
		}
		return returnPath;
	}

}
