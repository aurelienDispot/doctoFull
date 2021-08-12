package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;



public class PraticienSpecialite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name="specialite_id")
	private Specialite specialite;
	@ManyToOne
	@JoinColumn(name="praticien_id")
	private Praticien praticien;
	
	public PraticienSpecialite(Long id, int version, Specialite specialite, Praticien praticien) {
		super();
		this.id = id;
		this.version = version;
		this.specialite = specialite;
		this.praticien = praticien;
	}

	public PraticienSpecialite() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	@Override
	public String toString() {
		return "PraticienSpecialite [id=" + id + ", version=" + version + ", specialite=" + specialite + ", praticien="
				+ praticien + "]";
	}
	
	
	
	
	
	
	

	
	

}
