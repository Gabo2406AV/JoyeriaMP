package joyeriamp;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



public class ConsultaIndividual extends javax.swing.JFrame {


    public ConsultaIndividual() {
        initComponents();
    this.setLocationRelativeTo(null); // Centra la ventana

    // Configuración inicial de la tabla (como en el Word)
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Descripción");
    modelo.addColumn("Precio");
    tablaAlumnos.setModel(modelo);
    }
public void generarExcel(int id) {
        try {
            conexion con = new conexion();
            Connection cn = con.conectar();

            PreparedStatement ps = cn.prepareStatement(
                "SELECT id_producto, nombre_producto, descripcion, precio FROM productos WHERE id_producto = ?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No existe ese ID para exportar a Excel");
                return;
            }

            String ruta = "C:\\Users\\gabri\\OneDrive\\Documentos\\Reportes_Gabo\\Reporte_Producto_" + id + ".xls";

            Workbook libro = new HSSFWorkbook();
            Sheet hoja = libro.createSheet("Detalle Producto");

            // Encabezados de columnas del Excel
            Row filaEncabezado = hoja.createRow(0);
            filaEncabezado.createCell(0).setCellValue("ID PRODUCTO");
            filaEncabezado.createCell(1).setCellValue("NOMBRE");
            filaEncabezado.createCell(2).setCellValue("DESCRIPCIÓN");
            filaEncabezado.createCell(3).setCellValue("PRECIO");

            int filaNum = 1; 
            while (rs.next()) {
                Row filaDatos = hoja.createRow(filaNum);
                filaDatos.createCell(0).setCellValue(rs.getInt("id_producto"));
                filaDatos.createCell(1).setCellValue(rs.getString("nombre_producto"));
                filaDatos.createCell(2).setCellValue(rs.getString("descripcion"));
                filaDatos.createCell(3).setCellValue(rs.getDouble("precio"));
                filaNum++; 
            }

            for (int i = 0; i < 4; i++) {
                hoja.autoSizeColumn(i);
            }

            FileOutputStream archivo = new FileOutputStream(ruta);
            libro.write(archivo);
            archivo.close();
            libro.close();

            rs.close();
            ps.close();
            cn.close();

            JOptionPane.showMessageDialog(null, "Excel generado con éxito");
            Desktop.getDesktop().open(new File(ruta));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear Excel: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnExcel = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        Txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(244, 240, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        btnExcel.setBackground(new java.awt.Color(27, 32, 36));
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setText("GENERAR EXCEL");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnPDF.setBackground(new java.awt.Color(27, 32, 36));
        btnPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnPDF.setText("GENERAR PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        Txtbuscar.setBackground(new java.awt.Color(245, 242, 235));
        Txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtbuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID del producto");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("CONSULTA DE PRODUCTOS INDIVIDUALES");

        tablaAlumnos.setBackground(new java.awt.Color(244, 240, 230));
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAlumnos);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("⬅ Regresar al Menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExcel)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(btnPDF))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcel)
                    .addComponent(btnPDF))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtbuscarActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
       try {
        if (Txtbuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa un ID");
            return;
        }

        // 1. Conexión
        conexion con = new conexion();
        Connection cn = con.conectar();
        
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM productos WHERE id_producto = ?");
        ps.setInt(1, Integer.parseInt(Txtbuscar.getText()));
        
        ResultSet rs = ps.executeQuery();

        // 2. Llenar tabla visual
        DefaultTableModel modelo = (DefaultTableModel) tablaAlumnos.getModel();
        modelo.setRowCount(0);

        if (rs.next()) {
            Object[] fila = new Object[4];
            fila[0] = rs.getInt("id_producto");
            fila[1] = rs.getString("nombre_producto");
            fila[2] = rs.getString("descripcion");
            fila[3] = rs.getString("precio");
            modelo.addRow(fila);

            // 3. Crear PDF (Ruta corregida)
            String ruta = "C:\\Users\\gabri\\OneDrive\\Documentos\\Reportes_Gabo\\Reporte_Individual.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            // Título
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph titulo = new Paragraph("REPORTE DE PRODUCTO", fontTitulo);
            titulo.setAlignment(Paragraph.ALIGN_LEFT);
            fontTitulo.setColor(BaseColor.RED);
            document.add(titulo);

            // Tabla PDF
            PdfPTable table = new PdfPTable(4);
            table.addCell(new PdfPCell(new Paragraph("ID")) {{ setBackgroundColor(BaseColor.GRAY); }});
            table.addCell(new PdfPCell(new Paragraph("Nombre")) {{ setBackgroundColor(BaseColor.GRAY); }});
            table.addCell(new PdfPCell(new Paragraph("Descripción")) {{ setBackgroundColor(BaseColor.GRAY); }});
            table.addCell(new PdfPCell(new Paragraph("Precio")) {{ setBackgroundColor(BaseColor.GRAY); }});

            table.addCell(String.valueOf(rs.getInt("id_producto")));
            table.addCell(rs.getString("nombre_producto"));
            table.addCell(rs.getString("descripcion"));
            table.addCell(rs.getString("precio"));

            document.add(table);

            // Texto final y Logo
            Font fontTexto = new Font(Font.FontFamily.HELVETICA, 12, Font.ITALIC, BaseColor.BLACK);
            Paragraph textoFinal = new Paragraph("Reporte generado automáticamente por el sistema"
                +"este otro mensaje"
               +"mensaje final hols mi nombre es noe garcia pedro me gusta la materia de programación"
                , fontTexto);
        textoFinal.setSpacingBefore(10); 

        document.add(textoFinal);


            try {
                Image logo = Image.getInstance(getClass().getResource("/imagenes/logo_joyeria.jpg.png"));
                logo.scaleToFit(100, 100);
                logo.setAlignment(Image.ALIGN_CENTER);
                document.add(logo);
            } catch (Exception e) {}

            document.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "PDF generado correctamente en: " + ruta);
        } else {
            JOptionPane.showMessageDialog(null, "No existe el ID");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        try {
            if (Txtbuscar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa un ID");
                return;
            }
            
            int id = Integer.parseInt(Txtbuscar.getText());
            
            conexion con = new conexion();
            Connection cn = con.conectar();
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM productos WHERE id_producto = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            DefaultTableModel modelo = (DefaultTableModel) tablaAlumnos.getModel();
            modelo.setRowCount(0); 

            if (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("id_producto");
                fila[1] = rs.getString("nombre_producto");
                fila[2] = rs.getString("descripcion");
                fila[3] = rs.getString("precio");
                modelo.addRow(fila);
                
                // Llamamos a la función de generar excel que guardamos arriba
                generarExcel(id); 
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese producto");
            }
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
MenuPrincipal menu = new MenuPrincipal();
menu.setVisible(true);

// 2. Cerramos la ventana actual (por ejemplo, la de clientes o productos)
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaIndividual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Txtbuscar;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
