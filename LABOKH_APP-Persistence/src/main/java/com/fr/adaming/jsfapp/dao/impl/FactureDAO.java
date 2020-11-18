package com.fr.adaming.jsfapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IFactureDAO;
import com.fr.adaming.jsfapp.model.Facture;
import com.fr.adaming.jsfapp.model.ViewFactureDTO;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
@Repository("factureDAO")
public class FactureDAO extends ManagerDao<Facture> implements IFactureDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ViewFactureDTO> findAllViewFacture() {
		Criteria criteria = getSession().createCriteria(ViewFactureDTO.class);
		criteria.addOrder(Order.desc("idMouvement"));
		return criteria.list();
	}
}
