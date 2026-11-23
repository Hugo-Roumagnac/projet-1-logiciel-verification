package jauge;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class JaugeDistanceTest {

    private JaugeDistance jaugeDansIntervalle;
    private JaugeDistance jaugeDeplacer;
    private JaugeDistance jaugeInfStrict;
    private JaugeDistance jaugeInfEgale;
    private JaugeDistance jaugeSupStrict;
    private JaugeDistance jaugeSupEgale;

    @Before
    public void initialiser() throws Exception {
        jaugeDansIntervalle = new JaugeDistance(-345, 67899, 100);
        jaugeDeplacer = new JaugeDistance(10, 50, 12);
        jaugeInfStrict = new JaugeDistance(0, 50, -8);
        jaugeInfEgale = new JaugeDistance(20, 90, 20);
        jaugeSupStrict = new JaugeDistance(0, 50, 77);
        jaugeSupEgale = new JaugeDistance(-30, 15, 15);
    }

    @After
    public void nettoyer() throws Exception {
        jaugeDansIntervalle = null;
        jaugeDeplacer = null;
        jaugeInfStrict = null;
        jaugeInfEgale = null;
        jaugeSupStrict = null;
        jaugeSupEgale = null;
    }

    @Test
    public void testDansIntervalle() {
        assertFalse(jaugeDansIntervalle.estBleu());
        assertTrue(jaugeDansIntervalle.estVert());
        assertFalse(jaugeDansIntervalle.estRouge());
    }

    @Test
    public void testDeplacer() {
        jaugeDeplacer.decrementer();
        jaugeDeplacer.decrementer();
        assertTrue(jaugeDeplacer.estBleu());
        assertFalse(jaugeDeplacer.estVert());
        assertFalse(jaugeDeplacer.estRouge());

        jaugeDeplacer.incrementer();
        assertFalse(jaugeDeplacer.estBleu());
        assertTrue(jaugeDeplacer.estVert());
        assertFalse(jaugeDeplacer.estRouge());
    }

    @Test
    public void testInferieurIntervalle() {
        assertTrue(jaugeInfStrict.estBleu());
        assertFalse(jaugeInfStrict.estVert());
        assertFalse(jaugeInfStrict.estRouge());

        assertTrue(jaugeInfEgale.estBleu());
        assertFalse(jaugeInfEgale.estVert());
        assertFalse(jaugeInfEgale.estRouge());
    }

    @Test
    public void testSuperieurIntervalle() {
        assertFalse(jaugeSupStrict.estBleu());
        assertFalse(jaugeSupStrict.estVert());
        assertTrue(jaugeSupStrict.estRouge());

        assertFalse(jaugeSupEgale.estBleu());
        assertFalse(jaugeSupEgale.estVert());
        assertTrue(jaugeSupEgale.estRouge());
    }
}