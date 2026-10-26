package CLASES;

import java.util.Objects;
import java.util.UUID;

public class Objeto {

    private UUID ID;
    private String nombre;
    private String descripcion;

    public Objeto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ID = UUID.randomUUID();
    }

    public UUID getID() {
        return ID;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return
                "nombre: " + nombre +
                        "\n" + descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Objeto objeto)) return false;
        return Objects.equals(nombre, objeto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
