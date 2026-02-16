package exception;

public class ExceptionMauvaisNombreDElements extends Exception {
  public ExceptionMauvaisNombreDElements(int nombre){
    super("Le nombre d'éléments (" + nombre + ") n'est pas supérieur à 0 !");
  }
}
