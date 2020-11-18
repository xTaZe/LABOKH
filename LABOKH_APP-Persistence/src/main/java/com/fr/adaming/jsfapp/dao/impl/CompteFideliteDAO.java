package com.fr.adaming.jsfapp.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.ICompteFideliteDAO;
import com.fr.adaming.jsfapp.dto.ObjectSearchClient;
import com.fr.adaming.jsfapp.model.CompteFidelite;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
@Repository("compteFideliteDAO")
public class CompteFideliteDAO extends ManagerDao<CompteFidelite> implements ICompteFideliteDAO {

	@Override
	public List<CompteFidelite> findByColumn(String columnName, Object value) {
		List<CompteFidelite> listDesComptes = null;
		if (columnName != null && !columnName.isEmpty() && value != null) {
			String queryString = "select * from compte_fidelite WHERE " + columnName + "='" + value + "'";
			SQLQuery st = getSession().createSQLQuery(queryString);
			@SuppressWarnings("unchecked")
			List<CompteFidelite> liste = (List<CompteFidelite>) st.addEntity(CompteFidelite.class).list();
			listDesComptes = liste;
		}
		if (listDesComptes != null && listDesComptes.size() > 0) {
			return listDesComptes;
		} else {
			return null;
		}
	}

	@Override
	public List<CompteFidelite> findCompteFideletieByEntreprise(String value) {
		String queryString = "select * from compte_fidelite WHERE 1=1";
		if (value != null && !value.isEmpty()) {
			queryString = queryString + " AND ENTREPRISE_1 like '" + value + "%'";
			SQLQuery st = getSession().createSQLQuery(queryString);

			@SuppressWarnings("unchecked")
			List<CompteFidelite> liste = (List<CompteFidelite>) st.addEntity(CompteFidelite.class).list();
			return liste;
		} else {
			return null;
		}
	}

	@Override
	public List<CompteFidelite> VerifyNumberOfAccountByMarque(String value, long marque) {
		String queryString = "select * from compte_fidelite WHERE 1=1";
		if (value != null && !value.isEmpty()) {
			queryString = queryString + " AND N_COMPT = '" + value + "'";
			if (marque > 0) {
				queryString = queryString + " AND ID_MARQUE = '" + marque + "'";
			}
			SQLQuery st = getSession().createSQLQuery(queryString);

			@SuppressWarnings("unchecked")
			List<CompteFidelite> liste = (List<CompteFidelite>) st.addEntity(CompteFidelite.class).list();
			return liste;
		} else {
			return null;
		}
	}

	@Override
	public List<CompteFidelite> findByCriterie(ObjectSearchClient searchClient) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String queryString = "select * from compte_fidelite WHERE 1=1";
		if (searchClient != null) {
			if (searchClient.getFlotte() != null && !searchClient.getFlotte().isEmpty()) {
				queryString = queryString + " AND ENTREPRISE_1 = '" + searchClient.getFlotte() + "'";
			}
			if (searchClient.getStartDate() != null || searchClient.getFinishDate() != null) {
				queryString = queryString
						+ " AND ID_CMPT_FEDILITE IN ( SELECT ID_CMPT_FEDILITE from mouvement_fid WHERE 1=1";
				if (searchClient.getStartDate() != null) {
					queryString = queryString + " AND DATE >= '" + df.format(searchClient.getStartDate())
							+ " 00:00:00'";

				}
				if (searchClient.getFinishDate() != null) {
					if (searchClient.getStartDate() != null) {
						if (searchClient.getStartDate().compareTo(searchClient.getFinishDate()) != 0) {
							queryString = queryString + " AND DATE <= '" + df.format(searchClient.getFinishDate())
									+ " 00:00:00'";
						}
					} else {
						queryString = queryString + " AND DATE <= '" + df.format(searchClient.getFinishDate())
								+ " 00:00:00'";
					}

				}

				queryString = queryString + " )";
			}

			SQLQuery st = getSession().createSQLQuery(queryString);
			@SuppressWarnings("unchecked")
			List<CompteFidelite> liste = (List<CompteFidelite>) st.addEntity(CompteFidelite.class).list();
			return liste;
		} else {
			return null;
		}
	}

}
