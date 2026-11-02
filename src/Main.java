import CLASES.*;
import CLASES.Pociones.*;
import CLASES.Randomizador.RandEnemigos;
import ENUMS.EtipoDePociones;
import JDBC.ConnectionManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConnectionManager.crearTablaPersonaje();
        int nivel = 1;
        Scanner leer = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Elija un nombre");
        System.out.println("-----------------------");
        String nombre = leer.nextLine();
        Jugador A = new Jugador(nombre);
        Inventario in = A.getInventario();
        PocionRecuperacion p1 = new PocionRecuperacion(EtipoDePociones.chica);
        in.agregar(p1);
        do {
            System.out.println("NIVEL "+ nivel);
            int opcion;
            Enemigo B = RandEnemigos.generarEnemigo(nivel);
            System.out.println("Aparece un "+B.getNombre());
            System.out.println("-----------------------");
            for (int i = 2; i<=nivel; i++){B.NivelesPersonajes(i);}
            do {
                //System.out.println("------------------------");
                System.out.println(A.toString());
                System.out.println("que quieres hacer?");
                System.out.println("1. Atacar");
                System.out.println("2. inventario");
                opcion = leer.nextInt();
                System.out.println("-----------------------");
                leer.nextLine();
                switch (opcion)
                {
                    case 1:
                        B.ataque(A);
                        break;
                    case 2:
                        List<Objeto> objetos = in.obtenerObjetos();
                        System.out.println(in.mostrarMenu());
                        System.out.println("0. Salir");
                        int op;
                        op = leer.nextInt();
                        leer.nextLine();
                        if ((op > 0) && (objetos.size() >= op)) {
                            Objeto seleccion = objetos.get(op - 1);
                            A.UsarObjeto(seleccion);
                        }
                        break;
                    default:
                        break;
                }
                if (B.getHPActual()>0){
                    System.out.println(B.toString());
                    A.ataque(B);}
                else {System.out.println("el enemigo fue derrotado");
                      System.out.println("-----------------------");}
            }while (B.getHPActual()>0 && A.getHPActual()>0);
            A.NivelesPersonajes();
            in.agregar(B.Drop(nivel,in));
            nivel++;
        }while (A.getHPActual()>0);
        System.out.println("GAME OVER :c");
    }
}