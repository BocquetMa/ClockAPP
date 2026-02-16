package exception;

public class ExceptionListeTableauPleine extends Exception {
    public ExceptionListeTableauPleine(){
        super("La liste ne contient plus aucun emplacement disponible !");
    }
}
