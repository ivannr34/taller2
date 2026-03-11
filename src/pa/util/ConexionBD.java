
package pa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de manejar la conexión a la base de datos.
 * Implementa el patrón Singleton para garantizar
 * una única conexión durante la ejecución del programa.
 */
public class ConexionBD {

    private static ConexionBD instancia;
    private Connection conexion;

    private static final String URL = "jdbc:mysql://localhost:3306/minipigs";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private ConexionBD() throws SQLException {
        conexion = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ConexionBD getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}