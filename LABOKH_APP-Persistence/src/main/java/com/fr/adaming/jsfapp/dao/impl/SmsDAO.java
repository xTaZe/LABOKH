package com.fr.adaming.jsfapp.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.ISmsDAO;
import com.fr.adaming.jsfapp.dto.ObjectSearch;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Sms;

@Repository("smsDAO")
public class SmsDAO extends ManagerDao<Sms> implements ISmsDAO {

	@Override
	public List<Sms> findUtilByCriteria(ObjectSearch objectSearch, Journal journal) {
		String queryString = "select * from SMS WHERE 1=1";

		if (objectSearch != null) {
			if (objectSearch.getfActif() == 1) {
				queryString = queryString + " AND  F_ACTIF=1 ";
			}
			if (objectSearch.getfActif() == 0) {
				queryString = queryString + " AND  F_ACTIF= 0 ";
			}
		}

		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<Sms> liste = (List<Sms>) st.addEntity(Sms.class).list();

		return liste;
	}
}
