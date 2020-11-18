package com.fr.adaming.jsfapp.services;

import java.util.List;

import com.fr.adaming.jsfapp.dto.ObjectSearchUtilisateur;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Utilisateur;

public interface IUtilisateurService extends IManagerService<Utilisateur> {

	List<Utilisateur> findByCriteria(ObjectSearchUtilisateur objectSearch, Journal journal);

	Utilisateur findByLoginPass(String login, String passw);

	Utilisateur findByLogin(String login);

	Utilisateur findUtilisateurById(long identifiant, Journal journal);

	List<Utilisateur> findUtilisateurByProfil(Long id);

	public abstract Boolean verifimputText(ObjectSearchUtilisateur objectSearch);

	public abstract List<Utilisateur> findUtilisateToken(String Token);
}
