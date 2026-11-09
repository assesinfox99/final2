package EXEPCIONES;

public class Opcion_invalida extends RuntimeException {
    public Opcion_invalida(String message) {
        super(message);
    }
}
