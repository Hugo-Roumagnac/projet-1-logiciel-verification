/**
 * Réalisation d'une Jauge avec des entiers naturels.
 * Un objet Jauge définit un niveau et un intervalle ouvert ]vigieMin, vigieMax[.
 * Le niveau d'une jauge n'est pas limité aux valeurs dans l'intervalle.
 *
 * L'état d'une jauge correspond à la position de son niveau par rapport à l'intervalle.
 * Elle définit trois états :
 * - vert : niveau dans l'intervalle,
 * - rouge : niveau supérieur à l'intervalle,
 * - bleu : niveau inférieur à l'intervalle.
 */
public class jaugeNaturel implements IJauge {

    // Attributs stockant l'état de la jauge
    private long valeur;
    private final long min;
    private final long max;

    /**
     * Constructeur permettant d'initialiser l'état de l'instance créée.
     * Son nom correspond toujours au nom de la classe et il n'y a pas de type de retour.
     *
     * @param vigieMin valeur minimale de l'intervalle de vigie.
     * @param vigieMax valeur maximale de l'intervalle de vigie.
     * @param depart   valeur initiale de la jauge.
     */
    public jaugeNaturel(long vigieMin, long vigieMax, long depart) {
        this.valeur = depart;
        this.min = vigieMin;
        this.max = vigieMax;
    }

    /**
     * Vérifie si l'état de la jauge est rouge.
     * @return vrai si le niveau est supérieur ou égal à vigieMax.
     */
    @Override
    public boolean estRouge() {
        return valeur >= max;
    }

    /**
     * Vérifie si l'état de la jauge est vert.
     * @return vrai si le niveau appartient strictement à l'intervalle ]vigieMin, vigieMax[.
     */
    @Override
    public boolean estVert() {
        return valeur > min && valeur < max;
    }

    /**
     * Vérifie si l'état de la jauge est bleu.
     * @return vrai si le niveau est inférieur ou égal à vigieMin.
     */
    @Override
    public boolean estBleu() {
        return valeur <= min;
    }

    /**
     * Incrémente le niveau d'une unité.
     * L'état peut potentiellement devenir supérieur à vigieMax.
     */
    @Override
    public void incrementer() {
        valeur++;
    }

    /**
     * Décrémente le niveau d'une unité.
     * L'état peut potentiellement devenir inférieur à vigieMin.
     */
    @Override
    public void decrementer() {
        valeur--;
    }

    /**
     * Méthode héritée de la classe java.lang.Object, très utile pour le débogage.
     * Elle permet de fournir une chaîne de caractères correspondant à l'état de l'objet.
     *
     * Pour les chaînes de caractères, l'opérateur + sert à la concaténation.
     * Par exemple, si min = -456, max = 23 et valeur = -7,
     * la concaténation produit la chaîne : "<-7 [-456,23]>".
     */
    @Override
    public String toString() {
        return "<" + valeur + " [" + min + "," + max + "]>";
    }
}