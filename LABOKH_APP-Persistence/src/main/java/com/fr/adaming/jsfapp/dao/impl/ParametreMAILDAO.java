package com.fr.adaming.jsfapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IParametreMAILDAO;
import com.fr.adaming.jsfapp.model.ParametreMail;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
@Repository("parametreMAILDAO")
public class ParametreMAILDAO extends ManagerDao<ParametreMail> implements IParametreMAILDAO {

}
