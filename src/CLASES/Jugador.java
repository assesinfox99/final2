package CLASES;

import CLASES.Objetos.Objeto;
import CLASES.Randomizador.RamdObjeto;

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

    public String UsarObjeto(Objeto objeto,Enemigo B,int nivel,Inventario in) {

        String resultado = objeto.usar(this);
        if (!resultado.equals("La vida está al máximo.")) {
            inventario.eliminar(objeto);
        }
        resultado = Accion(resultado,B,nivel,in);
        return resultado;
    }

    public String Accion(String A,Enemigo B,int nivel,Inventario in)
    {
        if (!A.startsWith("A123:")){return A;}
        String[] partes = A.split(":",2);
        String Accion = partes[1];
        switch (Accion)
        {
            case "AUMENTO_ENEMIGO":
                B.setATK(B.getATK()+100);
                B.setHPActual(B.getHPActual()+100);
                B.setHP(B.getHP()+100);
                B.setVEL(B.getVEL()+100);
                B.setDEF(B.getDEF()+100);
                return "La suerte no esta de tu lado, el dado le esta dando poderes!!!";
            case "SE_MURIO":
                B.setHPActual(0);
                return "el " + B.getNombre() + " exploto";
            case "DROP":
                in.agregar(RamdObjeto.generar());
                return "El dado te teletrasporto 5 niveles arriba";
        }
        return A;
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
