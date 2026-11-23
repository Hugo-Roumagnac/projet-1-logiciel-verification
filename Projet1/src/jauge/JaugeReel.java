package jauge;

public class JaugeReel implements IJauge {
    private final float min;
    private final float max;
    private float valeur;

    public JaugeReel(long min, long max, long valeurDepart) {
        this.min = (float) min / 1000.0f;
        this.max = (float) max / 1000.0f;
        this.valeur = (float) valeurDepart / 1000.0f;
    }

    @Override
    public boolean estBleu() {
        return this.valeur <= this.min;
    }

    @Override
    public boolean estVert() {
        return this.valeur > this.min && this.valeur < this.max;
    }

    @Override
    public boolean estRouge() {
        return this.valeur >= this.max;
    }

    @Override
    public void incrementer() {
        this.valeur += 0.001f;
    }

    @Override
    public void decrementer() {
        this.valeur -= 0.001f;
    }

    @Override
    public String toString() {
        return "<" + valeur + " [" + min + "," + max + "]>";
    }
}