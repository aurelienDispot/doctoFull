package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "creneauxHoraires")
public class CreneauxHoraires {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "dtDebut")
	private Date dtDebut;
	@OneToMany(mappedBy = "creneauxHoraires")
	private List<Lieux> lieux = new ArrayList<Lieux>();
	@ManyToOne
	@JoinColumn(name = "rendezVous_id")
	private RendezVous rendezvous;
	@OneToMany(mappedBy = "creneauxHoraires")
	private List<Praticien> practicien = new ArrayList<Praticien>();
	
	public CreneauxHoraires(Long id, Date dtDebut, List<Lieux> lieux, RendezVous rendezvous,
			List<Praticien> practicien) {
		super();
		this.id = id;
		this.dtDebut = dtDebut;
		this.lieux = lieux;
		this.rendezvous = rendezvous;
		this.practicien = practicien;
	}

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

	public List<Lieux> getLieux() {
		return lieux;
	}

	public void setLieux(List<Lieux> lieux) {
		this.lieux = lieux;
	}

	public RendezVous getRendezvous() {
		return rendezvous;
	}

	public void setRendezvous(RendezVous rendezvous) {
		this.rendezvous = rendezvous;
	}

	public List<Praticien> getPracticien() {
		return practicien;
	}

	public void setPracticien(List<Praticien> practicien) {
		this.practicien = practicien;
	}

	@Override
	public String toString() {
		return "CreneauxHoraires [id=" + id + ", dtDebut=" + dtDebut + ", lieux=" + lieux + "]";
	}
	
	
}
