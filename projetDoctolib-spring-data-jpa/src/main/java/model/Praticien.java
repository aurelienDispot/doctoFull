package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("praticien")
public class Praticien extends Personne {
	@Column(name="dureeDefault")
	private int dureeDefault;
	
	@OneToMany(mappedBy="praticien")
	private List<PraticienSpecialite> praticienSpecialite = new ArrayList<PraticienSpecialite>();

	@OneToMany(mappedBy = "praticien")
	private List<CreneauxHoraires> creneauxHoraires = new ArrayList<CreneauxHoraires>();
	
	@OneToMany(mappedBy = "praticien")
	private List<RendezVous> rendezVous = new ArrayList<RendezVous>();

	@OneToMany(mappedBy="praticien")
	private List<MotifConsultation> motifConsultations = new ArrayList<MotifConsultation>();

	public Praticien() {
		super();
	}

	public Praticien(int dureeDefault, List<PraticienSpecialite> praticienSpecialite,
			List<CreneauxHoraires> creneauxHoraires, List<RendezVous> rendezVous,
			List<MotifConsultation> motifConsultations) {
		super();
		this.dureeDefault = dureeDefault;
		this.praticienSpecialite = praticienSpecialite;
		this.creneauxHoraires = creneauxHoraires;
		this.rendezVous = rendezVous;
		this.motifConsultations = motifConsultations;
	}

	public int getDureeDefault() {
		return dureeDefault;
	}

	public void setDureeDefault(int dureeDefault) {
		this.dureeDefault = dureeDefault;
	}

	public List<PraticienSpecialite> getPraticienSpecialite() {
		return praticienSpecialite;
	}

	public void setPraticienSpecialite(List<PraticienSpecialite> praticienSpecialite) {
		this.praticienSpecialite = praticienSpecialite;
	}

	public List<CreneauxHoraires> getCreneauxHoraires() {
		return creneauxHoraires;
	}

	public void setCreneauxHoraires(List<CreneauxHoraires> creneauxHoraires) {
		this.creneauxHoraires = creneauxHoraires;
	}

	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	public List<MotifConsultation> getMotifConsultations() {
		return motifConsultations;
	}

	public void setMotifConsultations(List<MotifConsultation> motifConsultations) {
		this.motifConsultations = motifConsultations;
	}

	@Override
	public String toString() {
		return "Praticien [dureeDefault=" + dureeDefault + ", praticienSpecialite=" + praticienSpecialite
				+ ", creneauxHoraires=" + creneauxHoraires + ", rendezVous=" + rendezVous + ", motifConsultations="
				+ motifConsultations + "]";
	}
	
}
