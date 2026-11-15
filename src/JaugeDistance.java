/**
 * Jauge optimisée qui ne stocke que les distances séparant la position courante
 * des deux vigies (min et max).
 */
public class JaugeDistance implements IJauge {
    private long distanceMin;
    private long distanceMax;

    public JaugeDistance(long min, long max, long valeurDepart) {
        this.distanceMin = valeurDepart - min;
        this.distanceMax = max - valeurDepart;
    }

    @Override
    public boolean estBleu() {
        return this.distanceMin < 0;
    }

    @Override
    public boolean estVert() {
        return this.distanceMin >= 0 && this.distanceMax >= 0;
    }

    @Override
    public boolean estRouge() {
        return this.distanceMax < 0;
    }

    @Override
    public void incrementer() {
        this.distanceMin++;
        this.distanceMax--;
    }

    @Override
    public void decrementer() {
        this.distanceMin--;
        this.distanceMax++;
    }
}