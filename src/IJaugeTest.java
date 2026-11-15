/**
 * Classe de test unifiée exploitant le polymorphisme grâce à l'interface IJauge.
 * Permet de tester toutes les implémentations de jauges avec le même code de test.
 */
public class IJaugeTest {

    private IJauge jauge;

    public void testerComportementCommun(IJauge j) {
        this.jauge = j;
        assert this.jauge.estVert() : "La jauge devrait être dans l'intervalle vert";
    }

    public static void main(String[] args) {
        IJaugeTest test = new IJaugeTest();

        System.out.println("Test de JaugeNaturel...");
        test.testerComportementCommun(new jaugeNaturel(0, 10, 5));

        System.out.println("Test de JaugeNegatif...");
        test.testerComportementCommun(new JaugeNegatif(0, 10, 5));

        System.out.println("Test de JaugeReel...");
        test.testerComportementCommun(new JaugeReel(0, 10000, 5000));

        System.out.println("Test de JaugeDistance...");
        test.testerComportementCommun(new JaugeDistance(0, 10, 5));

        System.out.println("Tous les tests polymorphes sont validés avec succès !");
    }
}