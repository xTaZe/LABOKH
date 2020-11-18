package com.fr.adaming.jsfapp.dao;

import java.util.List;

import com.fr.adaming.jsfapp.dto.ObjectSearch;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.model.Sms;

public interface ISmsDAO extends IManagerDao<Sms> {

	public abstract List<Sms> findUtilByCriteria(ObjectSearch objectSearch, Journal journal);

}
