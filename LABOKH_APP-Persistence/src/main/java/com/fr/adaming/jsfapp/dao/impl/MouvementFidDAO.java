package com.fr.adaming.jsfapp.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IMouvementFidDAO;
import com.fr.adaming.jsfapp.model.MouvementFid;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */

@Repository("mouvementFidDAO")
public class MouvementFidDAO extends ManagerDao<MouvementFid> implements IMouvementFidDAO {

	@Override
	public List<MouvementFid> findListByComteFid(long idCompteFid) {
		if (idCompteFid > 0) {
			String queryString = "select * from mouvement_fid WHERE ID_CMPT_FEDILITE=" + idCompteFid
					+ " ORDER BY DATE DESC";
			SQLQuery st = getSession().createSQLQuery(queryString);

			@SuppressWarnings("unchecked")
			List<MouvementFid> liste = st.addEntity(MouvementFid.class).list();
			return liste;
		} else {
			return null;
		}
	}

	@Override
	public List<MouvementFid> findAllList() {

		String queryString = "select * from mouvement_fid  ORDER BY DATE DESC";
		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<MouvementFid> liste = st.addEntity(MouvementFid.class).list();
		return liste;

	}

	@Override
	public List<MouvementFid> findAllAttenteList() {
		String queryString = "SELECT *  FROM mouvement_fid  where STATUT= 0";
		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<MouvementFid> liste = st.addEntity(MouvementFid.class).list();
		return liste;
	}

	@Override
	public List<MouvementFid> findMouvementByCVC(String cVC) {
		String queryString = "SELECT *  FROM mouvement_fid  where CVC = '" + cVC + "'";
		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<MouvementFid> liste = st.addEntity(MouvementFid.class).list();
		return liste;
	}

	@Override
	public List<MouvementFid> findMouvementBynumOR(String numOR) {
		String queryString = "SELECT *  FROM mouvement_fid  where NUM_OR = '" + numOR + "'";
		SQLQuery st = getSession().createSQLQuery(queryString);

		@SuppressWarnings("unchecked")
		List<MouvementFid> liste = st.addEntity(MouvementFid.class).list();
		return liste;
	}

}
