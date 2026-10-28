package CLASES.Pociones;

import CLASES.Jugador;
import ENUMS.EtipoDePociones;

public class PocionFuerza extends Pocion {
    public PocionFuerza(EtipoDePociones TIPO) {
        super("Pocion de Fuerza" + TIPO.getNombre(), "Una pocion que aumenta la fuerza", TIPO);
    }
    @Override
    public String usar(Jugador A) {

        int aumento = 0;

        switch (this.getTIPO()) {

            case chica:
                aumento = 10;
                break;

            case mediana:
                aumento = 15;
                break;

            case grande:
                aumento = 20;
                break;

            case elixir:
                aumento = 30;
                break;
        }
        A.setATK(A.getATK()+aumento);
        return "tu ataque  aumento en " + aumento + " puntos";
    }

}
