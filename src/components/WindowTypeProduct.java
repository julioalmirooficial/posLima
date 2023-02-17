package components;

import componentsregistry.RgtTypeProduct;
import controller.ControllerTypeproduct;
import database.ConnectionDB;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelTypeProduct;
import rojerusan.RSNotifyAnimated;

public class WindowTypeProduct extends javax.swing.JPanel {
    
    public WindowTypeProduct() {
        initComponents();
        idUpdateData.setVisible(false);
        jScrollPane1.getViewport().setBackground(new Color(241, 246, 249));
        getTypeProduct("");
    }
    
    void getTypeProduct(String search) {
        ControllerTypeproduct cTypeProduct = new ControllerTypeproduct();
        try {
            DefaultTableModel model;
            model = cTypeProduct.getTypeProduct(search);
            listTypeProducts.setModel(model);
            listTypeProducts.getColumnModel().getColumn(0).setMaxWidth(0);
            listTypeProducts.getColumnModel().getColumn(0).setMinWidth(0);
            listTypeProducts.getColumnModel().getColumn(0).setPreferredWidth(0);
            listTypeProducts.setDefaultEditor(Object.class, null);
            ConnectionDB c = new ConnectionDB();
            c.closeConection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idUpdateData = new javax.swing.JLabel();
        btnRegister = new rojerusan.RSButtonIconI();
        btnDelete = new rojerusan.RSButtonIconI();
        txtSearch = new RSMaterialComponent.RSTextFieldIconDos();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTypeProducts = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 60, 84));
        jLabel1.setText("Tipos de productos >");

        btnRegister.setBackground(new java.awt.Color(13, 110, 253));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnRegister.setToolTipText("REGISTRAR USUARIOS");
        btnRegister.setColorHover(new java.awt.Color(28, 119, 255));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(238, 111, 111));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnDelete.setToolTipText("ELIMINAR USUARIOS");
        btnDelete.setColorHover(new java.awt.Color(237, 90, 90));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtSearch.setForeground(new java.awt.Color(28, 60, 84));
        txtSearch.setBorderColor(new java.awt.Color(28, 60, 84));
        txtSearch.setColorIcon(new java.awt.Color(28, 60, 84));
        txtSearch.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        txtSearch.setPlaceholder("Buscar por nombre de suario");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        listTypeProducts.setBackground(new java.awt.Color(255, 255, 255));
        listTypeProducts.setForeground(new java.awt.Color(255, 255, 255));
        listTypeProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        listTypeProducts.setColorBackgoundHead(new java.awt.Color(241, 246, 249));
        listTypeProducts.setColorBordeFilas(new java.awt.Color(212, 227, 236));
        listTypeProducts.setColorBordeHead(new java.awt.Color(212, 227, 236));
        listTypeProducts.setColorFilasBackgound1(new java.awt.Color(241, 246, 249));
        listTypeProducts.setColorFilasBackgound2(new java.awt.Color(215, 229, 237));
        listTypeProducts.setColorFilasForeground1(new java.awt.Color(28, 60, 84));
        listTypeProducts.setColorFilasForeground2(new java.awt.Color(36, 58, 74));
        listTypeProducts.setColorForegroundHead(new java.awt.Color(28, 60, 84));
        listTypeProducts.setColorSelBackgound(new java.awt.Color(13, 110, 253));
        listTypeProducts.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        listTypeProducts.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listTypeProducts.setGridColor(new java.awt.Color(219, 221, 231));
        listTypeProducts.setGrosorBordeFilas(0);
        listTypeProducts.setMultipleSeleccion(false);
        listTypeProducts.setRowHeight(40);
        listTypeProducts.setSelectionBackground(new java.awt.Color(53, 209, 112));
        listTypeProducts.getTableHeader().setReorderingAllowed(false);
        listTypeProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTypeProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listTypeProductsMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listTypeProductsMousePressed(evt);
            }
        });
        listTypeProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listTypeProductsKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listTypeProducts);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 158, 255));
        jLabel2.setText("Mantenimiento de tipos de productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(289, 289, 289)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(idUpdateData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(idUpdateData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        RgtTypeProduct modal = new RgtTypeProduct();
        modal.setVisible(true);
        modal.accion = "savedata";
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!idUpdateData.getText().equals("")) {
            int fila = listTypeProducts.getSelectedRow();
            ControllerTypeproduct cTypeProduct = new ControllerTypeproduct();
            ModelTypeProduct mTypeProduct = new ModelTypeProduct();
            mTypeProduct.setId(Integer.parseInt(idUpdateData.getText()));
            if(cTypeProduct.deleteTypeProduct(mTypeProduct)) {
                new rojerusan.RSNotifyAnimated("SUCCESS", "HEMOS ELIMINADO EL TIPO DE PRODUCTO "+listTypeProducts.getValueAt(fila, 1).toString(),
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            } else {
                new rojerusan.RSNotifyAnimated("ERROR", "NO HEMOS PODIDO ELIMINAR EL TIPO DE PRODUCTO",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
            getTypeProduct("");
        } else {
            new rojerusan.RSNotifyAnimated("ERROR", "SOLICITUD DENEGADA, USTED NO SELECCIONÓ EL TIPO DE PRODUCTO PARA ELIMINAR, SELECCIONA UNO Y VUELVE A INTENTARLO DE NUEVO",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void listTypeProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTypeProductsMouseClicked
        int fila = listTypeProducts.getSelectedRow();
        idUpdateData.setText(listTypeProducts.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_listTypeProductsMouseClicked

    private void listTypeProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTypeProductsMousePressed
        if (evt.getClickCount() == 2) {
            int fila = listTypeProducts.getSelectedRow();
            RgtTypeProduct modal = new RgtTypeProduct();
            modal.setVisible(true);
            modal.idUpdateData.setText(listTypeProducts.getValueAt(fila, 0).toString());
            modal.txtDescription.setText(listTypeProducts.getValueAt(fila, 1).toString());
            
            modal.accion = "updatedata";
            modal.btnRegister.setText("MODIFICAR DATOS");
        }
    }//GEN-LAST:event_listTypeProductsMousePressed

    private void listTypeProductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listTypeProductsKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//           
//        }
    }//GEN-LAST:event_listTypeProductsKeyPressed

    private void listTypeProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTypeProductsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listTypeProductsMouseEntered

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        getTypeProduct(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnDelete;
    private rojerusan.RSButtonIconI btnRegister;
    public static javax.swing.JLabel idUpdateData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static rojerusan.RSTableMetro listTypeProducts;
    private RSMaterialComponent.RSTextFieldIconDos txtSearch;
    // End of variables declaration//GEN-END:variables
}
