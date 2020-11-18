package com.fr.adaming.jsfapp.model;

// Generated 13 nov. 2015 10:42:14 by Hibernate Tools 4.0.0

import java.util.Date;

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
 * Sms generated by hbm2java
 */
@Entity
@Table(name = "SMS", catalog = IConstants.SCHEMA)
public class Sms implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 818136346355117439L;
	private long idSms;
	private CompteFidelite compteFidelite;
	private String message;
	private boolean FActif;
	private Date dateEnvoi;

	public Sms() {
	}

	public Sms(long idSms, CompteFidelite compteFidelite, String message, boolean FActif) {
		this.idSms = idSms;
		this.compteFidelite = compteFidelite;
		this.message = message;
		this.FActif = FActif;
	}

	public Sms(long idSms, CompteFidelite compteFidelite, String message, boolean FActif, Date dateEnvoi) {
		this.idSms = idSms;
		this.compteFidelite = compteFidelite;
		this.message = message;
		this.FActif = FActif;
		this.dateEnvoi = dateEnvoi;
	}

	@Id
	@Column(name = "ID_SMS", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdSms() {
		return this.idSms;
	}

	public void setIdSms(long idSms) {
		this.idSms = idSms;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CMPT_FEDILITE", nullable = false)
	public CompteFidelite getCompteFidelite() {
		return this.compteFidelite;
	}

	public void setCompteFidelite(CompteFidelite compteFidelite) {
		this.compteFidelite = compteFidelite;
	}

	@Column(name = "MESSAGE", nullable = false, length = 150)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "F_ACTIF", nullable = false)
	public boolean isFActif() {
		return this.FActif;
	}

	public void setFActif(boolean FActif) {
		this.FActif = FActif;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ENVOI", length = 10)
	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

}