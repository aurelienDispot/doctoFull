package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Lieux {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "name")
		private String nom;
		@Column(name = "phone")
		private String telephone;
		@OneToOne()
		private Adresse adresse;
		@ManyToOne
		@JoinColumn(name = "creneauxHoraires_id")
		private CreneauxHoraires creneauxHoraires;
		
		public Lieux(Long id, String nom, String telephone, Adresse adresse, CreneauxHoraires creneauxHoraires) {
			super();
			this.id = id;
			this.nom = nom;
			this.telephone = telephone;
			this.adresse = adresse;
			this.creneauxHoraires = creneauxHoraires;
		}

		public Lieux() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public Adresse getAdresse() {
			return adresse;
		}

		public void setAdresse(Adresse adresse) {
			this.adresse = adresse;
		}

		public CreneauxHoraires getCreneauxHoraires() {
			return creneauxHoraires;
		}

		public void setCreneauxHoraires(CreneauxHoraires creneauxHoraires) {
			this.creneauxHoraires = creneauxHoraires;
		}

		@Override
		public String toString() {
			return "Lieux [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", adresse=" + adresse + "]";
		}
		
		
}
