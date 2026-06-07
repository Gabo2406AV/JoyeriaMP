package joyeriamp;

import java.sql.Connection; 
import java.sql.DriverManager;
import javax.swing.JOptionPane; 


public class conexion {
    Connection cn;

    public Connection conectar() {
        try {
            // Registro del driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Ruta de la base de datos en XAMPP
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/joyeriamp", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return cn;
    }
} 