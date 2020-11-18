package com.fr.adaming.jsfapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IParametreDAO;
import com.fr.adaming.jsfapp.model.Parametre;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
@Repository("ParametreDAO")
public class ParametreDAO extends ManagerDao<Parametre> implements IParametreDAO {

}
