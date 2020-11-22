package com.fr.adaming.jsfapp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.fr.adaming.dao.tools.HibernateUtil;
import com.fr.adaming.jsfapp.dao.IManagerDao;

/**
 * 
 *
 */
@Repository("managerDao")
public class ManagerDao<T> extends HibernateUtil implements IManagerDao<T> {

	/**
	 * cette méthode consiste à supprimer les enregistrements d'une table en
	 * respectant la condition entrée en paramètre
	 * 
	 * @param tableName
	 *            la table
	 * @param iDName
	 *            la propriété à vérifier
	 * @param idValue
	 *            la valeur que doit prendre la propriété
	 * @param journal
	 *            le journal
	 */
	public void deleteFrom(String tableName, String iDName, Long idValue) {

		Session hibernateSession = this.getSession();
		SQLQuery st = getSession().createSQLQuery("DELETE FROM " + tableName + " where " + iDName + " = " + idValue);
		st.executeUpdate();
		hibernateSession.flush();

	}

	/**
	 * cette méthode consiste à supprimer les enregistrement d'une table en
	 * respectant les deux conditions entrées en paramètre
	 * 
	 * @param tableName
	 *            la table
	 * @param pk1
	 *            la première propriété à vérifier
	 * @param valuePk1
	 *            la valeur que doit prendre la première propriété
	 * @param pk2
	 *            la deuxième propriété à vérifier
	 * @param valuePk2
	 *            la valeur que doit prendre la deuxième propriété
	 * @param journal
	 *            le journal
	 */
	public void deleteFromComposedPK(String tableName, String pk1, Long valuePk1, String pk2, Long valuePk2) {
		Session hibernateSession = this.getSession();
		SQLQuery st = getSession().createSQLQuery(
				"DELETE FROM " + tableName + " where " + pk1 + " = " + valuePk1 + " and " + pk2 + " = " + valuePk2);
		st.executeUpdate();
		hibernateSession.flush();

	}

	/**
	 * cette méthode permet de créer l'objet passé en paramètre
	 * 
	 * @param o
	 *            l'objet à créer
	 * @param journal
	 *            le journal
	 * @return retourner l'objet créé
	 */
	@SuppressWarnings("unchecked")
	public T save(Object entity) {
		Session hibernateSession = this.getSession();
		T newEntity = (T) hibernateSession.merge(entity);
		hibernateSession.flush();
		return newEntity;
	}

	/**
	 * cette méthode consiste à créer ou modifier une entité
	 * 
	 * @param entity
	 *            l'entité
	 * @param journal
	 *            le journal
	 * @return retourner l'entité créée ou modifiée
	 */
	@SuppressWarnings("unchecked")
	public T saveOrUpdate(T entity) {
		Session hibernateSession = this.getSession();
		T newEntity = (T) hibernateSession.merge(entity);
		hibernateSession.flush();

		return newEntity;
	}

	public void persist(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.persist(entity);
		hibernateSession.flush();

	}

	/**
	 * cette méthode consiste à supprimer une entité
	 * 
	 * @param entity
	 *            l'entité
	 * @param journal
	 *            le journal
	 */
	public void delete(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.delete(entity);
		hibernateSession.flush();

	}

	/**
	 * cette méthode consiste à récupérer une liste d'enregistrement d'une
	 * entité à partir d'une requete SQL
	 * 
	 * @param query
	 *            la requete
	 * @param journal
	 *            le journa
	 * @return retourner la liste d'enregistrement d'une entité à partir de la
	 *         requete entrée
	 */
	@SuppressWarnings("unchecked")
	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>) query.list();
		return t;
	}

	/**
	 * cette méthode consiste à récupérer une entité à partir d'une requete SQL
	 * 
	 * @param query
	 *            la requete
	 * @param journal
	 *            le journal
	 * @return retourner l'entité récupérée à partir de la requete entrée
	 */
	@SuppressWarnings("unchecked")
	public T findOne(String stringQuery) {
		Query query = getSession().createSQLQuery(stringQuery);
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

	/**
	 * cette méthode consiste à récupérer une entité à partir de son identifiant
	 * 
	 * @param clazz
	 *            l'entité classe
	 * @param id
	 *            l'identifiant de l'entité
	 * @param journal
	 *            le journal
	 * @return retourner l'entité récupérée à patir de son identifiant
	 */
	@SuppressWarnings("unchecked")
	public T findByID(Class<?> clazz, Long id) {
		Session hibernateSession = this.getSession();
		T t = null;
		t = (T) hibernateSession.get(clazz, id);
		return t;
	}

	/**
	 * cette méthode consiste à récupérer tous les enregistrements de l'entité
	 * passée en paramètre
	 * 
	 * @param clazz
	 *            l'entité classe
	 * @param journal
	 *            le journal
	 * @return retourner la liste de tous les enregistrements de l'entité passée
	 *         en paramètre
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<?> clazz) {
		Session hibernateSession = this.getSession();
		List<T> t = null;
		Query query = hibernateSession.createQuery("from " + clazz.getName());
		t = query.list();
		return t;
	}

	/**
	 * cette méthode consiste à récupérer une entité à patir de la propriété et
	 * la valeur passées en paramètre
	 * 
	 * @param clazz
	 *            l'entité
	 * @param proprety
	 *            la propriété à vérifier
	 * @param value
	 *            la valeur que doit prendre la propriété
	 * @return retourner l'entité récupérée
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T getEntityByProprety(Class<?> clazz, String proprety, String value) {

		Session hibernateSession = this.getSession();
		Query query = hibernateSession.createQuery(
				"from " + clazz.getName() + " where lower(" + proprety + ")='" + value.toLowerCase() + "'");
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

}
