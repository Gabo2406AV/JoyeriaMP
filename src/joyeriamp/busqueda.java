
package joyeriamp;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import joyeriamp.conexion;
 

public class busqueda extends javax.swing.JFrame {

   
    
    public busqueda() {
    initComponents(); // Esto carga todo el diseño que hiciste
    this.setLocationRelativeTo(null); // Esto centra la ventana en la pantalla   
}
        public void generarPDF() {
try {
        // 1. Conexión y búsqueda por ID
        conexion con = new conexion();
        Connection cn = con.conectar();
        
        // Obtenemos el ID del cuadro de texto
        int idBuscado = Integer.parseInt(txtbuscar.getText()); 
        
        // Consulta filtrada por id_producto
        String sql = "SELECT * FROM productos WHERE id_producto = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, idBuscado);
        ResultSet rs = ps.executeQuery();

        // Si no encuentra el ID, avisamos y salimos
        if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "No existe ese ID" + idBuscado);
            return;
        }

        // 2. Configuración del PDF (Tu ruta personalizada)
        String rutaCarpeta = "C:\\Users\\gabri\\OneDrive\\Documentos\\Reportes_Gabo";
        String rutaCompleta = rutaCarpeta + "\\Reporte_por_ID" + idBuscado + ".pdf";
        
        
        java.io.File dir = new java.io.File(rutaCarpeta);
        if (!dir.exists()) dir.mkdirs();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(rutaCompleta));
        document.open();

        // 3. Encabezado y Logo (Criterios de diseño)
        try {
            Image logo = Image.getInstance(getClass().getResource("/imagenes/logo_joyeria.jpg.png"));
            logo.scaleToFit(100, 100);
            logo.setAlignment(Image.ALIGN_CENTER);
            document.add(logo);
        } catch (Exception e) {
            System.out.println("Logo no encontrado");
        }

        Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.RED);
        Paragraph titulo = new Paragraph("REPORTE DETALLADO DE PRODUCTO", fontTitulo);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titulo);
        document.add(new Paragraph(" "));

        // 4. Tabla de resultados
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        
        // Encabezados con estilo
        String[] cabecera = {"ID", "Nombre", "Descripción", "Precio"};
        for (String col : cabecera) {
            PdfPCell cell = new PdfPCell(new Paragraph(col, new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
        }

        // 5. Llenar con el registro encontrado
        if (rs.next()) {
            table.addCell(String.valueOf(rs.getInt("id_producto")));
            table.addCell(rs.getString("nombre_producto"));
            table.addCell(rs.getString("descripcion"));
            table.addCell("$ " + rs.getString("precio"));
        }

        document.add(table);

        // 6. Pie de página
        Paragraph textoFinal = new Paragraph("\nReporte generado por el sistema Joyería M.P.", 
                new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC));
        document.add(textoFinal);

        // 7. Cierre
        document.close();
        cn.close();
        
        JOptionPane.showMessageDialog(null, "PDF individual generado: " + rutaCompleta);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor, ingresa un número de ID válido.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
       }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar por ID:");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1)
                        .addGap(91, 91, 91)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton1)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(95, 95, 95)
                .addComponent(jButton1)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    generarPDF();        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new busqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
