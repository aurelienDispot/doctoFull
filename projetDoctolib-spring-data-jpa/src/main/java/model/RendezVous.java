package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rendez_vous")
public class RendezVous {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "statut")
		private Statut statut;
		
		@Column(name = "nomPatient")
		private String nomPatient;
		
		@Column(name = "prenomPatient")
		private String prenomPatient;

		@ManyToOne
		@JoinColumn(name = "praticien_id")
		private Praticien praticien ;

		@ManyToOne
		@JoinColumn(name = "patient_id")
		private Patient patient;
		
		@OneToMany(mappedBy = "rendezVous")
		private List<CreneauxHoraires> creneauxHoraires = new ArrayList<CreneauxHoraires>();
		
		@OneToOne
		private MotifConsultation motifConsultation;
		
		
		public RendezVous() {
			super();
		}


		public RendezVous(Long id, Statut statut, String nomPatient, String prenomPatient) {
			super();
			this.id = id;
			this.statut = statut;
			this.nomPatient = nomPatient;
			this.prenomPatient = prenomPatient;			
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Statut getStatut() {
			return statut;
		}


		public void setStatut(Statut statut) {
			this.statut = statut;
		}


		public String getNomPatient() {
			return nomPatient;
		}


		public void setNomPatient(String nomPatient) {
			this.nomPatient = nomPatient;
		}


		public String getPrenomPatient() {
			return prenomPatient;
		}


		public void setPrenomPatient(String prenomPatient) {
			this.prenomPatient = prenomPatient;
		}
		
		
	}
