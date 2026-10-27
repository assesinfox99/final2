package CLASES.Randomizador;

import CLASES.Objeto;
import CLASES.Pociones.*;
import java.util.Random;
import static ENUMS.EtipoDePociones.*;

public class RamdObjeto {
    public static Objeto generar_objeto_J()
    {
        Random ran = new Random();
        int tipo = ran.nextInt(100) + 1;
        if (tipo <= 40 ) {
            tipo = ran.nextInt(2) + 1;
            switch (tipo) {
                case 1: return new PocionVida(chica);
                case 2: return new PocionFuerza(chica);
            }
        }else if (tipo <= 70) {
            tipo = ran.nextInt(2) + 1;
            switch (tipo) {
                case 1: return new PocionVida(mediana);
                case 2: return new PocionFuerza(mediana);
            }
        }else if (tipo <= 95) {
                tipo = ran.nextInt(2) + 1;
                switch (tipo) {
                    case 1: return new PocionVida(grande);
                    case 2: return new PocionFuerza(grande);
                }
            }else {
            tipo = ran.nextInt(2) + 1;
            switch (tipo) {
                case 1: return new PocionVida(elixir);
                case 2: return new PocionFuerza(elixir);
            }
        }
        return null;
    }


    public static Objeto generar_objeto() {
        Random ran = new Random();
        int tipo = ran.nextInt(100) + 1;
        if (tipo <= 70) {
            tipo = ran.nextInt(2) + 1;
            switch (tipo) {
                case 1: return new PocionVida(chica);
                case 2: return new PocionFuerza(chica);
            }
        } else if (tipo <= 80) {
            tipo = ran.nextInt(2) + 1;
            switch (tipo) {
                case 1: return new PocionVida(mediana);
                case 2: return new PocionFuerza(mediana);
            }
        } else{
            tipo = ran.nextInt(2) + 1;
            switch (tipo) {
                case 1: return new PocionVida(grande);
                case 2: return new PocionFuerza(grande);
            }
        }
        return null;
    }
}

