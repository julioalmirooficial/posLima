package componentsregistry;

import componenttoselect.ModalProducts;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import rojerusan.RSNotifyAnimated;

public class QuantitySHopping extends javax.swing.JDialog {

    public static final int RET_CANCEL = 0;

    public static String pShooping ;
    public static String pSales ;
    public static String utility ;

    public QuantitySHopping(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        txtPriceShopping.setText(pShooping);
        txtPriceSale.setText(pSales);
        txtUtility.setText(utility);
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    public int getReturnStatus() {
        return returnStatus;
    }
    
     void generateNewPriceSale() {
        if (txtPriceShopping.getText().length() <= 0) {
            new rojerusan.RSNotifyAnimated("ERROR", "EL PRECIO DE COMPRA NO DEBE DE IR CON EL VALOR DE VACIO, INGRESA Y UTLIDAD Y EL PRECIO DE COMPRA",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        if (Double.parseDouble(txtPriceShopping.getText()) <= 0) {
            new rojerusan.RSNotifyAnimated("ERROR", "EL PRECIO DE COMPRA NO DEBE DE IR CON EL VALOR DE 0, INGRESA Y UTLIDAD Y EL PRECIO DE COMPRA",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        double generatePercentage = Double.parseDouble(txtUtility.getText()) / 100;
        double generateUtility = Double.parseDouble(txtPriceShopping.getText()) * generatePercentage;
        double generateNewPrice = Double.parseDouble(txtPriceShopping.getText()) + generateUtility;
        txtPriceSale.setText(String.valueOf(Math.round(generateNewPrice * 100) / 100d));
    }
void insert() {
    if(Double.parseDouble(txtQuantityShopping.getText()) <= 0) {
             new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA LA CANTIDAD DE COMPRA DEL PRODUCTO",
                            5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                            RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
             return;
        }
        if(Double.parseDouble(txtPriceSale.getText()) <= 0) {
             new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA EL PRECIO DE VENTA DEL PRODUCTO",
                            5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                            RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
             return;
        }
        if(Double.parseDouble(txtPriceShopping.getText()) <= 0) {
             new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA EL PRECIO DE COMPRA DEL PRODUCTO",
                            5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                            RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
             return;
        }
        
        ModalProducts.pQuantity = txtQuantityShopping.getText();
        ModalProducts.pSales = txtPriceSale.getText();
        ModalProducts.pShopping = txtPriceShopping.getText();
        ModalProducts.utility = txtUtility.getText();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        txtPriceShopping = new RSMaterialComponent.RSTextFieldMaterial();
        txtPriceSale = new RSMaterialComponent.RSTextFieldMaterial();
        txtQuantityShopping = new RSMaterialComponent.RSTextFieldMaterial();
        txtUtility = new RSMaterialComponent.RSTextFieldMaterial();

        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(53, 209, 112), 4, true));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 209, 112));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONFIGURA TU COMPRA");

        rSButtonHover1.setBackground(new java.awt.Color(53, 209, 112));
        rSButtonHover1.setText("Configurar");
        rSButtonHover1.setColorHover(new java.awt.Color(91, 214, 137));
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });

        txtPriceShopping.setForeground(new java.awt.Color(53, 209, 112));
        txtPriceShopping.setText("0.00");
        txtPriceShopping.setColorMaterial(new java.awt.Color(53, 209, 112));
        txtPriceShopping.setPhColor(new java.awt.Color(28, 60, 84));
        txtPriceShopping.setPlaceholder("Precio compra");

        txtPriceSale.setForeground(new java.awt.Color(53, 209, 112));
        txtPriceSale.setText("0.00");
        txtPriceSale.setColorMaterial(new java.awt.Color(53, 209, 112));
        txtPriceSale.setPhColor(new java.awt.Color(28, 60, 84));
        txtPriceSale.setPlaceholder("Precio venta");

        txtQuantityShopping.setForeground(new java.awt.Color(53, 209, 112));
        txtQuantityShopping.setText("0.00");
        txtQuantityShopping.setColorMaterial(new java.awt.Color(53, 209, 112));
        txtQuantityShopping.setPhColor(new java.awt.Color(28, 60, 84));
        txtQuantityShopping.setPlaceholder("Cantidad de compra");
        txtQuantityShopping.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantityShoppingKeyPressed(evt);
            }
        });

        txtUtility.setForeground(new java.awt.Color(53, 209, 112));
        txtUtility.setText("0.00");
        txtUtility.setColorMaterial(new java.awt.Color(53, 209, 112));
        txtUtility.setPhColor(new java.awt.Color(28, 60, 84));
        txtUtility.setPlaceholder("Utilidad");
        txtUtility.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUtilityKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuantityShopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPriceShopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUtility, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(txtPriceSale, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPriceShopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtQuantityShopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPriceSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUtility, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rSButtonHover1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog

    }//GEN-LAST:event_closeDialog

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        
        insert();
        
        
        doClose(RET_CANCEL);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void txtUtilityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUtilityKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            generateNewPriceSale();
        }
    }//GEN-LAST:event_txtUtilityKeyPressed

    private void txtQuantityShoppingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityShoppingKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            insert();
            doClose(RET_CANCEL);
        }
    }//GEN-LAST:event_txtQuantityShoppingKeyPressed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

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
            java.util.logging.Logger.getLogger(QuantitySHopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuantitySHopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuantitySHopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuantitySHopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuantitySHopping dialog = new QuantitySHopping(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSButtonHover rSButtonHover1;
    public static RSMaterialComponent.RSTextFieldMaterial txtPriceSale;
    public static RSMaterialComponent.RSTextFieldMaterial txtPriceShopping;
    public static RSMaterialComponent.RSTextFieldMaterial txtQuantityShopping;
    public static RSMaterialComponent.RSTextFieldMaterial txtUtility;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
