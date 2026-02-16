package model;

public class ExceptionMauvaiseHeure extends Exception {
    public ExceptionMauvaiseHeure(int h){
        super("L'heure (" + h + ") n'est pas compris entre 0 et 23");
    }
}
