package ENUMS;

public enum EtipoDePociones {
    elixir("elexir"),
    grande("Grande"),
    mediana("mediana"),
    chica("chica");

    String nombre;

    EtipoDePociones(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
