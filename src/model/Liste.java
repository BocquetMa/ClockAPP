package model;

import exception.ExceptionListeTableauPleine;
import exception.ExceptionMauvaisIndex;

public interface Liste<Chose> {
    boolean estVide();
    int taille();
    void ajoute(Chose valeur) throws ExceptionListeTableauPleine;
    void retire(int index) throws ExceptionMauvaisIndex;
    Chose element(int index) throws ExceptionMauvaisIndex;
    boolean contient(Chose valeur);
}
