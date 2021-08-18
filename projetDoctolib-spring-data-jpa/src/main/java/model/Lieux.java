package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lieux")
public class Lieux {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "name")
		private String nom;
		@Column(name = "phone")
		private String telephone;
		@OneToOne
		private Adresse adresse;
		@OneToMany(mappedBy = "lieux")
		private List<CreneauxHoraires> creneauxHoraires = new ArrayList<CreneauxHoraires>();

		public Lieux() {
			super();
		}

		
		public Lieux(Long id, String nom, String telephone, Adresse adresse, List<CreneauxHoraires> creneauxHoraires) {
			super();
			this.id = id;
			this.nom = nom;
			this.telephone = telephone;
			this.adresse = adresse;
			this.creneauxHoraires = creneauxHoraires;
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
		

		public List<CreneauxHoraires> getCreneauxHoraires() {
			return creneauxHoraires;
		}

		public void setCreneauxHoraires(List<CreneauxHoraires> creneauxHoraires) {
			this.creneauxHoraires = creneauxHoraires;
		}

		@Override
		public String toString() {
			return "Lieux [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", adresse=" + adresse + "]";
		}
		
		
}
