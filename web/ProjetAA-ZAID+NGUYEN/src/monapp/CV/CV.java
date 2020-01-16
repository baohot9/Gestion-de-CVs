package monapp.CV;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class CV implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	Long id;

	@Column
	@NotNull
	@Size(min = 1, max = 200)
	String annee;

	@Column
	@NotNull
	@Size(min = 1, max = 200)
	String nature;

	@Column
	@NotNull
	@Size(min = 1, max = 200)
	String titre;

	@Column
	String descriptif;
	

	@Column
	String web;
	
	@Column
	boolean canEdit;
	
	@Column
	String idPersonne;
	
	public CV(String annee, String nature, String titre, String descriptif, String web, String idPersonne) {
		this.annee = annee;
		this.nature = nature;
		this.titre = titre;
		this.descriptif = descriptif;
		this.web = web;
		this.canEdit = false;
		this.idPersonne = idPersonne;
	}

	public CV() {
		this.canEdit = false;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAnnee() {
		return annee;
	}


	public void setAnnee(String annee) {
		this.annee = annee;
	}


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescriptif() {
		return descriptif;
	}


	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}


	public String getWeb() {
		return web;
	}


	public void setWeb(String web) {
		this.web = web;
	}
	
	public boolean getCanEdit() {
		return canEdit;
	}


	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
	
	public String getIdPersonne() {
		return idPersonne;
	}


	public void setIdPersonne(String idPersonne) {
		this.idPersonne = idPersonne;
	}

}