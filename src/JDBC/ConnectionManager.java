package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {

    //Metodo para crear la conexion con la base de datos.
    public static Connection createConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://172.16.1.64:3306/midb","bdd1","bdd1");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al realizar la conexion");
        }
    }

    //Metodo para crear la tabla Jugadores si no existe.
    public void crearTablaJugador(){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = ConnectionManager.createConnection();
            ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Personaje (ID int auto_increment primary key, nombre varchar(50),nivel int, ATK decimal(10.2), HP decimal(10.2), VEL decimal(10.2), DEF decimal(10.2))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try{
                if (ps!=null){
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
