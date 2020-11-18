package com.fr.adaming.jsfapp.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IProfilDAO;
import com.fr.adaming.jsfapp.dto.ObjectSearch;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Profil;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */

@Repository("profilDAO")
public class ProfilDAO extends ManagerDao<Profil> implements IProfilDAO {
	@Override
	public List<Profil> findByCriteria(ObjectSearch objectSearch, Journal journal) {
		String queryString = "select * from profil WHERE 1=1";

		if (objectSearch != null) {
			if (objectSearch.getCode() != null && !objectSearch.getCode().isEmpty()) {
				queryString = queryString + " AND CODE_PROFIL ='" + objectSearch.getCode() + "'";
			}

			if (objectSearch.getDesignation() != null && !objectSearch.getDesignation().isEmpty()) {
				queryString = queryString + " AND DESC_PROFIL  ='" + objectSearch.getDesignation() + "'";
			}

		}

		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<Profil> liste = (List<Profil>) st.addEntity(Profil.class).list();

		return liste;
	}

	@Override
	public Boolean verifimputText(ObjectSearch objectSearch) {
		String queryString = "select * from profil WHERE 1=1";
		if (objectSearch != null) {

			if (objectSearch.getCode() != null && !objectSearch.getCode().isEmpty()) {
				queryString = queryString + " AND COD_PROFIL ='" + objectSearch.getCode() + "'";
			}
			System.out.println(queryString);

			SQLQuery st = getSession().createSQLQuery(queryString);

			@SuppressWarnings("unchecked")
			List<Profil> liste = (List<Profil>) st.addEntity(Profil.class).list();
			if (!liste.isEmpty()) {

				return false;

			} else {
				return true;
			}
		} else {
			return false;
		}

	}

}
