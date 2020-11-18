package com.fr.adaming.jsfapp.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fr.adaming.jsfapp.model.Utilisateur;
import com.fr.adaming.jsfapp.services.IUtilisateurService;

@Service("userDetailsService")
@Scope("singleton")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired(required = true)
	@Qualifier("utilisateurService")
	private IUtilisateurService utilisateurService;

	private boolean rec;

	/**
	 * Intercept login user from form login
	 *
	 * @param String
	 *            username
	 * @return org.springframework.security.core.userdetails.UserDetails
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		if (username == null || username.trim().isEmpty()) {
			throw new UsernameNotFoundException("Empty username");
		}

		Utilisateur user = utilisateurService.findByLogin(username);

		if (user == null) {
			throw new UsernameNotFoundException("user " + username + " could not be found");
		} else {
		}

		Collection<GrantedAuthority> grantedAuthorities = toGrantedAuthorities(user.getProfil().getCodProfil());
		String password = user.getPassword();
		boolean enabled = true;
		boolean userNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean userNonLocked = true;

		User result = new User(username, password, enabled, userNonExpired, credentialsNonExpired, userNonLocked,
				grantedAuthorities);

		return result;

	}

	public static Collection<GrantedAuthority> toGrantedAuthorities(String role) {
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();

		if (role != null || !role.trim().isEmpty()) {
			result.add(new GrantedAuthorityImpl(role));
		}

		return result;
	}

	public boolean isRec() {
		return rec;
	}

	public void setRec(boolean rec) {
		this.rec = rec;
	}
}
