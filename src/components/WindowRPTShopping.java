package components;

import componentsregistry.RgtTypeProduct;
import controller.ControllerReportShopping;
import controller.ControllerSearchProductForDate;
import database.ConnectionDB;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reports.RPTSearchProductForDate;
import reports.RPTShopping;
import rojerusan.RSNotifyAnimated;

public class WindowRPTShopping extends javax.swing.JPanel {

    Calendar cal, cal2;
    int d, m, a, dd, mm, aa;

    public WindowRPTShopping() {
        initComponents();
        idUpdateData.setVisible(false);
        jScrollPane1.getViewport().setBackground(new Color(241, 246, 249));
    }

    void getShopping() {

        try {
            cal = dateStart.getCalendar();
            d = cal.get(Calendar.DAY_OF_MONTH);
            m = cal.get(Calendar.MONTH);
            a = cal.get(Calendar.YEAR) - 1900;

            cal2 = dateEnd.getCalendar();
            dd = cal2.get(Calendar.DAY_OF_MONTH);
            mm = cal2.get(Calendar.MONTH);
            aa = cal2.get(Calendar.YEAR) - 1900;
            DefaultTableModel model;
            if (checkReport.isSelected()) {
                ControllerReportShopping cReport = new ControllerReportShopping();
                model = cReport.getShopping(String.valueOf(new Date(a, m, d)), String.valueOf(new Date(aa, mm, dd)));
            } else {
                ControllerSearchProductForDate cReport = new ControllerSearchProductForDate();
                model = cReport.getShoppindDetails(String.valueOf(new Date(a, m, d)), String.valueOf(new Date(aa, mm, dd)));
            }
            reportSales.setModel(model);
            reportSales.setDefaultEditor(Object.class, null);
            ConnectionDB c = new ConnectionDB();
            c.closeConection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void report() {
        cal = dateStart.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;

        cal2 = dateEnd.getCalendar();
        dd = cal2.get(Calendar.DAY_OF_MONTH);
        mm = cal2.get(Calendar.MONTH);
        aa = cal2.get(Calendar.YEAR) - 1900;
        try {
            if (checkReport.isSelected()) {
                RPTShopping export = new RPTShopping();
                export.reportSales(String.valueOf(new Date(a, m, d)), String.valueOf(new Date(aa, mm, dd)));
                ConnectionDB c = new ConnectionDB();
                c.closeConection();
            } else {
                RPTSearchProductForDate export = new RPTSearchProductForDate();
                export.reportShoppingDetails(String.valueOf(new Date(a, m, d)), String.valueOf(new Date(aa, mm, dd)));
                ConnectionDB c = new ConnectionDB();
                c.closeConection();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    void validateData() {
        if (dateStart.getDate() == null) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA LA FECHA DE INICIO  PARA EL REPORTE",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        if (dateEnd.getDate() == null) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA LA FECHA DE TERMINO PARA EL REPORTE",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        getShopping();
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
        dateStart = new com.toedter.calendar.JDateChooser();
        dateEnd = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnExport1 = new rojerusan.RSButtonIconI();
        checkReport = new RSMaterialComponent.RSCheckBoxMaterial();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 60, 84));
        jLabel1.setText("Reportes >");

        btnExport.setBackground(new java.awt.Color(238, 111, 111));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf.png"))); // NOI18N
        btnExport.setToolTipText("EXPORTAR REPORTE A PDF");
        btnExport.setColorHover(new java.awt.Color(237, 90, 90));
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
        jLabel2.setText("Reporte de compras");

        dateStart.setBackground(new java.awt.Color(255, 255, 255));
        dateStart.setForeground(new java.awt.Color(25, 158, 255));
        dateStart.setDateFormatString("yyyy-MM-dd");
        dateStart.setFocusable(false);
        dateStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateStartPropertyChange(evt);
            }
        });

        dateEnd.setBackground(new java.awt.Color(255, 255, 255));
        dateEnd.setForeground(new java.awt.Color(25, 158, 255));
        dateEnd.setDateFormatString("yyyy-MM-dd");
        dateEnd.setFocusable(false);
        dateEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateEndPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(28, 60, 84));
        jLabel3.setText("Fec. Inicio");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(28, 60, 84));
        jLabel4.setText("Fec. Término");

        btnExport1.setBackground(new java.awt.Color(13, 110, 253));
        btnExport1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-light.png"))); // NOI18N
        btnExport1.setText("Generar reporte");
        btnExport1.setToolTipText("");
        btnExport1.setColorHover(new java.awt.Color(13, 110, 253));
        btnExport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExport1ActionPerformed(evt);
            }
        });

        checkReport.setSelected(true);
        checkReport.setText("Reporte general");
        checkReport.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkReportItemStateChanged(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExport1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkReport, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExport1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        if (dateStart.getDate() == null) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA LA FECHA DE INICIO  PARA EL REPORTE",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        if (dateEnd.getDate() == null) {
            new rojerusan.RSNotifyAnimated("ERROR", "POR FAVOR INGRESA LA FECHA DE TERMINO PARA EL REPORTE",
                    5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft,
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            return;
        }
        report();
    }//GEN-LAST:event_btnExportActionPerformed

    private void reportSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportSalesMouseClicked
    }//GEN-LAST:event_reportSalesMouseClicked

    private void reportSalesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportSalesMousePressed
    }//GEN-LAST:event_reportSalesMousePressed

    private void reportSalesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reportSalesKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//           
//        }
    }//GEN-LAST:event_reportSalesKeyPressed

    private void reportSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportSalesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_reportSalesMouseEntered

    private void btnExport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExport1ActionPerformed
        validateData();
        getShopping();
    }//GEN-LAST:event_btnExport1ActionPerformed

    private void dateStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateStartPropertyChange
//        validateData();
//        
    }//GEN-LAST:event_dateStartPropertyChange

    private void dateEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateEndPropertyChange
//        validateData();
    }//GEN-LAST:event_dateEndPropertyChange

    private void checkReportItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkReportItemStateChanged
       if(checkReport.isSelected()) {
           checkReport.setText("Reporte general");
       } else {
           checkReport.setText("Reporte detallado de la compra");           
       }
    }//GEN-LAST:event_checkReportItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnExport;
    private rojerusan.RSButtonIconI btnExport1;
    private RSMaterialComponent.RSCheckBoxMaterial checkReport;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    public static javax.swing.JLabel idUpdateData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static rojerusan.RSTableMetro reportSales;
    // End of variables declaration//GEN-END:variables
}
