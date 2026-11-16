package EtatPassager;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class EtatPassagerMonterTest {

    private EtatPassagerMonter etatAssis;
    private EtatPassagerMonter etatDebout;

    @Before
    public void initialiser() throws Exception {
        etatAssis = new EtatPassagerMonter(true);
        etatDebout = new EtatPassagerMonter(false);
    }

    @After
    public void nettoyer() throws Exception {
        etatAssis = null;
        etatDebout = null;
    }

    @Test
    public void testEstAssis() {
        assertFalse(etatAssis.estExterieur());
        assertTrue(etatAssis.estAssis());
        assertFalse(etatAssis.estDebout());
        assertTrue(etatAssis.estInterieur());
    }

    @Test
    public void testEstDebout() {
        assertFalse(etatDebout.estExterieur());
        assertFalse(etatDebout.estAssis());
        assertTrue(etatDebout.estDebout());
        assertTrue(etatDebout.estInterieur());
    }
}