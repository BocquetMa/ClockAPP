package model;

public interface Liste<Chose> {
    boolean estVide();
    int taill();
    void ajoute(Chose valeur);
    void retire(int index);
    Chose element(int index);
    boolean contient(int valeur);
}
