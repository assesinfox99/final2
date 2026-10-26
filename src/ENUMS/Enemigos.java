package ENUMS;

import CLASES.Enemigo;

public enum Enemigos {
    LOBO("Lobo Gris", 35, 15, 10, 20),
    esqueleto("Esqueleto", 75, 12, 5, 11),
    LOBO_J("Lobo Gris Alfa", 60, 25, 15, 50);

    private String nombre;
    private double HP;
    private double ATK;
    private double DEF;
    private double VEL;

    Enemigos(String nombre, double HP, double ATK, double DEF, double VEL) {
        this.nombre = nombre;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.VEL = VEL;
    }

    public String getNombre() {return nombre;}

    public double getHP() {return HP;}

    public double getATK() {
        return ATK;
    }

    public double getDEF() {
        return DEF;
    }

    public double getVEL() {
        return VEL;
    }
}
