package components;

import componenttoselect.ModalProductsSales;
import controller.ControllerCustomer;
import controller.ControllerGetNumberVoucher;
import controller.ControllerSales;
import controller.ControllerShopping;
import controllerpublic.ChangePanel;
import controllerpublic.UIComboBox;
import controllerpublic.cbxVouchers;
import database.ConnectionDB;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import main.Home;
import maincomponents.Sales;
import maincomponents.Shopping;
import model.ModelCustomer;
import model.ModelDetailSales;
import model.ModelDetailShopping;
import model.ModelSales;
import model.ModelShopping;
import model.ModelVoucher;
import rojerusan.RSNotifyAnimated;

public class WindowSales extends javax.swing.JPanel {

    public static String[] headers = {"ID", "Cantidad", "Descripción", "U.M", "Descuento", "P.U", "IGV", "Sub Total", "Total", "¿con stock?"};
    public static DefaultTableModel modelTable;

    public WindowSales() {
        initComponents();
        idVoucher.setVisible(false);
        modelTable = new DefaultTableModel(null, headers);
        listProducts.setModel(modelTable);
        listProducts.getColumnModel().getColumn(0).setMaxWidth(0);
        listProducts.getColumnModel().getColumn(0).setMinWidth(0);
        listProducts.getColumnModel().getColumn(0).setPreferredWidth(0);
        listProducts.getColumnModel().getColumn(1).setMaxWidth(100);
        listProducts.getColumnModel().getColumn(1).setMinWidth(100);
        listProducts.getColumnModel().getColumn(1).setPreferredWidth(100);
        listProducts.getColumnModel().getColumn(2).setMaxWidth(500);
        listProducts.getColumnModel().getColumn(2).setMinWidth(500);
        listProducts.getColumnModel().getColumn(2).setPreferredWidth(500);
        listProducts.getColumnModel().getColumn(6).setMaxWidth(0);
        listProducts.getColumnModel().getColumn(6).setMinWidth(0);
        listProducts.getColumnModel().getColumn(6).setPreferredWidth(0);
        listProducts.getColumnModel().getColumn(7).setMaxWidth(0);
        listProducts.getColumnModel().getColumn(7).setMinWidth(0);
        listProducts.getColumnModel().getColumn(7).setPreferredWidth(0);
        listProducts.getColumnModel().getColumn(9).setMaxWidth(0);
        listProducts.getColumnModel().getColumn(9).setMinWidth(0);
        listProducts.getColumnModel().getColumn(9).setPreferredWidth(0);
//        listProducts.setDefaultEditor(Object.class, null);
        cbxVouchers voucher = new cbxVouchers();
        voucher.viewVouchers(cbxVouchers);
        cbxVouchers.setUI(UIComboBox.createUI(this));
        idCustomer.setVisible(false);
    }

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
        btnSearchProducts = new rojerusan.RSButtonIconI();
        txtFullName = new RSMaterialComponent.RSTextFieldMaterial();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProducts = new rojerusan.RSTableMetro();
        txtAmountPaid = new rojeru_san.rsfield.RSTextFullRound();
        jLabel7 = new javax.swing.JLabel();
        txtNumberDocument = new RSMaterialComponent.RSTextFieldMaterial();
        txtSearch = new RSMaterialComponent.RSTextFieldMaterial();
        txtAdress = new RSMaterialComponent.RSTextFieldMaterial();
        panelRound1 = new main.PanelRound();
        cbxVouchers = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNumberVoucher = new javax.swing.JLabel();
        lblSerie = new javax.swing.JLabel();
        txtEntityBank = new RSMaterialComponent.RSTextFieldMaterial();
        cbxTypePayment = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel6 = new javax.swing.JLabel();
        txtNumberOperation = new RSMaterialComponent.RSTextFieldMaterial();
        lblTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        lblIGV = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new rojerusan.RSButtonIconI();
        idVoucher = new javax.swing.JLabel();
        idCustomer = new javax.swing.JLabel();
        txtAmountReturn = new rojeru_san.rsfield.RSTextFullRound();
        jLabel8 = new javax.swing.JLabel();
        btnDelete = new rojerusan.RSButtonIconI();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        btnSearchProducts.setBackground(new java.awt.Color(53, 209, 112));
        btnSearchProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-light.png"))); // NOI18N
        btnSearchProducts.setMnemonic('p');
        btnSearchProducts.setText("Buscar productos");
        btnSearchProducts.setToolTipText("ALT + P");
        btnSearchProducts.setColorHover(new java.awt.Color(62, 215, 120));
        btnSearchProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductsActionPerformed(evt);
            }
        });

        txtFullName.setForeground(new java.awt.Color(28, 60, 84));
        txtFullName.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtFullName.setPhColor(new java.awt.Color(28, 60, 84));
        txtFullName.setPlaceholder("Cliente");
        txtFullName.setSelectionColor(new java.awt.Color(117, 95, 238));

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
        listProducts.setAltoHead(40);
        listProducts.setColorBackgoundHead(new java.awt.Color(241, 246, 249));
        listProducts.setColorBordeFilas(new java.awt.Color(212, 227, 236));
        listProducts.setColorBordeHead(new java.awt.Color(212, 227, 236));
        listProducts.setColorFilasBackgound1(new java.awt.Color(241, 246, 249));
        listProducts.setColorFilasBackgound2(new java.awt.Color(215, 229, 237));
        listProducts.setColorFilasForeground1(new java.awt.Color(28, 60, 84));
        listProducts.setColorFilasForeground2(new java.awt.Color(36, 58, 74));
        listProducts.setColorForegroundHead(new java.awt.Color(28, 60, 84));
        listProducts.setColorSelBackgound(new java.awt.Color(13, 110, 253));
        listProducts.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        listProducts.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listProducts.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listProducts.setGridColor(new java.awt.Color(219, 221, 231));
        listProducts.setGrosorBordeFilas(0);
        listProducts.setMultipleSeleccion(false);
        listProducts.setRowHeight(30);
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

        txtAmountPaid.setBackground(new java.awt.Color(255, 255, 255));
        txtAmountPaid.setForeground(new java.awt.Color(28, 60, 84));
        txtAmountPaid.setText("0");
        txtAmountPaid.setBorderColor(new java.awt.Color(245, 178, 3));
        txtAmountPaid.setPhColor(new java.awt.Color(28, 60, 84));
        txtAmountPaid.setPlaceholder("Ingresa tu descuento");
        txtAmountPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountPaidKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(28, 60, 84));
        jLabel7.setText("Importe de pago");

        txtNumberDocument.setForeground(new java.awt.Color(28, 60, 84));
        txtNumberDocument.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtNumberDocument.setPhColor(new java.awt.Color(28, 60, 84));
        txtNumberDocument.setPlaceholder("N° Documento");
        txtNumberDocument.setSelectionColor(new java.awt.Color(117, 95, 238));
        txtNumberDocument.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumberDocumentKeyPressed(evt);
            }
        });

        txtSearch.setForeground(new java.awt.Color(28, 60, 84));
        txtSearch.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtSearch.setPhColor(new java.awt.Color(28, 60, 84));
        txtSearch.setPlaceholder("Buscar productos");
        txtSearch.setSelectionColor(new java.awt.Color(117, 95, 238));

        txtAdress.setForeground(new java.awt.Color(28, 60, 84));
        txtAdress.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtAdress.setPhColor(new java.awt.Color(28, 60, 84));
        txtAdress.setPlaceholder("Dirección");
        txtAdress.setSelectionColor(new java.awt.Color(117, 95, 238));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        cbxVouchers.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbxVouchers.setForeground(new java.awt.Color(28, 60, 84));
        cbxVouchers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxVouchersItemStateChanged(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(28, 60, 84));
        jLabel4.setText("N° Comprobante");

        jLabel5.setForeground(new java.awt.Color(28, 60, 84));
        jLabel5.setText("Serie");

        lblNumberVoucher.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNumberVoucher.setForeground(new java.awt.Color(69, 106, 135));
        lblNumberVoucher.setText("---");

        lblSerie.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSerie.setForeground(new java.awt.Color(69, 106, 135));
        lblSerie.setText("---");

        txtEntityBank.setForeground(new java.awt.Color(28, 60, 84));
        txtEntityBank.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtEntityBank.setPhColor(new java.awt.Color(28, 60, 84));
        txtEntityBank.setPlaceholder("Entidad bancaria");
        txtEntityBank.setSelectionColor(new java.awt.Color(117, 95, 238));
        txtEntityBank.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntityBankKeyPressed(evt);
            }
        });

        cbxTypePayment.setForeground(new java.awt.Color(69, 106, 135));
        cbxTypePayment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EFECTIVO", "TARJETA", "TRANSFERENCIA", "CHEQUE" }));
        cbxTypePayment.setColorMaterial(new java.awt.Color(69, 106, 135));

        jLabel6.setForeground(new java.awt.Color(28, 60, 84));
        jLabel6.setText("Tipo de pago");

        txtNumberOperation.setForeground(new java.awt.Color(28, 60, 84));
        txtNumberOperation.setColorMaterial(new java.awt.Color(101, 213, 143));
        txtNumberOperation.setPhColor(new java.awt.Color(28, 60, 84));
        txtNumberOperation.setPlaceholder("N° de operación");
        txtNumberOperation.setSelectionColor(new java.awt.Color(117, 95, 238));
        txtNumberOperation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumberOperationKeyPressed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(28, 60, 84));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.00");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(69, 106, 135));
        jLabel1.setText("TOTAL");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(69, 106, 135));
        jLabel2.setText("SUB TOTAL");

        lblSubTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(28, 60, 84));
        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotal.setText("0.00");

        lblIGV.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblIGV.setForeground(new java.awt.Color(28, 60, 84));
        lblIGV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIGV.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(69, 106, 135));
        jLabel3.setText("IGV");

        btnAdd.setBackground(new java.awt.Color(13, 110, 253));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        btnAdd.setText("Generar venta");
        btnAdd.setToolTipText("");
        btnAdd.setColorHover(new java.awt.Color(28, 119, 255));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        idCustomer.setText("1");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxTypePayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxVouchers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblNumberVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtEntityBank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumberOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(idCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(lblIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxVouchers, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNumberVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTypePayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEntityBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNumberOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(idVoucher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        txtAmountReturn.setEditable(false);
        txtAmountReturn.setBackground(new java.awt.Color(255, 255, 255));
        txtAmountReturn.setForeground(new java.awt.Color(28, 60, 84));
        txtAmountReturn.setText("0");
        txtAmountReturn.setBorderColor(new java.awt.Color(53, 209, 112));
        txtAmountReturn.setPhColor(new java.awt.Color(28, 60, 84));
        txtAmountReturn.setPlaceholder("Ingresa tu descuento");
        txtAmountReturn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountReturnKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(28, 60, 84));
        jLabel8.setText("Vuelto");

        btnDelete.setBackground(new java.awt.Color(236, 105, 105));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnDelete.setToolTipText("ALT + S");
        btnDelete.setColorHover(new java.awt.Color(238, 136, 136));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNumberDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135))
                            .addComponent(txtAmountPaid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135))
                            .addComponent(txtAmountReturn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(btnSearchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumberDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSearchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAmountReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        ModalProductsSales modal = new ModalProductsSales();
        modal.setVisible(true);
    }//GEN-LAST:event_btnSearchProductsActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (listProducts.getRowCount() <= 0) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA LOS PRODUCTOS PARA REALIZAR LA VENTA",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        if (!txtAmountPaid.getText().matches("^\\d+(\\.\\d+)?$")) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA UN NUMERO, ESTE CAMPO NO PERMITE INGRESA CARACTERES",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            txtAmountPaid.requestFocus();
            txtAmountPaid.setText("0");
            return;
        }
        if (Double.parseDouble(txtAmountPaid.getText()) <= 0) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA EL IMPORTE CON LA QUE ESTA PAGANDO EL CLIENTE",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            txtAmountPaid.requestFocus();
            txtAmountPaid.setText("0");
            return;
        }
        if (Double.parseDouble(txtAmountPaid.getText()) < Double.parseDouble(lblTotal.getText())) {
            new rojerusan.RSNotifyAnimated("ERROR", "EL IMPORTE QUE ESTAS INGRESANDO ES MENOR AL TOTAL DE CONSUMO DEL CLIENTE, INGRESA UN MONTO VÁLIDO",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            txtAmountPaid.requestFocus();
            txtAmountPaid.setText("0");
            return;
        }
        ControllerSales cSales = new ControllerSales();
        ModelSales mSales = new ModelSales();
        ModelDetailSales mDetailsSales = new ModelDetailSales();

        ControllerGetNumberVoucher cNumberVoucher = new ControllerGetNumberVoucher();
        ArrayList voucherData = cNumberVoucher.getNumberCurrent(idVoucher.getText());
        ModelVoucher mVoucher = new ModelVoucher();

        mSales.setIdUser(Integer.parseInt(Home.idUserLogin.getText()));
        mSales.setIdCustomer(Integer.parseInt(idCustomer.getText()));
        mSales.setIdVoucher(Integer.parseInt(idVoucher.getText()));
        mSales.setNumberVoucher(String.valueOf(voucherData.get(0)));
        mSales.setSerie(String.valueOf(voucherData.get(1)));
        mSales.setTypePayment(cbxTypePayment.getSelectedItem().toString());
        mSales.setNumberOperation(txtNumberOperation.getText().equals("") ? "---" : txtNumberOperation.getText());
        mSales.setEntityBank(txtEntityBank.getText().equals("") ? "---" : txtEntityBank.getText());
        mSales.setTotal(Double.parseDouble(lblTotal.getText()));
        mSales.setSubTotal(Double.parseDouble(lblSubTotal.getText()));
        mSales.setIgv(Double.parseDouble(lblIGV.getText()));
        mSales.setIgvAplicate(0.18);
        mSales.setAmountPaid(Double.parseDouble(txtAmountPaid.getText()));
        mSales.setAmountReturn(Double.parseDouble(txtAmountReturn.getText()));

        try {
            if (cSales.insertSales(mSales)) {
                for (int i = 0; i < listProducts.getRowCount(); i++) {
                    mDetailsSales.setIdProduct(Integer.parseInt(listProducts.getValueAt(i, 0).toString()));
                    mDetailsSales.setPriceUnit(Double.parseDouble(listProducts.getValueAt(i, 5).toString()));
                    mDetailsSales.setQuantity(Integer.parseInt(listProducts.getValueAt(i, 1).toString()));
                    mDetailsSales.setDiscount(Integer.parseInt(listProducts.getValueAt(i, 4).toString()));
                    mDetailsSales.setIgv(Double.parseDouble(listProducts.getValueAt(i, 6).toString()));
                    mDetailsSales.setSubTotal(Double.parseDouble(listProducts.getValueAt(i, 7).toString()));
                    mDetailsSales.setTotal(Double.parseDouble(listProducts.getValueAt(i, 8).toString()));
                    mDetailsSales.setUnitMeasure(listProducts.getValueAt(i, 3).toString());
                    cSales.insertDetailSales(mDetailsSales);

                    cSales.discountStock(listProducts.getValueAt(i, 0).toString(), listProducts.getValueAt(i, 1).toString());
                }

                new rojerusan.RSNotifyAnimated("SUCCESS", "FELICIDADES TU VENTA SE HA REALIZADO CON ÉXITO",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                mVoucher.setId(Integer.parseInt(idVoucher.getText()));
                mVoucher.setNumberCurrent(String.valueOf(voucherData.get(0)));
                cNumberVoucher.updateVouchers(mVoucher);
                ConnectionDB c = new ConnectionDB();
                c.closeConection();
                new ChangePanel(Sales.mainDesktop, new WindowSales());
            } else {
                new rojerusan.RSNotifyAnimated("ERROR", "LOS SENTIMOS NO PUDIMOS REALIZAR LA VENTA",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void listProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMouseClicked
    }//GEN-LAST:event_listProductsMouseClicked

    private void listProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listProductsMouseEntered

    private void listProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMousePressed
        if (evt.getClickCount() == 2) {
//            int fila = listProducts.getSelectedRow();
//            if (fila >= 0) {
//                modelTable.removeRow(fila);
//                calculateTotal();
//            }
        }
    }//GEN-LAST:event_listProductsMousePressed

    private void listProductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listProductsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = listProducts.getSelectedRow();

            double discountTable = Double.parseDouble(listProducts.getValueAt(fila, 4).toString());
            double totalDiscount = discountTable / 100;
            double priceUnit = Double.parseDouble(listProducts.getValueAt(fila, 5).toString());
            int quantityTable = Integer.parseInt(listProducts.getValueAt(fila, 1).toString());
            double newTotal = quantityTable * priceUnit;
            double productDiscount = newTotal * totalDiscount;
            double totalSale = newTotal - productDiscount;
            double subTotalTable = totalSale / 1.18;
            double igvTable = subTotalTable * 0.18;
            listProducts.setValueAt(Math.round(totalSale * 100) / 100d, fila, 8);
            listProducts.setValueAt(Math.round(subTotalTable * 100) / 100d, fila, 7);
            listProducts.setValueAt(Math.round(igvTable * 100) / 100d, fila, 6);

            calculateTotal();
        }
    }//GEN-LAST:event_listProductsKeyPressed

    private void txtAmountPaidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountPaidKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtAmountPaid.getText().matches("^\\d+(\\.\\d+)?$")) {
                new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA UN NUMERO, ESTE CAMPO NO PERMITE INGRESA CARACTERES",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                txtAmountPaid.requestFocus();
                txtAmountPaid.setText("0");
                return;
            }
            if (Double.parseDouble(txtAmountPaid.getText()) <= 0) {
                new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA EL IMPORTE CON LA QUE ESTA PAGANDO EL CLIENTE",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                txtAmountPaid.requestFocus();
                txtAmountPaid.setText("0");
                return;
            }
            if (Double.parseDouble(txtAmountPaid.getText()) < Double.parseDouble(lblTotal.getText())) {
                new rojerusan.RSNotifyAnimated("ERROR", "EL IMPORTE QUE ESTAS INGRESANDO ES MENOR AL TOTAL DE CONSUMO DEL CLIENTE, INGRESA UN MONTO VÁLIDO",
                        5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                txtAmountPaid.requestFocus();
                txtAmountPaid.setText("0");
                return;
            }
            double amountPaid = Double.parseDouble(txtAmountPaid.getText());
            double amountReturn = amountPaid - Double.parseDouble(lblTotal.getText());

            txtAmountReturn.setText(String.valueOf(Math.round(amountReturn * 100) / 100d));
        }
    }//GEN-LAST:event_txtAmountPaidKeyPressed

    private void cbxVouchersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxVouchersItemStateChanged
        idVoucher.setText(String.valueOf(cbxVouchers.getItemAt(cbxVouchers.getSelectedIndex()).getId()));
        try {
            ControllerGetNumberVoucher number = new ControllerGetNumberVoucher();
            lblNumberVoucher.setText(String.valueOf(number.getNumberCurrent(String.valueOf(cbxVouchers.getItemAt(cbxVouchers.getSelectedIndex()).getId())).get(0)));
            lblSerie.setText(String.valueOf(number.getNumberCurrent(String.valueOf(cbxVouchers.getItemAt(cbxVouchers.getSelectedIndex()).getId())).get(1)));
            ConnectionDB c = new ConnectionDB();
            c.closeConection();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_cbxVouchersItemStateChanged

    private void txtNumberDocumentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberDocumentKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                ControllerCustomer cCustomer = new ControllerCustomer();
                ArrayList data = cCustomer.searchCustomerSale(txtNumberDocument.getText());
                if (data.isEmpty()) {
                    if (txtFullName.getText().length() <= 2) {
                        new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA EL NOMBRE DEL CLIENTE PARA PODER REGISTRAR A NUESTRA BASE DE DATOS",
                                5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                                RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                        return;
                    }
                    if (txtNumberDocument.getText().length() <= 7) {
                        new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA EL NUMERO DE DOCUMENTO DEL CLIENTE PARA PODER REGISTRAR A NUESTRA BASE DE DATOS",
                                5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                                RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                        return;
                    }
                    ModelCustomer mCustomer = new ModelCustomer();
                    mCustomer.setAdress(txtAdress.getText());
                    mCustomer.setEmail("");
                    mCustomer.setFullName(txtFullName.getText());
                    mCustomer.setNumberDocument(txtNumberDocument.getText());
                    if (txtNumberDocument.getText().length() == 8) {
                        mCustomer.setTypeDocument("DNI");
                    } else if (txtNumberDocument.getText().length() == 11) {
                        mCustomer.setTypeDocument("RUC");
                    } else if (txtNumberDocument.getText().length() == 11) {
                        mCustomer.setTypeDocument("PASAPORTE");
                    }
                    cCustomer.insertCustomer(mCustomer);
                    new rojerusan.RSNotifyAnimated("SUCCESS", "FELICIDADES HEMOS REGISTRADO UN CLIENTE NUEVO A LA BASE DE DATOS",
                            5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                            RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                }
                idCustomer.setText(String.valueOf(data.get(0)));
                txtFullName.setText(String.valueOf(data.get(1)));
                txtAdress.setText(String.valueOf(data.get(2)));
                txtNumberDocument.setText(String.valueOf(data.get(3)));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_txtNumberDocumentKeyPressed

    private void txtEntityBankKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntityBankKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntityBankKeyPressed

    private void txtNumberOperationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberOperationKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberOperationKeyPressed

    private void txtAmountReturnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountReturnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountReturnKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int fila = listProducts.getSelectedRow();
        if (fila >= 0) {
            modelTable.removeRow(fila);
            calculateTotal();
        } else {
            new rojerusan.RSNotifyAnimated("ERROR", "SOLICITUD DENEGADA, PRIMERO SELECCIONA EL PRODUCTO AL CUAL QUIERE QUITAR DE LA LISTA DE VENTA DEL CLIENTE",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnAdd;
    private rojerusan.RSButtonIconI btnDelete;
    private rojerusan.RSButtonIconI btnSearchProducts;
    private RSMaterialComponent.RSComboBoxMaterial cbxTypePayment;
    private javax.swing.JComboBox<cbxVouchers> cbxVouchers;
    public static javax.swing.JLabel idCustomer;
    public static javax.swing.JLabel idVoucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblIGV;
    private javax.swing.JLabel lblNumberVoucher;
    private javax.swing.JLabel lblSerie;
    public static javax.swing.JLabel lblSubTotal;
    public static javax.swing.JLabel lblTotal;
    public static rojerusan.RSTableMetro listProducts;
    private main.PanelRound panelRound1;
    public static RSMaterialComponent.RSTextFieldMaterial txtAdress;
    private rojeru_san.rsfield.RSTextFullRound txtAmountPaid;
    private rojeru_san.rsfield.RSTextFullRound txtAmountReturn;
    public static RSMaterialComponent.RSTextFieldMaterial txtEntityBank;
    public static RSMaterialComponent.RSTextFieldMaterial txtFullName;
    public static RSMaterialComponent.RSTextFieldMaterial txtNumberDocument;
    public static RSMaterialComponent.RSTextFieldMaterial txtNumberOperation;
    public static RSMaterialComponent.RSTextFieldMaterial txtSearch;
    // End of variables declaration//GEN-END:variables
}
