package com.fr.adaming.jsfapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IMarqueDAO;
import com.fr.adaming.jsfapp.model.Marque;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */

@Repository("marqueDAO")
public class MarqueDAO extends ManagerDao<Marque> implements IMarqueDAO {

}
