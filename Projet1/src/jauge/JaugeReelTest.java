package jauge;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class JaugeReelTest {

    private JaugeReel jaugeDansIntervalle;
    private JaugeReel jaugeDeplacer;
    private JaugeReel jaugeInfStrict;
    private JaugeReel jaugeInfEgale;
    private JaugeReel jaugeSupStrict;
    private JaugeReel jaugeSupEgale;

    @Before
    public void initialiser() throws Exception {
        jaugeDansIntervalle = new JaugeReel(-345, 67899, 100);
        jaugeDeplacer = new JaugeReel(10, 50, 12);
        jaugeInfStrict = new JaugeReel(0, 50, -8);
        jaugeInfEgale = new JaugeReel(20, 90, 20);
        jaugeSupStrict = new JaugeReel(0, 50, 77);
        jaugeSupEgale = new JaugeReel(-30, 15, 15);
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