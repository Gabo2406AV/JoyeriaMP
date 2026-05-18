package joyeriamp;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class principal extends javax.swing.JFrame {


    public principal() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdproducto = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Id del producto");

        jLabel3.setText("Nombre del producto");

        jLabel5.setText("Tipo de joya");

        txtIdproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdproductoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha de registro");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel7.setText("Productos");

        jLabel6.setText("Precio");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnguardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTipo)
                                .addComponent(txtNombre)
                                .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(btnguardar)
                .addGap(45, 45, 45))
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

    private void txtIdproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdproductoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
// 1. Obtener los datos de los campos
    String id = txtIdproducto.getText().trim();
    String nombre = txtNombre.getText().trim();
    String tipo = txtTipo.getText().trim();
    String precio = txtPrecio.getText().trim(); // Nuevo campo capturado
    java.util.Date fecha = jDateChooser1.getDate();

    // 2. Validación de campos vacíos (Agregamos el precio a la validación)
    if (id.isEmpty() || nombre.isEmpty() || tipo.isEmpty() || precio.isEmpty() || fecha == null) {
        JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos (incluyendo el precio) antes de guardar.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
    } else {
        try {
            // 1. Conexión
            conexion con = new conexion();
            Connection cn = con.conectar();
            
            // 2. Query actualizado para incluir la columna 'precio'
            // Nota: Mantenemos 'tipo' mapeado a 'descripcion' como tenías antes
            String sql = "INSERT INTO productos (id_producto, nombre_producto, descripcion, precio) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = cn.prepareStatement(sql);
            
            // 3. Asignando valores a los 4 parámetros (?)
            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setString(3, tipo);   // Se guarda en la columna 'descripcion'
            ps.setString(4, precio); // Se guarda en la columna 'precio'

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Producto guardado correctamente en el inventario");
            
            // 4. Limpiar todos los campos después de guardar
            txtIdproducto.setText("");
            txtNombre.setText("");
            txtTipo.setText("");
            txtPrecio.setText("");
            jDateChooser1.setDate(null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar en la BD: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIdproducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}



