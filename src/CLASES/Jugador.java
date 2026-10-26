package CLASES;

import INTERFACES.IusarObjeto;

public class Jugador extends Personajes implements IusarObjeto {
    private Inventario inventario;

    public Jugador(String nombre) {
        super(nombre,100,15,10,10);
        this.inventario = new Inventario();
    }

    public Inventario getInventario() {
        return inventario;
    }

    @Override
    public void usarobjeto(Objeto objeto) {

        if (objeto instanceof pociones)
        {
            double num = ((pociones) objeto).usarPocion() + getHPActual();
            if (num > getHP())
            {setHPActual(getHP());}
            else {setHPActual(num);}
        }
        inventario.eliminar(objeto);
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
