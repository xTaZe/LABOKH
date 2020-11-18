package com.fr.adaming.jsfapp.dao;

import java.util.List;

import com.fr.adaming.jsfapp.dto.ObjectSearchJournal;
import com.fr.adaming.jsfapp.model.Journal;

public interface IJournalDao extends IManagerDao<Journal> {
	/**
	 * 
	 * @param objectSearch
	 * @param journal
	 * @return List<Journal>
	 *
	 */
	List<Journal> findJournalByCriteria(ObjectSearchJournal objectSearch, Journal journal);

}
