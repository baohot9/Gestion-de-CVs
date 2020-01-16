package monapp.Personne;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	Long id;

	@Column
	@NotNull
	@Size(min = 3, max = 200)
	String nom;

	@Column
	@NotNull
	@Size(min = 3, max = 200)
	String prenom;

	@Column
	@NotNull
	@Size(min = 3, max = 200)
	String email;

	@Column
	@NotNull
	@Size(min = 3, max = 200)
	String web;
	
//	public Personne(Long id, String nom, String prenom, String email, String web, String dateN, String password) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.email = email;
//		this.web = web;
//		this.dateN = dateN;
//		this.password = password;
//	}

	

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Column
	@NotNull
	@Size(min = 3, max = 200)
	String dateN;

	@Column
	@NotNull
	@Size(min = 3, max = 200)
	String password;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateN() {
		return dateN;
	}

	public void setDateN(String dateN) {
		this.dateN = dateN;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}