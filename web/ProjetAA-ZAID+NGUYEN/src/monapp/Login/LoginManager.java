package monapp.Login;

import monapp.Personne.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginManager {

    @PersistenceContext(unitName = "myData")
    EntityManager em;

    public List<Personne> findLogin() {
        return em.createQuery("Select c From Personne c", Personne.class)
                .getResultList();
    }

    public List<Personne> findLogin(String mail) {
        return em.createQuery("SELECT c FROM Personne c WHERE c.email LIKE :mail")
        		.setParameter("mail", mail)
        		.setMaxResults(10)
        		.getResultList();
        
    }

    public Login saveLogin(Login c) {
        if (c.getId() == null) {
            em.persist(c);
        } else {
            c = em.merge(c);
        }
        return c;
    }

    public void deleteLogin(Login c) {
        c = em.merge(c);
        em.remove(c);
    }

}