package ENUMS;

import java.util.List;
import java.util.Random;
import static ENUMS.TipoEnemigo.*;

public enum Mapas {

    BOSQUE(List.of(LOBO,GOBLIN),List.of(LOBO_J),"estas en un bosque"),
    CEMENTERIO(List.of(ESQUELETO),List.of(),"te encuentras en un cementerio");

    private final List<TipoEnemigo> normal;
    private final List<TipoEnemigo> jefe;
    private static final Random rand = new Random();
    public String nombre;


    Mapas(List<TipoEnemigo> normal, List<TipoEnemigo> jefe,String nombre) {
        this.normal = normal;
        this.jefe = jefe;
        this.nombre = nombre;
    }

    public TipoEnemigo obtenerEnemigo(int nivel){
        boolean ronda_J = nivel % 10 == 0;
        if(ronda_J && !jefe.isEmpty())
        {
            return jefe.get(rand.nextInt(jefe.size()));
        }
        return normal.get(rand.nextInt(normal.size()));
    }

    public static Mapas mapa_aliatorio()
    {
        Random ran = new Random();
        Mapas[] zonas = Mapas.values();
        int donde = ran.nextInt(zonas.length);
        return zonas[donde];
    }
}
