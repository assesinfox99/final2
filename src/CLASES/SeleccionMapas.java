package CLASES;

import ENUMS.Mapas;

import java.util.Random;

import static ENUMS.Mapas.*;


public class SeleccionMapas {

    public static Mapas SeleccionMapas(int nivel)
    {
        if (nivel <= 20)
        {
            return BOSQUE;
        }else if (nivel <= 40)
        {
            return CEMENTERIO;
        }else if (nivel <= 60)
        {
            return BOSQUE;
        }else if (nivel <= 80)
        {
            return BOSQUE;
        }else if (nivel <= 100)
        {
            return BOSQUE;
        }else
            return mapa_aliatorio();
    }
}
