package com.fr.adaming.jsfapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IAutomateDao;
import com.fr.adaming.jsfapp.model.Automate;

/**
 * @author mboumallouga
 */
@Repository("automateDAO")
public class AutomateDAO extends ManagerDao<Automate> implements IAutomateDao {

}
