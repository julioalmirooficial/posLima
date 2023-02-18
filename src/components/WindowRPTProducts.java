package components;

import controller.ControllerReportProducts;
import database.ConnectionDB;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reports.RPTProducts;

public class WindowRPTProducts extends javax.swing.JPanel {

    Calendar cal, cal2;
    int d, m, a, dd, mm, aa;

    public WindowRPTProducts() {
        initComponents();
        idUpdateData.setVisible(false);
        jScrollPane1.getViewport().setBackground(new Color(241, 246, 249));
       getProduct();
    }

    void getProduct() {
        ControllerReportProducts cReport = new ControllerReportProducts();
        try {
            DefaultTableModel model;
            model = cReport.getproduct();
            reportSales.setModel(model);
            reportSales.setDefaultEditor(Object.class, null);
            ConnectionDB c = new ConnectionDB();
            c.closeConection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void report() {
        try {
            RPTProducts export = new RPTProducts();
            export.reportProducts();
            ConnectionDB c = new ConnectionDB();
            c.closeConection();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idUpdateData = new javax.swing.JLabel();
        btnExport = new rojerusan.RSButtonIconI();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportSales = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 60, 84));
        jLabel1.setText("Reportes >");

        btnExport.setBackground(new java.awt.Color(25, 158, 255));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf.png"))); // NOI18N
        btnExport.setText("EXPORTAR REPORTE A PDF");
        btnExport.setToolTipText("EXPORTAR REPORTE A PDF");
        btnExport.setColorHover(new java.awt.Color(25, 158, 255));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        reportSales.setBackground(new java.awt.Color(255, 255, 255));
        reportSales.setForeground(new java.awt.Color(255, 255, 255));
        reportSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATOS NO ENCONTRADOS"
            }
        ));
        reportSales.setColorBackgoundHead(new java.awt.Color(241, 246, 249));
        reportSales.setColorBordeFilas(new java.awt.Color(212, 227, 236));
        reportSales.setColorBordeHead(new java.awt.Color(212, 227, 236));
        reportSales.setColorFilasBackgound1(new java.awt.Color(241, 246, 249));
        reportSales.setColorFilasBackgound2(new java.awt.Color(215, 229, 237));
        reportSales.setColorFilasForeground1(new java.awt.Color(28, 60, 84));
        reportSales.setColorFilasForeground2(new java.awt.Color(36, 58, 74));
        reportSales.setColorForegroundHead(new java.awt.Color(28, 60, 84));
        reportSales.setColorSelBackgound(new java.awt.Color(13, 110, 253));
        reportSales.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        reportSales.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        reportSales.setGridColor(new java.awt.Color(219, 221, 231));
        reportSales.setGrosorBordeFilas(0);
        reportSales.setMultipleSeleccion(false);
        reportSales.setRowHeight(40);
        reportSales.setSelectionBackground(new java.awt.Color(53, 209, 112));
        reportSales.getTableHeader().setReorderingAllowed(false);
        reportSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportSalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportSalesMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reportSalesMousePressed(evt);
            }
        });
        reportSales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reportSalesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(reportSales);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 158, 255));
        jLabel2.setText("Reporte de clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(467, 467, 467)
                        .addComponent(idUpdateData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(26, 26, 26)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        report();
    }//GEN-LAST:event_btnExportActionPerformed

    private void reportSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportSalesMouseClicked
    }//GEN-LAST:event_reportSalesMouseClicked

    private void reportSalesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportSalesMousePressed
    }//GEN-LAST:event_reportSalesMousePressed

    private void reportSalesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reportSalesKeyPressed
    }//GEN-LAST:event_reportSalesKeyPressed

    private void reportSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportSalesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_reportSalesMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnExport;
    public static javax.swing.JLabel idUpdateData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static rojerusan.RSTableMetro reportSales;
    // End of variables declaration//GEN-END:variables
}
