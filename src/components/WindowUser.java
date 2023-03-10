package components;

import componentsregistry.RgtUser;
import controller.ControllerUser;
import database.ConnectionDB;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelUser;
import rojerusan.RSNotifyAnimated;

public class WindowUser extends javax.swing.JPanel {
    
    public WindowUser() {
        initComponents();
        idUpdateData.setVisible(false);
        jScrollPane1.getViewport().setBackground(new Color(241, 246, 249));
        getUser("");
    }
    
    void getUser(String search) {
        ControllerUser cUser = new ControllerUser();
        try {
            DefaultTableModel model;
            model = cUser.getUser(search);
            listUser.setModel(model);
            listUser.getColumnModel().getColumn(0).setMaxWidth(0);
            listUser.getColumnModel().getColumn(0).setMinWidth(0);
            listUser.getColumnModel().getColumn(0).setPreferredWidth(0);
            listUser.getColumnModel().getColumn(3).setMaxWidth(0);
            listUser.getColumnModel().getColumn(3).setMinWidth(0);
            listUser.getColumnModel().getColumn(3).setPreferredWidth(0);
            listUser.setDefaultEditor(Object.class, null);
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
        listUser = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 60, 84));
        jLabel1.setText("Usuarios >");

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

        listUser.setBackground(new java.awt.Color(255, 255, 255));
        listUser.setForeground(new java.awt.Color(255, 255, 255));
        listUser.setModel(new javax.swing.table.DefaultTableModel(
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
        listUser.setColorBackgoundHead(new java.awt.Color(241, 246, 249));
        listUser.setColorBordeFilas(new java.awt.Color(212, 227, 236));
        listUser.setColorBordeHead(new java.awt.Color(212, 227, 236));
        listUser.setColorFilasBackgound1(new java.awt.Color(241, 246, 249));
        listUser.setColorFilasBackgound2(new java.awt.Color(215, 229, 237));
        listUser.setColorFilasForeground1(new java.awt.Color(28, 60, 84));
        listUser.setColorFilasForeground2(new java.awt.Color(36, 58, 74));
        listUser.setColorForegroundHead(new java.awt.Color(28, 60, 84));
        listUser.setColorSelBackgound(new java.awt.Color(13, 110, 253));
        listUser.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        listUser.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listUser.setGridColor(new java.awt.Color(219, 221, 231));
        listUser.setGrosorBordeFilas(0);
        listUser.setMultipleSeleccion(false);
        listUser.setRowHeight(40);
        listUser.setSelectionBackground(new java.awt.Color(53, 209, 112));
        listUser.getTableHeader().setReorderingAllowed(false);
        listUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listUserMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listUserMousePressed(evt);
            }
        });
        listUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listUserKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listUser);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 158, 255));
        jLabel2.setText("Mantenimiento de usuarios");

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
        RgtUser modal = new RgtUser();
        modal.setVisible(true);        
        modal.accion = "savedata";
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!idUpdateData.getText().equals("")) {
            int fila = listUser.getSelectedRow();
            ControllerUser cUser = new ControllerUser();
            ModelUser mUser = new ModelUser();
            mUser.setId(Integer.parseInt(idUpdateData.getText()));
            if(cUser.deleteUser(mUser)) {
                new rojerusan.RSNotifyAnimated("SUCCESS", "HEMOS ELIMINADO AL USARIO "+listUser.getValueAt(fila, 1).toString(),
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            } else {
                new rojerusan.RSNotifyAnimated("ERROR", "NO HEMOS PODIDO ELIMINAR AL SUARIO"+listUser.getValueAt(fila, 1).toString(),
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
            getUser("");
        } else {
            new rojerusan.RSNotifyAnimated("ERROR", "SOLICITUD DENEGADA, USTED NO SELECCION?? EL USARIO PARA ELIMINAR, SELECCIONA UNO Y VUELVE A INTENTARLO DE NUEVO",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void listUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listUserMouseClicked
        int fila = listUser.getSelectedRow();
        idUpdateData.setText(listUser.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_listUserMouseClicked

    private void listUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listUserMousePressed
        if (evt.getClickCount() == 2) {
            int fila = listUser.getSelectedRow();
            RgtUser modal = new RgtUser();
            modal.setVisible(true);
            modal.idUpdateData.setText(listUser.getValueAt(fila, 0).toString());
            modal.txtFullName.setText(listUser.getValueAt(fila, 1).toString());
            modal.txtEmail.setText(listUser.getValueAt(fila, 2).toString());
            modal.txtPassword.setText(listUser.getValueAt(fila, 3).toString());
            modal.txtUserName.setText(listUser.getValueAt(fila, 4).toString());
            modal.txtNumberDocument.setText(listUser.getValueAt(fila, 5).toString());
            modal.cbxTypeUser.setSelectedItem(listUser.getValueAt(fila, 6).toString());
            
            modal.accion = "updatedata";
            modal.btnRegister.setText("MODIFICAR DATOS");
        }
    }//GEN-LAST:event_listUserMousePressed

    private void listUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listUserKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//           
//        }
    }//GEN-LAST:event_listUserKeyPressed

    private void listUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listUserMouseEntered

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        getUser(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnDelete;
    private rojerusan.RSButtonIconI btnRegister;
    public static javax.swing.JLabel idUpdateData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static rojerusan.RSTableMetro listUser;
    private RSMaterialComponent.RSTextFieldIconDos txtSearch;
    // End of variables declaration//GEN-END:variables
}
