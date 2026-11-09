package CLASES;

import ENUMS.Mapas;

import java.util.Random;

import static ENUMS.Mapas.*;


public class SeleccionMapas {

    public static Mapas SeleccionMapas(int nivel)
    {
        if (nivel <= 20)
        {
            return LLANURA;
        }else if (nivel <= 40)
        {
            return BOSQUE;
        }else if (nivel <= 60)
        {
            return CEMENTERIO;
        }else if (nivel <= 80)
        {
            return DECIERTO;
        }else if (nivel < 100)
        {
            return CASTILLO;
        }else if (nivel == 100)
        {
            return VOLCAN;
        }else
            return mapa_aliatorio();
    }
}
