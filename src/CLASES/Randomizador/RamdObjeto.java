package CLASES.Randomizador;

import CLASES.Objeto;
import CLASES.Pociones.*;
import ENUMS.EtipoDePociones;

import java.util.Random;
import static ENUMS.EtipoDePociones.*;

public class RamdObjeto {
    public static Objeto generar_objeto_J()
    {
        Random ran = new Random();
        int probabilidad = ran.nextInt(100) + 1;

        EtipoDePociones tam;

        if (probabilidad <= 40) {
            tam = chica;
        } else if (probabilidad <= 70) {
            tam = mediana;
        } else if (probabilidad <= 95) {
            tam = grande;
        } else {
            tam = elixir;
        }

        int tipo = ran.nextInt(5) + 1;

        return switch (tipo) {
            case 1 -> new PocionRecuperacion(tam);
            case 2 -> new PocionFuerza(tam);
            case 3 -> new PocionVelocidad(tam);
            case 4 -> new PocionDefensa(tam);
            case 5 -> new PocionSalud(tam);
            default -> new PocionRecuperacion(tam);
        };
    }


    public static Objeto generar_objeto() {
        Random ran = new Random();
        int probabilidad = ran.nextInt(100) + 1;

        EtipoDePociones tam = null;

        if (probabilidad <= 70) {
            tam = chica;
        } else if (probabilidad <= 80) {
            tam = mediana;
        } else if (probabilidad <= 95) {
            tam = grande;
        }

        int tipo = ran.nextInt(5) + 1;

        return switch (tipo) {
            case 1 -> new PocionRecuperacion(tam);
            case 2 -> new PocionFuerza(tam);
            case 3 -> new PocionVelocidad(tam);
            case 4 -> new PocionDefensa(tam);
            case 5 -> new PocionSalud(tam);
            default -> new PocionRecuperacion(tam);
        };
    }
}

