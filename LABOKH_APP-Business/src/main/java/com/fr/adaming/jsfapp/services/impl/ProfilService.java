package com.fr.adaming.jsfapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fr.adaming.jsfapp.dao.IProfilDAO;
import com.fr.adaming.jsfapp.dto.ObjectSearchUtilisateur;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Profil;
import com.fr.adaming.jsfapp.services.IProfilService;

@Service("profilService")
public class ProfilService extends ManagerService<Profil> implements IProfilService {

	@Autowired()
	@Qualifier("profilDAO")
	private IProfilDAO profilDAO;

	@Override
	public List<Profil> findByCriteria(ObjectSearchUtilisateur objectSearch, Journal journal) {
		// TODO Auto-generated method stub
		return null;
	}

}
