package CLASES.Enemigos;

import CLASES.Enemigo;
import ENUMS.EtipoDePociones;
import CLASES.Objeto;
import classs.PocionVida;

import java.util.Random;

public class Lobo_J extends Enemigo {

    public Lobo_J() {
        super("Lobo Gris Alfa", 60, 25, 15, 50);
    }

    @Override
    public Objeto Drop() {
        Random rand = new Random();
        int tipo = rand.nextInt(100) + 1;
        if (tipo <= 40 ){return new PocionVida(EtipoDePociones.chica);}
        else if (tipo <= 70) {return new PocionVida(EtipoDePociones.mediana);}
        else if (tipo <= 95) {return new PocionVida(EtipoDePociones.grande);}
        else {return new PocionVida(EtipoDePociones.elixir);}
    }
}