package spring.boot.doctolib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@DiscriminatorValue("praticien")
public class Praticien extends Personne {
	@Column(name="dureeDefault")
	@JsonView(Views.ViewCommon.class)
	private int dureeDefault;
	
	@OneToMany(mappedBy="praticien")
	@JsonIgnore
	private List<PraticienSpecialite> praticienSpecialite = new ArrayList<PraticienSpecialite>();

	@OneToMany(mappedBy = "praticien")
	@JsonIgnore
	private List<CreneauxHoraires> creneauxHoraires = new ArrayList<CreneauxHoraires>();
	
	@OneToMany(mappedBy = "praticien")
	@JsonIgnore
	private List<RendezVous> rendezVous = new ArrayList<RendezVous>();
	
	@OneToMany(mappedBy="praticien")
	@JsonIgnore
	private List<MotifConsultation> motifConsultation = new ArrayList<MotifConsultation>();

	public Praticien() {
		super();
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

	public List<MotifConsultation> getMotifConsultation() {
		return motifConsultation;
	}

	public void setMotifConsultation(List<MotifConsultation> motifConsultation) {
		this.motifConsultation = motifConsultation;
	}

	@Override
	public String toString() {
		return "Praticien [dureeDefault=" + dureeDefault + ", praticienSpecialite=" + praticienSpecialite
				+ ", creneauxHoraires=" + creneauxHoraires + ", rendezVous=" + rendezVous + ", motifConsultation="
				+ motifConsultation + "]";
	}

	
	
}
