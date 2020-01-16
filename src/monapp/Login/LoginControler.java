package monapp.Login;

import monapp.Personne.*;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "login")
@SessionScoped
public class LoginControler {

	@EJB
	LoginManager cm;

	Login thePersonne = new Login();

	String email;
	String pw;
	boolean token = false;
	String label = "Log in";

	public void init() {
		token = false;
		this.label = "Log in";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public boolean isToken() {
		return token;
	}

	public void setToken(boolean token) {
		this.token = token;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public void setThePersonne(Login thePersonne) {
		this.thePersonne = thePersonne;
	}

	public List<Personne> getPersonne() {
		System.out.print("XXXXXXXXX");
		System.out.print(cm.findLogin().toString());
		return cm.findLogin();
	}

	public Login getThePersonne() {
		return thePersonne;
	}

	// public String show(Long n) {
	// thePersonne = cm.findLogin(n);
	// return "showPersonne";
	// }
	//
	// public String edit(Long n) {
	// thePersonne = cm.findLogin(n);
	// return "editPersonne";
	// }
	//
	// public String delete(Long n) {
	// thePersonne = cm.findLogin(n);
	// cm.deleteLogin(thePersonne);
	// return "personnes";
	// }

	public String save() {
		cm.saveLogin(thePersonne);
		return "showPersonne";
	}

	public String newPersonne() {
		thePersonne = new Login();
		return "editPersonne?faces-redirect=true";
	}

	public String findLogin() {
		List<Personne> aa = cm.findLogin(this.email);
		if (aa.size() > 0) {
			if (aa.get(0).getPassword().equals(this.pw)) {
				this.token = true;
				this.label = "Log out";
				return "personnes";
			} else {
				this.token = false;
				this.label = "Log in";
				return "login";
			}
		} else {
			this.token = false;
			this.label = "Log in";
			return "login";
		}
	}

	public String logout() {
		this.token = false;
		this.label = "Log in";
		return "login";
	}

}