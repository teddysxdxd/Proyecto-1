/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;

import org.springframework.data.jpa.repository.Query;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author casa
 */
public class OrdenVenta extends javax.swing.JFrame {
    private Creacion creacion;
    private Long estadoPedido = 0L;
    private String nit;
    /**
     * Creates new form OrdenVenta
     */

    private List<Clientes> clientes = new ArrayList<>();

    public OrdenVenta() {
        initComponents();
    }

    public OrdenVenta(Creacion creacion) {
        this.creacion = creacion;
        initComponents();

        cbxCliente.addItem("Seleccione un cliente");

        creacion.clientesRepo.findAll().forEach(cliente -> {
            cbxCliente.addItem(cliente.getNombre().concat(" - ").concat(cliente.getNit()));
            clientes.add(cliente);
        });


        String[] columnNames = new String[]{"ID", "Nombre", "Precio"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

//        Productos productos2 = new Productos();
//        productos2.setNombre("Producto 1");
//        productos2.setPrecio(1000.0);
//        creacion.productoRepo.save(productos2);

        //Query query = en
        List<Productos> productos = creacion.productoRepo.findAll();

        productos.forEach(producto -> {
            System.out.println("Producto: " + producto.getNombre());
            Object[] rowData = {
                    producto.getIdProducto(), producto.getNombre(), producto.getPrecio()
            };
            model.addRow(rowData);
        });
        tblProducto.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblNit = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        cbxEstado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtProductoId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxClienteItemStateChanged(evt);
            }
        });
        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Cliente:");

        lblNombre.setText("Nombre:");

        lblNit.setText("Nit:");

        lblCorreo.setText("Correo:");

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProducto);

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione un estado", "local", "importado" }));
        cbxEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEstadoItemStateChanged(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID producto:");

        jLabel3.setText("Cantidad productos:");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNombre)
                                    .addComponent(jLabel1)
                                    .addComponent(lblNit, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(lblCorreo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProductoId, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(lblNit)
                        .addGap(18, 18, 18)
                        .addComponent(lblCorreo)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtProductoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxClienteItemStateChanged
        // TODO add your handling code here:
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Obtener el valor seleccionado
            String selectedItem = (String) evt.getItem();
            if (selectedItem.equalsIgnoreCase("Seleccione un cliente")) {
                lblCorreo.setText("Correo: ");
                lblNit.setText("Nit: ");
                lblNombre.setText("Nombre: ");
                return;
            }

            for (Clientes cliente : clientes) {
                var selectedItemSplit = selectedItem.split(" - ");
                if (cliente.getNit().equals(selectedItemSplit[1].trim())) {
                    lblCorreo.setText("Correo: ".concat(cliente.getCorreo()));
                    lblNit.setText("Nit: ".concat(cliente.getNit()));
                    lblNombre.setText("Nombre: ".concat(cliente.getNombre()));
                    nit = cliente.getNit();
                    break;
                }
            }
         }
    }//GEN-LAST:event_cbxClienteItemStateChanged

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxClienteActionPerformed

    private void cbxEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEstadoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Obtener el valor seleccionado
            String selectedItem = (String) evt.getItem();
            
            if (selectedItem.equalsIgnoreCase("seleccione un estado")) {
                estadoPedido = 0L;
                return;
            }
            
            if (selectedItem.equalsIgnoreCase("importado")) {
                this.estadoPedido = 1L;
            } else {
                this.estadoPedido = 2L;
            }
         }
    }//GEN-LAST:event_cbxEstadoItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.estadoPedido == 0L) {
            return;
        }
        
        Pedidos pedido = new Pedidos();
        pedido.setNit(nit);
        pedido.setEstadoPedido(estadoPedido);
        pedido = creacion.pedidosRepo.save(pedido);
        ProductoPedidoPK productoPedidoPK = new ProductoPedidoPK();
        productoPedidoPK.setIdPedido(pedido.getId());
        int idProducto = Integer.parseInt(txtProductoId.getText());
        productoPedidoPK.setIdProducto(idProducto);
        ProductoPedido productoPedido = new ProductoPedido();
        productoPedido.setProductoPedidoPK(productoPedidoPK);
        int cantidad = Integer.parseInt(txtCantidad.getText());
        productoPedido.setCantidad(cantidad);
        creacion.productosPedidoRepo.save(productoPedido);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdenVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdenVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtProductoId;
    // End of variables declaration//GEN-END:variables
}
