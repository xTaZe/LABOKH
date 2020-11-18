package com.fr.adaming.jsfapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IRefPointDAO;
import com.fr.adaming.jsfapp.model.RefPoint;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
@Repository("refPointDAO")
public class RefPointDAO extends ManagerDao<RefPoint> implements IRefPointDAO {

}
