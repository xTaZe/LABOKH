package com.fr.adaming.jsfapp.services;

import java.util.List;

import org.hibernate.Query;

public interface IManagerService<T> {

	/**
	 * cette méthode consiste à créer ou modifier une entité
	 * 
	 * @param entity
	 *            l'entité
	 * @param journal
	 *            le journal
	 * @return retourner l'entité créée ou modifiée
	 */
	T saveOrUpdateService(T entity);

	/**
	 * cette méthode consiste à supprimer une entité
	 * 
	 * @param entity
	 *            l'entité
	 * @param journal
	 *            le journal
	 */
	void deleteService(T entity);

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
	T findByIDService(Class<?> clazz, Long id);

	/**
	 * cette méthode consiste à récupérer une entité à partir d'une requete SQL
	 * 
	 * @param query
	 *            la requete
	 * @param journal
	 *            le journal
	 * @return retourner l'entité récupérée à partir de la requete entrée
	 */
	T findOneService(String query);

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
	List<T> findManyService(Query query);

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

	void persist(T entity);

}
