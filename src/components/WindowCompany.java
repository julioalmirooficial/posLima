package components;

import controller.ControllerCompany;
import database.ConnectionDB;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelCompany;
import rojerusan.RSNotifyAnimated;

public class WindowCompany extends javax.swing.JPanel {
    private String accion = "savedata";
    public WindowCompany() {
        initComponents();
        idUpdateData.setVisible(false);
        getCompany();
    }
    
    void getCompany() {
        ControllerCompany cCompany = new ControllerCompany();
        try {
            if(cCompany.existCompany()) {
                cCompany.getCompany();
                accion = "updatedata";
                btnRegister.setText("Modificar empresa");
            } else {
                lblNameCommpany.setText("EMPRESA POR CONFIGURAR");
            }
            
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
        idUpdateData = new javax.swing.JLabel();
        btnRegister = new rojerusan.RSButtonIconI();
        lblNameCommpany = new javax.swing.JLabel();
        txtNameCompany = new RSMaterialComponent.RSTextFieldMaterial();
        txtAdress = new RSMaterialComponent.RSTextFieldMaterial();
        txtEmail = new RSMaterialComponent.RSTextFieldMaterial();
        txtCellPhone = new RSMaterialComponent.RSTextFieldMaterial();
        txtRUC = new RSMaterialComponent.RSTextFieldMaterial();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        btnRegister.setBackground(new java.awt.Color(13, 110, 253));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        btnRegister.setText("Agregar un empresa");
        btnRegister.setToolTipText("");
        btnRegister.setColorHover(new java.awt.Color(28, 119, 255));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        lblNameCommpany.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNameCommpany.setForeground(new java.awt.Color(25, 158, 255));
        lblNameCommpany.setText("----");

        txtNameCompany.setForeground(new java.awt.Color(28, 60, 84));
        txtNameCompany.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtNameCompany.setPhColor(new java.awt.Color(28, 60, 84));
        txtNameCompany.setPlaceholder("Razón Social");
        txtNameCompany.setSelectionColor(new java.awt.Color(117, 95, 238));

        txtAdress.setForeground(new java.awt.Color(28, 60, 84));
        txtAdress.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtAdress.setPhColor(new java.awt.Color(28, 60, 84));
        txtAdress.setPlaceholder("Dirección de la empresa");
        txtAdress.setSelectionColor(new java.awt.Color(117, 95, 238));

        txtEmail.setForeground(new java.awt.Color(28, 60, 84));
        txtEmail.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtEmail.setPhColor(new java.awt.Color(28, 60, 84));
        txtEmail.setPlaceholder("Correo electrónico");
        txtEmail.setSelectionColor(new java.awt.Color(117, 95, 238));

        txtCellPhone.setForeground(new java.awt.Color(28, 60, 84));
        txtCellPhone.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtCellPhone.setPhColor(new java.awt.Color(28, 60, 84));
        txtCellPhone.setPlaceholder("Celular // Teléfono");
        txtCellPhone.setSelectionColor(new java.awt.Color(117, 95, 238));

        txtRUC.setForeground(new java.awt.Color(28, 60, 84));
        txtRUC.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtRUC.setPhColor(new java.awt.Color(28, 60, 84));
        txtRUC.setPlaceholder("RUC");
        txtRUC.setSelectionColor(new java.awt.Color(117, 95, 238));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNameCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNameCommpany, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                        .addGap(467, 467, 467)
                        .addComponent(idUpdateData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCellPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNameCommpany)
                    .addComponent(idUpdateData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(txtNameCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCellPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
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
        if(txtNameCompany.getText().length() <= 5) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA LA RAZÓN SOCIAL DE EMPRESA",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        if(txtRUC.getText().length() <= 10) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA EL RUC DE LA EMPRESA",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        
        try {
            ControllerCompany cCompany = new ControllerCompany();
            ModelCompany mCompany = new ModelCompany();
            mCompany.setFullName(txtNameCompany.getText());
            mCompany.setAdress(txtAdress.getText());
            mCompany.setCellPhone(txtCellPhone.getText());
            mCompany.setEmail(txtEmail.getText());
            mCompany.setNumberDocument(txtRUC.getText());
            if(accion.equals("savedata")) {
                if(cCompany.insertCompany(mCompany)) {
                    new rojerusan.RSNotifyAnimated("FELICIDADES", "HAS REGISTRADO UNA EMPRESA",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                    getCompany();
                } else {
                    new rojerusan.RSNotifyAnimated("UPPS", "ALGO SALIO MAL AL MONENTO DE CONFIGURAR LA EMPRESA, INTENTALO DE NUEVO",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                }
                ConnectionDB c = new ConnectionDB();
                c.closeConection();
            } else if(accion.equals("updatedata")){
                mCompany.setId(Integer.parseInt(idUpdateData.getText()));
                if(cCompany.updateCompany(mCompany)) {
                    new rojerusan.RSNotifyAnimated("FELICIDADES", "HEMOS MODIFICADO LOS DATOS DE LA EMPRESA",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                    getCompany();
                } else {
                    new rojerusan.RSNotifyAnimated("UPPS", "ALGO SALIO MAL AL MONENTO DE MODIFICAR LOS DATOS DE LA EMPRESA, INTENTALO DE NUEVO",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                }
                ConnectionDB c = new ConnectionDB();
                c.closeConection();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnRegister;
    public static javax.swing.JLabel idUpdateData;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblNameCommpany;
    public static RSMaterialComponent.RSTextFieldMaterial txtAdress;
    public static RSMaterialComponent.RSTextFieldMaterial txtCellPhone;
    public static RSMaterialComponent.RSTextFieldMaterial txtEmail;
    public static RSMaterialComponent.RSTextFieldMaterial txtNameCompany;
    public static RSMaterialComponent.RSTextFieldMaterial txtRUC;
    // End of variables declaration//GEN-END:variables
}
