public class JaugeNegatif implements IJauge {
    private long min;
    private long max;
    private long valeur;

    public JaugeNegatif(long min, long max, long valeurDepart) {
        this.min = -min;
        this.max = -max;
        this.valeur = -valeurDepart;
    }

    public boolean estBleu() {
        return this.valeur > this.min;
    }

    public boolean estVert() {
        return this.valeur <= this.min && this.valeur >= this.max;
    }

    public boolean estRouge() {
        return this.valeur < this.max;
    }

    public void incrementer() {
        this.valeur--;
    }

    public void decrementer() {
        this.valeur++;
    }
}