package com.fr.adaming.jsfapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.adaming.jsfapp.utils.IConstants;

@Entity
@Table(name = "VIEW_FACTURE_MVT_USER", catalog = IConstants.SCHEMA)
@org.hibernate.annotations.Entity(dynamicUpdate = false)
public class ViewFactureDTO {

	private long idMouvement;
	private long idUser;
	private long idCompteFidelite;
	private Long montantFacture;
	private long idFacture;
	private String numFacture;
	private long prixFacture;
	private Date dateFacture;
	private String nom;
	private String prenom;
	private Date dateMvt;

	public ViewFactureDTO() {
	}

	@Id
	@Column(name = "ID_MOUVEMENT")
	public long getIdMouvement() {
		return idMouvement;
	}

	public void setIdMouvement(long idMouvement) {
		this.idMouvement = idMouvement;
	}

	@Column(name = "ID_USER")
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	@Column(name = "ID_CMPT_FEDILITE")
	public long getIdCompteFidelite() {
		return idCompteFidelite;
	}

	public void setIdCompteFidelite(long idCompteFidelite) {
		this.idCompteFidelite = idCompteFidelite;
	}

	@Column(name = "MONTANT_MOUVEMENT")
	public Long getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(Long montantFacture) {
		this.montantFacture = montantFacture;
	}

	@Column(name = "ID_FACTURE")
	public long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}

	@Column(name = "NUM_FACTURE")
	public String getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(String numFacture) {
		this.numFacture = numFacture;
	}

	@Column(name = "TOTAL_PRIX")
	public long getPrixFacture() {
		return prixFacture;
	}

	public void setPrixFacture(long prixFacture) {
		this.prixFacture = prixFacture;
	}

	@Column(name = "DATE_FACTURE")
	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	@Column(name = "NOM")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRENOM")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "DATEMVT")
	public Date getDateMvt() {
		return dateMvt;
	}

	public void setDateMvt(Date dateMvt) {
		this.dateMvt = dateMvt;
	}

}
