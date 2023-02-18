package maincomponents;

import components.WindowRPTBox;
import components.WindowRPTCustomer;
import components.WindowRPTProducts;
import components.WindowRPTSales;
import components.WindowRPTShopping;
import components.WindowRPTSupplier;
import components.WindowSupplier;
import controllerpublic.ChangePanel;
import java.awt.Color;

public class Reports extends javax.swing.JPanel {

    public Reports() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        subMenuReportSales = new rojerusan.RSButtonIconI();
        subMenuReportShopping = new rojerusan.RSButtonIconI();
        subMenuReportCustomer = new rojerusan.RSButtonIconI();
        submenuReportSupplier = new rojerusan.RSButtonIconI();
        subMenuReportProducts = new rojerusan.RSButtonIconI();
        subMenuReportBox = new rojerusan.RSButtonIconI();
        mainDesktop = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jPanel2.setBackground(new java.awt.Color(241, 246, 249));

        subMenuReportSales.setBackground(new java.awt.Color(241, 246, 249));
        subMenuReportSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report-two.png"))); // NOI18N
        subMenuReportSales.setText("Reporte de ventas");
        subMenuReportSales.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuReportSales.setColorText(new java.awt.Color(28, 60, 84));
        subMenuReportSales.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuReportSales.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuReportSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuReportSalesActionPerformed(evt);
            }
        });

        subMenuReportShopping.setBackground(new java.awt.Color(241, 246, 249));
        subMenuReportShopping.setForeground(new java.awt.Color(28, 60, 84));
        subMenuReportShopping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reporte-compras.png"))); // NOI18N
        subMenuReportShopping.setText("Reporte de compras");
        subMenuReportShopping.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuReportShopping.setColorText(new java.awt.Color(28, 60, 84));
        subMenuReportShopping.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuReportShopping.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuReportShopping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subMenuReportShoppingMouseClicked(evt);
            }
        });
        subMenuReportShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuReportShoppingActionPerformed(evt);
            }
        });

        subMenuReportCustomer.setBackground(new java.awt.Color(241, 246, 249));
        subMenuReportCustomer.setForeground(new java.awt.Color(28, 60, 84));
        subMenuReportCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        subMenuReportCustomer.setText("Reporte de clientes");
        subMenuReportCustomer.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuReportCustomer.setColorText(new java.awt.Color(28, 60, 84));
        subMenuReportCustomer.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuReportCustomer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuReportCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subMenuReportCustomerMouseClicked(evt);
            }
        });
        subMenuReportCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuReportCustomerActionPerformed(evt);
            }
        });

        submenuReportSupplier.setBackground(new java.awt.Color(241, 246, 249));
        submenuReportSupplier.setForeground(new java.awt.Color(28, 60, 84));
        submenuReportSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        submenuReportSupplier.setText("Reporte de proveedores");
        submenuReportSupplier.setColorHover(new java.awt.Color(226, 236, 242));
        submenuReportSupplier.setColorText(new java.awt.Color(28, 60, 84));
        submenuReportSupplier.setColorTextHover(new java.awt.Color(44, 88, 120));
        submenuReportSupplier.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        submenuReportSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submenuReportSupplierMouseClicked(evt);
            }
        });
        submenuReportSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportSupplierActionPerformed(evt);
            }
        });

        subMenuReportProducts.setBackground(new java.awt.Color(241, 246, 249));
        subMenuReportProducts.setForeground(new java.awt.Color(28, 60, 84));
        subMenuReportProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        subMenuReportProducts.setText("Reporte de productos");
        subMenuReportProducts.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuReportProducts.setColorText(new java.awt.Color(28, 60, 84));
        subMenuReportProducts.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuReportProducts.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuReportProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subMenuReportProductsMouseClicked(evt);
            }
        });
        subMenuReportProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuReportProductsActionPerformed(evt);
            }
        });

        subMenuReportBox.setBackground(new java.awt.Color(241, 246, 249));
        subMenuReportBox.setForeground(new java.awt.Color(28, 60, 84));
        subMenuReportBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        subMenuReportBox.setText("Reporte de cajas");
        subMenuReportBox.setColorHover(new java.awt.Color(226, 236, 242));
        subMenuReportBox.setColorText(new java.awt.Color(28, 60, 84));
        subMenuReportBox.setColorTextHover(new java.awt.Color(44, 88, 120));
        subMenuReportBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subMenuReportBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subMenuReportBoxMouseClicked(evt);
            }
        });
        subMenuReportBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuReportBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subMenuReportSales, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subMenuReportShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subMenuReportCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submenuReportSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subMenuReportProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subMenuReportBox, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subMenuReportSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subMenuReportShopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subMenuReportCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submenuReportSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subMenuReportProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subMenuReportBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void subMenuReportSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuReportSalesActionPerformed
        subMenuReportSales.setBackground(new Color(226, 236, 242));
        subMenuReportShopping.setBackground(new Color(241, 246, 249));
        subMenuReportProducts.setBackground(new Color(241, 246, 249));
        subMenuReportCustomer.setBackground(new Color(241, 246, 249));
        submenuReportSupplier.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowRPTSales());
    }//GEN-LAST:event_subMenuReportSalesActionPerformed

    private void subMenuReportShoppingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subMenuReportShoppingMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuReportShoppingMouseClicked

    private void subMenuReportShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuReportShoppingActionPerformed
        subMenuReportShopping.setBackground(new Color(226, 236, 242));
        subMenuReportSales.setBackground(new Color(241, 246, 249));
        subMenuReportProducts.setBackground(new Color(241, 246, 249));
        subMenuReportCustomer.setBackground(new Color(241, 246, 249));
        submenuReportSupplier.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowRPTShopping());
    }//GEN-LAST:event_subMenuReportShoppingActionPerformed

    private void subMenuReportCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subMenuReportCustomerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuReportCustomerMouseClicked

    private void subMenuReportCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuReportCustomerActionPerformed
        subMenuReportCustomer.setBackground(new Color(226, 236, 242));
        subMenuReportSales.setBackground(new Color(241, 246, 249));
        subMenuReportProducts.setBackground(new Color(241, 246, 249));
        subMenuReportShopping.setBackground(new Color(241, 246, 249));
        submenuReportSupplier.setBackground(new Color(241, 246, 249));
        subMenuReportBox.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowRPTCustomer());
    }//GEN-LAST:event_subMenuReportCustomerActionPerformed

    private void submenuReportSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submenuReportSupplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_submenuReportSupplierMouseClicked

    private void submenuReportSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportSupplierActionPerformed
        submenuReportSupplier.setBackground(new Color(226, 236, 242));
        subMenuReportSales.setBackground(new Color(241, 246, 249));
        subMenuReportProducts.setBackground(new Color(241, 246, 249));
        subMenuReportShopping.setBackground(new Color(241, 246, 249));
        subMenuReportCustomer.setBackground(new Color(241, 246, 249));
        subMenuReportBox.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowRPTSupplier());
    }//GEN-LAST:event_submenuReportSupplierActionPerformed

    private void subMenuReportProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subMenuReportProductsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuReportProductsMouseClicked

    private void subMenuReportProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuReportProductsActionPerformed
        subMenuReportProducts.setBackground(new Color(226, 236, 242));
        subMenuReportSales.setBackground(new Color(241, 246, 249));
        submenuReportSupplier.setBackground(new Color(241, 246, 249));
        subMenuReportShopping.setBackground(new Color(241, 246, 249));
        subMenuReportCustomer.setBackground(new Color(241, 246, 249));
        subMenuReportBox.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowRPTProducts());
    }//GEN-LAST:event_subMenuReportProductsActionPerformed

    private void subMenuReportBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subMenuReportBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuReportBoxMouseClicked

    private void subMenuReportBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuReportBoxActionPerformed
         subMenuReportBox.setBackground(new Color(226, 236, 242));
        subMenuReportSales.setBackground(new Color(241, 246, 249));
        submenuReportSupplier.setBackground(new Color(241, 246, 249));
        subMenuReportShopping.setBackground(new Color(241, 246, 249));
        subMenuReportCustomer.setBackground(new Color(241, 246, 249));
        subMenuReportProducts.setBackground(new Color(241, 246, 249));
        new ChangePanel(mainDesktop, new WindowRPTBox());
    }//GEN-LAST:event_subMenuReportBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel mainDesktop;
    public static rojerusan.RSButtonIconI subMenuReportBox;
    public static rojerusan.RSButtonIconI subMenuReportCustomer;
    public static rojerusan.RSButtonIconI subMenuReportProducts;
    public static rojerusan.RSButtonIconI subMenuReportSales;
    public static rojerusan.RSButtonIconI subMenuReportShopping;
    public static rojerusan.RSButtonIconI submenuReportSupplier;
    // End of variables declaration//GEN-END:variables
}
