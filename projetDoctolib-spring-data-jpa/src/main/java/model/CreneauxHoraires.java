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

@Entity
@Table(name = "creneauxHoraires")
public class CreneauxHoraires {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public RendezVous getRendezVous() {
		return rendezVous;
	}

	public void setRendezvous(RendezVous rendezVous) {
		this.rendezVous = rendezVous;
	}

	@Override
	public String toString() {
		return "CreneauxHoraires [id=" + id + ", dtDebut=" + dtDebut + ", lieux=" + lieux + "]";
	}
	
	
}

