package tec;

/**
 * Passager qui cherche d'abord une place assise, sinon une place debout,
 * et qui sort a son arret de destination.
 */
public class PassagerStandard implements Usager, Passager {
  private final String nom;
  private final int destination;
  private EtatPassager etat;

  /**
   * @param nom nom du passager
   * @param destination arret de destination
   */
  public PassagerStandard(String nom, int destination) {
    this.nom = nom;
    this.destination = destination;
    etat = new EtatPassager(EtatPassager.Etat.DEHORS);
  }

  public String nom() {
    return nom;
  }

  public boolean estDehors() {
    return etat.estExterieur();
  }

  public boolean estAssis() {
    return etat.estAssis();
  }

  public boolean estDebout() {
    return etat.estDebout();
  }

  public void accepterSortie() {
    etat = new EtatPassager(EtatPassager.Etat.DEHORS);
  }

  public void accepterPlaceAssise() {
    etat = new EtatPassager(EtatPassager.Etat.ASSIS);
  }

  public void accepterPlaceDebout() {
    etat = new EtatPassager(EtatPassager.Etat.DEBOUT);
  }

  public void nouvelArret(Bus bus, int numeroArret) {
    if (numeroArret == destination) {
      bus.demanderSortie(this);
    }
  }

  public void monterDans(Transport t) throws UsagerInvalideException {
    Bus b = (Bus) t;
    b.demanderPlaceAssise(this);
    if (estDehors()) {
      b.demanderPlaceDebout(this);
    }
  }

  @Override
  public String toString() {
    String s = nom + " ";
    if (estAssis()) {
      s = s + "assis";
    } else if (estDebout()) {
      s = s + "debout";
    } else {
      s = s + "dehors";
    }
    return s;
  }
}
