package com.fr.adaming.jsfapp.dto;

import java.io.Serializable;

public class UtilBeanUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6829199795285655223L;
	private Long id;
	private String des;
	private String code;
	private String adresse;
	private Integer qteRest;
	private float prix;

	public UtilBeanUI() {
	}

	public UtilBeanUI(Long id, String des, String code) {
		this.id = id;
		if (des != null) {
			this.des = des.trim();
		} else {
			this.des = des;
		}
		this.code = code;
	}

	public UtilBeanUI(Long id, String des, String code, boolean bool) {
		this.id = id;
		this.des = des.trim().replaceAll("^([\\W]+)<", "<");
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((des == null) ? 0 : des.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(prix);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtilBeanUI other = (UtilBeanUI) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (des == null) {
			if (other.des != null)
				return false;
		} else if (!des.equals(other.des))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		return true;
	}

	public Integer getQteRest() {
		return qteRest;
	}

	public void setQteRest(Integer qteRest) {
		this.qteRest = qteRest;
	}

}
