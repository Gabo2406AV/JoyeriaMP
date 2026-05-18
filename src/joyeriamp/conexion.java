package joyeriamp;

import java.sql.Connection; // Importa la clase Connection [cite: 2, 3]
import java.sql.DriverManager;
import javax.swing.JOptionPane; // Importa JOptionPane para alertas [cite: 6, 9]


public class conexion {
    Connection cn;

    public Connection conectar() { // Este es el método que llama tu PDF [cite: 52, 53]
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