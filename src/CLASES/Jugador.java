package CLASES;

public class Jugador extends Personaje {
    private Inventario inventario;

    public Jugador(String nombre) {
        super(nombre,100,200,10,2000);
        this.inventario = new Inventario();
    }

    public Inventario getInventario() {
        return inventario;
    }

    @Override
    public void UsarObjeto(Objeto objeto) {
        if (objeto instanceof Pocion)
        {
            double num = ((Pocion) objeto).usarPocion() + getHPActual();
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
