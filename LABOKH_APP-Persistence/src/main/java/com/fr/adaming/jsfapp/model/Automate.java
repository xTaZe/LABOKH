package com.fr.adaming.jsfapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fr.adaming.jsfapp.utils.IConstants;

@Entity
@Table(name = "AUTOMATE", catalog = IConstants.SCHEMA)
public class Automate {

	private static final long serialVersionUID = 8104474410712565713L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAutomate;

	@Column(name = "CODE_AUTOMATE")
	private String codeAutomate;
	@Column(name = "NOM_AUTOMATE")
	private String nomAutomate;
	@Column(name = "FLAG_ACTIF")
	private Boolean flagActif;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER")
	private Utilisateur utilisateur;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "automate")
	private Set<Reactif> reactifs = new HashSet<>();

	public Automate(long idAutomate, String codeAutomate, String nomAutomate, Boolean flagActif,
			Utilisateur utilisateur, Set<Reactif> reactifs) {
		super();
		this.idAutomate = idAutomate;
		this.codeAutomate = codeAutomate;
		this.nomAutomate = nomAutomate;
		this.flagActif = flagActif;
		this.utilisateur = utilisateur;
		this.reactifs = reactifs;
	}

	public Automate() {
	}

	public long getIdAutomate() {
		return idAutomate;
	}

	public void setIdAutomate(long idAutomate) {
		this.idAutomate = idAutomate;
	}

	public String getCodeAutomate() {
		return codeAutomate;
	}

	public void setCodeAutomate(String codeAutomate) {
		this.codeAutomate = codeAutomate;
	}

	public String getNomAutomate() {
		return nomAutomate;
	}

	public void setNomAutomate(String nomAutomate) {
		this.nomAutomate = nomAutomate;
	}

	public Boolean getFlagActif() {
		return flagActif;
	}

	public void setFlagActif(Boolean flagActif) {
		this.flagActif = flagActif;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
