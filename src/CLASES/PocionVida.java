package CLASES;

import ENUMS.EtipoDePociones;

public class PocionVida extends Pocion{
    private static int IDpocion = 25;
    public PocionVida(EtipoDePociones TIPO) {
        super("Pocion de salud " + TIPO.getNombre() ,"una pocion creada para la recuperacion rapida de salud", TIPO);
    }

    public static int getIDpocion() {
        return IDpocion;
    }

    public static void setIDpocion(int IDpocion) {
        PocionVida.IDpocion = IDpocion;
    }

    @Override
    public double usarPocion() {

        if (this.getTIPO().equals(EtipoDePociones.grande)){return 150;}
        else if (this.getTIPO().equals(EtipoDePociones.mediana)){return 100;}
        else if (this.getTIPO().equals(EtipoDePociones.chica)){return 50;}
        else if (this.getTIPO().equals(EtipoDePociones.elixir)){return 9999999;}
        return 0;
    }

}
