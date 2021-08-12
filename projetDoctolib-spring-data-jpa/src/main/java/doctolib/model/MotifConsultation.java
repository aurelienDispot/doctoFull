package doctolib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MotifConsultation")
@NamedQuery(name = "MotifConsultation.findByPatientId", query = "select motif.motifconsultation from Patient p where p.id = :idPatient")

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
	
	@OneToOne(mappedBy = "motifconsultation")
	private RendezVous rendezvous;
	
//	@OneToMany(mappedBy = "motifconsultation")
//	private Praticien praticien;
	
	
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
