package CLASES.Pociones;

import CLASES.Jugador;
import ENUMS.EtipoDePociones;

public class PocionDefensa extends Pocion{

    public PocionDefensa(EtipoDePociones TIPO) {
        super("pocion de recistencia " + TIPO.getNombre(), "pocion que aumenta tu defensa ", TIPO);
    }

    @Override
    public String usar(Jugador A) {

        int aumento = 0;

        switch (this.getTIPO()) {

            case chica:
                aumento = 2;
                break;

            case mediana:
                aumento = 4;
                break;

            case grande:
                aumento = 6;
                break;

            case elixir:
                aumento = 10;
                break;
        }
        A.setDEF(A.getDEF()+aumento);
        return "tu defensa aumento en " + aumento + " puntos";
    }


}
