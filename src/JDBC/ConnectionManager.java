package JDBC;

import CLASES.Jugador;
import EXEPCIONES.NombreRepetidoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    //Metodo para crear la base de datos.
    public static void crearBaseDeDatos(){
        try{
            conn = ConnectionManager.createConnection();
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
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TP_Final_Juego_De_Rol","root","giovanico05");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al realizar la conexion" + e.getMessage());
        }
    }

    //Metodo para crear la tabla Jugadores si no existe.
    public static void crearTablaPersonaje(){
        try{
            conn = ConnectionManager.createConnection();
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
            conn = ConnectionManager.createConnection();
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
            conn = ConnectionManager.createConnection();
            ps = conn.prepareStatement("SELECT * FROM personaje where ID = ?");
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
                conn = ConnectionManager.createConnection();
                ps = conn.prepareStatement("INSERT INTO Personaje (nombre, nivel, ATK, HP,HPActual, VEL, DEF) VALUES (?,?,?,?,?,?,?);");
                ps.setString(1,jugador.getNombre());
                ps.setInt(2,nivel);
                ps.setDouble(3,jugador.getATK());
                ps.setDouble(4,jugador.getHP());
                ps.setDouble(5,jugador.getHPActual());
                ps.setDouble(6,jugador.getVEL());
                ps.setDouble(7,jugador.getDEF());
                ps.executeUpdate();
            }else{
                eliminarPerosnaje(jugador.getId());
                conn = ConnectionManager.createConnection();
                ps = conn.prepareStatement("INSERT INTO Personaje (nombre, nivel, ATK, HP,HPActual, VEL, DEF) VALUES (?,?,?,?,?,?,?);");
                ps.setString(1,jugador.getNombre());
                ps.setInt(2,nivel);
                ps.setDouble(3,jugador.getATK());
                ps.setDouble(4,jugador.getHP());
                ps.setDouble(5,jugador.getHPActual());
                ps.setDouble(6,jugador.getVEL());
                ps.setDouble(7,jugador.getDEF());
                ps.executeUpdate();
            }
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

    //Metodo para eliminar un personaje.
    public static void eliminarPerosnaje (int id){
        try{
            conn = ConnectionManager.createConnection();
            ps = conn.prepareStatement("DELETE FROM personaje WHERE ID = ?;");
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
    public static List listarJugadores(){
        List<Jugador> jugadores = new ArrayList<>();
        Jugador aux = null;
        try{
            conn = ConnectionManager.createConnection();
            ps = conn.prepareStatement("SELECT * FROM personaje;");
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
            return jugadores;
        } catch (SQLException e) {
            throw new RuntimeException("Error en la sentencia SQL: " + e.getMessage());
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
    public void crearTablaInventario (){
        try{
            conn = ConnectionManager.createConnection();
            ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Inventarios (ID INT AUTO_INCREMENT PRIMARY_KEY, ID_Jugador INT, objeto VARCHAR(50), cantidad INT);");
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
    /*public void guardarInventario (){
        try{
            conn = ConnectionManager.createConnection();
            ps = conn.prepareStatement("INSERT INTO");


        }




    }*/



}
