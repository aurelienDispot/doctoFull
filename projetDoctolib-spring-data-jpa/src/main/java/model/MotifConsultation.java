package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MotifConsultation")

public class MotifConsultation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "nbCreneaux")
	private int nbCreneaux;
	
	@OneToOne(mappedBy = "motifConsultation")
	private RendezVous rendezVous;
	
	@ManyToOne
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;
	
	
	public MotifConsultation() {
		super();
	}

	public MotifConsultation(Long id, String nom, String description, int nbCreneaux) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.nbCreneaux = nbCreneaux;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbCreneaux() {
		return nbCreneaux;
	}

	public void setNbCreneaux(int nbCreneaux) {
		this.nbCreneaux = nbCreneaux;
	}
	
	
	

}
