public interface IJauge {
    boolean estBleu();
    boolean estVert();
    boolean estRouge();
    void incrementer();
    void decrementer();
}