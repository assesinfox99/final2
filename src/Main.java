import CLASES.*;
import CLASES.Objetos.Objeto;
import CLASES.Objetos.XD.Dado;
import ENUMS.Mapas;
import EXEPCIONES.ListaVaciaException;
import EXEPCIONES.NombreRepetidoException;
import JDBC.ConnectionManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static JDBC.ConnectionManager.*;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        crearBaseDeDatos();
        crearTablaPersonaje();
        crearTablaInventario();
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
                    try{
                        System.out.println("Elija un nombre");
                        System.out.println("-----------------------");
                        String nombre = leer.nextLine();
                        System.out.println("-----------------------");
                        ConnectionManager.verificarNombre(nombre);
                        A = new Jugador(nombre);
                        in = A.getInventario();
                        juego(A,in,nivel);
                    }catch(NombreRepetidoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2 :
                    int i = 1;
                    List<Jugador> jugadoresCargados = new ArrayList<>();
                    try {
                        jugadoresCargados = ConnectionManager.listarJugadores();
                    }catch (ListaVaciaException e){
                        System.out.println(e.getMessage());
                        System.out.println("-----------------------");
                        break;
                    }
                    for (Jugador j : jugadoresCargados){
                        System.out.println(j.toString());
                        System.out.println("Nivel: " + j.getNivel());
                        System.out.println("Numero: " + i);
                        System.out.println("-----------------------");
                        i++;
                    }
                    try{
                        System.out.println("Ingrese el numero del personaje que desea usar: ");
                        int indice = leer.nextInt();
                        A = jugadoresCargados.get(indice-1);
                        juego(A,A.getInventario(),A.getNivel());
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("El numero del personaje que desea usar no existe. ");
                    }
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
            System.out.println(donde.descripcion);
            Enemigo B = donde.obtenerEnemigo(nivel).crearEnemigo();
            System.out.println("aparece un " + B.getNombre());
            System.out.println("-----------------------");
            System.out.println(B.toString());
            for (int i = 2; i <= nivel; i++) {
                B.NivelesPersonajes(i);
            }
            do {
                System.out.println("-----------------------");
                System.out.println(A.toString());
                System.out.println("-----------------------");
                System.out.println("que quieres hacer?");
                System.out.println("1. Atacar");
                System.out.println("2. inventario");
                System.out.println("0. salir y guardar");
                System.out.println("-----------------------");
                try {
                    opcion = leer.nextInt();
                    System.out.println("-----------------------");
                    leer.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Error: ¡Debes ingresar un número, no se aceptan letras!");
                    leer.nextLine();
                    opcion = 0;
                }
                switch (opcion) {
                    case 1:
                        System.out.println(A.ataque(B));
                        System.out.println("-----------------------");
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
                            System.out.println(A.UsarObjeto(seleccion,B,nivel,in));
                        }
                        break;
                    case 0:
                        guardarJugador(A,nivel);
                        guardarInventario(A);
                        return;
                    default:
                        break;
                }
                if (B.getHPActual() > 0) {
                    System.out.println(B.toString());
                    System.out.println("-----------------------");
                    System.out.println(B.ataque(A));
                }
            } while (B.getHPActual() > 0 && A.getHPActual() > 0);
            if (A.getHPActual() > 0 )
            {A.NivelesPersonajes();
            in.agregar(B.Drop(nivel, in));
            nivel++;
            }
        } while (A.getHPActual() > 0);
        System.out.println("\nGAME OVER :c\n");
        ConnectionManager.eliminarPerosnaje(A.getId());
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