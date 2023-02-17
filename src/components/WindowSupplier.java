package components;

import componentsregistry.RgtSupplier;
import controller.ControllerSupplier;
import database.ConnectionDB;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelSupplier;
import rojerusan.RSNotifyAnimated;

public class WindowSupplier extends javax.swing.JPanel {

    public WindowSupplier() {
        initComponents();
        idUpdateData.setVisible(false);
        jScrollPane1.getViewport().setBackground(new Color(241, 246, 249));
        getSupplier("");
    }

    void getSupplier(String search) {
        ControllerSupplier cSupplier = new ControllerSupplier();
        try {
            DefaultTableModel model;
            model = cSupplier.getSupplier(search);
            listSupplier.setModel(model);
            listSupplier.getColumnModel().getColumn(0).setMaxWidth(0);
            listSupplier.getColumnModel().getColumn(0).setMinWidth(0);
            listSupplier.getColumnModel().getColumn(0).setPreferredWidth(0);
            listSupplier.setDefaultEditor(Object.class, null);
            ConnectionDB c = new ConnectionDB();
            c.closeConection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void delete(String accion) {
        if (!idUpdateData.getText().equals("")) {
            int fila = listSupplier.getSelectedRow();
            ControllerSupplier cSupplier = new ControllerSupplier();
            ModelSupplier mSupplier = new ModelSupplier();
            mSupplier.setId(Integer.parseInt(idUpdateData.getText()));
            if (accion.equals("delete")) {
                if (cSupplier.deleteSupplier(mSupplier)) {
                    new rojerusan.RSNotifyAnimated("SUCCESS", "HEMOS ELIMINADO AL PROVEEDOR " + listSupplier.getValueAt(fila, 1).toString(),
                            5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                            RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                } else {
                    new rojerusan.RSNotifyAnimated("ERROR", "NO HEMOS PODIDO ELIMINAR AL PROVEEDOR " + listSupplier.getValueAt(fila, 1).toString(),
                            5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                            RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                }
            } else if (accion.equals("inactive")) {
                if (cSupplier.inactiveSupplier(mSupplier)) {
                    new rojerusan.RSNotifyAnimated("SUCCESS", "HEMOS ELIMINADO AL PROVEEDOR " + listSupplier.getValueAt(fila, 1).toString(),
                            5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                            RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                } else {
                    new rojerusan.RSNotifyAnimated("ERROR", "NO HEMOS PODIDO ELIMINAR AL PROVEEDOR " + listSupplier.getValueAt(fila, 1).toString(),
                            5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                            RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                }
            }
            getSupplier("");
        } else {
            new rojerusan.RSNotifyAnimated("ERROR", "SOLICITUD DENEGADA, USTED NO SELECCIONÓ AL PROVEEDOR PARA ELIMINAR, SELECCIONA UNO Y VUELVE A INTENTARLO DE NUEVO",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
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
        listSupplier = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        btnDelete1 = new rojerusan.RSButtonIconI();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 60, 84));
        jLabel1.setText("Proveedor >");

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
        txtSearch.setPlaceholder("Buscar por razón social o RUC");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        listSupplier.setBackground(new java.awt.Color(255, 255, 255));
        listSupplier.setForeground(new java.awt.Color(255, 255, 255));
        listSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        listSupplier.setColorBackgoundHead(new java.awt.Color(241, 246, 249));
        listSupplier.setColorBordeFilas(new java.awt.Color(212, 227, 236));
        listSupplier.setColorBordeHead(new java.awt.Color(212, 227, 236));
        listSupplier.setColorFilasBackgound1(new java.awt.Color(241, 246, 249));
        listSupplier.setColorFilasBackgound2(new java.awt.Color(215, 229, 237));
        listSupplier.setColorFilasForeground1(new java.awt.Color(28, 60, 84));
        listSupplier.setColorFilasForeground2(new java.awt.Color(36, 58, 74));
        listSupplier.setColorForegroundHead(new java.awt.Color(28, 60, 84));
        listSupplier.setColorSelBackgound(new java.awt.Color(13, 110, 253));
        listSupplier.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        listSupplier.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listSupplier.setGridColor(new java.awt.Color(219, 221, 231));
        listSupplier.setGrosorBordeFilas(0);
        listSupplier.setMultipleSeleccion(false);
        listSupplier.setRowHeight(40);
        listSupplier.setSelectionBackground(new java.awt.Color(53, 209, 112));
        listSupplier.getTableHeader().setReorderingAllowed(false);
        listSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listSupplierMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listSupplierMousePressed(evt);
            }
        });
        listSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listSupplierKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listSupplier);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 158, 255));
        jLabel2.setText("Mantenimiento de proveedores");

        btnDelete1.setBackground(new java.awt.Color(253, 194, 15));
        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        btnDelete1.setText("DESACTIVAR PROVEEDOR");
        btnDelete1.setToolTipText("ELIMINAR USUARIOS");
        btnDelete1.setColorHover(new java.awt.Color(219, 164, 0));
        btnDelete1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        RgtSupplier modal = new RgtSupplier();
        modal.setVisible(true);
        modal.accion = "savedata";
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete("delete");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void listSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSupplierMouseClicked
        int fila = listSupplier.getSelectedRow();
        idUpdateData.setText(listSupplier.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_listSupplierMouseClicked

    private void listSupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSupplierMousePressed
        if (evt.getClickCount() == 2) {
            int fila = listSupplier.getSelectedRow();
            RgtSupplier modal = new RgtSupplier();
            modal.setVisible(true);            
            modal.idUpdateData.setText(listSupplier.getValueAt(fila, 0).toString());
            modal.txtFullName.setText(listSupplier.getValueAt(fila, 1).toString());
            modal.txtRuc.setText(listSupplier.getValueAt(fila, 2).toString());
            modal.txtAdress.setText(listSupplier.getValueAt(fila, 3).toString());
            modal.txtCellPhone.setText(listSupplier.getValueAt(fila, 4).toString() == null?"":listSupplier.getValueAt(fila, 4).toString());

            modal.accion = "updatedata";
            modal.btnRegister.setText("MODIFICAR DATOS");
        }
    }//GEN-LAST:event_listSupplierMousePressed

    private void listSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listSupplierKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//           
//        }
    }//GEN-LAST:event_listSupplierKeyPressed

    private void listSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSupplierMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listSupplierMouseEntered

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        getSupplier(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyTyped

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        delete("inactive");
    }//GEN-LAST:event_btnDelete1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnDelete;
    private rojerusan.RSButtonIconI btnDelete1;
    private rojerusan.RSButtonIconI btnRegister;
    public static javax.swing.JLabel idUpdateData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static rojerusan.RSTableMetro listSupplier;
    private RSMaterialComponent.RSTextFieldIconDos txtSearch;
    // End of variables declaration//GEN-END:variables
}
