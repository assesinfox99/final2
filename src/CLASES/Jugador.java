package CLASES;

import CLASES.Pociones.Pocion;
import CLASES.Pociones.PocionFuerza;
import CLASES.Pociones.PocionVida;

public class Jugador extends Personaje {
    private Inventario inventario;

    public Jugador(String nombre) {
        super(nombre,100,10,10,2000);
        this.inventario = new Inventario();
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void UsarObjeto(Objeto objeto) {
        if (objeto instanceof Pocion)
        {
            double num = ((Pocion) objeto).usarPocion() + getHPActual();
            if (num > getHP())
            {setHPActual(getHP());}
            else {setHPActual(num);}
        }

    }

    public String UsarObjeto(PocionVida p){
        if (getHPActual() < getHP()){
            if (getHPActual() + p.usarPocion() < getHP()){
            setHPActual(getHPActual() + p.usarPocion());
            }else setHPActual(getHP());
            inventario.eliminar(p);
            return "Se uso la pocion. ";
        }
        return "La vida esta al maximo.";
    }

    public String UsarObjeto(PocionFuerza p){
        setATK(getATK() + p.usarPocion());
        inventario.eliminar(p);
        return "Se mejoro la fuerza en: " + p.usarPocion();
    }


    @Override
    public void NivelesPersonajes() {
        setHP(getHP()*1.06);
        setHPActual(getHPActual()*1.06);
        setATK(getATK()*1.02);
        setDEF(getDEF()*1.02);
        setVEL(getVEL()*1.02);
    }

}
