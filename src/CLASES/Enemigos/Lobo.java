package CLASES.Enemigos;

import ENUMS.EtipoDePociones;
import classs.Enemigos;
import classs.Objeto;
import classs.PocionVida;
import enum.EtipoDePociones;

import java.util.Random;

public class Lobo extends Enemigos {


    public Lobo() {
        super("Lobo Gris", 35, 15, 10, 20);
    }


    @Override
    public Objeto Drop() {
        Random rand = new Random();
        int tipo = rand.nextInt(100) + 1;
        if (tipo <= 85 ){return new PocionVida(EtipoDePociones.chica);}
        else {return new PocionVida(EtipoDePociones.mediana);}
    }
}