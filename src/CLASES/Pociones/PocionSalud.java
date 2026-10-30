package CLASES.Pociones;

import CLASES.Jugador;
import ENUMS.EtipoDePociones;

public class PocionSalud extends Pocion{

    public PocionSalud(EtipoDePociones TIPO) {
        super("pocion de salud " + TIPO.getNombre(), "pocion que aumenta tu cantidad de vida ", TIPO);
    }

    @Override
    public String usar(Jugador A) {

        int aumento = 0;

        switch (this.getTIPO()) {

            case chica:
                aumento = 15;
                break;

            case mediana:
                aumento = 30;
                break;

            case grande:
                aumento = 50;
                break;

            case elixir:
                aumento = 100;
                break;
        }
        A.setHP(A.getHP()+aumento);
        A.setHPActual(A.getHPActual()+aumento);
        return "tu vida aumento en " + aumento + " puntos";
    }
}
