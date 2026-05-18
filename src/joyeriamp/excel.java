
package joyeriamp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import java.awt.Desktop; 
import java.io.File; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import javax.swing.JFileChooser; 
import javax.swing.JTable; 
import javax.swing.filechooser.FileNameExtensionFilter; 
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Sheet; 

public class excel extends javax.swing.JFrame {

 
    public excel() { 
initComponents();
    this.setLocationRelativeTo(null);
    
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Descripción");
    modelo.addColumn("Precio");
    
    // Cambia 'producto' por el nombre real de tu variable de tabla
    producto.setModel(modelo);
    }

    public void generarExcel(int id) {
    try {
        // 1. CONEXIÓN
        conexion con = new conexion();
        Connection cn = con.conectar();

        PreparedStatement ps = cn.prepareStatement(
            "SELECT id_producto, nombre_producto, descripcion, precio FROM productos WHERE id_producto = ?"
        );

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "No existe ese ID");
            return;
        }

        // 2. RUTA DEL ARCHIVO (Corregida la comilla final)
        String ruta = "C:\\Users\\gabri\\OneDrive\\Documentos\\Reportes_Gabo\\Reporte_Producto_" + id + ".xls";

        // 3. CREAR LIBRO EXCEL
        Workbook libro = new HSSFWorkbook();
        Sheet hoja = libro.createSheet("Detalle Producto");

        // 5. ENCABEZADOS
        Row filaEncabezado = hoja.createRow(0);
        filaEncabezado.createCell(0).setCellValue("ID PRODUCTO");
        filaEncabezado.createCell(1).setCellValue("NOMBRE");
        filaEncabezado.createCell(2).setCellValue("DESCRIPCIÓN");
        filaEncabezado.createCell(3).setCellValue("PRECIO");

        // 6. INSERTAR DATOS (Corregido)
        int filaNum = 1; // Usamos una sola variable clara
        while (rs.next()) {
            Row filaDatos = hoja.createRow(filaNum);
            filaDatos.createCell(0).setCellValue(rs.getInt("id_producto"));
            filaDatos.createCell(1).setCellValue(rs.getString("nombre_producto"));
            filaDatos.createCell(2).setCellValue(rs.getString("descripcion"));
            filaDatos.createCell(3).setCellValue(rs.getDouble("precio"));
            filaNum++; // Incrementamos la variable correcta
        }

        // 7. AJUSTAR TAMAÑO
        for (int i = 0; i < 4; i++) {
            hoja.autoSizeColumn(i);
        }

        // 8. GUARDAR
        FileOutputStream archivo = new FileOutputStream(ruta);
        libro.write(archivo);
        archivo.close();
        libro.close();

        // 9. CERRAR CONEXIONES
        rs.close();
        ps.close();
        cn.close();

        JOptionPane.showMessageDialog(null, "Excel generado con éxito");

        // 10. ABRIR EXCEL
        Desktop.getDesktop().open(new File(ruta));

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
} 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        producto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Generar Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Id del producto");

        producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(producto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(199, 199, 199))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try {
        int id = Integer.parseInt(jTextField1.getText());
        
        // 1. Lógica para llenar la tabla visual
        conexion con = new conexion();
        Connection cn = con.conectar();
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM productos WHERE id_producto = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        DefaultTableModel modelo = (DefaultTableModel) producto.getModel();
        modelo.setRowCount(0); // Limpia la tabla

        if (rs.next()) {
            Object[] fila = new Object[4];
            fila[0] = rs.getInt("id_producto");
            fila[1] = rs.getString("nombre_producto");
            fila[2] = rs.getString("descripcion");
            fila[3] = rs.getString("precio");
            modelo.addRow(fila);
            
            // 2. Generar el Excel
            generarExcel(id); 
        } else {
            JOptionPane.showMessageDialog(null, "No existe ese producto");
        }
        cn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new excel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable producto;
    // End of variables declaration//GEN-END:variables
}
