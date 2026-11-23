package tec;

/**
 * Autobus avec un nombre maximal de places assises et de places debout.
 * Les passagers sont stockes dans un tableau.
 */
public class Autobus implements Transport, Bus {
  private JaugeNaturel jaugeAssis;
  private JaugeNaturel jaugeDebout;
  private Passager[] passagers;
  private int arret;

  /**
   * @param nbAssis nombre maximal de places assises
   * @param nbDebout nombre maximal de places debout
   */
  public Autobus(int nbAssis, int nbDebout) {
    jaugeAssis = new JaugeNaturel(0, nbAssis, 0);
    jaugeDebout = new JaugeNaturel(0, nbDebout, 0);
    passagers = new Passager[nbAssis + nbDebout];
    arret = 0;
  }

  public boolean aPlaceAssise() {
    return !jaugeAssis.estRouge();
  }

  public boolean aPlaceDebout() {
    return !jaugeDebout.estRouge();
  }

  public void demanderPlaceAssise(Passager p) {
    if (aPlaceAssise()) {
      jaugeAssis.incrementer();
      ajouter(p);
      p.accepterPlaceAssise();
    }
  }

  public void demanderPlaceDebout(Passager p) {
    if (aPlaceDebout()) {
      jaugeDebout.incrementer();
      ajouter(p);
      p.accepterPlaceDebout();
    }
  }

  public void demanderChangerEnDebout(Passager p) {
    if (aPlaceDebout()) {
      jaugeAssis.decrementer();
      jaugeDebout.incrementer();
      p.accepterPlaceDebout();
    }
  }

  public void demanderChangerEnAssis(Passager p) {
    if (aPlaceAssise()) {
      jaugeDebout.decrementer();
      jaugeAssis.incrementer();
      p.accepterPlaceAssise();
    }
  }

  public void demanderSortie(Passager p) {
    if (p.estAssis()) {
      jaugeAssis.decrementer();
    } else if (p.estDebout()) {
      jaugeDebout.decrementer();
    }
    for (int i = 0; i < passagers.length; i++) {
      if (passagers[i] == p) {
        passagers[i] = null;
      }
    }
    p.accepterSortie();
  }

  public void allerArretSuivant() throws UsagerInvalideException {
    arret++;
    for (int i = 0; i < passagers.length; i++) {
      if (passagers[i] != null) {
        passagers[i].nouvelArret(this, arret);
      }
    }
  }

  private void ajouter(Passager p) {
    for (int i = 0; i < passagers.length; i++) {
      if (passagers[i] == null) {
        passagers[i] = p;
        return;
      }
    }
  }

  @Override
  public String toString() {
    return "[arret:" + arret + ", assis:" + jaugeAssis.valeur() + ", debout:" + jaugeDebout.valeur() + "]";
  }
}
