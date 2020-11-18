package com.fr.adaming.jsfapp.dao;

import java.util.List;

import com.fr.adaming.jsfapp.dto.ObjectSearch;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Profil;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
public interface IProfilDAO extends IManagerDao<Profil> {

	public abstract List<Profil> findByCriteria(ObjectSearch objectSearch, Journal journal);

	public abstract Boolean verifimputText(ObjectSearch objectSearch);

}
