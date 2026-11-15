public class JaugeDistanceTest {

    public void testDistance() {
        // Jauge avec min = 10, max = 20, depart = 15
        JaugeDistance j = new JaugeDistance(10, 20, 15);
        assert !j.estBleu() : "Ne doit pas être bleue";
        assert j.estVert() : "Doit être dans l'intervalle (verte)";
        assert !j.estRouge() : "Ne doit pas être rouge";

        // Déplacement pour tester la mise à jour des distances
        j.incrementer();
        assert j.estVert() : "Doit rester verte après un pas";
    }

    public static void main(String[] args) {
        JaugeDistanceTest test = new JaugeDistanceTest();
        test.testDistance();
        System.out.println("Tous les tests JaugeDistance sont validés !");
    }
}