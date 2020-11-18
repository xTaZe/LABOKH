package com.fr.adaming.jsfapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.ISmsParametreDAO;
import com.fr.adaming.jsfapp.model.SmsParametre;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
@Repository("smsParametreDAO")
public class SmsParametreDAO extends ManagerDao<SmsParametre> implements ISmsParametreDAO {

}
