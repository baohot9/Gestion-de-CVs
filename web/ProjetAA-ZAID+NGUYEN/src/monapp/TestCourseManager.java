package monapp;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import monapp.Personne.PersonneManager;

public class TestCourseManager {

    @EJB
    PersonneManager cm;

    @Before
    public void setUp() throws Exception {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);
    }

    @After
    public void tearDown() throws Exception {
        EJBContainer.createEJBContainer().close();
    }

    @Test
    public void testFindCourses() {
        assertNotNull(cm.findPersonne(null));
    }

}