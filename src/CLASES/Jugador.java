package CLASES;

import CLASES.Pociones.Pocion;
import CLASES.Pociones.PocionFuerza;
import CLASES.Pociones.PocionVida;

public class Jugador extends Personaje {
    private Inventario inventario;

    public Jugador(String nombre) {
        super(nombre,100,200,10,2000);
        this.inventario = new Inventario();
    }

    public Inventario getInventario() {
        return inventario;
    }

    public String UsarObjeto(Objeto objeto) {

        String resultado = objeto.usar(this);

        if (!resultado.equals("La vida está al máximo.")) {
            inventario.eliminar(objeto);
        }

        return resultado;
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
