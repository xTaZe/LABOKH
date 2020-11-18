package com.fr.adaming.jsfapp.dao;

import java.util.List;

import com.fr.adaming.jsfapp.dto.ObjectSearchClient;
import com.fr.adaming.jsfapp.model.CompteFidelite;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
public interface ICompteFideliteDAO extends IManagerDao<CompteFidelite> {

	List<CompteFidelite> findByColumn(String columnName, Object value);

	List<CompteFidelite> findCompteFideletieByEntreprise(String value);

	List<CompteFidelite> VerifyNumberOfAccountByMarque(String value, long marque);

	List<CompteFidelite> findByCriterie(ObjectSearchClient searchClient);
}
