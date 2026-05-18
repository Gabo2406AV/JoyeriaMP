package joyeriamp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
 
public class eliminar extends javax.swing.JFrame {

conexion cc = new conexion();
Connection cn = cc.conectar();
    
    public eliminar() {
        initComponents();
        this.setLocationRelativeTo(null);
        if (cn == null) {
        conexion cc = new conexion();
        cn = cc.conectar();
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtid = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNuevoNombre = new javax.swing.JTextArea();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnactualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnbuscar.setText("Id del producto");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        txtNuevoNombre.setColumns(20);
        txtNuevoNombre.setRows(5);
        jScrollPane1.setViewportView(txtNuevoNombre);

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRegresar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnactualizar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnactualizar))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
try {
            String datos = txtNuevoNombre.getText();
            
            // Extraemos los nuevos datos del JTextArea usando substring
            // Nota: El usuario debe editar el texto dentro de los paréntesis y etiquetas
            String nuevoNom = datos.substring(datos.indexOf("PRODUCTO: ") + 10, datos.indexOf(" ("));
            String nuevaDesc = datos.substring(datos.indexOf(" (") + 2, datos.indexOf(")\n"));
            String nuevoPrec = datos.substring(datos.indexOf("PRECIO ACTUAL: ") + 15);

            String sql = "UPDATE productos SET nombre_producto = ?, descripcion = ?, precio = ? WHERE id_producto = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, nuevoNom);
            pst.setString(2, nuevaDesc);
            pst.setString(3, nuevoPrec);
            pst.setString(4, txtid.getText());

            int n = pst.executeUpdate();
            
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "¡Producto actualizado correctamente!");
                btnbuscar.doClick(); // Refresca la vista
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: Asegúrate de mantener el formato PRODUCTO: nombre (descripción)");
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
int confirmar = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este producto de Joyería M.P.?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM productos WHERE id_producto = ?");
                pst.setString(1, txtid.getText());

                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.");
                    txtid.setText("");
                    txtNuevoNombre.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el ID.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
            }
        }       // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
try {
            // Buscamos en la tabla productos de Joyería M.P.
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM productos WHERE id_producto = ?");
            pst.setString(1, txtid.getText());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nombre_producto");
                String desc = rs.getString("descripcion");
                String prec = rs.getString("precio");

                // Mostramos la información en el JTextArea con etiquetas claras
                txtNuevoNombre.setText(
                    "PRODUCTO: " + nom + " (" + desc + ")\n" + 
                    "PRECIO ACTUAL: " + prec
                );
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
                txtNuevoNombre.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage());
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
    principal p = new principal();
    p.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtNuevoNombre;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}