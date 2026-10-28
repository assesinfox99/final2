package CLASES.Pociones;

import CLASES.Jugador;
import ENUMS.EtipoDePociones;

public class PocionVida extends Pocion {

    public PocionVida(EtipoDePociones TIPO) {
        super("Pocion de salud " + TIPO.getNombre(), "una pocion creada para la recuperacion rapida de salud", TIPO);
    }

    @Override
    public String usar(Jugador A) {

        if (A.getHPActual() >= A.getHP()) {
            return "La vida está al máximo.";
        }
        int curacion = 0;

        switch (this.getTIPO()) {

            case chica:
                curacion = 50;
                break;

            case mediana:
                curacion = 100;
                break;

            case grande:
                curacion = 150;
                break;

            case elixir:
                A.setHPActual(A.getHP());
                return "vida curada al maximo";
        }

        if (A.getHPActual() < A.getHP()) {
            A.setHPActual(
                    Math.min(
                            A.getHPActual() + curacion,
                            A.getHP()
                    )
            );
        }
        return "Te has curado " + curacion + " puntos de salud";
    }
}
