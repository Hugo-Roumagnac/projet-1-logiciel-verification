package tec;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * Tests de la classe Autobus.
 */
public class AutobusTest {

  private Autobus serenity;

  @Before
  public void initialiser() throws Exception {
    serenity = new Autobus(1, 2);
  }

  @After
  public void nettoyer() throws Exception {
    serenity = null;
  }

  /**
   * Teste les places disponibles a la creation du bus.
   */
  @Test
  public void testInstanciation() {
  }

  /**
   * Teste la demande d'une place assise.
   */
  @Test
  public void testDemanderPlaceAssise() {
  }

  /**
   * Teste la demande d'une place debout.
   */
  @Test
  public void testDemanderPlaceDebout() {
  }

  /**
   * Teste les changements de place.
   */
  @Test
  public void testDemanderChangerPlace() {
  }

  /**
   * Teste la sortie d'un passager.
   */
  @Test
  public void testDemanderSortie() {
  }

  /**
   * Teste le passage a l'arret suivant.
   */
  @Test
  public void testAllerArretSuivant() {
  }
}
