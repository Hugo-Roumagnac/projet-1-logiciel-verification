public class EtatPassagerTest {

    public void initialiser() throws Exception {
        // Méthode d'initialisation
    }

    public void nettoyer() throws Exception {
        // Méthode de nettoyage
    }

    /**
     * Etat dehors après instanciation.
     * À vérifier :
     * - estExterieur() retourne vrai.
     * - estAssis() retourne faux.
     * - estDebout() retourne faux.
     */
    public void testEstExterieur() {
        EtatPassager passager = new EtatPassager(EtatPassager.Etat.Dehors);
        assert passager.estExterieur();
        assert !passager.estAssis();
        assert !passager.estDebout();
    }

    /**
     * Etat assis après instanciation.
     * À vérifier :
     * - estExterieur() retourne faux.
     * - estAssis() retourne vrai.
     * - estDebout() retourne faux.
     */
    public void testEstAssis() {
        EtatPassager passager = new EtatPassager(EtatPassager.Etat.Assis);
        assert !passager.estExterieur();
        assert passager.estAssis();
        assert !passager.estDebout();
    }

    /**
     * Etat debout après instanciation.
     * À vérifier :
     * - estExterieur() retourne faux.
     * - estAssis() retourne faux.
     * - estDebout() retourne vrai.
     */
    public void testEstDebout() {
        EtatPassager passager = new EtatPassager(EtatPassager.Etat.Debout);
        assert !passager.estExterieur();
        assert !passager.estAssis();
        assert passager.estDebout();
    }

    /**
     * Etat intérieur après instanciation.
     * - Instanciation avec ASSIS : estInterieur() retourne vrai.
     * - Instanciation avec DEBOUT : estInterieur() retourne vrai.
     * - Instanciation avec DEHORS : estInterieur() retourne faux.
     */
    public void testEstInterieur() {
        EtatPassager passagerAssis = new EtatPassager(EtatPassager.Etat.Assis);
        assert passagerAssis.estInterieur();

        EtatPassager passagerDebout = new EtatPassager(EtatPassager.Etat.Debout);
        assert passagerDebout.estInterieur();

        EtatPassager passagerDehors = new EtatPassager(EtatPassager.Etat.Dehors);
        assert !passagerDehors.estInterieur();
    }
}