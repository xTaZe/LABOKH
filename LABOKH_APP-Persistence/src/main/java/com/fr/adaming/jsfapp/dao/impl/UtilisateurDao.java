package com.fr.adaming.jsfapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IUtilisateurDao;
import com.fr.adaming.jsfapp.dto.ObjectSearchUtilisateur;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Utilisateur;

@Repository("utilisateurDao")
public class UtilisateurDao extends ManagerDao<Utilisateur> implements IUtilisateurDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findUtilByCriteria(ObjectSearchUtilisateur os, Journal journal) {

		Criteria criteria = getSession().createCriteria(Utilisateur.class);

		if (os != null) {
			if (os.getCin() != null)
				criteria.add(Restrictions.eq("cin", os.getCin()));
			if (os.getNom() != null && !os.getNom().isEmpty())
				criteria.add(Restrictions.like("nom", os.getNom(), MatchMode.ANYWHERE).ignoreCase());
			if (os.getPrenom() != null && !os.getPrenom().isEmpty())
				criteria.add(Restrictions.like("prenom", os.getPrenom(), MatchMode.ANYWHERE).ignoreCase());
			if (os.getToken() != null)
				criteria.add(Restrictions.eq("token", os.getToken()));
		}
		criteria.addOrder(Order.asc(os.getNom()));
		return criteria.list();

	}

	@Override
	public Utilisateur findbyLoginPass(String login, String passw) {
		Criteria criteria = getSession().createCriteria(Utilisateur.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", passw));
		return (Utilisateur) criteria.uniqueResult();
	}

	@Override
	public Utilisateur findByLogin(String login) {
		Criteria criteria = getSession().createCriteria(Utilisateur.class);
		criteria.add(Restrictions.eq("login", login));
		return (Utilisateur) criteria.uniqueResult();
	}

	@Override
	public Utilisateur findUtilisateurById(long identifiant, Journal journal) {
		String queryString = "select us.* from utilisateur us where us.ID_UTILISATEUR= " + identifiant;

		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<Utilisateur> liste = (List<Utilisateur>) st.addEntity(Utilisateur.class).list();

		if (liste.size() != 0) {
			return liste.get(0);
		}
		return null;
	}

	@Override
	public List<Utilisateur> findUtilisateurByProfil(Long id) {

		String queryString = "SELECT * FROM utilisateur WHERE ID_PROFIL =" + id + " ;";

		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<Utilisateur> liste = (List<Utilisateur>) st.addEntity(Utilisateur.class).list();

		return liste;
	}

	@Override
	public Boolean verifimputText(ObjectSearchUtilisateur objectSearch) {
		String queryString = "select * from utilisateur WHERE 1=1";
		if (objectSearch != null) {

			if (objectSearch.getLogin() != null && !objectSearch.getLogin().isEmpty()) {
				queryString = queryString + " AND LOGIN = '" + objectSearch.getLogin() + "'";

			}
			if (objectSearch.getCin() != null && !objectSearch.getCin().isEmpty()) {
				queryString = queryString + " AND CIN = '" + objectSearch.getCin() + "'";

			}
			if (objectSearch.getMail() != null && !objectSearch.getMail().isEmpty()) {
				queryString = queryString + " AND EMAIL  = '" + objectSearch.getMail() + "'";

			}

			System.out.println(queryString);
			SQLQuery st = getSession().createSQLQuery(queryString);
			@SuppressWarnings("unchecked")
			List<Utilisateur> list = (List<Utilisateur>) st.addEntity(Utilisateur.class).list();

			if (!list.isEmpty()) {

				return false;

			} else {
				return true;
			}
		} else {
			return false;
		}

	}

	@Override
	public List<Utilisateur> findUtilisateToken(String Token) {

		String queryString = "SELECT *  FROM utilisateur WHERE TOKEN ='" + Token + "'";
		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<Utilisateur> liste = (List<Utilisateur>) st.addEntity(Utilisateur.class).list();

		return liste;
	}

}
