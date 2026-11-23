package tec;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * Tests de la classe PassagerStandard.
 */
public class PassagerStandardTest {

  private PassagerStandard kaylee;

  // Faux Bus (Mock) pour tester PassagerStandard sans dépendre d'Autobus
  private static class FauxBus implements Bus, Transport {
    boolean placeAssiseDispo;
    boolean placeDeboutDispo;
    String dernierMessage = "";

    FauxBus(boolean assise, boolean debout) {
      this.placeAssiseDispo = assise;
      this.placeDeboutDispo = debout;
    }

    @Override
    public boolean aPlaceAssise() {
      return placeAssiseDispo;
    }

    @Override
    public boolean aPlaceDebout() {
      return placeDeboutDispo;
    }

    @Override
    public void demanderPlaceAssise(Passager p) {
      dernierMessage = "demanderPlaceAssise";
      if (placeAssiseDispo) {
        p.accepterPlaceAssise();
      }
    }

    @Override
    public void demanderPlaceDebout(Passager p) {
      dernierMessage = "demanderPlaceDebout";
      if (placeDeboutDispo) {
        p.accepterPlaceDebout();
      }
    }

    @Override
    public void demanderChangerEnDebout(Passager p) {
      dernierMessage = "demanderChangerEnDebout";
    }

    @Override
    public void demanderChangerEnAssis(Passager p) {
      dernierMessage = "demanderChangerEnAssis";
    }

    @Override
    public void demanderSortie(Passager p) {
      dernierMessage = "demanderSortie";
      p.accepterSortie();
    }

    @Override
    public void allerArretSuivant() {
    }
  }

  @Before
  public void initialiser() throws Exception {
    kaylee = new PassagerStandard("Kaylee", 5);
  }

  @After
  public void nettoyer() throws Exception {
    kaylee = null;
  }

  /**
   * Teste l'etat d'un passager a sa creation.
   */
  @Test
  public void testInstanciation() {
    assertEquals("Kaylee", kaylee.nom());
    assertTrue(kaylee.estDehors());
    assertFalse(kaylee.estAssis());
    assertFalse(kaylee.estDebout());
  }

  /**
   * Teste les changements d'etat du passager.
   */
  @Test
  public void testGestionEtat() {
    kaylee.accepterPlaceAssise();
    assertFalse(kaylee.estDehors());
    assertTrue(kaylee.estAssis());
    assertFalse(kaylee.estDebout());

    kaylee.accepterPlaceDebout();
    assertFalse(kaylee.estDehors());
    assertFalse(kaylee.estAssis());
    assertTrue(kaylee.estDebout());

    kaylee.accepterSortie();
    assertTrue(kaylee.estDehors());
    assertFalse(kaylee.estAssis());
    assertFalse(kaylee.estDebout());
  }

  /**
   * Teste la montee dans un bus avec des places assises.
   */
  @Test
  public void testMonterAvecPlaceAssise() throws UsagerInvalideException {
    FauxBus bus = new FauxBus(true, true);
    kaylee.monterDans(bus);
    assertTrue(kaylee.estAssis());
    assertFalse(kaylee.estDebout());
    assertFalse(kaylee.estDehors());
  }

  /**
   * Teste la montee dans un bus sans place assise.
   */
  @Test
  public void testMonterSansPlaceAssise() throws UsagerInvalideException {
    FauxBus busAvecDebout = new FauxBus(false, true);
    kaylee.monterDans(busAvecDebout);
    assertFalse(kaylee.estAssis());
    assertTrue(kaylee.estDebout());
    assertFalse(kaylee.estDehors());

    PassagerStandard jayne = new PassagerStandard("Jayne", 3);
    FauxBus busPlein = new FauxBus(false, false);
    jayne.monterDans(busPlein);
    assertTrue(jayne.estDehors());
  }

  /**
   * Teste la sortie du passager a son arret de destination.
   */
  @Test
  public void testNouvelArret() throws UsagerInvalideException {
    FauxBus bus = new FauxBus(true, true);
    kaylee.monterDans(bus);

    kaylee.nouvelArret(bus, 4);
    assertTrue(kaylee.estAssis());

    kaylee.nouvelArret(bus, 5);
    assertEquals("demanderSortie", bus.dernierMessage);
    assertTrue(kaylee.estDehors());
  }
}