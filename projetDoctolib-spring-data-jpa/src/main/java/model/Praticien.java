package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("praticien")
public class Praticien extends Personne {
	@Column(name="dureeDefault")
	private int dureeDefault;
	
	@OneToMany(mappedBy="praticien")
	private List<Praticien> praticiens = new ArrayList<Praticien>();

//	@OneToMany(mappedBy="creneauxHoraires")
//	private List<CreneauxHoraires> creneauxHorairess = new ArrayList<CreneauxHoraires>();
//	
//	@OneToMany(mappedBy="rendezVous")
//	private List<RendezVous> rendezVouss = new ArrayList<RendezVous>();
//	
//	@OneToMany(mappedBy="motifConsultation")
//	private List<MotifConsultation> motifConsultations = new ArrayList<MotifConsultation>();

	public Praticien() {
		super();
	}

//	public Praticien(int dureeDefault, List<Praticien> praticiens, CrenauxHoraires creneauxHoraires,
//			RendezVous rendezVous, List<MotifConsultation> motifConsultations) {
//		super();
//		this.dureeDefault = dureeDefault;
//		this.praticiens = praticiens;
//		this.creneauxHoraires = creneauxHoraires;
//		this.rendezVous = rendezVous;
//		this.motifConsultations = motifConsultations;
//	}

	public int getDureeDefault() {
		return dureeDefault;
	}

	public void setDureeDefault(int dureeDefault) {
		this.dureeDefault = dureeDefault;
	}

	public List<Praticien> getPraticiens() {
		return praticiens;
	}

	public void setPraticiens(List<Praticien> praticiens) {
		this.praticiens = praticiens;
	}
//
//	public CrenauxHoraires getCreneauxHoraires() {
//		return creneauxHoraires;
//	}
//
//	public void setCreneauxHoraires(CrenauxHoraires creneauxHoraires) {
//		this.creneauxHoraires = creneauxHoraires;
//	}
//
//	public RendezVous getRendezVous() {
//		return rendezVous;
//	}
//
//	public void setRendezVous(RendezVous rendezVous) {
//		this.rendezVous = rendezVous;
//	}
//
//	public List<MotifConsultation> getMotifConsultations() {
//		return motifConsultations;
//	}
//
//	public void setMotifConsultations(List<MotifConsultation> motifConsultations) {
//		this.motifConsultations = motifConsultations;
//	}

	
	
	
	

}
