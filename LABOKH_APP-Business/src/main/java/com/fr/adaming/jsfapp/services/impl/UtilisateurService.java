package com.fr.adaming.jsfapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fr.adaming.jsfapp.dao.IUtilisateurDao;
import com.fr.adaming.jsfapp.dto.ObjectSearchUtilisateur;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Utilisateur;
import com.fr.adaming.jsfapp.services.IUtilisateurService;

@Service("utilisateurService")
public class UtilisateurService extends ManagerService<Utilisateur> implements IUtilisateurService {

	@Autowired()
	@Qualifier("utilisateurDao")
	private IUtilisateurDao utilisateurDao;

	private Utilisateur utilisateur;

	@Override
	public List<Utilisateur> findByCriteria(ObjectSearchUtilisateur objectSearch, Journal journal) {
		return utilisateurDao.findUtilByCriteria(objectSearch, journal);

	}

	@Override
	public Utilisateur findByLoginPass(String login, String passw) {
		Utilisateur utilisateur;
		utilisateur = utilisateurDao.findbyLoginPass(login, passw);
		if (utilisateur != null) {
			return utilisateur;
		}
		return null;
	}

	@Override
	public Utilisateur findByLogin(String login) {

		return utilisateurDao.findByLogin(login);

	}

	@Override
	public Utilisateur findUtilisateurById(long identifiant, Journal journal) {
		utilisateur = utilisateurDao.findUtilisateurById(identifiant, journal);
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findUtilisateurByProfil(Long id) {
		return utilisateurDao.findUtilisateurByProfil(id);
	}

	@Override
	public Boolean verifimputText(ObjectSearchUtilisateur objectSearch) {
		// TODO Auto-generated method stub
		return utilisateurDao.verifimputText(objectSearch);
	}

	@Override
	public List<Utilisateur> findUtilisateToken(String Token) {
		// TODO Auto-generated method stub
		return utilisateurDao.findUtilisateToken(Token);
	}

}
