package model;

public class ListeTableau<Chose> implements Liste<Chose> {

    private Object contenu[];
    private int nbElem;

    public ListeTableau(int NbMaxDElements){
        contenu = new Object[NbMaxDElements];
        nbElem = 0;

    }

    @Override
    public boolean estVide() {
        return nbElem == 0;
    }

    @Override
    public int taille() {
        return nbElem;
    }

    @Override
    public void ajoute(Chose valeur) throws ExceptionListePleine{
        if (nbElem >= contenu.length){
            throw new ExceptionListePleine(contenu.length);
        }
        contenu[nbElem++] = valeur; // équivaut à contenu[nbElem] = valeur; nbElem+=1;
        //ou alors contenu[++nbElem] = valeur; // équivaut à nbElem += 1 ; contenu[nbElem] = valeur;
    }

    @Override
    public void retire(int index) throws ExceptionIndexInvalide, ExceptionListeVide{
        if (estVide()){
            throw new ExceptionListeVide();
        }
        if (index < 0 || index >= nbElem){
            throw new ExceptionIndexInvalide(index, nbElem);
        }
        int indexActuel, ancienIndex;
        for(ancienIndex = (indexActuel = index) + 1; ancienIndex < nbElem; ancienIndex++, indexActuel++){
            contenu[indexActuel] = contenu[ancienIndex];
        }
        nbElem--;
    }

    @Override
    public Chose element(int index) throws ExceptionIndexInvalide, ExceptionListeVide {
        if (estVide()){
            throw new ExceptionListeVide();
        }
        if (index < 0 || index >= nbElem){
            throw new ExceptionIndexInvalide(index, nbElem);
        }
        return (Chose)contenu[index];
    }

    @Override
    public boolean contient(Chose valeur) {
        for (int index = 0; index < nbElem; index++){
            if (contenu[index] == valeur) return true;
        }
        return false;
    }
}
