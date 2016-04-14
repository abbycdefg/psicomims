/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abby
 */
public class DCCompleteDeliverySchedulesTab extends javax.swing.JFrame {

	String msgAD = "Administrator";
	String msgDC = "Documentation Clerk";
	String prevPage;
	
    /**
     * Creates new form DCCompleteDeliverySchedulesTab
     */
    public DCCompleteDeliverySchedulesTab(String page) {
    	if (page.equals("")){
    		initComponents(msgDC);
    	}
    	else if (page.equals("ad")){
    		initComponents(msgAD);
    	}
        
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        signOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            Font originalFont = null;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                originalFont = signOutButton.getFont();
                Map attributes = originalFont.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                signOutButton.setFont(originalFont.deriveFont(attributes));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signOutButton.setFont(originalFont);
            }
        });
        
             searchField.addFocusListener(new FocusListener(){            
            @Override
            public void focusLost(FocusEvent arg0) {
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                searchField.setText("");
            }
        }); 
             
        
        
        searchField.addFocusListener(new FocusListener(){            
            @Override
            public void focusLost(FocusEvent arg0) {
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                searchField.setText("");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(String message) {

        logoLabel = new javax.swing.JLabel();
        greetingLabel = new javax.swing.JLabel();
        signOutButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        copyrightLabel1 = new javax.swing.JLabel();
        titleLabel1 = new javax.swing.JLabel();
        advanceSearchPanel1 = new javax.swing.JLayeredPane();
        dsPerDayChooser1 = new com.toedter.calendar.JDateChooser();
        dsPerDayLabel1 = new javax.swing.JLabel();
        advancedSearchLabel1 = new javax.swing.JLabel();
        dsFromLabel1 = new javax.swing.JLabel();
        dsToLabel1 = new javax.swing.JLabel();
        dsFromChooser1 = new com.toedter.calendar.JDateChooser();
        dsToChooser1 = new com.toedter.calendar.JDateChooser();
        advSearchButton = new javax.swing.JButton();
        dsPerWeekMonthLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deliverySchedulesTable = new javax.swing.JTable();
        navbarPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Complete Delivery Schedules");

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/VS2.1.png"))); // NOI18N

        greetingLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        greetingLabel.setForeground(new java.awt.Color(255, 255, 255));
        greetingLabel.setText("Hello, "+ message + " | ");

        signOutButton.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        signOutButton.setForeground(new java.awt.Color(255, 255, 255));
        signOutButton.setText("Sign Out");
        signOutButton.setBorder(null);
        signOutButton.setBorderPainted(false);
        signOutButton.setContentAreaFilled(false);
        signOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setText("   Search");
        searchField.setToolTipText("Search");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(205, 0, 69));
        searchButton.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_search.png"))); // NOI18N
        searchButton.setToolTipText("");
        searchButton.setAlignmentY(0.0F);
        searchButton.setBorder(null);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        searchButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_search2.png"))); // NOI18N
        searchButton.setRequestFocusEnabled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setAlignmentX(0.0F);
        tablePanel.setAlignmentY(0.0F);

        copyrightLabel1.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        copyrightLabel1.setForeground(new java.awt.Color(32, 55, 73));
        copyrightLabel1.setText("� 2016 PSICOM Inventory Mgt. System Powered by VIPE Solutions. All Rights Reserved. ");

        titleLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        titleLabel1.setForeground(new java.awt.Color(32, 55, 73));
        titleLabel1.setText("DELIVERY SCHEDULES");

        advanceSearchPanel1.setBackground(new java.awt.Color(234, 234, 234));
        advanceSearchPanel1.setOpaque(true);

        dsPerDayLabel1.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        dsPerDayLabel1.setForeground(new java.awt.Color(51, 51, 51));
        dsPerDayLabel1.setText("Delivery Schedules Per Day");

        advancedSearchLabel1.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        advancedSearchLabel1.setForeground(new java.awt.Color(51, 51, 51));
        advancedSearchLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom75.png"))); // NOI18N
        advancedSearchLabel1.setText("Advanced Search");

        dsFromLabel1.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        dsFromLabel1.setForeground(new java.awt.Color(51, 51, 51));
        dsFromLabel1.setText("Delivery Schedules from");

        dsToLabel1.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        dsToLabel1.setForeground(new java.awt.Color(51, 51, 51));
        dsToLabel1.setText("to");

        advSearchButton.setBackground(new java.awt.Color(205, 0, 69));
        advSearchButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        advSearchButton.setForeground(new java.awt.Color(255, 255, 255));
        advSearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_search3.png"))); // NOI18N
        advSearchButton.setBorder(null);
        advSearchButton.setBorderPainted(false);
        advSearchButton.setContentAreaFilled(false);
        advSearchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        advSearchButton.setIconTextGap(0);
        advSearchButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        advSearchButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_search4.png"))); // NOI18N
        advSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                advSearchButtonMouseEntered(evt);
            }
        });
        advSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advSearchButtonActionPerformed(evt);
            }
        });

        dsPerWeekMonthLabel1.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        dsPerWeekMonthLabel1.setForeground(new java.awt.Color(51, 51, 51));
        dsPerWeekMonthLabel1.setText("Delivery Schedules Per Week/Month");

        javax.swing.GroupLayout advanceSearchPanel1Layout = new javax.swing.GroupLayout(advanceSearchPanel1);
        advanceSearchPanel1.setLayout(advanceSearchPanel1Layout);
        advanceSearchPanel1Layout.setHorizontalGroup(
            advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advanceSearchPanel1Layout.createSequentialGroup()
                .addGroup(advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(advanceSearchPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(advSearchButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, advanceSearchPanel1Layout.createSequentialGroup()
                        .addGroup(advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, advanceSearchPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(advancedSearchLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, advanceSearchPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dsPerWeekMonthLabel1)
                                    .addGroup(advanceSearchPanel1Layout.createSequentialGroup()
                                        .addGroup(advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dsPerDayLabel1)
                                            .addComponent(dsFromLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(advanceSearchPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(dsFromChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dsToLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dsToChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(advanceSearchPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dsPerDayChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        advanceSearchPanel1Layout.setVerticalGroup(
            advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advanceSearchPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dsPerDayChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(advanceSearchPanel1Layout.createSequentialGroup()
                        .addComponent(advancedSearchLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dsPerDayLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dsPerWeekMonthLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(advanceSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dsToLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dsToChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dsFromChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dsFromLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(advSearchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        advanceSearchPanel1.setLayer(dsPerDayChooser1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        advanceSearchPanel1.setLayer(dsPerDayLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        advanceSearchPanel1.setLayer(advancedSearchLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        advanceSearchPanel1.setLayer(dsFromLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        advanceSearchPanel1.setLayer(dsToLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        advanceSearchPanel1.setLayer(dsFromChooser1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        advanceSearchPanel1.setLayer(dsToChooser1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        advanceSearchPanel1.setLayer(advSearchButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        advanceSearchPanel1.setLayer(dsPerWeekMonthLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        deliverySchedulesTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        deliverySchedulesTable.setForeground(new java.awt.Color(255, 255, 255));
                
        this.displayAll("", "");
        
        deliverySchedulesTable.setToolTipText("");
        deliverySchedulesTable.setCellSelectionEnabled(true);
        deliverySchedulesTable.setGridColor(new java.awt.Color(204, 204, 255));
        deliverySchedulesTable.setRequestFocusEnabled(false);
        deliverySchedulesTable.setRowHeight(18);
        deliverySchedulesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(deliverySchedulesTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(advanceSearchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(titleLabel1))
                    .addComponent(copyrightLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(titleLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(advanceSearchPanel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(copyrightLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        navbarPanel.setBackground(new java.awt.Color(227, 234, 245));
        navbarPanel.setAlignmentX(0.0F);

        homeButton.setBackground(new java.awt.Color(255, 255, 255));
        homeButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_home.png"))); // NOI18N
        homeButton.setAlignmentY(0.0F);
        homeButton.setBorder(null);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.setIconTextGap(0);
        homeButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        homeButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_home2.png"))); // NOI18N
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navbarPanelLayout = new javax.swing.GroupLayout(navbarPanel);
        navbarPanel.setLayout(navbarPanelLayout);
        navbarPanelLayout.setHorizontalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeButton)
                .addContainerGap())
        );
        navbarPanelLayout.setVerticalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(greetingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signOutButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(signOutButton)
                            .addComponent(greetingLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(navbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
    	if(prevPage.equals("ad")){
    		this.dispose();
	    	ADLogInScreen a = new ADLogInScreen();
	    	a.setVisible(true);
    	}
    	else{
	    	this.dispose();
	    	DCLogInScreen a = new DCLogInScreen();
	    	a.setVisible(true);
    	}
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
    	if (searchField.getText() == null || searchField.getText() == " "){
            this.displayAll("", "");
        }
        else{
        	String[] columnNames = {"DATE", "SCHEDULE CODE", "OUTLETS", "DELIVERY RECEIPT CODE"};

        	DefaultTableModel model = new DefaultTableModel(){
            	public boolean isCellEditable(int row, int column)
            	 {
            	     return false;
            	 }
            };
            model.setColumnIdentifiers(columnNames);
            
            PreparedStatement pst;
            Connection con;
            
            String date = "";
            String scheduleCode = "";
            String outlet = "";
            String deliveryReceiptCode = "";
            
            Date dateToday = Calendar.getInstance().getTime();        
            DateFormat d = new SimpleDateFormat("MM/dd/yyyy");
            String dateTodayStr = d.format(dateToday);
            
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
                pst = con.prepareStatement("SELECT * FROM delivery_schedule WHERE date LIKE '%" + searchField.getText() + "%' OR delivery_receipt_code LIKE '%" + searchField.getText() + "%' OR schedule_code LIKE '%" + searchField.getText() + "%' OR outlet LIKE '%" + searchField.getText() + "%'");
                ResultSet rs = pst.executeQuery();
                int i = 0;
                while (rs.next()) {
                	date = rs.getString("date");
                	scheduleCode = rs.getString("delivery_receipt_code");
                	outlet = rs.getString("outlet");
                	deliveryReceiptCode = rs.getString("schedule_code");
                	
                	Date givenDate = d.parse(date);
    				boolean before = givenDate.before(d.parse(dateTodayStr));
    				
    				if (before == true){
    					model.addRow(new Object[]{date, scheduleCode, outlet, deliveryReceiptCode});
    				}
    				i++;
                }
                
                if (i < 1) {
                    JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                if (i == 1) {
                    System.out.println(i + " Record Found");
                } 
                
                else {
                    System.out.println(i + " Records Found");
                }

                      
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            deliverySchedulesTable.setModel(model);
            deliverySchedulesTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
    	if(prevPage.equals("ad")){
    		this.dispose();
	    	ADHomeScreen a = new ADHomeScreen();
	    	a.setVisible(true);
    	}
    	else{
	    	this.dispose();
	    	DCHomeScreen a = new DCHomeScreen();
	    	a.setVisible(true);
    	}
    }//GEN-LAST:event_homeButtonActionPerformed

    private void advSearchButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_advSearchButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_advSearchButtonMouseEntered

    private void advSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advSearchButtonActionPerformed
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        if (dsFromChooser1.getDate() != null && dsToChooser1.getDate() != null)
        {
	        java.util.Date firstDate = dsFromChooser1.getDate();
	        String fromDate = df.format(firstDate);
	        
	        java.util.Date secondDate = dsToChooser1.getDate();
	        String toDate = df.format(secondDate);
	        if(!fromDate.equals("") && !toDate.equals("")) {
	       	 
	            displayAll(fromDate, toDate);
	        }
        }
        
        else if(dsPerDayChooser1.getDate() != null)
        {
	         java.util.Date dayDate = dsPerDayChooser1.getDate();
	         String dayDateStr = df.format(dayDate);
	
	          if (!dayDateStr.equals(""))
	         {
	        	 displayAll(dayDateStr, "");
	         }
        }
    }//GEN-LAST:event_advSearchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DCCompleteDeliverySchedulesTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCCompleteDeliverySchedulesTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCCompleteDeliverySchedulesTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCCompleteDeliverySchedulesTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCCompleteDeliverySchedulesTab("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton advSearchButton;
    private javax.swing.JLayeredPane advanceSearchPanel1;
    private javax.swing.JLabel advancedSearchLabel1;
    private javax.swing.JLabel copyrightLabel1;
    private javax.swing.JTable deliverySchedulesTable;
    private com.toedter.calendar.JDateChooser dsFromChooser1;
    private javax.swing.JLabel dsFromLabel1;
    private com.toedter.calendar.JDateChooser dsPerDayChooser1;
    private javax.swing.JLabel dsPerDayLabel1;
    private javax.swing.JLabel dsPerWeekMonthLabel1;
    private com.toedter.calendar.JDateChooser dsToChooser1;
    private javax.swing.JLabel dsToLabel1;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel navbarPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton signOutButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel titleLabel1;
    // End of variables declaration//GEN-END:variables
    
    public void displayAll(String date1, String date2){
    	String[] columnNames = {"DATE", "SCHEDULE CODE", "OUTLETS", "DELIVERY RECEIPT CODE"};

    	DefaultTableModel model = new DefaultTableModel(){
        	public boolean isCellEditable(int row, int column)
        	 {
        	     return false;
        	 }
        };
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
        Connection con;
        
        String date = "";
        String scheduleCode = "";
        String outlet = "";
        String deliveryReceiptCode = "";
        
        Date dateToday = Calendar.getInstance().getTime();        
        DateFormat d = new SimpleDateFormat("MM/dd/yyyy");
        String dateTodayStr = d.format(dateToday);
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
        	pst = con.prepareStatement("SELECT * FROM delivery_schedule");
            ResultSet rs = pst.executeQuery();
        	int i = 0;
            
            	if(!date1.equals("") && date2.equals("")){
            		while (rs.next()) {            	                   	        
	            		if(date1.equals(rs.getString("date")))
	            		{
            			
            				date = rs.getString("date");       	
            				scheduleCode = rs.getString("schedule_code");
            				outlet = rs.getString("outlet");
            				deliveryReceiptCode = rs.getString("delivery_receipt_code");
            				
            				Date givenDate = d.parse(date);
            				boolean before = givenDate.before(d.parse(dateTodayStr));
            				
            				if (before == true){
            					model.addRow(new Object[]{date, scheduleCode, outlet, deliveryReceiptCode});
            				}
            				i++;
            			
	            		}
            		}
            	}
            		
        		else if( !date1.equals("") && !date2.equals("")){
        			while (rs.next()) {        				
            		Date dateTo = dsToChooser1.getDate();
            		Date dateFrom = dsFromChooser1.getDate();
            		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            		Date thisDate = df.parse(rs.getString("date"));
            			if(dateFrom.compareTo(thisDate) * thisDate.compareTo(dateTo) > 0)
                		{
            				
            				date = rs.getString("date");       	
            				scheduleCode = rs.getString("schedule_code");
            				outlet = rs.getString("outlet");
            				deliveryReceiptCode = rs.getString("delivery_receipt_code");
            				
            				Date givenDate = d.parse(date);
            				boolean before = givenDate.before(d.parse(dateTodayStr));
            				
            				if (before == true){
            					model.addRow(new Object[]{date, scheduleCode, outlet, deliveryReceiptCode});
            				}
            				i++;
                		}
            		}
        		}
            	
        		else {
        			while (rs.next()) {
            			date = rs.getString("date");       	
                    	scheduleCode = rs.getString("schedule_code");
                    	outlet = rs.getString("outlet");
                    	deliveryReceiptCode = rs.getString("delivery_receipt_code");
                    	
                    	Date givenDate = d.parse(date);
        				boolean before = givenDate.before(d.parse(dateTodayStr));
        				
        				if (before == true){
        					model.addRow(new Object[]{date, scheduleCode, outlet, deliveryReceiptCode});
        				}
        				i++;
        			}
        		}
            	
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            if (i == 1) {
                System.out.println(i + " Record Found");
            } 
            
            else {
                System.out.println(i + " Records Found");
            }

                  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        deliverySchedulesTable = new JTable(model);
        deliverySchedulesTable.setModel(model);
        deliverySchedulesTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        deliverySchedulesTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        deliverySchedulesTable.setForeground(new java.awt.Color(255, 255, 255));
        deliverySchedulesTable.setForeground(Color.BLACK);      
        deliverySchedulesTable.setToolTipText("");
        deliverySchedulesTable.setCellSelectionEnabled(true);
        deliverySchedulesTable.setGridColor(new java.awt.Color(204, 204, 255));
        deliverySchedulesTable.setRequestFocusEnabled(false);
        deliverySchedulesTable.setRowHeight(18);
        deliverySchedulesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setColumnHeaderView(deliverySchedulesTable.getTableHeader());
        jScrollPane1.setViewportView(deliverySchedulesTable);
    }
}
