package com.fr.adaming.jsfapp.dao;

import java.util.List;

import org.hibernate.Query;

public interface IManagerDao<T> {

	/**
	 * cette méthode consiste à créer ou modifier une entité
	 * 
	 * @param entity
	 *            l'entité
	 * @param journal
	 *            le journal
	 * @return retourner l'entité créée ou modifiée
	 */
	T saveOrUpdate(T entity);

	void persist(T entity);

	/**
	 * cette méthode consiste à supprimer une entité
	 * 
	 * @param entity
	 *            l'entité
	 * @param journal
	 *            le journal
	 */
	void delete(T entity);

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
	List<T> findMany(Query query);

	/**
	 * cette méthode consiste à récupérer une entité à partir d'une requete SQL
	 * 
	 * @param query
	 *            la requete
	 * @param journal
	 *            le journal
	 * @return retourner l'entité récupérée à partir de la requete entrée
	 */
	T findOne(String stringQuery);

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
	T findByID(Class<?> clazz, Long id);

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
	List<T> findAll(Class<?> clazz);

	/**
	 * cette méthode permet de créer l'objet passé en paramètre
	 * 
	 * @param o
	 *            l'objet à créer
	 * @param journal
	 *            le journal
	 * @return retourner l'objet créé
	 */
	T save(Object o);

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
	void deleteFrom(String tableName, String iDName, Long idValue);

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
	void deleteFromComposedPK(String tableName, String pk1, Long valuePk1, String pk2, Long valuePk2);

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
	T getEntityByProprety(Class<?> clazz, String proprety, String value);

}
