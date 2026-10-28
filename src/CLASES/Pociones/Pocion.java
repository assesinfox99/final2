package CLASES.Pociones;

import CLASES.Jugador;
import CLASES.Objeto;
import ENUMS.EtipoDePociones;

public abstract class Pocion extends Objeto {
    private EtipoDePociones TIPO;
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

}
