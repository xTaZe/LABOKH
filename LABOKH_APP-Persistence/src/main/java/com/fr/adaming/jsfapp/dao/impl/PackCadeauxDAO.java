package com.fr.adaming.jsfapp.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IPackCadeauxDAO;
import com.fr.adaming.jsfapp.model.PackCadeaux;
import com.fr.adaming.jsfapp.model.PackCompt;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */

@Repository("packCadeauxDAO")
public class PackCadeauxDAO extends ManagerDao<PackCadeaux> implements IPackCadeauxDAO {

	@Override
	public List<PackCadeaux> findPackCadeauDispoByPackCompte(PackCompt packCompt) {

		String queryString = "SELECT * from pack_cadeaux  where "
				+ " CONVERT (date, DATE_ECHEANCE) >=  CONVERT (date, SYSDATETIME()) " + "AND QUANTITE > 0 "
				+ "AND F_ACTIF = 1 AND ID_PACK_COMPT = " + packCompt.getIdPackCompt();

		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<PackCadeaux> liste = st.addEntity(PackCadeaux.class).list();
		return liste;

	}

}
