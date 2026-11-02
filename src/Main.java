import CLASES.*;
import CLASES.Pociones.*;
import ENUMS.Mapas;
import JDBC.ConnectionManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ConnectionManager.crearTablaPersonaje();
        Jugador A;
        Inventario in;
        int nivel;
        int opcion;
        do {
            System.out.println("---LEVEL TOWER---");
            System.out.println("1. crear jugador");
            System.out.println("2. cargar jugador");
            System.out.println("0. salir");
            try {
                opcion = leer.nextInt();
                System.out.println("-----------------------");
                leer.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: ¡Debes ingresar un número, no se aceptan letras!");
                leer.nextLine();
                opcion = 0;
            }
            switch (opcion)
            {
                case 1:
                    nivel = 1;
                    System.out.println("Elija un nombre");
                    System.out.println("-----------------------");
                    String nombre = leer.nextLine();
                    A = new Jugador(nombre);
                    in = A.getInventario();
                    juego(A,in,nivel);
                    break;
                case 2 :
                    break;
                default:
                    break;

            }
        }while (opcion !=0);
    }

    public static void juego(Jugador A, Inventario in, int nivel)
    {
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("NIVEL " + nivel);
            Mapas donde = SeleccionMapas.SeleccionMapas(nivel);
            System.out.println(donde.nombre);
            Enemigo B = donde.obtenerEnemigo(nivel).crearEnemigo();
            System.out.println("aparece un " + B.getNombre());
            System.out.println("-----------------------");
            for (int i = 2; i <= nivel; i++) {
                B.NivelesPersonajes(i);
            }
            do {
                System.out.println(A.toString());
                System.out.println("que quieres hacer?");
                System.out.println("1. Atacar");
                System.out.println("2. inventario");
                System.out.println("-----------------------");
                try {
                    opcion = leer.nextInt();
                    System.out.println("-----------------------");
                    leer.nextLine();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error: ¡Debes ingresar un número, no se aceptan letras!");
                    leer.nextLine();
                    opcion = 0;
                }
                switch (opcion) {
                    case 1:
                        B.ataque(A);
                        break;
                    case 2:
                        List<Objeto> objetos = in.obtenerObjetos();
                        System.out.println(in.mostrarMenu());
                        System.out.println("0. Salir");
                        try {
                            opcion = leer.nextInt();
                            System.out.println("-----------------------");
                            leer.nextLine();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Error: ¡Debes ingresar un número, no se aceptan letras!");
                            leer.nextLine();
                            opcion = 0;
                        }
                        if ((opcion > 0) && (objetos.size() >= opcion)) {
                            Objeto seleccion = objetos.get(opcion - 1);
                            A.UsarObjeto(seleccion);
                        }
                        break;
                    default:
                        break;
                }
                if (B.getHPActual() > 0) {
                    System.out.println(B.toString());
                    A.ataque(B);
                } else {
                    System.out.println("el enemigo fue derrotado");
                    System.out.println("-----------------------");
                }
            } while (B.getHPActual() > 0 && A.getHPActual() > 0);
            A.NivelesPersonajes();
            in.agregar(B.Drop(nivel, in));
            nivel++;
        } while (A.getHPActual() > 0);
        System.out.println("\nGAME OVER :c\n");
        System.out.println("toca para continuar");
        esperarEnter(leer);

    }

    private static void esperarEnter(Scanner leer) {
        try {
            leer.nextLine();
        } catch (Exception e) {
            System.out.println("Error al leer la entrada: " + e.getMessage());
        }
    }
}