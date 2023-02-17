package components;

import componenttoselect.ModalProductsShopping;
import componenttoselect.ModalSupplier;
import controller.ControllerGetNumberVoucher;
import controller.ControllerShopping;
import controllerpublic.ChangePanel;
import database.ConnectionDB;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import main.Home;
import maincomponents.Shopping;
import model.ModelDetailShopping;
import model.ModelShopping;
import model.ModelVoucher;
import rojerusan.RSNotifyAnimated;

public class WindowShopping extends javax.swing.JPanel {

    public static String[] headers = {"ID", "Descripción", "Precio de compra", "Precio de venta", "Cant.", "Total", "utility"};
    public static DefaultTableModel modelTable;

    public WindowShopping() {
        initComponents();
        idUpdateData.setVisible(false);
        modelTable = new DefaultTableModel(null, headers);
        listProducts.setModel(modelTable);
        listProducts.getColumnModel().getColumn(0).setMaxWidth(0);
        listProducts.getColumnModel().getColumn(0).setMinWidth(0);
        listProducts.getColumnModel().getColumn(0).setPreferredWidth(0);
        listProducts.getColumnModel().getColumn(6).setMaxWidth(0);
        listProducts.getColumnModel().getColumn(6).setMinWidth(0);
        listProducts.getColumnModel().getColumn(6).setPreferredWidth(0);
        listProducts.setDefaultEditor(Object.class, null);
    }

//    void getCompany() {
//        ControllerCompany cCompany = new ControllerCompany();
//        try {
//            if(cCompany.existCompany()) {
//                cCompany.getCompany();
//                accion = "updatedata";
//                btnRegister.setText("Modificar empresa");
//            } else {
//                lblNameCommpany.setText("EMPRESA POR CONFIGURAR");
//            }
//            
//            ConnectionDB c = new ConnectionDB();
//            c.closeConection();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    void calculateTotal() {
        double total = 0;
        double subTotal = 0;
        double igv = 0;

        for (int i = 0; i < listProducts.getRowCount(); i++) {
            total += Double.parseDouble(listProducts.getValueAt(i, 5).toString());
        }
        subTotal = total / 1.18;
        igv = subTotal * 0.18;
        lblTotal.setText(String.valueOf(Math.round(total * 100) / 100d));
        lblSubTotal.setText(String.valueOf(Math.round(subTotal * 100) / 100d));
        lblIGV.setText(String.valueOf(Math.round(igv * 100) / 100d));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        idUpdateData = new javax.swing.JLabel();
        btnSearchProducts = new rojerusan.RSButtonIconI();
        txtNameSupplier = new RSMaterialComponent.RSTextFieldMaterial();
        btnAdd = new rojerusan.RSButtonIconI();
        btnSearchSupplier = new rojerusan.RSButtonIconI();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProducts = new rojerusan.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblIGV = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtDiscount = new rojeru_san.rsfield.RSTextFullRound();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        btnSearchProducts.setBackground(new java.awt.Color(53, 209, 112));
        btnSearchProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-light.png"))); // NOI18N
        btnSearchProducts.setMnemonic('s');
        btnSearchProducts.setText("Buscar productos");
        btnSearchProducts.setToolTipText("ALT + S");
        btnSearchProducts.setColorHover(new java.awt.Color(62, 215, 120));
        btnSearchProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductsActionPerformed(evt);
            }
        });

        txtNameSupplier.setEditable(false);
        txtNameSupplier.setBackground(new java.awt.Color(241, 246, 249));
        txtNameSupplier.setForeground(new java.awt.Color(28, 60, 84));
        txtNameSupplier.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtNameSupplier.setPhColor(new java.awt.Color(28, 60, 84));
        txtNameSupplier.setPlaceholder("Proveedor");
        txtNameSupplier.setSelectionColor(new java.awt.Color(117, 95, 238));

        btnAdd.setBackground(new java.awt.Color(13, 110, 253));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        btnAdd.setText("Generar compra");
        btnAdd.setToolTipText("");
        btnAdd.setColorHover(new java.awt.Color(28, 119, 255));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearchSupplier.setBackground(new java.awt.Color(13, 110, 253));
        btnSearchSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-light.png"))); // NOI18N
        btnSearchSupplier.setMnemonic('p');
        btnSearchSupplier.setText("Buscar proveedor");
        btnSearchSupplier.setToolTipText("ALT + P");
        btnSearchSupplier.setColorHover(new java.awt.Color(28, 119, 255));
        btnSearchSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSupplierActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 60, 84));
        jLabel1.setText("TOTAL");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(28, 60, 84));
        jLabel2.setText("SUB TOTAL");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(28, 60, 84));
        jLabel3.setText("IGV");

        lblIGV.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblIGV.setForeground(new java.awt.Color(28, 60, 84));
        lblIGV.setText("0.00");

        lblSubTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(28, 60, 84));
        lblSubTotal.setText("0.00");

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(28, 60, 84));
        lblTotal.setText("0.00");

        txtDiscount.setBackground(new java.awt.Color(255, 255, 255));
        txtDiscount.setForeground(new java.awt.Color(28, 60, 84));
        txtDiscount.setText("0");
        txtDiscount.setBorderColor(new java.awt.Color(28, 60, 84));
        txtDiscount.setPhColor(new java.awt.Color(28, 60, 84));
        txtDiscount.setPlaceholder("Ingresa tu descuento");
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDiscountKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(28, 60, 84));
        jLabel7.setText("DESCUENTO (%)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idUpdateData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNameSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idUpdateData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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

    private void btnSearchProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductsActionPerformed
        ModalProductsShopping modal = new ModalProductsShopping();
        modal.setVisible(true);
    }//GEN-LAST:event_btnSearchProductsActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (idUpdateData.getText().length() <= 0 || idUpdateData.getText().equals("")) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR SELECCIONA UN PROVEEDOR PARA REALIZAR LA COMPRA",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        if (listProducts.getRowCount() <= 0) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA LOS PRODUCTOS PARA REALIZAR LA COMPRA",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        ControllerShopping cShopping = new ControllerShopping();
        ModelShopping mShopping = new ModelShopping();
        ModelDetailShopping mDetailsShopping = new ModelDetailShopping();
        ControllerGetNumberVoucher cNumberVoucher = new ControllerGetNumberVoucher();
        ModelVoucher mVoucher = new ModelVoucher();

        mShopping.setIdUser(Integer.parseInt(Home.idUserLogin.getText()));
        mShopping.setIdSupplier(Integer.parseInt(idUpdateData.getText()));
        mShopping.setIdVoucher(3);
        mShopping.setNumberVoucher(String.valueOf(cNumberVoucher.getNumberCurrent("3").get(0)));
        mShopping.setSerie(String.valueOf(cNumberVoucher.getNumberCurrent("3").get(1)));
        mShopping.setTotal(Double.parseDouble(lblTotal.getText()));
        mShopping.setSubTotal(Double.parseDouble(lblSubTotal.getText()));
        mShopping.setIgv(Double.parseDouble(lblIGV.getText()));
        mShopping.setDiscount(Double.parseDouble(txtDiscount.getText()));
        try {
            if (cShopping.insertShopping(mShopping)) {
                for (int i = 0; i < listProducts.getRowCount(); i++) {
                    mDetailsShopping.setIdProduct(Integer.parseInt(listProducts.getValueAt(i, 0).toString()));
                    mDetailsShopping.setQuantity(Integer.parseInt(listProducts.getValueAt(i, 4).toString()));
                    mDetailsShopping.setPriceSales(Double.parseDouble((listProducts.getValueAt(i, 3).toString())));
                    mDetailsShopping.setPriceShopping(Double.parseDouble(listProducts.getValueAt(i, 2).toString()));
                    cShopping.insertDetailShopping(mDetailsShopping);
                    cShopping.updateStock(listProducts.getValueAt(i, 0).toString(), listProducts.getValueAt(i, 4).toString(), listProducts.getValueAt(i, 2).toString(), listProducts.getValueAt(i, 3).toString(), listProducts.getValueAt(i, 6).toString());
                }

                new rojerusan.RSNotifyAnimated("SUCCESS", "FELICIDADES HEMOS REALIZADO LA COMPRA DE TUS PRODUCTOS",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                mVoucher.setId(3);
                mVoucher.setNumberCurrent(String.valueOf(cNumberVoucher.getNumberCurrent("3").get(0)));
                cNumberVoucher.updateVouchers(mVoucher);
                ConnectionDB c = new ConnectionDB();
                c.closeConection();
                new ChangePanel(Shopping.mainDesktop, new WindowShopping());
            }
        } catch (NumberFormatException | SQLException e) {
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSupplierActionPerformed
        ModalSupplier modal = new ModalSupplier();
        modal.setVisible(true);
        modal.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnSearchSupplierActionPerformed

    private void listProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMouseClicked
    }//GEN-LAST:event_listProductsMouseClicked

    private void listProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listProductsMouseEntered

    private void listProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMousePressed
        if (evt.getClickCount() == 2) {
            int fila = listProducts.getSelectedRow();
            if (fila >= 0) {
                modelTable.removeRow(fila);
                calculateTotal();
            }
        }
    }//GEN-LAST:event_listProductsMousePressed

    private void listProductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listProductsKeyPressed

    }//GEN-LAST:event_listProductsKeyPressed

    private void txtDiscountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double discount = Double.parseDouble(txtDiscount.getText()) / 100;
            double amountDiscount = Double.parseDouble(lblTotal.getText()) * discount;
            double priceCurrent = Double.parseDouble(lblTotal.getText()) - amountDiscount;

            // VOLVEMOS A CALCULAR EL MONTO DE COMPRA
            double subTotal = 0;
            double igv = 0;
            subTotal = priceCurrent / 1.18;
            igv = subTotal * 0.18;
            lblTotal.setText(String.valueOf(Math.round(priceCurrent * 100) / 100d));
            lblSubTotal.setText(String.valueOf(Math.round(subTotal * 100) / 100d));
            lblIGV.setText(String.valueOf(Math.round(igv * 100) / 100d));
        }
    }//GEN-LAST:event_txtDiscountKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnAdd;
    private rojerusan.RSButtonIconI btnSearchProducts;
    private rojerusan.RSButtonIconI btnSearchSupplier;
    public static javax.swing.JLabel idUpdateData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblIGV;
    public static javax.swing.JLabel lblSubTotal;
    public static javax.swing.JLabel lblTotal;
    public static rojerusan.RSTableMetro listProducts;
    private rojeru_san.rsfield.RSTextFullRound txtDiscount;
    public static RSMaterialComponent.RSTextFieldMaterial txtNameSupplier;
    // End of variables declaration//GEN-END:variables
}
