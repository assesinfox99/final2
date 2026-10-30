import CLASES.*;
import CLASES.Pociones.*;
import CLASES.Randomizador.RandEnemigos;
import ENUMS.EtipoDePociones;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int nivel = 1;
        Scanner leer = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("elija un nombre");
        System.out.println("-----------------------");
        String nombre = leer.nextLine();
        Jugador A = new Jugador(nombre);
        Inventario in = A.getInventario();
        PocionVida p1 = new PocionVida(EtipoDePociones.chica);
        in.agregar(p1);
        do {
            System.out.println("NIVEL "+ nivel);
            int opcion;
            Enemigo B = RandEnemigos.generarEnemigo(nivel);
            System.out.println("aparece un "+B.getNombre());
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
                        System.out.println(in.mostrarMenu());
                        int op;
                        op = leer.nextInt();
                        leer.nextLine();
                        if (op == 1){
                            PocionVida pocionAux = new PocionVida(EtipoDePociones.chica);
                            A.UsarObjeto(pocionAux);
                        } else if (op == 2) {
                            PocionVida pocionAux = new PocionVida(EtipoDePociones.mediana);
                            A.UsarObjeto(pocionAux);
                        }else if (op == 3){
                            PocionVida pocionAux = new PocionVida(EtipoDePociones.grande);
                            A.UsarObjeto(pocionAux);
                        }else if (op == 4){
                            PocionVida pocionAux = new PocionVida(EtipoDePociones.elixir);
                            A.UsarObjeto(pocionAux);
                        }else if (op == 0){A.ataque(B);}
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
            in.agregar(B.Drop());
            nivel++;
        }while (A.getHPActual()>0);
        System.out.println("GAME OVER :c");
    }
}