package CLASES;

import CLASES.Randomizador.RamdObjeto;

import java.util.Random;

public class Enemigo extends Personaje {
    public Enemigo(String nombre, double HP, double ATK, double DEF, double VEL) {
        super(nombre, HP, ATK, DEF, VEL);
    }

    public void NivelesPersonajes(int nivel) {

        if (nivel % 10 == 0)
        {
            setHP(getHP()*1.2);
            setHPActual(getHPActual()*1.2);
            setATK(getATK()*1.1);
            setDEF(getDEF()*1.1);
            setVEL(getVEL()*1.1);
        }else{
            setHP(getHP()+20);
            setHPActual(getHPActual()+20);
            setATK(getATK()+2);
            setDEF(getDEF()+2);
            setVEL(getVEL()+2);}
    }

    public Objeto Drop(int nivel, Inventario in) {
        Random ran = new Random();
        if (nivel<=20)
        {
            if (nivel %10 == 0 )
            {
                int num = ran.nextInt(5)+3;
                for (int i =0;num > i ;i++)
                {
                    in.agregar(RamdObjeto.generar_objeto_J());
                }
                return null;
            }

            int num = ran.nextInt(3)+1;
            for (int i =0;num > i ;i++)
            {
                in.agregar(RamdObjeto.generar_objeto());
            }
            return null;
        }
        return null;
    }
}
