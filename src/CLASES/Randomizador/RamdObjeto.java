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
            tipo = ran.nextInt(5) + 1;
            switch (tipo) {
                case 1: return new PocionVida(chica);
                case 2: return new PocionFuerza(chica);
                case 3: return new PocionVelocidad(chica);
                case 4: return new PocionDefensa(chica);
                case 5: return new PocionSalud(chica);
            }
        }else if (tipo <= 70) {
            tipo = ran.nextInt(5) + 1;
            switch (tipo) {
                case 1: return new PocionVida(mediana);
                case 2: return new PocionFuerza(mediana);
                case 3: return new PocionVelocidad(mediana);
                case 4: return new PocionDefensa(mediana);
                case 5: return new PocionSalud(mediana);
            }
        }else if (tipo <= 95) {
                tipo = ran.nextInt(5) + 1;
                switch (tipo) {
                    case 1: return new PocionVida(grande);
                    case 2: return new PocionFuerza(grande);
                    case 3: return new PocionVelocidad(grande);
                    case 4: return new PocionDefensa(grande);
                    case 5: return new PocionSalud(grande);
                }
            }else {
            tipo = ran.nextInt(5) + 1;
            switch (tipo) {
                case 1: return new PocionVida(elixir);
                case 2: return new PocionFuerza(elixir);
                case 3: return new PocionVelocidad(elixir);
                case 4: return new PocionDefensa(elixir);
                case 5: return new PocionSalud(elixir);
            }
        }
        return null;
    }


    public static Objeto generar_objeto() {
        Random ran = new Random();
        int tipo = ran.nextInt(100) + 1;
        if (tipo <= 70) {
            tipo = ran.nextInt(5) + 1;
            switch (tipo) {
                case 1: return new PocionVida(chica);
                case 2: return new PocionFuerza(chica);
                case 3: return new PocionVelocidad(chica);
                case 4: return new PocionDefensa(chica);
                case 5: return new PocionSalud(chica);
            }
        } else if (tipo <= 80) {
            tipo = ran.nextInt(5) + 1;
            switch (tipo) {
                case 1: return new PocionVida(mediana);
                case 2: return new PocionFuerza(mediana);
                case 3: return new PocionVelocidad(mediana);
                case 4: return new PocionDefensa(mediana);
                case 5: return new PocionSalud(mediana);
            }
        } else{
            tipo = ran.nextInt(5) + 1;
            switch (tipo) {
                case 1: return new PocionVida(grande);
                case 2: return new PocionFuerza(grande);
                case 3: return new PocionVelocidad(grande);
                case 4: return new PocionDefensa(grande);
                case 5: return new PocionSalud(grande);
            }
        }
        return null;
    }
}

