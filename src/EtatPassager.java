/**
 * Représente l'état d'un passager à l'aide d'une énumération interne.
 */
public class EtatPassager implements IEtatPassager {

    // Définition de l'énumération directement à l'intérieur de la classe
    public enum Etat {
        Dehors,
        Assis,
        Debout
    }

    private Etat sonEtat;

    public EtatPassager(Etat e) {
        this.sonEtat = e;
    }

    @Override
    public boolean estExterieur() {
        return this.sonEtat == Etat.Dehors;
    }

    @Override
    public boolean estAssis() {
        return this.sonEtat == Etat.Assis;
    }

    @Override
    public boolean estDebout() {
        return this.sonEtat == Etat.Debout;
    }

    @Override
    public boolean estInterieur() {
        return this.sonEtat == Etat.Assis || this.sonEtat == Etat.Debout;
    }
}