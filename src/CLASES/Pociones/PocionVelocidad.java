package CLASES.Pociones;

import CLASES.Jugador;
import ENUMS.EtipoDePociones;

public class PocionVelocidad extends Pocion{

    public PocionVelocidad(EtipoDePociones TIPO) {
        super("pocion de velocidad " + TIPO.getNombre(), "pocion que aumenta tu velocidad ", TIPO);
    }

    @Override
    public String usar(Jugador A) {

        int aumento = 0;

        switch (this.getTIPO()) {

            case chica:
                aumento = 5;
                break;

            case mediana:
                aumento = 10;
                break;

            case grande:
                aumento = 15;
                break;

            case elixir:
                aumento = 25;
                break;
        }
        A.setVEL(A.getVEL()+aumento);
        return "tu velocidad aumento en " + aumento + " puntos";
    }

}
