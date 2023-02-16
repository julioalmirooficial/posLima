package maincomponents;

import components.WindowProducts;
import components.WindowTypeProduct;
import components.WindowUser;
import controllerpublic.ChangePanel;
import java.awt.Color;

public class Store extends javax.swing.JPanel {

    public Store() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        subMenuProducts = new rojerusan.RSButtonIconI();
        subMenuTypeProducts = new rojerusan.RSButtonIconI();
        mainDesktop = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jPanel2.setBackground(new java.awt.Color(241, 246, 249));

        subMenuProducts.setBackground(new java.awt.Color(241, 246, 249));
        subMenuProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/products.png"))); // NOI18N
        subMenuProducts.setText("Productos");
        subMenuProducts.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuProducts.setColorText(new java.awt.Color(28, 60, 84));
        subMenuProducts.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuProducts.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuProductsActionPerformed(evt);
            }
        });

        subMenuTypeProducts.setBackground(new java.awt.Color(241, 246, 249));
        subMenuTypeProducts.setForeground(new java.awt.Color(28, 60, 84));
        subMenuTypeProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stock.png"))); // NOI18N
        subMenuTypeProducts.setText("Tipo de productos");
        subMenuTypeProducts.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuTypeProducts.setColorText(new java.awt.Color(28, 60, 84));
        subMenuTypeProducts.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuTypeProducts.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuTypeProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subMenuTypeProductsMouseClicked(evt);
            }
        });
        subMenuTypeProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuTypeProductsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subMenuProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subMenuTypeProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(944, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subMenuProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subMenuTypeProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void subMenuProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuProductsActionPerformed
        subMenuProducts.setBackground(new Color(226, 236, 242));
        subMenuTypeProducts.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowProducts());
    }//GEN-LAST:event_subMenuProductsActionPerformed

    private void subMenuTypeProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subMenuTypeProductsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuTypeProductsMouseClicked

    private void subMenuTypeProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuTypeProductsActionPerformed
        subMenuTypeProducts.setBackground(new Color(226, 236, 242));
        subMenuProducts.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowTypeProduct());
    }//GEN-LAST:event_subMenuTypeProductsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainDesktop;
    public static rojerusan.RSButtonIconI subMenuProducts;
    public static rojerusan.RSButtonIconI subMenuTypeProducts;
    // End of variables declaration//GEN-END:variables
}
