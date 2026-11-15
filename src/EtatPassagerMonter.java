/**
 * Variante simplifiée où l'on s'intéresse uniquement au fait d'être monté ou non.
 */
public class EtatPassagerMonter implements IEtatPassager {
    private boolean estMonte;

    public EtatPassagerMonter(boolean estMonte) {
        this.estMonte = estMonte;
    }

    @Override
    public boolean estExterieur() {
        return !this.estMonte;
    }

    @Override
    public boolean estAssis() {
        return this.estMonte;
    }

    @Override
    public boolean estDebout() {
        return false;
    }

    @Override
    public boolean estInterieur() {
        return this.estMonte;
    }
}