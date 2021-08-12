package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adress")
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="street")
	private String rue;
	@Column(name="addtionnal_details")
	private String complement;
	@Column(name="zipcode")
	private String codePostal;
	@Column(name="city")
	private String ville;
	@OneToOne(mappedBy="adresse")
	private Lieux lieux;
	
	public Adresse() {
		super();
	}

	public Adresse(Long id, String rue, String complement, String codePostal, String ville, Lieux lieux) {
		super();
		this.id = id;
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
		this.lieux = lieux;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Lieux getLieux() {
		return lieux;
	}

	public void setLieux(Lieux lieux) {
		this.lieux = lieux;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", complement=" + complement + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}
	
	
	
}
