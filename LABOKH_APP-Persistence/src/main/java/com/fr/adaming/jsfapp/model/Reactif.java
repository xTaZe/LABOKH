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
@Table(name = "REACTIF", catalog = IConstants.SCHEMA)
public class Reactif implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7243882769449440014L;
	@Id
	@Column(name = "ID_REACTIF", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReactif;
	@Column(name = "CODE_REACTIF")
	private String codeReactif;
	@Column(name = "DESC_REACTIF")
	private String descReactif;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_AUTOMATE")
	private Automate automate;

	public long getIdReactif() {
		return idReactif;
	}

	public Reactif() {
	}

	public Reactif(long idReactif, String codeReactif, String descReactif) {
		super();
		this.idReactif = idReactif;
		this.codeReactif = codeReactif;
		this.descReactif = descReactif;
	}

	public void setIdReactif(long idReactif) {
		this.idReactif = idReactif;
	}

	public String getCodeReactif() {
		return codeReactif;
	}

	public void setCodeReactif(String codeReactif) {
		this.codeReactif = codeReactif;
	}

	public String getDescReactif() {
		return descReactif;
	}

	public void setDescReactif(String descReactif) {
		this.descReactif = descReactif;
	}

	public Automate getAutomate() {
		return automate;
	}

	public void setAutomate(Automate automate) {
		this.automate = automate;
	}

}
