package CLASES;

import ENUMS.EtipoDePociones;

public abstract class Pocion extends Objeto {
    EtipoDePociones TIPO;
    public Pocion(String nombre, String descripcion,EtipoDePociones TIPO) {
        super(nombre, descripcion);
        this.TIPO = TIPO;
    }
    public EtipoDePociones getTIPO() {
        return TIPO;
    }

    public void setTIPO(EtipoDePociones TIPO) {
        this.TIPO = TIPO;
    }

    public abstract double usarPocion();

}
