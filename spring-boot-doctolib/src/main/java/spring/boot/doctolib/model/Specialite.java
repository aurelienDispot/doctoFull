package spring.boot.doctolib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "specialite")
public class Specialite {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "nom", length = 100)
	private String nom;
	@Column(name = "description", length = 1000)
	private String description;
	@OneToMany(mappedBy="specialite")
	private List<PraticienSpecialite> praticienSpecialites = new ArrayList<PraticienSpecialite>();
	
	


	public Specialite(Long id, int version, String nom, String description,
			List<PraticienSpecialite> praticienSpecialites) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.description = description;
		this.praticienSpecialites = praticienSpecialites;
	}
	
	
	public Specialite() {
		super();
	}


	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<PraticienSpecialite> getPraticienSpecialites() {
		return praticienSpecialites;
	}
	public void setPraticienSpecialites(List<PraticienSpecialite> praticienSpecialites) {
		this.praticienSpecialites = praticienSpecialites;
	}


	
	@Override
	public String toString() {
		return "Specialite [id=" + id + ", version=" + version + ", nom=" + nom + ", description=" + description
				+ ", praticienSpecialites=" + praticienSpecialites + "]";
	}

	
}
