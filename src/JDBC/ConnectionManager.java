package JDBC;

import CLASES.Jugador;
import CLASES.Objetos.Objeto;
import EXEPCIONES.SinJugadoresCargadosException;
import EXEPCIONES.NombreRepetidoException;
import EXEPCIONES.JugadorNoCreadoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionManager {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/TP_Final_Juego_De_Rol";
    private static final String USER = "root";
    private static final String PASSWORD = "giovanico05";

    //Metodo para crear la base de datos.
    public static void crearBaseDeDatos(){
        try{
            conn = createConnection();
            ps = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS TP_Final_Juego_De_Rol");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al crear la base de datos");
        }finally {
            try{
                if (ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement");
            }
            try{
                if (conn !=null){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion");
            }
        }
    }

    //Metodo para crear la conexion con la base de datos.
    public static Connection createConnection(){
        try{
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al realizar la conexion" + e.getMessage());
        }
    }

    //Metodo para crear la tabla Jugadores si no existe.
    public static void crearTablaPersonaje(){
        try{
            conn = createConnection();
            ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Personaje (ID int auto_increment primary key, nombre varchar(50),nivel int, ATK decimal(10,2), HP decimal(10,2),HPActual decimal (10,2), VEL decimal(10,2), DEF decimal(10,2));");
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al intentar crear la tabla personaje" + e.getMessage());
        }finally {
            try{
                if (ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement" + e.getMessage());
            }
            try{
                if (conn !=null){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion" + e.getMessage());
            }
        }
    }

    //Metodo para verificar si un nombre existe.
    public static void verificarNombre (String nombre) throws NombreRepetidoException {
        try{
            conn = createConnection();
            ps = conn.prepareStatement("SELECT * FROM Personaje where nombre = ?");
            ps.setString(1,nombre);
            rs = ps.executeQuery();
            if (rs.next()){
                throw new NombreRepetidoException("El nombre: " + nombre + " ya se encuentra registrado. ");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error la realizar la quary " + e.getMessage());
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement" + e.getMessage());
            }
            try{
                if (rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al cerrar el result set");
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion" + e.getMessage());
            }
        }
    }

    //Metodo para verificar si un jugador ya existe.
    public static boolean verificarExistencia (int id){
        try{
            conn = createConnection();
            ps = conn.prepareStatement("SELECT * FROM Personaje where ID = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error la realizar la quary " + e.getMessage());
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement" + e.getMessage());
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion" + e.getMessage());
            }
        }
        return false;
    }

    //Metodo para guardar un jugador en la base de datos.
    public static void guardarJugador (Jugador jugador, int nivel){
        try{
            if (!verificarExistencia(jugador.getId())){
                conn = createConnection();
                ps = conn.prepareStatement("INSERT INTO Personaje (nombre, nivel, ATK, HP,HPActual, VEL, DEF) VALUES (?,?,?,?,?,?,?);");
                ps.setString(1,jugador.getNombre());
                ps.setInt(2,nivel);
                ps.setDouble(3,jugador.getATK());
                ps.setDouble(4,jugador.getHP());
                ps.setDouble(5,jugador.getHPActual());
                ps.setDouble(6,jugador.getVEL());
                ps.setDouble(7,jugador.getDEF());
                ps.executeUpdate();
            }else actualizarJugador(jugador);
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al ejecutar la actualizacion: " + e.getMessage());
        }finally {
            try{
                if (ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement");
            }
            try{
                if (conn !=null){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion");
            }
        }
    }

    //Metodo para actualizar los datos de un jugador.
    public static void actualizarJugador(Jugador jugador){
       try{
           conn = createConnection();
           ps = conn.prepareStatement("UPDATE Personaje SET nivel = ?, ATK = ?, HP = ?,HPActual = ?, VEL = ?, DEF = ? WHERE ID = ?");
           ps.setInt(1,jugador.getNivel());
           ps.setDouble(2,jugador.getATK());
           ps.setDouble(3,jugador.getHP());
           ps.setDouble(4,jugador.getHPActual());
           ps.setDouble(5,jugador.getVEL());
           ps.setDouble(6,jugador.getDEF());
           ps.setInt(7,jugador.getId());
           ps.executeUpdate();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }finally {
           try {
               if (ps != null) {
                   ps.close();
               }
           } catch (SQLException e) {
               throw new RuntimeException("Ocurrio un error al cerrar el prepared statement: " + e.getMessage());
           }
           try {
               if (conn != null) {
                   conn.close();
               }
           } catch (SQLException e) {
               throw new RuntimeException("Ocurrio un error al cerrar el connexion: " + e.getMessage());
           }
       }
    }

    //Metodo para eliminar un personaje.
    public static void eliminarPerosnaje (int id){
        try{
            conn = createConnection();
            ps = conn.prepareStatement("DELETE FROM Personaje WHERE ID = ?;");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al eliminar el personaje: " + e.getMessage());
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement: " + e.getMessage());
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion: " + e.getMessage());
            }
        }
    }

    //Metodo para listar todos los personajes de la base de datos.
    public static List listarJugadores() throws SinJugadoresCargadosException {
        List<Jugador> jugadores = new ArrayList<>();
        Jugador aux = null;
        try{
            conn = createConnection();
            ps = conn.prepareStatement("SELECT * FROM Personaje;");
            rs = ps.executeQuery();
            while (rs.next()){
                aux = new Jugador(rs.getString("nombre"));
                aux.setId(rs.getInt("ID"));
                aux.setHP(rs.getDouble("HP"));
                aux.setATK(rs.getDouble("ATK"));
                aux.setHPActual(rs.getDouble("HPActual"));
                aux.setDEF(rs.getDouble("DEF"));
                aux.setVEL(rs.getDouble("VEL"));
                aux.setNivel(rs.getInt("nivel"));
                jugadores.add(aux);
            }
            if (!jugadores.isEmpty()){
                return jugadores;
            }else throw new SinJugadoresCargadosException("No hay jugadores cargados. ");
        } catch (SQLException e) {
            throw new RuntimeException("Error en la sentencia SQL: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement: " + e.getMessage());
            }try{
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el resultSet: " + e.getMessage());
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion: " + e.getMessage());
            }
        }
    }

    //Metodo para obtener el id del jugador recien ingresado.
    public static int obtenerIDJugador(String nombre){
        try{
            conn = createConnection();
            ps = conn.prepareStatement("SELECT * FROM Personaje WHERE nombre = ?;");
            ps.setString(1,nombre);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("ID");
            }else return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement: " + e.getMessage());
            }try{
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el resultSet: " + e.getMessage());
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion: " + e.getMessage());
            }
        }
    }


    //Metodo para crear la tabla inventario.
    public static void crearTablaInventario (){
        try{
            conn = createConnection();
            ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Inventario (ID INT AUTO_INCREMENT PRIMARY KEY, ID_Jugador INT, objeto VARCHAR(50), cantidad INT, FOREIGN KEY (ID_Jugador) REFERENCES Personaje(ID) ON DELETE CASCADE);");
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement: " + e.getMessage());
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion: " + e.getMessage());
            }
        }
    }

    //Metodo para guardar el inventario de un personaje.
    public static void guardarInventario (Jugador jugador) {
        int i = 0;
        Map<Class<?>,List<Objeto>> inventario = jugador.getInventario().obtenerMapa();
        try{
            conn = createConnection();
            for (Class<?> clave : inventario.keySet()){
                ps = conn.prepareStatement("INSERT INTO Inventario (ID_jugador, objeto, cantidad) VALUES (?,?,?)");
                ps.setInt(1,jugador.getId());
                ps.setString(2,clave.toString());
                ps.setInt(3,inventario.get(clave).size());
                ps.executeUpdate();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el prepared statement: " + e.getMessage());
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Ocurrio un error al cerrar el connexion: " + e.getMessage());
            }
        }
    }

    //Metodo para descargar los objetos del inventario de la base de datos.
    public static HashMap<Class<?>,List<Objeto>> obtenerInventario (int id) {

        HashMap<Class<?>,List<Objeto>> inventarioAux =  new HashMap<>();

        try{
            conn = createConnection();
            ps = conn.prepareStatement("SELECT * FROM Inventario where ID_Jugador = ?");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
