package jauge;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class JaugeNegatifTest {

    private JaugeNegatif jaugeDansIntervalle;
    private JaugeNegatif jaugeDeplacer;
    private JaugeNegatif jaugeInfStrict;
    private JaugeNegatif jaugeInfEgale;
    private JaugeNegatif jaugeSupStrict;
    private JaugeNegatif jaugeSupEgale;

    @Before
    public void initialiser() throws Exception {
        jaugeDansIntervalle = new JaugeNegatif(-345, 67899, 100);
        jaugeDeplacer = new JaugeNegatif(10, 50, 12);
        jaugeInfStrict = new JaugeNegatif(0, 50, -8);
        jaugeInfEgale = new JaugeNegatif(20, 90, 20);
        jaugeSupStrict = new JaugeNegatif(0, 50, 77);
        jaugeSupEgale = new JaugeNegatif(-30, 15, 15);
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