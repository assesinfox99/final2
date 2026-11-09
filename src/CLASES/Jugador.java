package CLASES;

public class Jugador extends Personaje {
    private Inventario inventario;
    private int nivel;

    public Jugador(String nombre) {
        super(nombre,100,15,10,20);
        this.inventario = new Inventario();
        this.nivel = 0;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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
        setHP(getHP()+20);
        setHPActual(getHPActual()+20);
        setATK(getATK()+2);
        setDEF(getDEF()+2);
        setVEL(getVEL()+2);
    }

}
