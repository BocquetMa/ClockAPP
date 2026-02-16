package model;

public class ExceptionIndexInvalide extends Exception {
    public ExceptionIndexInvalide(int index, int tailleMax){
        super("L'index (" + index + ") n'est pas valide. Il doit etre compris entre 0 et " + (tailleMax - 1));
    }
}
