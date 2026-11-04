package JDBC;

import CLASES.Jugador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {

    //Metodo para crear la base de datos.
    public static void crearBaseDeDatos(){
        Connection conn = null;
        PreparedStatement ps = null;
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
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TP_Final_Juego_De_Rol","root","giovanico05");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al realizar la conexion" + e.getMessage());
        }
    }

    //Metodo para crear la tabla Jugadores si no existe.
    public static void crearTablaPersonaje(){
        Connection conn = null;
        PreparedStatement ps = null;
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

    //Metodo para guardar un jugador en la base de datos.
    public static void guardarJugador (Jugador jugador, int nivel){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
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
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al ejecutar la actualizacion. ");
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

}
