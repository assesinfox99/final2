package ENUMS;

import CLASES.Enemigo;

import java.util.Random;

public enum TipoEnemigo {
    LOBO("Lobo Gris", 35, 15, 10, 20),
    GOBLIN("Goblin",70,15,2,13),
    ESQUELETO("Esqueleto", 75, 12, 5, 11),
    SLIME("Slime",50,2,1,10),
    ZOMBIE("Zombie",100,20,10,20),
    CABALLERO("Caballero",150,35,40,35),
    GOLEM("Golem",500,40,60,1),
    ESCORPION("Escorpion gigante",65,25,6,16),
    OSO("Oso pardo",150,25,30,20),
    //JEFES
    LOBO_J("Lobo Gris Alfa", 60, 25, 15, 50),
    GOBLIN_J("Señor Goblin",250,30,20,45),
    ESQUELETO_J("REY ESQUELETO",200,35,15,60),
    CABALLERO_J("Capitan De Los Caballeros",350,60,50,50),
    DRAGON("Gran Dragon",1000,100,100,100),
    ;

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
