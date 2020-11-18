package com.fr.adaming.jsfapp.dto;

import java.util.Date;

public class ObjectSearchClient {
	private Date startDate;
	private Date finishDate;
	private String flotte;

	public ObjectSearchClient() {
		// TODO Auto-generated constructor stub
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getFlotte() {
		return flotte;
	}

	public void setFlotte(String flotte) {
		this.flotte = flotte;
	}
}
