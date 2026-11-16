package jauge;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class IJaugeTest {

    private IJauge jaugeDansIntervalle;
    private IJauge jaugeDeplacer;
    private IJauge jaugeInfStrict;
    private IJauge jaugeInfEgale;
    private IJauge jaugeSupStrict;
    private IJauge jaugeSupEgale;

    private IJauge creerJauge(long min, long max, long depart) {
        return new JaugeNaturel(min, max, depart);
        // return new JaugeNegatif(min, max, depart);
        // return new JaugeReel(min, max, depart);
        // return new JaugeDistance(min, max, depart);
    }

    @Before
    public void initialiser() throws Exception {
        jaugeDansIntervalle = creerJauge(-345, 67899, 100);
        jaugeDeplacer = creerJauge(10, 50, 12);
        jaugeInfStrict = creerJauge(0, 50, -8);
        jaugeInfEgale = creerJauge(20, 90, 20);
        jaugeSupStrict = creerJauge(0, 50, 77);
        jaugeSupEgale = creerJauge(-30, 15, 15);
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