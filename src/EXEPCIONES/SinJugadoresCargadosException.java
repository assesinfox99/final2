package EXEPCIONES;

public class SinJugadoresCargadosException extends Exception {
    public SinJugadoresCargadosException(String message) {
        super("La lista se encuentra vacia. ");
    }
}
