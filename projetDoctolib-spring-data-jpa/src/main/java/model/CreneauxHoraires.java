package model;

import java.util.Date;



import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "creneauxHoraires")
public class CreneauxHoraires {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name = "dtDebut")
	private Date dtDebut;
	@ManyToOne
	@JoinColumn(name = "lieux_id")
	private Lieux lieux;
	@ManyToOne
	@JoinColumn(name = "rendezVous_id")
	private RendezVous rendezVous;
	@ManyToOne
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;

	public CreneauxHoraires() {
		super();
	}
	
	

	public CreneauxHoraires(Long id, Date dtDebut, Lieux lieux, Praticien praticien) {
		super();
		this.dtDebut = dtDebut;
		this.lieux = lieux;
		this.praticien = praticien;
	}



	public CreneauxHoraires(Long id, int version, Date dtDebut, Lieux lieux, RendezVous rendezVous,
			Praticien praticien) {
		super();
		this.id = id;
		this.version = version;
		this.dtDebut = dtDebut;
		this.lieux = lieux;
		this.rendezVous = rendezVous;
		this.praticien = praticien;
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



	public Date getDtDebut() {
		return dtDebut;
	}



	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}



	public Lieux getLieux() {
		return lieux;
	}



	public void setLieux(Lieux lieux) {
		this.lieux = lieux;
	}



	public RendezVous getRendezVous() {
		return rendezVous;
	}



	public void setRendezVous(RendezVous rendezVous) {
		this.rendezVous = rendezVous;
	}



	public Praticien getPraticien() {
		return praticien;
	}



	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	



	


	


}




