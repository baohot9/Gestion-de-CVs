package monapp.Personne;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "personne")
@SessionScoped
public class PersonneControler {

    @EJB
    PersonneManager cm;

    Personne thePersonne = new Personne();

    @PostConstruct
    public void init() {
        System.out.println("Create " + this);
        if (cm.findPersonnes().size() == 0) {
            Personne c1 = new Personne();
            c1.setNom("Alice");
            c1.setPrenom("Bob");
            c1.setDateN("10/10/1990");
            c1.setEmail("alice@gmail.com");
            c1.setWeb("github/Alice");
            c1.setPassword("abcd");
            cm.savePersonne(c1);
        }
    }

    public List<Personne> getPersonnes() {
        return cm.findPersonnes();
    }

    public Personne getThePersonne() {
        return thePersonne;
    }

    public String show(Long n) {
        thePersonne = cm.findPersonne(n);
        return "showPersonne";
    }
    
    public String edit(Long n) {
        thePersonne = cm.findPersonne(n);
        return "editPersonne";
    }

    public String delete(Long n) {
    	thePersonne = cm.findPersonne(n);
    	cm.deletePersonne(thePersonne);
        return "personnes";
    }
    
    public String save() {
        cm.savePersonne(thePersonne);
        return "showPersonne";
    }

    public String newPersonne() {
        thePersonne = new Personne();
        return "editPersonne?faces-redirect=true";
    }

}