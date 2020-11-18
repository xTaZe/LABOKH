package com.fr.adaming.jsfapp.controller.backingBean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fr.adaming.jsfapp.controller.SuperFacade;
import com.fr.adaming.jsfapp.model.Journal;
import com.fr.adaming.jsfapp.util.IBean;

@ManagedBean
@Controller("journalBean")
@Scope("session")
public class JournalBean extends SuperFacade implements IBean {

	private Journal journal;
	private List<Journal> journals;

	@Override
	public String init() {

		Collections.sort(journals, new Comparator<Journal>() {
			public int compare(Journal o1, Journal o2) {
				return o1.getTimeaction().compareTo(o2.getTimeaction());
			}
		});
		Collections.reverse(journals);
		// TODO Auto-generated method stub
		return "toJournalIndex";
	}

	@Override
	public String nouveauEnregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editEnregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String detailsEnregistrement() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEnregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rechercher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveEnregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public List<Journal> getJournals() {
		return journals;
	}

	public void setJournals(List<Journal> journals) {
		this.journals = journals;
	}

}
