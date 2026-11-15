public class EtatPassagerMonterTest {

    public void testPassagerExterieur() {
        // On crée un passager non monté (dehors)
        EtatPassagerMonter p = new EtatPassagerMonter(false);
        assert p.estExterieur() : "Le passager devrait être à l'extérieur";
        assert !p.estAssis() : "Il ne doit pas être assis";
        assert !p.estDebout() : "Il ne doit pas être debout";
        assert !p.estInterieur() : "Il ne doit pas être à l'intérieur";
    }

    public void testPassagerInterieur() {
        // On crée un passager monté
        EtatPassagerMonter p = new EtatPassagerMonter(true);
        assert !p.estExterieur() : "Il ne doit plus être dehors";
        assert p.estAssis() : "Il est considéré comme assis dans cette variante";
        assert p.estInterieur() : "Il est bien à l'intérieur";
    }

    public static void main(String[] args) {
        EtatPassagerMonterTest test = new EtatPassagerMonterTest();
        test.testPassagerExterieur();
        test.testPassagerInterieur();
        System.out.println("Tous les tests de EtatPassagerMonter sont passés avec succès !");
    }
}