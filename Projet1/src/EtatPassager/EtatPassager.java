package EtatPassager;

public class EtatPassager implements IEtatPassager {
  public enum Etat {
    ASSIS,
    DEBOUT,
    DEHORS
  }

  private final Etat monEtat;

  public EtatPassager(Etat e) {
    monEtat = e;
  }

  @Override
  public boolean estExterieur() {
    return monEtat == Etat.DEHORS;
  }

  @Override
  public boolean estAssis() {
    return monEtat == Etat.ASSIS;
  }

  @Override
  public boolean estDebout() {
    return monEtat == Etat.DEBOUT;
  }

  @Override
  public boolean estInterieur() {
    return monEtat == Etat.ASSIS || monEtat == Etat.DEBOUT;
  }

  @Override
  public String toString() {
    switch (monEtat) {
      case ASSIS:
        return "<assis>";
      case DEBOUT:
        return "<debout>";
      case DEHORS:
        return "<dehors>";
      default:
        return "<inconnu>";
    }
  }
}