package model;

public class ListeTableau<Chose> implements Liste<Chose> {

    @Override
    public boolean estVide() {
        return false;
    }

    @Override
    public int taill() {
        return 0;
    }

    @Override
    public void ajoute(Chose valeur) {

    }

    @Override
    public void retire(int index) {

    }

    @Override
    public Chose element(int index) {
        return null;
    }

    @Override
    public boolean contient(int valeur) {
        return false;
    }
}
