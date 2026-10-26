package CLASES;

import CLASES.Enemigos.Esqueleto;
import CLASES.Enemigos.Lobo;
import CLASES.Enemigos.Lobo_J;
import ENUMS.Enemigos;

import java.util.Random;

import static ENUMS.Enemigos.*;

public class RandEnemigos {
    public static Enemigo generarEnemigo(int nivel) {
        if (nivel % 10 == 0) {
            return new Lobo_J();
        } else {
            Random rand = new Random();
            int tipo = rand.nextInt(2) + 1;
            switch (tipo) {
                case 1: return LOBO.crearEnemigo();
                case 2: return ESQUELETO.crearEnemigo();
                default: return LOBO_J.crearEnemigo();
            }
        }
    }
}
