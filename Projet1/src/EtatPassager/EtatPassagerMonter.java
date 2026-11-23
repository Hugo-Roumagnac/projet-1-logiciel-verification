package EtatPassager;

public class EtatPassagerMonter implements IEtatPassager {
    private final boolean estAssis;

    public EtatPassagerMonter(boolean estAssis) {
        this.estAssis = estAssis;
    }

    @Override
    public boolean estExterieur() {
        return false;
    }

    @Override
    public boolean estAssis() {
        return this.estAssis;
    }

    @Override
    public boolean estDebout() {
        return !this.estAssis;
    }

    @Override
    public boolean estInterieur() {
        return true;
    }

    @Override
    public String toString() {
        return estAssis ? "<assis>" : "<debout>";
    }
}