public class JaugeNegatifTest {

    public void testNegatif() {
        // Test de base avec des bornes inversées en interne
        JaugeNegatif j = new JaugeNegatif(0, 50, 10);
        assert !j.estBleu();
        assert j.estVert() : "La valeur doit être dans la zone verte inversée";
        assert !j.estRouge();
    }

    public static void main(String[] args) {
        JaugeNegatifTest test = new JaugeNegatifTest();
        test.testNegatif();
        System.out.println("Tous les tests JaugeNegatif sont passés !");
    }
}