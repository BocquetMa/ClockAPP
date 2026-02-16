package exception;

public class ExceptionMauvaiseMinute extends Exception {
    public ExceptionMauvaiseMinute(int m){
        super("La minute (" + m + ") n'est pas compris entre 0 et 59");
    }
}
