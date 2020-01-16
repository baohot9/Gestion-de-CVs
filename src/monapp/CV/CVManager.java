package monapp.CV;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CVManager {

    @PersistenceContext(unitName = "myData")
    EntityManager em;

    public List<CV> findCVs() {
        return em.createQuery("Select c From CV c", CV.class)
                .getResultList();
    }

    public CV findCV(Long n) {
        return em.find(CV.class, n);
    }

    public CV saveCV(CV c) {
        if (c.getId() == null) {
            em.persist(c);
        } else {
            c = em.merge(c);
        }
        return c;
    }

    public void deleteCV(CV c) {
        c = em.merge(c);
        em.remove(c);
    }

}