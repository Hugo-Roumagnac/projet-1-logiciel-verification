/**
 * Variante où l'état du passager est représenté par une simple chaîne de caractères.
 */
public class EtatPassagerChaine implements IEtatPassager {
    private String sonEtat;

    public EtatPassagerChaine(String etat) {
        this.sonEtat = etat;
    }

    @Override
    public boolean estExterieur() {
        return "dehors".equals(this.sonEtat);
    }

    @Override
    public boolean estAssis() {
        return "assis".equals(this.sonEtat);
    }

    @Override
    public boolean estDebout() {
        return "debout".equals(this.sonEtat);
    }

    @Override
    public boolean estInterieur() {
        return estAssis() || estDebout();
    }
}