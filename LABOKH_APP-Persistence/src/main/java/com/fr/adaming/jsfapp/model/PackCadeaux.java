package com.fr.adaming.jsfapp.model;

// Generated 13 nov. 2015 10:42:14 by Hibernate Tools 4.0.0

import java.util.Date;
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

/**
 * PackCadeaux generated by hbm2java
 */
@Entity
@Table(name = "pack_cadeaux", catalog = IConstants.SCHEMA)
public class PackCadeaux implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 814964416091058740L;
	private long idPack;
	private PackCompt packCompt;
	// private String typePack;
	private String decription;
	private Long valeur;
	private Long quantite;
	private Date dateEcheance;
	private Boolean FActif;
	private String pathImg;
	private Set<MouvementFid> mouvementFids = new HashSet<MouvementFid>(0);

	public PackCadeaux() {
		// TODO Auto-generated constructor stub
	}

	public PackCadeaux(long idPack, PackCompt packCompt, String decription, Long valeur, Long quantite,
			Date dateEcheance, Boolean fActif, String pathImg, Set<MouvementFid> mouvementFids) {
		super();
		this.idPack = idPack;
		this.packCompt = packCompt;
		this.decription = decription;
		this.valeur = valeur;
		this.quantite = quantite;
		this.dateEcheance = dateEcheance;
		FActif = fActif;
		this.pathImg = pathImg;
		this.mouvementFids = mouvementFids;
	}

	@Id
	@Column(name = "ID_PACK", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdPack() {
		return this.idPack;
	}

	public void setIdPack(long idPack) {
		this.idPack = idPack;
	}

	// @Column(name = "TYPE_PACK", length = 55)
	// public String getTypePack() {
	// return this.typePack;
	// }
	//
	// public void setTypePack(String typePack) {
	// this.typePack = typePack;
	// }

	@Column(name = "DECRIPTION", length = 254)
	public String getDecription() {
		return this.decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	@Column(name = "VALEUR", precision = 18, scale = 0)
	public Long getValeur() {
		return this.valeur;
	}

	public void setValeur(Long valeur) {
		this.valeur = valeur;
	}

	@Column(name = "F_ACTIF")
	public Boolean getFActif() {
		return this.FActif;
	}

	public void setFActif(Boolean FActif) {
		this.FActif = FActif;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "packCadeaux")
	public Set<MouvementFid> getMouvementFids() {
		return this.mouvementFids;
	}

	public void setMouvementFids(Set<MouvementFid> mouvementFids) {
		this.mouvementFids = mouvementFids;
	}

	@Column(name = "PATH_IMG")
	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	@Column(name = "QUANTITE", precision = 18, scale = 0)
	public Long getQuantite() {
		return quantite;
	}

	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}

	@Column(name = "DATE_ECHEANCE")
	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PACK_COMPT")
	public PackCompt getPackCompt() {
		return this.packCompt;
	}

	public void setPackCompt(PackCompt packCompt) {
		this.packCompt = packCompt;
	}

}