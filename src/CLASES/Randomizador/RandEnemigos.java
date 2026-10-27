package CLASES.Randomizador;

import CLASES.Enemigo;

import java.util.Random;

import static ENUMS.TipoEnemigo.*;

public class RandEnemigos {
    public static Enemigo generarEnemigo(int nivel) {
        if (nivel % 10 == 0) {
            return LOBO_J.crearEnemigo();
        } else {
            Random rand = new Random();
            int tipo = rand.nextInt(2) + 1;
            switch (tipo) {
                case 2: return ESQUELETO.crearEnemigo();
                default: return LOBO.crearEnemigo();
            }
        }
    }
}
