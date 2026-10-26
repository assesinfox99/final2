package CLASES;

import INTERFACES.IDrops;

public class Enemigo extends Personaje implements IDrops {
    public Enemigo(String nombre, double HP, double ATK, double DEF, double VEL) {
        super(nombre, HP, ATK, DEF, VEL);
    }
    public void NivelesPersonajes(int nivel) {

        if (nivel % 10 == 0)
        {
            setHP(getHP()*1.6);
            setHPActual(getHPActual()*1.6);
            setATK(getATK()*1.2);
            setDEF(getDEF()*1.2);
            setVEL(getVEL()*1.2);
        }else{
            setHP(getHP()*1.05);
            setHPActual(getHPActual()*1.05);
            setATK(getATK()*1.03);
            setDEF(getDEF()*1.03);
            setVEL(getVEL()*1.03);}
    }

    @Override
    public Objeto Drop() {
        return null;
    }
}
