package EtatPassager;

public class EtatPassagerChaine implements IEtatPassager {
    private final String monEtat;

    public EtatPassagerChaine(String etat) {
        this.monEtat = etat;
    }

    @Override
    public boolean estExterieur() {
        return "dehors".equals(this.monEtat);
    }

    @Override
    public boolean estAssis() {
        return "assis".equals(this.monEtat);
    }

    @Override
    public boolean estDebout() {
        return "debout".equals(this.monEtat);
    }

    @Override
    public boolean estInterieur() {
        return estAssis() || estDebout();
    }

    @Override
    public String toString() {
        return "<" + monEtat + ">";
    }
}