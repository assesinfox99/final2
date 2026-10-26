package CLASES.Enemigos;

import CLASES.Enemigo;
import CLASES.Objeto;
import CLASES.PocionVida;
import ENUMS.EtipoDePociones;

import java.util.Random;

public class Esqueleto extends Enemigo {
    public Esqueleto() {
        super("Esqueleto", 75, 12, 5, 11);
    }

    @Override
    public Objeto Drop() {
        Random rand = new Random();
        int tipo = rand.nextInt(100) + 1;
        if (tipo <= 60){return new PocionVida(EtipoDePociones.chica);}
        else if (tipo <= 80) {return new PocionVida(EtipoDePociones.mediana);}
        else {return new PocionVida(EtipoDePociones.grande);}
    }
}
