package maincomponents;

import components.WindowSupplier;
import components.WindowUser;
import controllerpublic.ChangePanel;
import java.awt.Color;

public class Shopping extends javax.swing.JPanel {

    public Shopping() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        subMenuShopping = new rojerusan.RSButtonIconI();
        subMenuSupplier = new rojerusan.RSButtonIconI();
        mainDesktop = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jPanel2.setBackground(new java.awt.Color(241, 246, 249));

        subMenuShopping.setBackground(new java.awt.Color(241, 246, 249));
        subMenuShopping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shopping-product.png"))); // NOI18N
        subMenuShopping.setText("Compras");
        subMenuShopping.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuShopping.setColorText(new java.awt.Color(28, 60, 84));
        subMenuShopping.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuShopping.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuShoppingActionPerformed(evt);
            }
        });

        subMenuSupplier.setBackground(new java.awt.Color(241, 246, 249));
        subMenuSupplier.setForeground(new java.awt.Color(28, 60, 84));
        subMenuSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/proveedor.png"))); // NOI18N
        subMenuSupplier.setText("Proveedores");
        subMenuSupplier.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuSupplier.setColorText(new java.awt.Color(28, 60, 84));
        subMenuSupplier.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuSupplier.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subMenuSupplierMouseClicked(evt);
            }
        });
        subMenuSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subMenuShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subMenuSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(976, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subMenuShopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subMenuSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void subMenuShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuShoppingActionPerformed
        subMenuShopping.setBackground(new Color(226, 236, 242));
        subMenuSupplier.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowUser());
    }//GEN-LAST:event_subMenuShoppingActionPerformed

    private void subMenuSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subMenuSupplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuSupplierMouseClicked

    private void subMenuSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuSupplierActionPerformed
        subMenuSupplier.setBackground(new Color(226, 236, 242));
        subMenuShopping.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowSupplier());
    }//GEN-LAST:event_subMenuSupplierActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainDesktop;
    public static rojerusan.RSButtonIconI subMenuShopping;
    public static rojerusan.RSButtonIconI subMenuSupplier;
    // End of variables declaration//GEN-END:variables
}
