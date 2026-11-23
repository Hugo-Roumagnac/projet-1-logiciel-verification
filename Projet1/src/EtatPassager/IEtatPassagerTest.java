package EtatPassager;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class IEtatPassagerTest {

    private IEtatPassager etatDehors;
    private IEtatPassager etatAssis;
    private IEtatPassager etatDebout;

    private IEtatPassager creerAssis() {
        return new EtatPassager(EtatPassager.Etat.ASSIS);
        // return new EtatPassagerChaine("assis");
    }

    private IEtatPassager creerDebout() {
        return new EtatPassager(EtatPassager.Etat.DEBOUT);
        // return new EtatPassagerChaine("debout");
    }

    private IEtatPassager creerDehors() {
        return new EtatPassager(EtatPassager.Etat.DEHORS);
        // return new EtatPassagerChaine("dehors");
    }

    @Before
    public void initialiser() throws Exception {
        etatDehors = creerDehors();
        etatAssis = creerAssis();
        etatDebout = creerDebout();
    }

    @After
    public void nettoyer() throws Exception {
        etatDehors = null;
        etatAssis = null;
        etatDebout = null;
    }

    @Test
    public void testEstExterieur() {
        assertTrue(etatDehors.estExterieur());
        assertFalse(etatDehors.estAssis());
        assertFalse(etatDehors.estDebout());
    }

    @Test
    public void testEstAssis() {
        assertFalse(etatAssis.estExterieur());
        assertTrue(etatAssis.estAssis());
        assertFalse(etatAssis.estDebout());
    }

    @Test
    public void testEstDebout() {
        assertFalse(etatDebout.estExterieur());
        assertFalse(etatDebout.estAssis());
        assertTrue(etatDebout.estDebout());
    }

    @Test
    public void testEstInterieur() {
        assertTrue(etatAssis.estInterieur());
        assertTrue(etatDebout.estInterieur());
        assertFalse(etatDehors.estInterieur());
    }
}