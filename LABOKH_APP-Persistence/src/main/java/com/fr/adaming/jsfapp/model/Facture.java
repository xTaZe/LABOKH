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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fr.adaming.jsfapp.utils.IConstants;

/**
 * Facture generated by hbm2java
 */
@Entity
@Table(name = "facture", catalog = IConstants.SCHEMA)
public class Facture implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1001309860387774821L;
	private long idFacture;
	private MouvementFid mouvementFid;
	private String numFacture;
	private Date dateFacture;
	private Long totalPrix;
	private Boolean FActif;
	private Set<MouvementFid> mouvementFids = new HashSet<MouvementFid>(0);

	public Facture() {
	}

	public Facture(long idFacture, MouvementFid mouvementFid) {
		this.idFacture = idFacture;
		this.mouvementFid = mouvementFid;
	}

	public Facture(long idFacture, MouvementFid mouvementFid, String numFacture, Date dateFacture, Long totalPrix,
			Boolean FActif, Set<MouvementFid> mouvementFids) {
		this.idFacture = idFacture;
		this.mouvementFid = mouvementFid;
		this.numFacture = numFacture;
		this.dateFacture = dateFacture;
		this.totalPrix = totalPrix;
		this.FActif = FActif;
		this.mouvementFids = mouvementFids;
	}

	@Id
	@Column(name = "ID_FACTURE", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MOUVEMENT", nullable = true)
	public MouvementFid getMouvementFid() {
		return this.mouvementFid;
	}

	public void setMouvementFid(MouvementFid mouvementFid) {
		this.mouvementFid = mouvementFid;
	}

	@Column(name = "NUM_FACTURE", length = 55)
	public String getNumFacture() {
		return this.numFacture;
	}

	public void setNumFacture(String numFacture) {
		this.numFacture = numFacture;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_FACTURE", length = 10)
	public Date getDateFacture() {
		return this.dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	@Column(name = "TOTAL_PRIX", precision = 18, scale = 0)
	public Long getTotalPrix() {
		return this.totalPrix;
	}

	public void setTotalPrix(Long totalPrix) {
		this.totalPrix = totalPrix;
	}

	@Column(name = "F_ACTIF")
	public Boolean getFActif() {
		return this.FActif;
	}

	public void setFActif(Boolean FActif) {
		this.FActif = FActif;
	}

	@Override
	public String toString() {
		return "Facture [numFacture=" + numFacture + ", dateFacture=" + dateFacture + ", totalPrix=" + totalPrix + "]";
	}

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "facture")
	// public Set<MouvementFid> getMouvementFids() {
	// return this.mouvementFids;
	// }
	//
	// public void setMouvementFids(Set<MouvementFid> mouvementFids) {
	// this.mouvementFids = mouvementFids;
	// }

}