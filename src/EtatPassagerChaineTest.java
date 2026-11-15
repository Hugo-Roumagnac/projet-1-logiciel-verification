/**
 * Classe de test pour valider la variante EtatPassagerChaine.
 * Vérifie que les méthodes d'état réagissent correctement selon la chaîne fournie.
 */
public class EtatPassagerChaineTest {

    public void testPassagerDehors() {
        // On crée un passager avec la chaîne "dehors"
        IEtatPassager p = new EtatPassagerChaine("dehors");
        assert p.estExterieur() : "Le passager devrait être dehors";
        assert !p.estAssis() : "Il ne doit pas être assis";
        assert !p.estDebout() : "Il ne doit pas être debout";
        assert !p.estInterieur() : "Il ne doit pas être à l'intérieur";
    }

    public void testPassagerAssis() {
        // On crée un passager avec la chaîne "assis"
        IEtatPassager p = new EtatPassagerChaine("assis");
        assert !p.estExterieur() : "Il ne doit plus être dehors";
        assert p.estAssis() : "Il doit être assis";
        assert !p.estDebout() : "Il ne doit pas être debout";
        assert p.estInterieur() : "Il doit être à l'intérieur";
    }

    public void testPassagerDebout() {
        // On crée un passager avec la chaîne "debout"
        IEtatPassager p = new EtatPassagerChaine("debout");
        assert !p.estExterieur() : "Il ne doit plus être dehors";
        assert !p.estAssis() : "Il ne doit pas être assis";
        assert p.estDebout() : "Il doit être debout";
        assert p.estInterieur() : "Il doit être à l'intérieur";
    }

    public static void main(String[] args) {
        EtatPassagerChaineTest test = new EtatPassagerChaineTest();
        test.testPassagerDehors();
        test.testPassagerAssis();
        test.testPassagerDebout();
        System.out.println("Tous les tests de EtatPassagerChaine sont validés avec succès !");
    }
}