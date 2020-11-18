package com.fr.adaming.jsfapp.dao;

import java.util.List;

import com.fr.adaming.jsfapp.model.Facture;
import com.fr.adaming.jsfapp.model.ViewFactureDTO;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
public interface IFactureDAO extends IManagerDao<Facture> {

	List<ViewFactureDTO> findAllViewFacture();

}
