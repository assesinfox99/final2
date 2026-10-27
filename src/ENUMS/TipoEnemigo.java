package ENUMS;

import CLASES.Enemigo;

public enum TipoEnemigo {
    LOBO("Lobo Gris", 35, 15, 10, 20),
    ESQUELETO("Esqueleto", 75, 12, 5, 11),
    LOBO_J("Lobo Gris Alfa", 60, 25, 15, 50);

    private String nombre;
    private double HP;
    private double ATK;
    private double DEF;
    private double VEL;

    TipoEnemigo(String nombre, double HP, double ATK, double DEF, double VEL) {
        this.nombre = nombre;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.VEL = VEL;
    }

    public Enemigo crearEnemigo (){
         return new Enemigo(this.nombre, this.HP, this.ATK, this.DEF, this.VEL);
    }

}
