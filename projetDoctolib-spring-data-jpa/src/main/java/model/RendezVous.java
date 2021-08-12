package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Rendez-Vous")
@NamedQuery(name = "RendezVous.findByPatientId", query = "select rv.rendezvous from Patient p where p.id = :idPatient")

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

//		@ManyToOne(mappedBy = "rendezvous")
//		private Praticien praticien ;

//		@ManyToOne(mappedBy = "rendezvous")
//		private Patient patient;
		
//		@OneToMany
//		private CreneauxHoraires creneauxhoraires;
		
		
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
