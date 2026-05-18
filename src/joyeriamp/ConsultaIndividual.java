package joyeriamp;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();

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

        jLabel1.setText("Buscar por ID:");

        Txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtbuscarActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar y Generar PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
