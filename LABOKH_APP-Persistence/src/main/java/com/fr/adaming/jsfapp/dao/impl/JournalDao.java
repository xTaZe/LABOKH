package com.fr.adaming.jsfapp.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IJournalDao;
import com.fr.adaming.jsfapp.dto.ObjectSearchJournal;
import com.fr.adaming.jsfapp.model.Journal;

/**
 * 
 * @author Khaled BRAHIM
 *
 */
@Repository("journalDao")
public class JournalDao extends ManagerDao<Journal> implements IJournalDao {

	/**
	 * @param objectSearch
	 * @description lister tous les événements du journal via différents
	 *              critéres de recherches
	 * @return List<Journal>
	 * @see com.fr.adaming.jsfapp.dao.IJournalDao#findJournalByCriteria(ObjectSearchJournal,
	 *      Journal)
	 */
	@Override
	public List<Journal> findJournalByCriteria(ObjectSearchJournal objectSearch, Journal journal) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String queryString = "select * from journal WHERE 1=1";

		if (objectSearch != null) {

			if (objectSearch.getUtilisateur() != null) {
				if (objectSearch.getUtilisateur().getId() != null) {
					queryString = queryString + " AND ID_UTILISATEUR = " + objectSearch.getUtilisateur().getId();
				}
			}

			if (objectSearch.getDateDeb() != null) {
				queryString = queryString + " AND TIMEACTION > '" + dateFormat.format(objectSearch.getDateDeb()) + "'";
			}

			if (objectSearch.getDateFin() != null) {
				queryString = queryString + " AND TIMEACTION < '" + dateFormat.format(objectSearch.getDateFin()) + "'";
			}

			if (objectSearch.getAction() != null) {
				if (objectSearch.getAction() != null) {
					queryString = queryString + " AND ACTION LIKE '%" + objectSearch.getAction() + "%'";
				}
			}

		}
		queryString = queryString + " ORDER BY ID_LOG DESC";

		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<Journal> liste = (List<Journal>) st.addEntity(Journal.class).list();

		Session hibernateSession = this.getSession();

		Date date = new Date();
		journal.setActionDesc("Accès en lecture à la Table Journal");
		journal.setTimeaction(date);
		hibernateSession.merge(journal);
		hibernateSession.flush();

		return liste;
	}
}
