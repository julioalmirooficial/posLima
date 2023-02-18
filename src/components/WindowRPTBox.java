package components;

import controller.ControllerRPTBox;
import database.ConnectionDB;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class WindowRPTBox extends javax.swing.JPanel {

    public WindowRPTBox() {
        initComponents();
        idUpdateData.setVisible(false);
        jScrollPane1.getViewport().setBackground(new Color(241, 246, 249));
        getBox("");
    }

    void getBox(String search) {
        ControllerRPTBox cBox = new ControllerRPTBox();
        try {
            DefaultTableModel model;
            model = cBox.getBox(search);
            listVBox.setModel(model);
            listVBox.setDefaultEditor(Object.class, null);
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
        jLabel1 = new javax.swing.JLabel();
        idUpdateData = new javax.swing.JLabel();
        txtSearch = new RSMaterialComponent.RSTextFieldIconDos();
        jScrollPane1 = new javax.swing.JScrollPane();
        listVBox = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(241, 246, 249));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 60, 84));
        jLabel1.setText("Reportes >");

        txtSearch.setForeground(new java.awt.Color(28, 60, 84));
        txtSearch.setBorderColor(new java.awt.Color(28, 60, 84));
        txtSearch.setColorIcon(new java.awt.Color(28, 60, 84));
        txtSearch.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        txtSearch.setPlaceholder("Buscar por usuario");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        listVBox.setBackground(new java.awt.Color(255, 255, 255));
        listVBox.setForeground(new java.awt.Color(255, 255, 255));
        listVBox.setModel(new javax.swing.table.DefaultTableModel(
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
        listVBox.setColorBackgoundHead(new java.awt.Color(241, 246, 249));
        listVBox.setColorBordeFilas(new java.awt.Color(212, 227, 236));
        listVBox.setColorBordeHead(new java.awt.Color(212, 227, 236));
        listVBox.setColorFilasBackgound1(new java.awt.Color(241, 246, 249));
        listVBox.setColorFilasBackgound2(new java.awt.Color(215, 229, 237));
        listVBox.setColorFilasForeground1(new java.awt.Color(28, 60, 84));
        listVBox.setColorFilasForeground2(new java.awt.Color(36, 58, 74));
        listVBox.setColorForegroundHead(new java.awt.Color(28, 60, 84));
        listVBox.setColorSelBackgound(new java.awt.Color(13, 110, 253));
        listVBox.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        listVBox.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listVBox.setGridColor(new java.awt.Color(219, 221, 231));
        listVBox.setGrosorBordeFilas(0);
        listVBox.setMultipleSeleccion(false);
        listVBox.setRowHeight(40);
        listVBox.setSelectionBackground(new java.awt.Color(53, 209, 112));
        listVBox.getTableHeader().setReorderingAllowed(false);
        listVBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listVBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listVBoxMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listVBoxMousePressed(evt);
            }
        });
        listVBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listVBoxKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listVBox);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 158, 255));
        jLabel2.setText("Reporte de cajas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(467, 467, 467)
                        .addComponent(idUpdateData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
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
                .addGap(27, 27, 27)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void listVBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listVBoxMouseClicked
    }//GEN-LAST:event_listVBoxMouseClicked

    private void listVBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listVBoxMousePressed
        if (evt.getClickCount() == 2) {
        }
    }//GEN-LAST:event_listVBoxMousePressed

    private void listVBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listVBoxKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//           
//        }
    }//GEN-LAST:event_listVBoxKeyPressed

    private void listVBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listVBoxMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listVBoxMouseEntered

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        getBox(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel idUpdateData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static rojerusan.RSTableMetro listVBox;
    private RSMaterialComponent.RSTextFieldIconDos txtSearch;
    // End of variables declaration//GEN-END:variables
}
