package exception;

public class ExceptionMauvaisIndex extends Exception {
    public ExceptionMauvaisIndex(int index, int tailleMax) {

      super("L'index (" + index + ") n'est pas compris entre 0 et " + (tailleMax - 1) + " inclus");

    }
}
