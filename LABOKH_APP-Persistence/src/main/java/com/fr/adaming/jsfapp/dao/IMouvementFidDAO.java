package com.fr.adaming.jsfapp.dao;

import java.util.List;

import com.fr.adaming.jsfapp.model.MouvementFid;

/**
 * @author mboumallouga
 * @date 9 nov. 2015
 */
public interface IMouvementFidDAO extends IManagerDao<MouvementFid> {

	public List<MouvementFid> findListByComteFid(long idCompteFid);

	List<MouvementFid> findAllList();

	List<MouvementFid> findAllAttenteList();

	List<MouvementFid> findMouvementByCVC(String cVC);

	List<MouvementFid> findMouvementBynumOR(String numOR);
}
