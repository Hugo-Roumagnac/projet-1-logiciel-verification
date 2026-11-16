package jauge;

public class JaugeNegatif implements IJauge {
    private final long min;
    private final long max;
    private long valeur;

    public JaugeNegatif(long min, long max, long valeurDepart) {
        this.min = -min;
        this.max = -max;
        this.valeur = -valeurDepart;
    }

    @Override
    public boolean estBleu() {
        return this.valeur >= this.min;
    }

    @Override
    public boolean estVert() {
        return this.valeur < this.min && this.valeur > this.max;
    }

    @Override
    public boolean estRouge() {
        return this.valeur <= this.max;
    }

    @Override
    public void incrementer() {
        this.valeur--;
    }

    @Override
    public void decrementer() {
        this.valeur++;
    }

    @Override
    public String toString() {
        return "<" + (-valeur) + " [" + (-min) + "," + (-max) + "]>";
    }
}