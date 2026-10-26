package CLASES;

import INTERFACES.IusarObjeto;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class Personajes {

    private UUID id;
    private String nombre;
    private double HP;
    private double HPActual;
    private double ATK;
    private double DEF;
    private double VEL;

    public Personajes(String nombre, double HP, double ATK, double DEF, double VEL) {
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

    public void ataque(Personajes VELE)
    {
        double num = getHPActual();
        if (VELE.getVEL() > VEL)
        {
            if (probabilidad()<=75){setHPActual(getHPActual()- ATK - getDEF()*ATK/100);}
        } else if (VELE.getVEL() == VEL)
        {
            if (probabilidad()<=50){setHPActual(getHPActual()- ATK - getDEF()*ATK/100);}
        }else if (VELE.getVEL() < VEL)
        {
            if (probabilidad()<=25){setHPActual(getHPActual()- ATK - getDEF()*ATK/100);}
        }
        if (num == getHP()){System.out.println(getNombre() +" esquivo");}
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
        if (!(o instanceof Personajes that)) return false;
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
