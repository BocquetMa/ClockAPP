package model;

import exception.ExceptionListeTableauPleine;
import exception.ExceptionMauvaisIndex;
import exception.ExceptionMauvaisNombreDElements;

public class ListeTableau<Chose> implements Liste<Chose> {

    private Object contenu[];
    private int nbElem;

    /**
     * Construction d une liste vide ListeTableau avec un nombre d elements maximum
     * @param  NbMaxDElements la capacite maximale de la liste (doit etre > 0)
     * @throws ExceptionMauvaisNombreDElements verifie si la capacite demandee est inferieure ou egale a 0
     */
    public ListeTableau(int NbMaxDElements) throws ExceptionMauvaisNombreDElements{
        if(NbMaxDElements <= 0){
            throw new ExceptionMauvaisNombreDElements(NbMaxDElements);
        }
        contenu = new Object[NbMaxDElements];
        nbElem = 0;
    }

    /**
     * Permet de verifier si la liste est vide
     * @return true si la liste est vide, sinon false
     */
    @Override
    public boolean estVide() {
        return nbElem == 0;
    }

    /**
     * Permet de donner le nombre actuelle d elements dans la liste
     * @return la taille actuelle de la liste
     */
    @Override
    public int taille() {
        return nbElem;
    }

    /**
     * Ajoute un element a la fin de la liste
     * @param valeur l element de type Chose a ajouter
     * @throws ExceptionListeTableauPleine verifie si la capacite maximale du tableau est atteinte
     */
    @Override
    public void ajoute(Chose valeur) throws ExceptionListeTableauPleine {
        if (nbElem >= contenu.length){
            throw new ExceptionListeTableauPleine();
        }
        contenu[nbElem++] = valeur; // équivaut à contenu[nbElem] = valeur; nbElem+=1;
        //ou alors contenu[++nbElem] = valeur; // équivaut à nbElem += 1 ; contenu[nbElem] = valeur;
    }

    /**
     * Permet de supprimer l element situe a l index et decale les elements suivants vers la gauche
     * @param index la position de l element a retirer (doit etre entre 0 et taille - 1)
     * @throws ExceptionMauvaisIndex verifie si l'index est hors des limites de la liste
     */
    @Override
    public void retire(int index) throws ExceptionMauvaisIndex {
        if(index < 0 || index >= nbElem){
            throw new ExceptionMauvaisIndex(index, nbElem);
        }
        int indexActuel, ancienIndex;
        for(ancienIndex = (indexActuel = index) + 1; ancienIndex < nbElem; ancienIndex++, indexActuel++){
            contenu[indexActuel] = contenu[ancienIndex];
        }
        nbElem--;
    }

    /**
     * Permet de recuperer l element situe a l index specifie
     * @param index soit la position de l element a recuperer
     * @return l element de type Chose a cet index
     * @throws ExceptionMauvaisIndex verifie si l index fourni n est pas valide
     */
    @Override
    public Chose element(int index) throws ExceptionMauvaisIndex{
        if(index < 0 || index >= nbElem){
            throw new ExceptionMauvaisIndex(index, nbElem);
        }
        return (Chose)contenu[index];
    }

    /**
     * Permet de rechercher si un element specifique est present dans la liste
     * @param valeur soit l element dont on cherche la presence
     * @return true si l element est trouve, false sinon
     */
    @Override
    public boolean contient(Chose valeur) {
        for (int index = 0; index < nbElem; index++){
            if (contenu[index] == valeur) return true;
        }
        return false;
    }
}
