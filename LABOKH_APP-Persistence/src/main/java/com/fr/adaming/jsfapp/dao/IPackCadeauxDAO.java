package com.fr.adaming.jsfapp.dao;

import java.util.List;

import com.fr.adaming.jsfapp.model.PackCadeaux;
import com.fr.adaming.jsfapp.model.PackCompt;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
public interface IPackCadeauxDAO extends IManagerDao<PackCadeaux> {

	List<PackCadeaux> findPackCadeauDispoByPackCompte(PackCompt packCompt);

}
