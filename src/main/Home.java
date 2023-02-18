package main;


import controllerpublic.ChangePanel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import maincomponents.Company;
import maincomponents.Customer;
import maincomponents.Reports;
import maincomponents.Sales;
import maincomponents.Setting;
import maincomponents.Shopping;
import maincomponents.Store;
import maincomponents.Users;

public class Home extends javax.swing.JFrame {

  

    public Home() {
        initComponents();
        homeDefault();
        setTitle("SISTEMA POS");
        idUserLogin.setVisible(false);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("D:\\sistemapos/logo/logo.png"));
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(image);
    }

    public void homeDefault() {
        lblTitleHome.setText("Importante - ¡Atencion urgente!");
        setExtendedState(MAXIMIZED_BOTH);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        idUserLogin = new javax.swing.JLabel();
        lblTitleHome = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        rSPanelCircleImage1 = new rojerusan.RSPanelCircleImage();
        userName = new javax.swing.JLabel();
        userLevel = new javax.swing.JLabel();
        mnuExitSystem = new rojerusan.RSButtonIconI();
        jPanel2 = new javax.swing.JPanel();
        nameCompany = new javax.swing.JLabel();
        panelMenus = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        mnuHome = new rojerusan.RSButtonIconI();
        mnuSales = new rojerusan.RSButtonIconI();
        mnuShopping = new rojerusan.RSButtonIconI();
        mnuStore = new rojerusan.RSButtonIconI();
        mnuReport = new rojerusan.RSButtonIconI();
        jPanel6 = new javax.swing.JPanel();
        mnuCompany = new rojerusan.RSButtonIconI();
        titlessCompany = new javax.swing.JLabel();
        mnuUsers = new rojerusan.RSButtonIconI();
        mnuCustomer = new rojerusan.RSButtonIconI();
        jPanel7 = new javax.swing.JPanel();
        titlessAdministrations = new javax.swing.JLabel();
        mnuSetting = new rojerusan.RSButtonIconI();
        mnuHelp = new rojerusan.RSButtonIconI();
        nameStore = new javax.swing.JLabel();
        lblNonw = new javax.swing.JLabel();
        PrincipalHomes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1720, 720));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitleHome.setBackground(new java.awt.Color(28, 60, 84));
        lblTitleHome.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitleHome.setForeground(new java.awt.Color(28, 60, 84));
        lblTitleHome.setText("Dashboard");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        rSPanelCircleImage1.setColorBorde(new java.awt.Color(255, 255, 255));
        rSPanelCircleImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/icons/avatar.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelCircleImage1Layout = new javax.swing.GroupLayout(rSPanelCircleImage1);
        rSPanelCircleImage1.setLayout(rSPanelCircleImage1Layout);
        rSPanelCircleImage1Layout.setHorizontalGroup(
            rSPanelCircleImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        rSPanelCircleImage1Layout.setVerticalGroup(
            rSPanelCircleImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        userName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        userName.setForeground(new java.awt.Color(28, 60, 84));
        userName.setText("Julio QUIÑONES ARANDA");

        userLevel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        userLevel.setForeground(new java.awt.Color(153, 153, 153));
        userLevel.setText("Administrador");

        mnuExitSystem.setBackground(new java.awt.Color(255, 255, 255));
        mnuExitSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/power.png"))); // NOI18N
        mnuExitSystem.setToolTipText("Salir del sistema");
        mnuExitSystem.setColorHover(new java.awt.Color(255, 255, 255));
        mnuExitSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitSystemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(rSPanelCircleImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnuExitSystem, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelCircleImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(userLevel)
                .addGap(8, 8, 8))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(mnuExitSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(238, 240, 241));

        nameCompany.setBackground(new java.awt.Color(255, 255, 255));
        nameCompany.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameCompany.setForeground(new java.awt.Color(28, 60, 84));
        nameCompany.setText("Sistema POS SAC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitleHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(66, 66, 66)
                .addComponent(idUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitleHome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        panelMenus.setBackground(new java.awt.Color(238, 240, 241));

        jPanel5.setBackground(new java.awt.Color(238, 240, 241));

        mnuHome.setBackground(new java.awt.Color(238, 240, 241));
        mnuHome.setForeground(new java.awt.Color(76, 76, 76));
        mnuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        mnuHome.setText("Inicio             ");
        mnuHome.setToolTipText("Inicio");
        mnuHome.setColorHover(new java.awt.Color(13, 110, 253));
        mnuHome.setColorText(new java.awt.Color(28, 60, 84));
        mnuHome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mnuHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuHomeMouseClicked(evt);
            }
        });
        mnuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHomeActionPerformed(evt);
            }
        });

        mnuSales.setBackground(new java.awt.Color(238, 240, 241));
        mnuSales.setForeground(new java.awt.Color(76, 76, 76));
        mnuSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sales.png"))); // NOI18N
        mnuSales.setText("Ventas           ");
        mnuSales.setToolTipText("VENTAS");
        mnuSales.setColorHover(new java.awt.Color(13, 110, 253));
        mnuSales.setColorText(new java.awt.Color(28, 60, 84));
        mnuSales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mnuSales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuSales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalesMouseClicked(evt);
            }
        });
        mnuSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalesActionPerformed(evt);
            }
        });

        mnuShopping.setBackground(new java.awt.Color(238, 240, 241));
        mnuShopping.setForeground(new java.awt.Color(76, 76, 76));
        mnuShopping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shopping.png"))); // NOI18N
        mnuShopping.setText("Compras        ");
        mnuShopping.setToolTipText("COMPRAS");
        mnuShopping.setColorHover(new java.awt.Color(13, 110, 253));
        mnuShopping.setColorText(new java.awt.Color(28, 60, 84));
        mnuShopping.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mnuShopping.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuShopping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuShoppingMouseClicked(evt);
            }
        });
        mnuShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuShoppingActionPerformed(evt);
            }
        });

        mnuStore.setBackground(new java.awt.Color(238, 240, 241));
        mnuStore.setForeground(new java.awt.Color(76, 76, 76));
        mnuStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/almacen.png"))); // NOI18N
        mnuStore.setText("Almacén         ");
        mnuStore.setToolTipText("ALMACEN");
        mnuStore.setColorHover(new java.awt.Color(13, 110, 253));
        mnuStore.setColorText(new java.awt.Color(28, 60, 84));
        mnuStore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mnuStore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuStoreMouseClicked(evt);
            }
        });
        mnuStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuStoreActionPerformed(evt);
            }
        });

        mnuReport.setBackground(new java.awt.Color(238, 240, 241));
        mnuReport.setForeground(new java.awt.Color(76, 76, 76));
        mnuReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pie-chart.png"))); // NOI18N
        mnuReport.setText("Reportes        ");
        mnuReport.setToolTipText("REPORTES");
        mnuReport.setColorHover(new java.awt.Color(13, 110, 253));
        mnuReport.setColorText(new java.awt.Color(28, 60, 84));
        mnuReport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mnuReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuReportMouseClicked(evt);
            }
        });
        mnuReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mnuHome, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mnuSales, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mnuShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mnuStore, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mnuReport, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(mnuHome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnuSales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnuShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnuStore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnuReport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(238, 240, 241));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        mnuCompany.setBackground(new java.awt.Color(238, 240, 241));
        mnuCompany.setForeground(new java.awt.Color(76, 76, 76));
        mnuCompany.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/company.png"))); // NOI18N
        mnuCompany.setText("Empresa        ");
        mnuCompany.setToolTipText("EMPRESA");
        mnuCompany.setColorHover(new java.awt.Color(13, 110, 253));
        mnuCompany.setColorText(new java.awt.Color(28, 60, 84));
        mnuCompany.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mnuCompany.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuCompanyMouseClicked(evt);
            }
        });
        mnuCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCompanyActionPerformed(evt);
            }
        });

        titlessCompany.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        titlessCompany.setForeground(new java.awt.Color(76, 76, 76));
        titlessCompany.setText("EMPRESA");

        mnuUsers.setBackground(new java.awt.Color(238, 240, 241));
        mnuUsers.setForeground(new java.awt.Color(76, 76, 76));
        mnuUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/money-sale.png"))); // NOI18N
        mnuUsers.setText("Usuarios         ");
        mnuUsers.setToolTipText("USUARIOS");
        mnuUsers.setColorHover(new java.awt.Color(13, 110, 253));
        mnuUsers.setColorText(new java.awt.Color(28, 60, 84));
        mnuUsers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mnuUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuUsersMouseClicked(evt);
            }
        });
        mnuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsersActionPerformed(evt);
            }
        });

        mnuCustomer.setBackground(new java.awt.Color(238, 240, 241));
        mnuCustomer.setForeground(new java.awt.Color(76, 76, 76));
        mnuCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users.png"))); // NOI18N
        mnuCustomer.setText("Cliente           ");
        mnuCustomer.setToolTipText("CLIENTES");
        mnuCustomer.setColorHover(new java.awt.Color(13, 110, 253));
        mnuCustomer.setColorText(new java.awt.Color(28, 60, 84));
        mnuCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mnuCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuCustomerMouseClicked(evt);
            }
        });
        mnuCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(titlessCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(mnuUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mnuCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mnuCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(titlessCompany)
                .addGap(9, 9, 9)
                .addComponent(mnuUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnuCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnuCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel7.setBackground(new java.awt.Color(238, 240, 241));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        titlessAdministrations.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        titlessAdministrations.setForeground(new java.awt.Color(76, 76, 76));
        titlessAdministrations.setText("ADMINISTRACIÓN");

        mnuSetting.setBackground(new java.awt.Color(238, 240, 241));
        mnuSetting.setForeground(new java.awt.Color(76, 76, 76));
        mnuSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/configuration.png"))); // NOI18N
        mnuSetting.setText("Configuraciones");
        mnuSetting.setToolTipText("CONFIGURACIONES");
        mnuSetting.setColorHover(new java.awt.Color(13, 110, 253));
        mnuSetting.setColorText(new java.awt.Color(28, 60, 84));
        mnuSetting.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mnuSetting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSettingMouseClicked(evt);
            }
        });
        mnuSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSettingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(titlessAdministrations, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(mnuSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(titlessAdministrations, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(mnuSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        mnuHelp.setBackground(new java.awt.Color(238, 240, 241));
        mnuHelp.setForeground(new java.awt.Color(153, 153, 153));
        mnuHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cuestion.png"))); // NOI18N
        mnuHelp.setText("Ayuda");
        mnuHelp.setColorHover(new java.awt.Color(13, 110, 253));
        mnuHelp.setColorText(new java.awt.Color(246, 208, 93));
        mnuHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuHelpMouseClicked(evt);
            }
        });
        mnuHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHelpActionPerformed(evt);
            }
        });

        nameStore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameStore.setForeground(new java.awt.Color(28, 60, 84));

        lblNonw.setBackground(new java.awt.Color(255, 255, 255));
        lblNonw.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        lblNonw.setForeground(new java.awt.Color(28, 60, 84));
        lblNonw.setText("Sistema de ventas");

        javax.swing.GroupLayout panelMenusLayout = new javax.swing.GroupLayout(panelMenus);
        panelMenus.setLayout(panelMenusLayout);
        panelMenusLayout.setHorizontalGroup(
            panelMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNonw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelMenusLayout.createSequentialGroup()
                .addGroup(panelMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mnuHelp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenusLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(nameStore, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMenusLayout.setVerticalGroup(
            panelMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenusLayout.createSequentialGroup()
                .addComponent(lblNonw)
                .addGap(1, 1, 1)
                .addComponent(nameStore, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mnuHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(panelMenus, gridBagConstraints);

        PrincipalHomes.setBackground(new java.awt.Color(255, 255, 255));
        PrincipalHomes.setLayout(new javax.swing.BoxLayout(PrincipalHomes, javax.swing.BoxLayout.LINE_AXIS));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.4;
        getContentPane().add(PrincipalHomes, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalesMouseClicked

    }//GEN-LAST:event_mnuSalesMouseClicked

    private void mnuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuHomeMouseClicked

    }//GEN-LAST:event_mnuHomeMouseClicked

    private void mnuShoppingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuShoppingMouseClicked

    }//GEN-LAST:event_mnuShoppingMouseClicked

    private void mnuStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuStoreMouseClicked
//        if (!mnuHabitaciones.isEnabled()) {
//            new CambiaPanel(PrincipalHomes, new ItemsErrorAcceso());
//        }
    }//GEN-LAST:event_mnuStoreMouseClicked

    private void mnuReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuReportMouseClicked

    }//GEN-LAST:event_mnuReportMouseClicked

    private void mnuUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuUsersMouseClicked

    }//GEN-LAST:event_mnuUsersMouseClicked

    private void mnuCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCustomerMouseClicked

    }//GEN-LAST:event_mnuCustomerMouseClicked

    private void mnuCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCompanyMouseClicked

    }//GEN-LAST:event_mnuCompanyMouseClicked

    private void mnuSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSettingMouseClicked

    }//GEN-LAST:event_mnuSettingMouseClicked

    private void mnuHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuHelpMouseClicked

    }//GEN-LAST:event_mnuHelpMouseClicked

    private void mnuCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCustomerActionPerformed
        mnuCustomer.setColorText(new Color(255,255,255));
        mnuCustomer.setBackground(new Color(13,110,253));
        mnuSales.setColorText(new Color(76,76,76));
        mnuSales.setBackground(new Color(238,240,241));
        mnuHome.setColorText(new Color(76,76,76));
        mnuHome.setBackground(new Color(238,240,241));
        mnuShopping.setColorText(new Color(76,76,76));
        mnuShopping.setBackground(new Color(238,240,241));
        mnuStore.setColorText(new Color(76,76,76));
        mnuStore.setBackground(new Color(238,240,241));
        mnuReport.setColorText(new Color(76,76,76));
        mnuReport.setBackground(new Color(238,240,241));
        mnuUsers.setColorText(new Color(76,76,76));
        mnuUsers.setBackground(new Color(238,240,241));
        mnuCompany.setColorText(new Color(76,76,76));
        mnuCompany.setBackground(new Color(238,240,241));
        mnuSetting.setColorText(new Color(76,76,76));
        mnuSetting.setBackground(new Color(238,240,241));
        new ChangePanel(PrincipalHomes, new Customer());
        lblTitleHome.setText("Usuarios y personal");
    }//GEN-LAST:event_mnuCustomerActionPerformed

    private void mnuStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuStoreActionPerformed
        mnuStore.setColorText(new Color(255,255,255));
        mnuStore.setBackground(new Color(13,110,253));
        mnuSales.setColorText(new Color(76,76,76));
        mnuSales.setBackground(new Color(238,240,241));
        mnuHome.setColorText(new Color(76,76,76));
        mnuHome.setBackground(new Color(238,240,241));
        mnuShopping.setColorText(new Color(76,76,76));
        mnuShopping.setBackground(new Color(238,240,241));
        mnuReport.setColorText(new Color(76,76,76));
        mnuReport.setBackground(new Color(238,240,241));
        mnuUsers.setColorText(new Color(76,76,76));
        mnuUsers.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuCompany.setColorText(new Color(76,76,76));
        mnuCompany.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuSetting.setColorText(new Color(76,76,76));
        mnuSetting.setBackground(new Color(238,240,241));
        new ChangePanel(PrincipalHomes, new Store());
        lblTitleHome.setText("Almacén productos");
    }//GEN-LAST:event_mnuStoreActionPerformed

    private void mnuCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCompanyActionPerformed
        mnuCompany.setColorText(new Color(255,255,255));
        mnuCompany.setBackground(new Color(13,110,253));
        mnuSales.setColorText(new Color(76,76,76));
        mnuSales.setBackground(new Color(238,240,241));
        mnuHome.setColorText(new Color(76,76,76));
        mnuHome.setBackground(new Color(238,240,241));
        mnuShopping.setColorText(new Color(76,76,76));
        mnuShopping.setBackground(new Color(238,240,241));
        mnuStore.setColorText(new Color(76,76,76));
        mnuStore.setBackground(new Color(238,240,241));
        mnuReport.setColorText(new Color(76,76,76));
        mnuReport.setBackground(new Color(238,240,241));
        mnuUsers.setColorText(new Color(76,76,76));
        mnuUsers.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuSetting.setColorText(new Color(76,76,76));
        mnuSetting.setBackground(new Color(238,240,241));
        new ChangePanel(PrincipalHomes, new Company());
        lblTitleHome.setText("Empresa");

    }//GEN-LAST:event_mnuCompanyActionPerformed

    private void mnuSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSettingActionPerformed
        mnuSetting.setColorText(new Color(255,255,255));
        mnuSetting.setBackground(new Color(13,110,253));
        mnuSales.setColorText(new Color(76,76,76));
        mnuSales.setBackground(new Color(238,240,241));
        mnuHome.setColorText(new Color(76,76,76));
        mnuHome.setBackground(new Color(238,240,241));
        mnuShopping.setColorText(new Color(76,76,76));
        mnuShopping.setBackground(new Color(238,240,241));
        mnuStore.setColorText(new Color(76,76,76));
        mnuStore.setBackground(new Color(238,240,241));
        mnuReport.setColorText(new Color(76,76,76));
        mnuReport.setBackground(new Color(238,240,241));
        mnuUsers.setColorText(new Color(76,76,76));
        mnuUsers.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuCompany.setColorText(new Color(76,76,76));
        mnuCompany.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        new ChangePanel(PrincipalHomes, new Setting());
        lblTitleHome.setText("Configuraciones");
    }//GEN-LAST:event_mnuSettingActionPerformed

    private void mnuHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHelpActionPerformed
//        new ChangePanel(PrincipalHomes, new Help());
        lblTitleHome.setText("Centro de soporte");
    }//GEN-LAST:event_mnuHelpActionPerformed

    private void mnuReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReportActionPerformed
        mnuReport.setColorText(new Color(255,255,255));
        mnuReport.setBackground(new Color(13,110,253));
        mnuSales.setColorText(new Color(76,76,76));
        mnuSales.setBackground(new Color(238,240,241));
        mnuHome.setColorText(new Color(76,76,76));
        mnuHome.setBackground(new Color(238,240,241));
        mnuShopping.setColorText(new Color(76,76,76));
        mnuShopping.setBackground(new Color(238,240,241));
        mnuStore.setColorText(new Color(76,76,76));
        mnuStore.setBackground(new Color(238,240,241));
        mnuUsers.setColorText(new Color(76,76,76));
        mnuUsers.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuCompany.setColorText(new Color(76,76,76));
        mnuCompany.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuSetting.setColorText(new Color(76,76,76));
        mnuSetting.setBackground(new Color(238,240,241));
        new ChangePanel(PrincipalHomes, new Reports());
        lblTitleHome.setText("Módulo de consultas y reporte");
    }//GEN-LAST:event_mnuReportActionPerformed

    private void mnuExitSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitSystemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuExitSystemActionPerformed

    private void mnuSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalesActionPerformed
        mnuSales.setColorText(new Color(255,255,255));
        mnuSales.setBackground(new Color(13,110,253));
        mnuHome.setColorText(new Color(76,76,76));
        mnuHome.setBackground(new Color(238,240,241));
        mnuShopping.setColorText(new Color(76,76,76));
        mnuShopping.setBackground(new Color(238,240,241));
        mnuStore.setColorText(new Color(76,76,76));
        mnuStore.setBackground(new Color(238,240,241));
        mnuReport.setColorText(new Color(76,76,76));
        mnuReport.setBackground(new Color(238,240,241));
        mnuUsers.setColorText(new Color(76,76,76));
        mnuUsers.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuCompany.setColorText(new Color(76,76,76));
        mnuCompany.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuSetting.setColorText(new Color(76,76,76));
        mnuSetting.setBackground(new Color(238,240,241));
        new ChangePanel(PrincipalHomes, new Sales());
//        cLogin.loginAccessSales(idUserLogin.getText());
        lblTitleHome.setText("Ventas");
    }//GEN-LAST:event_mnuSalesActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged

    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed

    private void mnuShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuShoppingActionPerformed
        mnuShopping.setColorText(new Color(255,255,255));
        mnuShopping.setBackground(new Color(13,110,253));
        mnuSales.setColorText(new Color(76,76,76));
        mnuSales.setBackground(new Color(238,240,241));
        mnuHome.setColorText(new Color(76,76,76));
        mnuHome.setBackground(new Color(238,240,241));
        mnuStore.setColorText(new Color(76,76,76));
        mnuStore.setBackground(new Color(238,240,241));
        mnuReport.setColorText(new Color(76,76,76));
        mnuReport.setBackground(new Color(238,240,241));
        mnuUsers.setColorText(new Color(76,76,76));
        mnuUsers.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuCompany.setColorText(new Color(76,76,76));
        mnuCompany.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuSetting.setColorText(new Color(76,76,76));
        mnuSetting.setBackground(new Color(238,240,241));
        new ChangePanel(PrincipalHomes, new Shopping());
        lblTitleHome.setText("Compras y proveedores");
    }//GEN-LAST:event_mnuShoppingActionPerformed

    private void mnuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsersActionPerformed
        mnuUsers.setColorText(new Color(255,255,255));
        mnuUsers.setBackground(new Color(13,110,253));
        mnuSales.setColorText(new Color(76,76,76));
        mnuSales.setBackground(new Color(238,240,241));
        mnuHome.setColorText(new Color(76,76,76));
        mnuHome.setBackground(new Color(238,240,241));
        mnuShopping.setColorText(new Color(76,76,76));
        mnuShopping.setBackground(new Color(238,240,241));
        mnuStore.setColorText(new Color(76,76,76));
        mnuStore.setBackground(new Color(238,240,241));
        mnuReport.setColorText(new Color(76,76,76));
        mnuReport.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuCompany.setColorText(new Color(76,76,76));
        mnuCompany.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuSetting.setColorText(new Color(76,76,76));
        mnuSetting.setBackground(new Color(238,240,241));
        new ChangePanel(PrincipalHomes, new Users());
//        cLogin.loginAccessExpences(idUserLogin.getText());
        lblTitleHome.setText("Desembolso de dinero");
    }//GEN-LAST:event_mnuUsersActionPerformed

    private void mnuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHomeActionPerformed
        mnuHome.setColorText(new Color(255,255,255));
        mnuHome.setBackground(new Color(13,110,253));
        mnuSales.setColorText(new Color(76,76,76));
        mnuSales.setBackground(new Color(238,240,241));
        mnuShopping.setColorText(new Color(76,76,76));
        mnuShopping.setBackground(new Color(238,240,241));
        mnuStore.setColorText(new Color(76,76,76));
        mnuStore.setBackground(new Color(238,240,241));
        mnuReport.setColorText(new Color(76,76,76));
        mnuReport.setBackground(new Color(238,240,241));
        mnuUsers.setColorText(new Color(76,76,76));
        mnuUsers.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuCompany.setColorText(new Color(76,76,76));
        mnuCompany.setBackground(new Color(238,240,241));
        mnuCustomer.setColorText(new Color(76,76,76));
        mnuCustomer.setBackground(new Color(238,240,241));
        mnuSetting.setColorText(new Color(76,76,76));
        mnuSetting.setBackground(new Color(238,240,241));
//        new ChangePanel(PrincipalHomes, new Dashboard());
        lblTitleHome.setText("Dashoard principal");

    }//GEN-LAST:event_mnuHomeActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel PrincipalHomes;
    public static javax.swing.JLabel idUserLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public static javax.swing.JLabel lblNonw;
    public static javax.swing.JLabel lblTitleHome;
    public static rojerusan.RSButtonIconI mnuCompany;
    public static rojerusan.RSButtonIconI mnuCustomer;
    private rojerusan.RSButtonIconI mnuExitSystem;
    private rojerusan.RSButtonIconI mnuHelp;
    public static rojerusan.RSButtonIconI mnuHome;
    public static rojerusan.RSButtonIconI mnuReport;
    public static rojerusan.RSButtonIconI mnuSales;
    public static rojerusan.RSButtonIconI mnuSetting;
    public static rojerusan.RSButtonIconI mnuShopping;
    public static rojerusan.RSButtonIconI mnuStore;
    public static rojerusan.RSButtonIconI mnuUsers;
    public static javax.swing.JLabel nameCompany;
    public static javax.swing.JLabel nameStore;
    private javax.swing.JPanel panelMenus;
    private rojerusan.RSPanelCircleImage rSPanelCircleImage1;
    public static javax.swing.JLabel titlessAdministrations;
    public static javax.swing.JLabel titlessCompany;
    public static javax.swing.JLabel userLevel;
    public static javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
