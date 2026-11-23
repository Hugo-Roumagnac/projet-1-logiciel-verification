package EtatPassager;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class EtatPassagerChaineTest {

    private EtatPassagerChaine etatDehors;
    private EtatPassagerChaine etatAssis;
    private EtatPassagerChaine etatDebout;

    @Before
    public void initialiser() throws Exception {
        etatDehors = new EtatPassagerChaine("dehors");
        etatAssis = new EtatPassagerChaine("assis");
        etatDebout = new EtatPassagerChaine("debout");
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