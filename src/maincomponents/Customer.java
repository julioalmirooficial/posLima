package maincomponents;

import components.WindowUser;
import controllerpublic.ChangePanel;
import java.awt.Color;

public class Users extends javax.swing.JPanel {

    public Users() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        subMenuUsuarios = new rojerusan.RSButtonIconI();
        subMenuPagosAlPersonal = new rojerusan.RSButtonIconI();
        mainDesktop = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jPanel2.setBackground(new java.awt.Color(241, 246, 249));

        subMenuUsuarios.setBackground(new java.awt.Color(241, 246, 249));
        subMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users-registry.png"))); // NOI18N
        subMenuUsuarios.setText("Usuarios");
        subMenuUsuarios.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuUsuarios.setColorText(new java.awt.Color(28, 60, 84));
        subMenuUsuarios.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuUsuarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuUsuariosActionPerformed(evt);
            }
        });

        subMenuPagosAlPersonal.setBackground(new java.awt.Color(241, 246, 249));
        subMenuPagosAlPersonal.setForeground(new java.awt.Color(28, 60, 84));
        subMenuPagosAlPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        subMenuPagosAlPersonal.setText("Pagos");
        subMenuPagosAlPersonal.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuPagosAlPersonal.setColorText(new java.awt.Color(28, 60, 84));
        subMenuPagosAlPersonal.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuPagosAlPersonal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuPagosAlPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subMenuPagosAlPersonalMouseClicked(evt);
            }
        });
        subMenuPagosAlPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPagosAlPersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subMenuUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subMenuPagosAlPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1016, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subMenuUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subMenuPagosAlPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        mainDesktop.setBackground(new java.awt.Color(241, 246, 249));
        mainDesktop.setForeground(new java.awt.Color(241, 246, 249));
        mainDesktop.setLayout(new javax.swing.BoxLayout(mainDesktop, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void subMenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuUsuariosActionPerformed
        subMenuUsuarios.setBackground(new Color(226, 236, 242));
        subMenuPagosAlPersonal.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowUser());
    }//GEN-LAST:event_subMenuUsuariosActionPerformed

    private void subMenuPagosAlPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subMenuPagosAlPersonalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuPagosAlPersonalMouseClicked

    private void subMenuPagosAlPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPagosAlPersonalActionPerformed
        subMenuPagosAlPersonal.setBackground(new Color(226, 236, 242));
        subMenuUsuarios.setBackground(new Color(241, 246, 249));
//        new ChangePanel(mainDesktop, new WindowPaymentUser());
    }//GEN-LAST:event_subMenuPagosAlPersonalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainDesktop;
    public static rojerusan.RSButtonIconI subMenuPagosAlPersonal;
    public static rojerusan.RSButtonIconI subMenuUsuarios;
    // End of variables declaration//GEN-END:variables
}
