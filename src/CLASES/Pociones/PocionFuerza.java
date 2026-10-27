package CLASES.Pociones;

import ENUMS.EtipoDePociones;

public class PocionFuerza extends Pocion {
    public PocionFuerza(EtipoDePociones TIPO) {
        super("Pocion de Fuerza" + TIPO.getNombre(), "Una pocion que aumenta la fuerza", TIPO);
    }

    @Override
    public double usarPocion() {
        if (this.getTIPO().equals(EtipoDePociones.grande)){return 25;}
        else if (this.getTIPO().equals(EtipoDePociones.mediana)){return 20;}
        else if (this.getTIPO().equals(EtipoDePociones.chica)){return 15;}
        else if (this.getTIPO().equals(EtipoDePociones.elixir)){return 40;}
        return 0;
    }


}
