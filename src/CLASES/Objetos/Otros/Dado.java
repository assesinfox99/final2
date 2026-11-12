package CLASES.Objetos.Otros;

import CLASES.Jugador;
import CLASES.Objetos.Objeto;

import java.util.Random;

public class Dado extends Objeto {


    public Dado() {
        super("dado de 6 caras?", "un dado de la suerte, nunca se sabe si te mata o ganas");
    }


    @Override
    public String usar(Jugador A){
        Random ran = new Random();
        int probabilidad = ran.nextInt(6) + 1;
        switch (probabilidad)
        {
            case 1 : {
                A.setDEF(A.getDEF()+100);
                A.setATK(A.getATK()+100);
                A.setHP(A.getHP()+100);
                A.setHPActual(A.getHPActual()+100);
                A.setVEL(A.getVEL()+100);
            return "La suerte te sorrie, tus estadisticas aumentaron en 100!!";
        }
            case 2 :
                return"A123:AUMENTO_ENEMIGO";
            case 3 :return"No paso nada";
            case 4 :
                A.setHPActual(0);
                return"creo que le caiste mal al dado ";
            case 5 : return"A123:SE_MURIO";
            case 6 : return"A123:DROP";
        }
        return "";
    }

}
