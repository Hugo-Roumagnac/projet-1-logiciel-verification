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
  }

  /**
   * Teste les changements d'etat du passager.
   */
  @Test
  public void testGestionEtat() {
  }

  /**
   * Teste la montee dans un bus avec des places assises.
   */
  @Test
  public void testMonterAvecPlaceAssise() {
  }

  /**
   * Teste la montee dans un bus sans place assise.
   */
  @Test
  public void testMonterSansPlaceAssise() {
  }

  /**
   * Teste la sortie du passager a son arret de destination.
   */
  @Test
  public void testNouvelArret() {
  }
}
