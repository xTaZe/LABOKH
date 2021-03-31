package com.fr.adaming.jsfapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	@Column
	private String conditionnement;
	@Column
	private Date dateDePreemption;
	@Column
	private Date dateFinUtilisation;
	@Column
	private Date dateOuverture;
	@Column
	private Boolean isPartage;
	@Column
	private String nomLabo;
	@Column
	private long quantiteRecu;
	@Column
	private long quantiteAceder;
	@Lob
	@Column(name = "facture", columnDefinition = "BLOB")
	private byte[] facture;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_AUTOMATE")
	private Automate automate;

	public Reactif() {
	}

	public Reactif(long idReactif, String codeReactif, String descReactif, String conditionnement,
			Date dateDePreemption, Date dateFinUtilisation, Date dateOuverture, Boolean isPartage, String nomLabo,
			long quantiteRecu, long quantiteAceder, byte[] facture, Automate automate) {
		super();
		this.idReactif = idReactif;
		this.codeReactif = codeReactif;
		this.descReactif = descReactif;
		this.conditionnement = conditionnement;
		this.dateDePreemption = dateDePreemption;
		this.dateFinUtilisation = dateFinUtilisation;
		this.dateOuverture = dateOuverture;
		this.isPartage = isPartage;
		this.nomLabo = nomLabo;
		this.quantiteRecu = quantiteRecu;
		this.quantiteAceder = quantiteAceder;
		this.facture = facture;
		this.automate = automate;
	}

	public long getIdReactif() {
		return idReactif;
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

	public String getConditionnement() {
		return conditionnement;
	}

	public void setConditionnement(String conditionnement) {
		this.conditionnement = conditionnement;
	}

	public Date getDateDePreemption() {
		return dateDePreemption;
	}

	public void setDateDePreemption(Date dateDePreemption) {
		this.dateDePreemption = dateDePreemption;
	}

	public Date getDateFinUtilisation() {
		return dateFinUtilisation;
	}

	public void setDateFinUtilisation(Date dateFinUtilisation) {
		this.dateFinUtilisation = dateFinUtilisation;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Boolean getIsPartage() {
		return isPartage;
	}

	public void setIsPartage(Boolean isPartage) {
		this.isPartage = isPartage;
	}

	public String getNomLabo() {
		return nomLabo;
	}

	public void setNomLabo(String nomLabo) {
		this.nomLabo = nomLabo;
	}

	public long getQuantiteRecu() {
		return quantiteRecu;
	}

	public void setQuantiteRecu(long quantiteRecu) {
		this.quantiteRecu = quantiteRecu;
	}

	public long getQuantiteAceder() {
		return quantiteAceder;
	}

	public void setQuantiteAceder(long quantiteAceder) {
		this.quantiteAceder = quantiteAceder;
	}

	public byte[] getFacture() {
		return facture;
	}

	public void setFacture(byte[] facture) {
		this.facture = facture;
	}

	public Automate getAutomate() {
		return automate;
	}

	public void setAutomate(Automate automate) {
		this.automate = automate;
	}

}
