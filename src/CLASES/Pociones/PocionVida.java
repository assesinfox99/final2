package CLASES.Pociones;

import ENUMS.EtipoDePociones;

public class PocionVida extends Pocion {

    public PocionVida(EtipoDePociones TIPO) {
        super("Pocion de salud " + TIPO.getNombre() ,"una pocion creada para la recuperacion rapida de salud", TIPO);
    }

    @Override
    public double usarPocion() {
        if (this.getTIPO().equals(EtipoDePociones.grande)){return 150;}
        else if (this.getTIPO().equals(EtipoDePociones.mediana)){return 100;}
        else if (this.getTIPO().equals(EtipoDePociones.chica)){return 50;}
        else if (this.getTIPO().equals(EtipoDePociones.elixir)){return 9999999;}
        return 0;
    }

}
