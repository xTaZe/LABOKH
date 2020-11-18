package com.fr.adaming.jsfapp.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IPackComptDAO;
import com.fr.adaming.jsfapp.model.PackCompt;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */

@Repository("packComptDAO")
public class PackComptDAO extends ManagerDao<PackCompt> implements IPackComptDAO {

	@Override
	public List<PackCompt> findActivePackCompte() {
		String queryString = "select * from pack_compt WHERE F_ACTIF = 'true'";
		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<PackCompt> liste = (List<PackCompt>) st.addEntity(PackCompt.class).list();
		return liste;
	}

}
