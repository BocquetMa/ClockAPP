package model;

public interface Liste<Chose> {
    boolean estVide();
    int taille();
    void ajoute(Chose valeur) throws ExceptionListePleine;
    void retire(int index) throws ExceptionIndexInvalide, ExceptionListeVide;
    Chose element(int index) throws ExceptionIndexInvalide, ExceptionListeVide;
    boolean contient(Chose valeur);
}
