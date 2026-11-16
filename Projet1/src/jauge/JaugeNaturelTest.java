package jauge;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class JaugeNaturelTest {

    private JaugeNaturel jaugeDansIntervalle;
    private JaugeNaturel jaugeDeplacer;
    private JaugeNaturel jaugeInfStrict;
    private JaugeNaturel jaugeInfEgale;
    private JaugeNaturel jaugeSupStrict;
    private JaugeNaturel jaugeSupEgale;
    private JaugeNaturel jaugeMaxInfMin;
    private JaugeNaturel jaugeMaxEgaleMinSup;
    private JaugeNaturel jaugeMaxEgaleMinEgale;

    @Before
    public void initialiser() throws Exception {
        jaugeDansIntervalle = new JaugeNaturel(-345, 67899, 100);
        jaugeDeplacer = new JaugeNaturel(10, 50, 12);
        jaugeInfStrict = new JaugeNaturel(0, 50, -8);
        jaugeInfEgale = new JaugeNaturel(20, 90, 20);
        jaugeSupStrict = new JaugeNaturel(0, 50, 77);
        jaugeSupEgale = new JaugeNaturel(-30, 15, 15);
        jaugeMaxInfMin = new JaugeNaturel(100, 10, 50);
        jaugeMaxEgaleMinSup = new JaugeNaturel(7, 7, 20);
        jaugeMaxEgaleMinEgale = new JaugeNaturel(7, 7, 7);
    }

    @After
    public void nettoyer() throws Exception {
        jaugeDansIntervalle = null;
        jaugeDeplacer = null;
        jaugeInfStrict = null;
        jaugeInfEgale = null;
        jaugeSupStrict = null;
        jaugeSupEgale = null;
        jaugeMaxInfMin = null;
        jaugeMaxEgaleMinSup = null;
        jaugeMaxEgaleMinEgale = null;
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
        jaugeDeplacer.decrementer(); // 10 = vigieMin
        assertTrue(jaugeDeplacer.estBleu());
        assertFalse(jaugeDeplacer.estVert());
        assertFalse(jaugeDeplacer.estRouge());

        jaugeDeplacer.incrementer(); // 11
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

    @Test
    public void testLimiteVigieMaxInferieurVigieMin() {
        assertTrue(jaugeMaxInfMin.estBleu());
        assertTrue(jaugeMaxInfMin.estRouge());
        assertFalse(jaugeMaxInfMin.estVert());
    }

    @Test
    public void testMaxEgaleMin() {
        assertFalse(jaugeMaxEgaleMinSup.estBleu());
        assertFalse(jaugeMaxEgaleMinSup.estVert());
        assertTrue(jaugeMaxEgaleMinSup.estRouge());

        assertTrue(jaugeMaxEgaleMinEgale.estBleu());
        assertFalse(jaugeMaxEgaleMinEgale.estVert());
        assertTrue(jaugeMaxEgaleMinEgale.estRouge());
    }
}