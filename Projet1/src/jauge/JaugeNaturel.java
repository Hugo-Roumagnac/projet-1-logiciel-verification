package jauge;

public class JaugeNaturel implements IJauge {
    private long valeur;
    private final long min;
    private final long max;

    public JaugeNaturel(long vigieMin, long vigieMax, long depart) {
        this.valeur = depart;
        this.min = vigieMin;
        this.max = vigieMax;
    }

    @Override
    public boolean estRouge() {
        return valeur >= max;
    }

    @Override
    public boolean estVert() {
        return valeur > min && valeur < max;
    }

    @Override
    public boolean estBleu() {
        return valeur <= min;
    }

    @Override
    public void incrementer() {
        valeur++;
    }

    @Override
    public void decrementer() {
        valeur--;
    }

    @Override
    public String toString() {
        return "<" + valeur + " [" + min + "," + max + "]>";
    }
}