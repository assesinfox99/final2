package ENUMS;

import java.util.List;
import java.util.Random;
import static ENUMS.TipoEnemigo.*;

public enum Mapas {

    BOSQUE(List.of(LOBO,GOBLIN,OSO),List.of(LOBO_J,GOBLIN_J),"estas en un bosque"),
    CEMENTERIO(List.of(ESQUELETO,ZOMBIE),List.of(ESQUELETO_J),"te encuentras en un cementerio"),
    CASTILLO(List.of(GOLEM,CABALLERO),List.of(CABALLERO_J),"estas en un castillo"),
    VOLCAN(List.of(),List.of(DRAGON),"la abrasadora temperatura del volcan te pega la ropa al cuerpo"),
    LLANURA(List.of(SLIME,LOBO,GOBLIN),List.of(GOBLIN_J),"solo ves una vasta pradera hasta donde alcansas  "),
    DECIERTO(List.of(ESCORPION,GOLEM),List.of(),"no paras de quitarte la arena del decirto de entre la ropa"),
    ;
    private final List<TipoEnemigo> normal;
    private final List<TipoEnemigo> jefe;
    private static final Random rand = new Random();
    public String descripcion;


    Mapas(List<TipoEnemigo> normal, List<TipoEnemigo> jefe,String descripcion) {
        this.normal = normal;
        this.jefe = jefe;
        this.descripcion = descripcion;
    }

    public TipoEnemigo obtenerEnemigo(int nivel){
        boolean ronda_J = nivel % 10 == 0;
        if(ronda_J && !jefe.isEmpty()) {
            return jefe.get(rand.nextInt(jefe.size()));
        }
        return normal.get(rand.nextInt(normal.size()));
    }

    public static Mapas mapa_aliatorio() {
        Random ran = new Random();
        Mapas[] zonas = Mapas.values();
        int donde = ran.nextInt(zonas.length);
        return zonas[donde];
    }
}
