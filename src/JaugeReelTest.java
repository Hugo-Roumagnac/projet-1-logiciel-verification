public class JaugeReelTest {

    public void testJaugeReelle() {
        // Paramètres : min = 1.000, max = 5.000, depart = 3.000
        JaugeReel j = new JaugeReel(1000, 5000, 3000);
        assert !j.estBleu() : "Ne doit pas être bleue au départ";
        assert j.estVert() : "Doit être dans l'intervalle (verte)";
        assert !j.estRouge() : "Ne doit pas être rouge";

        // Test d'incrémentation
        j.incrementer();
        assert j.estVert() : "Doit rester verte après une petite augmentation";
    }

    public static void main(String[] args) {
        JaugeReelTest test = new JaugeReelTest();
        test.testJaugeReelle();
        System.out.println("Tous les tests JaugeReel sont validés !");
    }
}