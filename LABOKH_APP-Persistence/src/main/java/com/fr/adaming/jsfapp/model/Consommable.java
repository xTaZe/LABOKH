package com.fr.adaming.jsfapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fr.adaming.jsfapp.utils.IConstants;

@Entity
@Table(name = "CONSOMMABLE", catalog = IConstants.SCHEMA)
public class Consommable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7243882769449440014L;
	@Id
	@Column(name = "ID_CONSOMMABLE", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReactif;

	@Column(name = "CODE_CONSOMMABLE")
	private String codeConsommable;

	@Column(name = "DESC_CONSOMMABLE")
	private String descConsommable;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_AUTOMATE")
	private Automate automate;

	public long getIdReactif() {
		return idReactif;
	}

	public void setIdReactif(long idReactif) {
		this.idReactif = idReactif;
	}

	public String getCodeConsommable() {
		return codeConsommable;
	}

	public void setCodeConsommable(String codeConsommable) {
		this.codeConsommable = codeConsommable;
	}

	public String getDescConsommable() {
		return descConsommable;
	}

	public void setDescConsommable(String descConsommable) {
		this.descConsommable = descConsommable;
	}

	public Automate getAutomate() {
		return automate;
	}

	public void setAutomate(Automate automate) {
		this.automate = automate;
	}

}
