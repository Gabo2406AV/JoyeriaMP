
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
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class reporte extends javax.swing.JFrame {


    
    public reporte() {
        initComponents(); // Inicializa la interfaz
    }
       public void generarPDF() {
        Document document = new Document();
    try {
        // 1. DEFINIR RUTA CORRECTA
        String rutaCarpeta = "C:\\Users\\gabri\\OneDrive\\Documentos\\Reportes_Gabo";
        String nombreArchivo = "\\Reporte_Inventario.pdf";
        String rutaCompleta = rutaCarpeta + nombreArchivo;


        // USAR LA RUTA COMPLETA AQUÍ
        PdfWriter.getInstance(document, new FileOutputStream(rutaCompleta));
        document.open();

        // 2. INSERTAR LOGO (Asegúrate de que la ruta del recurso sea correcta)
        try {
            Image logo = Image.getInstance(getClass().getResource("/imagenes/logo_joyeria.jpg.png"));
            logo.scaleToFit(150, 150);
            logo.setAlignment(Image.ALIGN_CENTER);
            document.add(logo);
        } catch (Exception e) {
            System.out.println("No se encontró el logo en /imagenes/logo_joyeria.jpg.png");
        }

        // 3. TÍTULO
        Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD, BaseColor.DARK_GRAY);
        Paragraph titulo = new Paragraph("INVENTARIO DE PRODUCTOS - JOYERÍA M.P.", fontTitulo);
        
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // 4. TABLA
        PdfPTable table = new PdfPTable(4); 
        table.setWidthPercentage(100);

        PdfPCell cellHeader = new PdfPCell();
        cellHeader.setBackgroundColor(BaseColor.LIGHT_GRAY); 
        cellHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellHeader.setPadding(5);

        String[] encabezados = {"ID", "Nombre", "Descripción", "Precio"};
        for (String col : encabezados) {
            cellHeader.setPhrase(new Paragraph(col, new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            table.addCell(cellHeader);
        }

        // 5. LLENADO DE DATOS DESDE LA BD
        conexion con = new conexion();
        Connection cn = con.conectar();
        // Usamos los nombres de columna de tu base de datos Joyería M.P.
        PreparedStatement ps = cn.prepareStatement("SELECT id_producto, nombre_producto, descripcion, precio FROM productos");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            table.addCell(rs.getString("id_producto"));     
            table.addCell(rs.getString("nombre_producto")); 
            table.addCell(rs.getString("descripcion"));     
            table.addCell("$ " + rs.getString("precio")); // Agregamos el signo de pesos para mejor vista
        }
        
        document.add(table);

        // 6. PIE DE PÁGINA
        Font fontPie = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.GRAY);
        Paragraph pie = new Paragraph("\nReporte generado por el sistema Joyería M.P.", fontPie);
        pie.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(pie);

        // 7. CERRAR TODO
        document.close();
        cn.close(); // ¡Importante cerrar la conexión!
        
        JOptionPane.showMessageDialog(null, "¡Reporte guardado con éxito en:\n" + rutaCompleta);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al generar: " + e.getMessage());
    }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Generar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(149, 149, 149))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generarPDF();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
