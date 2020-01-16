package monapp.Personne;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonneManager {

    @PersistenceContext(unitName = "myData")
    EntityManager em;

    public List<Personne> findPersonnes() {
        return em.createQuery("Select c From Personne c", Personne.class)
                .getResultList();
    }

    public Personne findPersonne(Long n) {
        return em.find(Personne.class, n);
    }

    public Personne savePersonne(Personne c) {
        if (c.getId() == null) {
            em.persist(c);
        } else {
            c = em.merge(c);
        }
        return c;
    }

    public void deletePersonne(Personne c) {
        c = em.merge(c);
        em.remove(c);
    }

}