package CLASES;

import INTERFACES.INiveles;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public abstract class Personaje implements INiveles {

    private UUID id;
    private String nombre;
    private double HP;
    private double HPActual;
    private double ATK;
    private double DEF;
    private double VEL;

    public Personaje(String nombre, double HP, double ATK, double DEF, double VEL) {
        this.nombre = nombre;
        this.HP = HP;
        this.HPActual = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.VEL = VEL;
        id = UUID.randomUUID();
    }

    public String getNombre() {
        return nombre;
    }

    public double getDEF() {
        return DEF;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public void setATK(double ATK) {
        this.ATK = ATK;
    }

    public void setDEF(double DEF) {
        this.DEF = DEF;
    }

    public void setVEL(double VEL) {
        this.VEL = VEL;
    }

    public double getHP() {
        return HP;
    }

    public double getHPActual() {
        return HPActual;
    }

    public void setHPActual(double HPActual) {
        this.HPActual = HPActual;
    }

    public double getATK() {
        return ATK;
    }

    public double getVEL() {
        return VEL;
    }
    private int probabilidad()
    {
        Random aliatorio = new Random();
        return aliatorio.nextInt(100)+1;
    }

    public String ataque(Personaje B)
    {
        StringBuilder sb = new StringBuilder();
        double velocidad = B.VEL/Math.max(1,VEL);
        double provavilidadesquive = Math.max(0,Math.min(0.75,(velocidad-1)*0.6));
        boolean esquivo = Math.random()<provavilidadesquive;
        if (esquivo){
            sb.append(B.getNombre() + " esquivo el ataque");
            return sb.toString();
        }
        double efectividad =ATK/(ATK+B.DEF);
        double daño = Math.max(1,Math.round(ATK*efectividad));
        B.setHPActual(B.HPActual- daño);
        sb.append(" ha echo " + daño + " a " + B.getNombre());
        if (B.HPActual <= 0) {
            B.setHPActual(0);
            sb.append("\n" + B.getNombre() + " fue derrotado");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "nombre: %s\nHP %.1f/%.1f   ATK %.1f\nDEF %.1f         VEL %.1f",
                nombre, HPActual, HP, ATK, DEF, VEL
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personaje that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void NivelesPersonajes(){

    }
}
