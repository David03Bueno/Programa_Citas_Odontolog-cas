/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class ConexionMysql {
    String db = "PCitasMedicas";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "paula1717";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cn;

    public Connection conectar() {
        try {
            Class.forName(driver);
            cn = (Connection) DriverManager.getConnection(url + db, user, password);
            System.out.println("Estamos conectados con exito.");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en la conexion :" + ex);
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
}
