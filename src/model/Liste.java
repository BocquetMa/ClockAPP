package model;

public interface Liste<Chose> {
    boolean estVide();
    int taille();
    void ajoute(Chose valeur);
    void retire(int index);
    Chose element(int index);
    boolean contient(int valeur);
}
