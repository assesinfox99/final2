import CLASES.*;
import ENUMS.EtipoDePociones;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int nivel = 1;
        Scanner leer = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("elija un nombre");
        String nombre = leer.nextLine();
        System.out.println("-----------------------");
        Jugador A = new Jugador(nombre);
        Inventario in = A.getInventario();
        do {
            System.out.println("NIVEL "+ nivel);
            int opcion;
            Enemigo B = RandEnemigos.generarEnemigo(nivel);
            System.out.println("aparece un "+B.getNombre());
            for (int i = 2; i<=nivel; i++){B.NivelesPersonajes(i);}
            do {
                System.out.println("------------------------");
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
                        in.mostrar();
                        int op;
                        System.out.println("\n");
                        System.out.println("1.Pocion Chica");
                        System.out.println("2.Pocion Mediana");
                        System.out.println("3.Pocion Grande");
                        System.out.println("4.Elixir");
                        System.out.println("0.salir");
                        op = leer.nextInt();
                        leer.nextLine();
                        if (op == 1){
                            PocionVida pocionAux = new PocionVida(EtipoDePociones.chica);
                            A.usarobjeto(pocionAux);
                        } else if (op == 2) {
                            PocionVida pocionAux = new PocionVida(EtipoDePociones.mediana);
                            A.usarobjeto(pocionAux);
                        }else if (op == 3){
                            PocionVida pocionAux = new PocionVida(EtipoDePociones.grande);
                            A.usarobjeto(pocionAux);
                        }else if (op == 4){
                            PocionVida pocionAux = new PocionVida(EtipoDePociones.elixir);
                            A.usarobjeto(pocionAux);
                        }else if (op == 0){A.ataque(B);}
                        break;
                    default:
                        break;
                }
                if (B.getHPActual()>0){
                    System.out.println(B.toString());
                    A.ataque(B);}
                else {System.out.println("el enemigo fue derrotado");}
            }while (B.getHPActual()>0 && A.getHPActual()>0);
            A.NivelesPersonajes();
            in.agregar(B.Drop());
            nivel++;
        }while (A.getHPActual()>0);
        System.out.println("GAME OVER :c");
    }
}