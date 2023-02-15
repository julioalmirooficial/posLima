package components;

import componentsregistry.RgtProducts;
import componentsregistry.RgtUser;
import controller.ControllerProducts;
import controller.ControllerUser;
import database.ConnectionDB;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelUser;
import rojerusan.RSNotifyAnimated;

public class WindowProducts extends javax.swing.JPanel {
    
    public WindowProducts() {
        initComponents();
        idUpdateData.setVisible(false);
        jScrollPane1.getViewport().setBackground(new Color(241, 246, 249));
        getProducts("");
    }
    
    void getProducts(String search) {
        ControllerProducts cProducts = new ControllerProducts();
        try {
            DefaultTableModel model;
            model = cProducts.getProducts(search);
            listProducts.setModel(model);
            listProducts.getColumnModel().getColumn(0).setMaxWidth(0);
            listProducts.getColumnModel().getColumn(0).setMinWidth(0);
            listProducts.getColumnModel().getColumn(0).setPreferredWidth(0);
            listProducts.getColumnModel().getColumn(1).setMaxWidth(0);
            listProducts.getColumnModel().getColumn(1).setMinWidth(0);
            listProducts.getColumnModel().getColumn(1).setPreferredWidth(0);
            listProducts.getColumnModel().getColumn(12).setMaxWidth(0);
            listProducts.getColumnModel().getColumn(12).setMinWidth(0);
            listProducts.getColumnModel().getColumn(12).setPreferredWidth(0);
            listProducts.getColumnModel().getColumn(13).setMaxWidth(0);
            listProducts.getColumnModel().getColumn(13).setMinWidth(0);
            listProducts.getColumnModel().getColumn(13).setPreferredWidth(0);
            listProducts.setDefaultEditor(Object.class, null);
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
        listProducts = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 60, 84));
        jLabel1.setText("Productos >");

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

        listProducts.setBackground(new java.awt.Color(255, 255, 255));
        listProducts.setForeground(new java.awt.Color(255, 255, 255));
        listProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        listProducts.setColorBackgoundHead(new java.awt.Color(241, 246, 249));
        listProducts.setColorBordeFilas(new java.awt.Color(212, 227, 236));
        listProducts.setColorBordeHead(new java.awt.Color(212, 227, 236));
        listProducts.setColorFilasBackgound1(new java.awt.Color(241, 246, 249));
        listProducts.setColorFilasBackgound2(new java.awt.Color(215, 229, 237));
        listProducts.setColorFilasForeground1(new java.awt.Color(28, 60, 84));
        listProducts.setColorFilasForeground2(new java.awt.Color(36, 58, 74));
        listProducts.setColorForegroundHead(new java.awt.Color(28, 60, 84));
        listProducts.setColorSelBackgound(new java.awt.Color(13, 110, 253));
        listProducts.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        listProducts.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listProducts.setGridColor(new java.awt.Color(219, 221, 231));
        listProducts.setGrosorBordeFilas(0);
        listProducts.setMultipleSeleccion(false);
        listProducts.setRowHeight(40);
        listProducts.setSelectionBackground(new java.awt.Color(53, 209, 112));
        listProducts.getTableHeader().setReorderingAllowed(false);
        listProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listProductsMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listProductsMousePressed(evt);
            }
        });
        listProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listProductsKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listProducts);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 158, 255));
        jLabel2.setText("Mantenimiento de productos");

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
        RgtProducts modal = new RgtProducts();
        modal.setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!idUpdateData.getText().equals("")) {
            int fila = listProducts.getSelectedRow();
            ControllerUser cUser = new ControllerUser();
            ModelUser mUser = new ModelUser();
            mUser.setId(Integer.parseInt(idUpdateData.getText()));
            if(cUser.deleteUser(mUser)) {
                new rojerusan.RSNotifyAnimated("SUCCESS", "HEMOS ELIMINADO AL USARIO "+listProducts.getValueAt(fila, 1).toString(),
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            } else {
                new rojerusan.RSNotifyAnimated("ERROR", "NO HEMOS PODIDO ELIMINAR AL SUARIO"+listProducts.getValueAt(fila, 1).toString(),
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
            getProducts("");
        } else {
            new rojerusan.RSNotifyAnimated("ERROR", "SOLICITUD DENEGADA, USTED NO SELECCIONÓ EL USARIO PARA ELIMINAR, SELECCIONA UNO Y VUELVE A INTENTARLO DE NUEVO",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void listProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMouseClicked
        int fila = listProducts.getSelectedRow();
        idUpdateData.setText(listProducts.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_listProductsMouseClicked

    private void listProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMousePressed
        if (evt.getClickCount() == 2) {
            int fila = listProducts.getSelectedRow();
            RgtUser modal = new RgtUser();
            modal.setVisible(true);
            modal.idUpdateData.setText(listProducts.getValueAt(fila, 0).toString());
            modal.txtFullName.setText(listProducts.getValueAt(fila, 1).toString());
            modal.txtEmail.setText(listProducts.getValueAt(fila, 2).toString());
            modal.txtPassword.setText(listProducts.getValueAt(fila, 3).toString());
            modal.txtUserName.setText(listProducts.getValueAt(fila, 4).toString());
            modal.txtNumberDocument.setText(listProducts.getValueAt(fila, 5).toString());
            modal.cbxTypeUser.setSelectedItem(listProducts.getValueAt(fila, 6).toString());
            
            modal.accion = "updatedata";
            modal.btnRegister.setText("MODIFICAR DATOS");
        }
    }//GEN-LAST:event_listProductsMousePressed

    private void listProductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listProductsKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//           
//        }
    }//GEN-LAST:event_listProductsKeyPressed

    private void listProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listProductsMouseEntered

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        getProducts(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnDelete;
    private rojerusan.RSButtonIconI btnRegister;
    public static javax.swing.JLabel idUpdateData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static rojerusan.RSTableMetro listProducts;
    private RSMaterialComponent.RSTextFieldIconDos txtSearch;
    // End of variables declaration//GEN-END:variables
}
