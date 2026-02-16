package model;

public class ExceptionListePleine extends Exception {
    public ExceptionListePleine(int capaciteMax){
        super("La liste est pleine. Capacité maximale : " + capaciteMax + " éléments");
    }
}
