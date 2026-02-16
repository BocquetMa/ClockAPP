package model;

public class ExceptionListeVide extends Exception {
    public ExceptionListeVide(){
        super("la liste est vide. Impossible d'effectuer cette opération");
    }
}
