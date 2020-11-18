package com.fr.adaming.jsfapp.dto;

public class ObjectSearch {
	private String code;
	private String designation;
	private int fActif;
	private int fAdmin;
	private int fResp;
	private int fBio;
	private int idUser;

	public ObjectSearch() {
		fActif = 2;
		fAdmin = 2;
		fResp = 2;
		fBio = 2;
	}

	public int getfResp() {
		return fResp;
	}

	public void setfResp(int fResp) {
		this.fResp = fResp;
	}

	public int getfBio() {
		return fBio;
	}

	public void setfBio(int fBio) {
		this.fBio = fBio;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getfActif() {
		return fActif;
	}

	public void setfActif(int fActif) {
		this.fActif = fActif;
	}

	public int getfAdmin() {
		return fAdmin;
	}

	public void setfAdmin(int fAdmin) {
		this.fAdmin = fAdmin;
	}

	public int getfCondidat() {
		return fResp;
	}

	public void setfCondidat(int fCondidat) {
		this.fResp = fCondidat;
	}

	public int getfRecruteur() {
		return fBio;
	}

	public void setfRecruteur(int fRecruteur) {
		this.fBio = fRecruteur;
	}

}
