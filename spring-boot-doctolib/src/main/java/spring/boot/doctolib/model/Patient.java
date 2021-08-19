package spring.boot.doctolib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("patient")
public class Patient extends Personne {
	@Column(name="carteVitale")
	@JsonView(Views.ViewCommon.class)
	private Integer carteVitale;
	@OneToMany(mappedBy = "patient")
	@JsonView(Views.ViewPatient.class)
	private List<RendezVous> rendezVous = new ArrayList<RendezVous>();
	
	public Patient() {
		super();
	}

	public Integer getCarteVitale() {
		return carteVitale;
	}

	public void setCarteVitale(Integer carteVitale) {
		this.carteVitale = carteVitale;
	}

	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	@Override
	public String toString() {
		return "Patient [carteVitale=" + carteVitale + "]";
	}
	
}
