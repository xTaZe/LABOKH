package com.fr.adaming.jsfapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IIntervaleDAO;
import com.fr.adaming.jsfapp.model.Intervale;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
@Repository("IntervaleDAO")
public class IntervaleDAO extends ManagerDao<Intervale> implements IIntervaleDAO {

}
