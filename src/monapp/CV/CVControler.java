package monapp.CV;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

@ManagedBean(name = "CV")
@SessionScoped
public class CVControler {

	@EJB
	CVManager cm;

	CV theCV = new CV();
	CV showCV = new CV();

	String annee;
	String nature;
	String titre;
	String descriptif;
	String web;

	boolean editMode = false;

	@PostConstruct
	public void init() {
		System.out.println("Create " + this);
		showCV = new CV();
		editMode = false;
		// if (cm.findCVs().size() == 0) {
		// CV c1 = new CV();
		// c1.setAnnee("2017");
		// c1.setNature("formation");
		// c1.setTitre("ILD");
		// c1.setWeb("abc.com");
		// c1.setDescriptif("qqq");
		// c1.setCanEdit(false);
		// cm.saveCV(c1);
		// }
	}

	public List<CV> getCVs() {
		System.out.println("Create " + this);
		return cm.findCVs();
	}

	public CV getTheCV() {
		return theCV;
	}

	public CV getShowCV() {
		return showCV;
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

	public boolean getEditMode() {
		return editMode;
	}

	public void setEditMode(boolean web) {
		this.editMode = editMode;
	}

	public String showCV(Long n) {
		showCV = cm.findCV(n);
		System.out.println("++++" + n);
		return null;
	}

	public String editCV(Long n) {
		theCV = cm.findCV(n);
		this.annee = theCV.annee;
		this.nature = theCV.nature;
		this.titre = theCV.titre;
		this.descriptif = theCV.descriptif;
		this.web = theCV.web;
		this.editMode = true;
		return "showPersonne";
	}

	public String delete(Long n) {
		theCV = cm.findCV(n);
		cm.deleteCV(theCV);
		return "showPersonne";
	}

	public String saveCV() {
		theCV.setAnnee(this.annee);
		theCV.setNature(this.nature);
		theCV.setTitre(this.titre);
		theCV.setDescriptif(this.descriptif);
		theCV.setWeb(this.web);
		this.editMode = false;
		cm.saveCV(theCV);
		this.annee = "";
		this.nature = "";
		this.titre = "";
		this.descriptif = "";
		this.web = "";
		return "showPersonne";
	}

	public String cancelCV() {
		this.editMode = false;
		this.annee = "";
		this.nature = "";
		this.titre = "";
		this.descriptif = "";
		this.web = "";
		return "showPersonne";
	}

	public String newCV() {
		theCV = new CV();
		return "editCV?faces-redirect=true";
	}

	public String addCV(String id) {
		theCV = new CV(this.annee, this.nature, this.titre, this.descriptif, this.web, id);
		cm.saveCV(theCV);
		this.annee = "";
		this.nature = "";
		this.titre = "";
		this.descriptif = "";
		this.web = "";
		// cm.saveCV(theNewCV);
		// theNewCV = new CV();
		return "showPersonne";
	}

	public void showMessage(Long id) {
    	showCV = cm.findCV(id);
      	String msg = "ID: " + showCV.id + "\n" + 
      			"Annee: " +  showCV.annee + "\n" + 
      			"Nature: " +  showCV.nature + "\n" +
      			"Titre: " +  showCV.titre + "\n" + 
      			"Descriptif: " +  showCV.descriptif + "\n" + 
      			"Web: " +  showCV.web + "\n";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Show activite", msg);
         
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }


}