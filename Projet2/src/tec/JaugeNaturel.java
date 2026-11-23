package tec;

class JaugeNaturel {
  private long valeur;
  private final long min;
  private final long max;

  public JaugeNaturel(long vigieMin, long vigieMax, long depart) {
    this.valeur = depart;
    this.min = vigieMin;
    this.max = vigieMax;
  }

  public boolean estRouge() {
    return valeur >= max;
  }

  public boolean estVert() {
    return valeur > min && valeur < max;
  }

  public boolean estBleu() {
    return valeur <= min;
  }

  public void incrementer() {
    valeur++;
  }

  public void decrementer() {
    valeur--;
  }

  public long valeur() {
    return valeur;
  }

  @Override
  public String toString() {
    return "<" + valeur + " [" + min + "," + max + "]>";
  }
}
