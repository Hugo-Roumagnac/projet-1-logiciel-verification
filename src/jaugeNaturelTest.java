import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class jaugeNaturelTest {

    private jaugeNaturel jauge;

    @BeforeEach
    public void initialiser() throws Exception {
        jauge = new jaugeNaturel(-345, 67899, 100);
    }

    @AfterEach
    public void nettoyer() throws Exception {
        jauge = null;
    }

    /**
     * Etat après instanciation pour une valeur de départ dans l'intervalle de vigie.
     */
    @Test
    public void testDansIntervalle() {
        assertFalse(jauge.estBleu(), "estBleu doit retourner faux");
        assertTrue(jauge.estVert(), "estVert doit retourner vrai");
        assertFalse(jauge.estRouge(), "estRouge doit retourner faux");
    }

    /**
     * Test des méthodes incrementer() et decrementer().
     */
    @Test
    public void testDeplacer() {
        jaugeNaturel j = new jaugeNaturel(10, 50, 12);   // depart = vigieMin + 2
        j.decrementer();
        j.decrementer();                                  // 10 = vigieMin
        assertTrue(j.estBleu(), "estBleu doit retourner vrai");
        assertFalse(j.estVert(), "estVert doit retourner faux");
        assertFalse(j.estRouge(), "estRouge doit retourner faux");

        j.incrementer();                                  // 11, retour dans l'intervalle
        assertFalse(j.estBleu(), "estBleu doit retourner faux");
        assertTrue(j.estVert(), "estVert doit retourner vrai");
        assertFalse(j.estRouge(), "estRouge doit retourner faux");
    }

    /**
     * 1) depart < vigieMin < vigieMax
     * 2) depart = vigieMin < vigieMax
     */
    @Test
    public void testInferieurIntervalle() {
        jaugeNaturel j1 = new jaugeNaturel(0, 50, -8);
        assertTrue(j1.estBleu(), "estBleu doit retourner vrai");
        assertFalse(j1.estVert(), "estVert doit retourner faux");
        assertFalse(j1.estRouge(), "estRouge doit retourner faux");

        jaugeNaturel j2 = new jaugeNaturel(20, 90, 20);
        assertTrue(j2.estBleu(), "estBleu doit retourner vrai");
        assertFalse(j2.estVert(), "estVert doit retourner faux");
        assertFalse(j2.estRouge(), "estRouge doit retourner faux");
    }

    /**
     * 1) vigieMin < vigieMax < depart
     * 2) vigieMin < vigieMax = depart
     */
    @Test
    public void testSuperieurIntervalle() {
        jaugeNaturel j1 = new jaugeNaturel(0, 50, 77);
        assertFalse(j1.estBleu(), "estBleu doit retourner faux");
        assertFalse(j1.estVert(), "estVert doit retourner faux");
        assertTrue(j1.estRouge(), "estRouge doit retourner vrai");

        jaugeNaturel j2 = new jaugeNaturel(-30, 15, 15);
        assertFalse(j2.estBleu(), "estBleu doit retourner faux");
        assertFalse(j2.estVert(), "estVert doit retourner faux");
        assertTrue(j2.estRouge(), "estRouge doit retourner vrai");
    }

    /**
     * Cas limite vigieMax < depart < vigieMin.
     * Le cas n'est pas traité : la jauge est à la fois bleue et rouge.
     */
    @Test
    public void testLimiteVigieMaxInferieurVigieMin() {
        jaugeNaturel j = new jaugeNaturel(100, 10, 50);
        assertTrue(j.estBleu());
        assertTrue(j.estRouge());
        assertFalse(j.estVert());
    }

    /**
     * 1) vigieMin = vigieMax < depart
     * 2) vigieMin = vigieMax = depart
     */
    @Test
    public void testMaxEgaleMin() {
        jaugeNaturel j1 = new jaugeNaturel(7, 7, 20);
        assertFalse(j1.estBleu());
        assertFalse(j1.estVert());
        assertTrue(j1.estRouge());

        // état incohérent : bleue et rouge à la fois
        jaugeNaturel j2 = new jaugeNaturel(7, 7, 7);
        assertTrue(j2.estBleu());
        assertFalse(j2.estVert());
        assertTrue(j2.estRouge());
    }
}
