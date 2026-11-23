package tec;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class AutobusTest {

  private Autobus serenity;

  // --- Faux Passager (Mock) pour tester Autobus sans dépendre de PassagerStandard ---
  private static class FauxPassager implements Passager {
    int etat = 0; // 0: dehors, 1: assis, 2: debout
    int dernierArretRecu = -1;

    @Override
    public String nom() {
      return "Faux";
    }

    @Override
    public boolean estDehors() {
      return etat == 0;
    }

    @Override
    public boolean estAssis() {
      return etat == 1;
    }

    @Override
    public boolean estDebout() {
      return etat == 2;
    }

    @Override
    public void accepterSortie() {
      etat = 0;
    }

    @Override
    public void accepterPlaceAssise() {
      etat = 1;
    }

    @Override
    public void accepterPlaceDebout() {
      etat = 2;
    }

    @Override
    public void nouvelArret(Bus bus, int numeroArret) {
      dernierArretRecu = numeroArret;
    }
  }

  @Before
  public void initialiser() throws Exception {
    serenity = new Autobus(1, 2); // 1 place assise, 2 places debout
  }

  @After
  public void nettoyer() throws Exception {
    serenity = null;
  }

  @Test
  public void testInstanciation() {
    assertTrue(serenity.aPlaceAssise());
    assertTrue(serenity.aPlaceDebout());

    Autobus busVide = new Autobus(0, 0);
    assertFalse(busVide.aPlaceAssise());
    assertFalse(busVide.aPlaceDebout());
  }

  @Test
  public void testDemanderPlaceAssise() {
    FauxPassager p1 = new FauxPassager();
    FauxPassager p2 = new FauxPassager();

    serenity.demanderPlaceAssise(p1);
    assertTrue(p1.estAssis());
    assertFalse(serenity.aPlaceAssise()); // Plus de place assise (max = 1)

    serenity.demanderPlaceAssise(p2);
    assertTrue(p2.estDehors()); // Refusé
  }

  @Test
  public void testDemanderPlaceDebout() {
    FauxPassager p1 = new FauxPassager();
    FauxPassager p2 = new FauxPassager();
    FauxPassager p3 = new FauxPassager();

    serenity.demanderPlaceDebout(p1);
    serenity.demanderPlaceDebout(p2);
    assertTrue(p1.estDebout());
    assertTrue(p2.estDebout());
    assertFalse(serenity.aPlaceDebout()); // Plus de place debout (max = 2)

    serenity.demanderPlaceDebout(p3);
    assertTrue(p3.estDehors()); // Refusé
  }

  @Test
  public void testDemanderChangerPlace() {
    FauxPassager p1 = new FauxPassager();
    serenity.demanderPlaceAssise(p1);
    assertFalse(serenity.aPlaceAssise());

    // Assis -> Debout
    serenity.demanderChangerEnDebout(p1);
    assertTrue(p1.estDebout());
    assertTrue(serenity.aPlaceAssise());

    // Debout -> Assis
    serenity.demanderChangerEnAssis(p1);
    assertTrue(p1.estAssis());
    assertFalse(serenity.aPlaceAssise());
  }

  @Test
  public void testDemanderSortie() {
    FauxPassager p1 = new FauxPassager();
    serenity.demanderPlaceAssise(p1);
    assertFalse(serenity.aPlaceAssise());

    serenity.demanderSortie(p1);
    assertTrue(p1.estDehors());
    assertTrue(serenity.aPlaceAssise()); // La place est bien libérée
  }

  @Test
  public void testAllerArretSuivant() throws UsagerInvalideException {
    FauxPassager p1 = new FauxPassager();
    serenity.demanderPlaceAssise(p1);

    serenity.allerArretSuivant();
    assertEquals(1, p1.dernierArretRecu);

    serenity.allerArretSuivant();
    assertEquals(2, p1.dernierArretRecu);
  }
}