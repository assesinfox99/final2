package EXEPCIONES;

public class ListaVaciaException extends RuntimeException {
    public ListaVaciaException(String message) {
        super("La lista se encuentra vacia. ");
    }
}
