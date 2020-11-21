package com.fr.adaming.jsfapp.services;

import java.util.List;

import com.fr.adaming.jsfapp.dto.ObjectSearchUtilisateur;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Profil;

public interface IProfilService extends IManagerService<Profil> {

	List<Profil> findByCriteria(ObjectSearchUtilisateur objectSearch, Journal journal);

}
