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
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class DCIncompletePurchaseOrdersTab extends javax.swing.JFrame {

	String msgAD = "Administrator";
	String msgDC = "Documentation Clerk";
	String prevPage;
	
    /**
     * Creates new form DCIncompletePurchaseOrdersTab
     */
    public DCIncompletePurchaseOrdersTab(String page) {
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
        tablePanel = new javax.swing.JPanel();
        titleLabel1 = new javax.swing.JLabel();
        copyrightLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseOrdersTable = new javax.swing.JTable();
        navbarPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        completeButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();
        greetingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Incomplete Purchase Orders");

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/VS2.1.png"))); // NOI18N

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setAlignmentX(0.0F);
        tablePanel.setAlignmentY(0.0F);

        titleLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        titleLabel1.setForeground(new java.awt.Color(32, 55, 73));
        titleLabel1.setText("PURCHASE ORDERS");

        copyrightLabel1.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        copyrightLabel1.setForeground(new java.awt.Color(32, 55, 73));
        copyrightLabel1.setText("� 2016 PSICOM Inventory Mgt. System Powered by VIPE Solutions. All Rights Reserved. ");

        purchaseOrdersTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        purchaseOrdersTable.setForeground(new java.awt.Color(255, 255, 255));
        
        this.displayAll();
        
        purchaseOrdersTable.setToolTipText("");
        purchaseOrdersTable.setCellSelectionEnabled(true);
        purchaseOrdersTable.setGridColor(new java.awt.Color(204, 204, 255));
        purchaseOrdersTable.setRequestFocusEnabled(false);
        purchaseOrdersTable.setRowHeight(18);
        purchaseOrdersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(purchaseOrdersTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(copyrightLabel1)))
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(titleLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(copyrightLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        navbarPanel.setBackground(new java.awt.Color(227, 234, 245));
        navbarPanel.setAlignmentX(0.0F);

        createButton.setBackground(new java.awt.Color(205, 0, 69));
        createButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        createButton.setForeground(new java.awt.Color(255, 255, 255));
        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_createPO.png"))); // NOI18N
        createButton.setBorder(null);
        createButton.setBorderPainted(false);
        createButton.setContentAreaFilled(false);
        createButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createButton.setIconTextGap(0);
        createButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        createButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_createPO2.png"))); // NOI18N
        createButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createButtonMouseEntered(evt);
            }
        });
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        viewButton.setBackground(new java.awt.Color(255, 255, 255));
        viewButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        viewButton.setForeground(new java.awt.Color(255, 255, 255));
        viewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_view.png"))); // NOI18N
        viewButton.setAlignmentY(0.0F);
        viewButton.setBorder(null);
        viewButton.setBorderPainted(false);
        viewButton.setContentAreaFilled(false);
        viewButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_view2.png"))); // NOI18N
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(255, 255, 255));
        editButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_edit.png"))); // NOI18N
        editButton.setAlignmentY(0.0F);
        editButton.setBorder(null);
        editButton.setBorderPainted(false);
        editButton.setContentAreaFilled(false);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        editButton.setIconTextGap(0);
        editButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_edit2.png"))); // NOI18N
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_delete.png"))); // NOI18N
        deleteButton.setToolTipText("");
        deleteButton.setAlignmentY(0.0F);
        deleteButton.setBorder(null);
        deleteButton.setBorderPainted(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        deleteButton.setIconTextGap(0);
        deleteButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        deleteButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_delete2.png"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

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

        completeButton.setBackground(new java.awt.Color(255, 255, 255));
        completeButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        completeButton.setForeground(new java.awt.Color(255, 255, 255));
        completeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_completePO1.png"))); // NOI18N
        completeButton.setAlignmentY(0.0F);
        completeButton.setBorder(null);
        completeButton.setBorderPainted(false);
        completeButton.setContentAreaFilled(false);
        completeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        completeButton.setIconTextGap(0);
        completeButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        completeButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_completePO2.png"))); // NOI18N
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navbarPanelLayout = new javax.swing.GroupLayout(navbarPanel);
        navbarPanel.setLayout(navbarPanelLayout);
        navbarPanelLayout.setHorizontalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(viewButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteButton)
                            .addComponent(homeButton))
                        .addComponent(completeButton, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(createButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        navbarPanelLayout.setVerticalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(completeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createButton)
                .addGap(77, 77, 77)
                .addComponent(viewButton)
                .addGap(18, 18, 18)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

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

        greetingLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        greetingLabel.setForeground(new java.awt.Color(255, 255, 255));
        greetingLabel.setText("Hello, "+ message + " | ");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(navbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_createButtonMouseEntered

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
    	this.dispose();
    	DCAddPurchaseOrderScreen a = new DCAddPurchaseOrderScreen("");
    	
        if (prevPage.equals("")){
        	a = new DCAddPurchaseOrderScreen("");
        }
        else if (prevPage.equals("ad")){
        	a = new DCAddPurchaseOrderScreen("ad");
        }
        
        a.setVisible(true);
    }//GEN-LAST:event_createButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
    	if (purchaseOrdersTable.getSelectedColumn() == 0){
    		
    		String poNumber = DCIncompletePurchaseOrdersTab.getColumnData(0);
			String contactPerson = DCIncompletePurchaseOrdersTab.getColumnData(2);
			String outlet = DCIncompletePurchaseOrdersTab.getColumnData(3);
			this.dispose();
			DCViewPurchaseOrderScreen a = new DCViewPurchaseOrderScreen(poNumber, contactPerson, outlet, "");
	        
	         if (prevPage.equals("")){
	         	a = new DCViewPurchaseOrderScreen(poNumber, contactPerson, outlet, "");
	         }
	         else if (prevPage.equals("ad")){
	         	a = new DCViewPurchaseOrderScreen(poNumber, contactPerson, outlet, "ad");
	         }
            
            a.setVisible(true);
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }//GEN-LAST:event_viewButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
    	if (purchaseOrdersTable.getSelectedRowCount() == 1 && purchaseOrdersTable.getSelectedColumn() == 0){
    		int row = purchaseOrdersTable.getSelectedRow();
    		String poNumber = purchaseOrdersTable.getValueAt(row, 0).toString();
    		String date = purchaseOrdersTable.getValueAt(row, 1).toString();
    		String contactPers = purchaseOrdersTable.getValueAt(row, 2).toString();
    		String outlet = purchaseOrdersTable.getValueAt(row, 3).toString();
    		this.dispose();
	    	DCEditPurchaseOrderScreen a = new DCEditPurchaseOrderScreen(poNumber, date, contactPers, outlet, "");
	    	
	         if (prevPage.equals("")){
	         	a = new DCEditPurchaseOrderScreen(poNumber, date, contactPers, outlet, "");;
	         }
	         else if (prevPage.equals("ad")){
	         	a = new DCEditPurchaseOrderScreen(poNumber, date, contactPers, outlet, "ad");;
	         }
            
            a.setVisible(true);
    		}

    	else{
    		JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    	if (purchaseOrdersTable.getSelectedRowCount() == 1 && purchaseOrdersTable.getSelectedColumn() == 0){
    		int row = purchaseOrdersTable.getSelectedRow();
    		String poNumber = purchaseOrdersTable.getValueAt(row, 0).toString();
    		System.out.println(poNumber);
    		this.dispose();
	    	DCDeletePurchaseOrderScreen a = new DCDeletePurchaseOrderScreen(poNumber, "");
	    	
	         if (prevPage.equals("")){
	         	a = new DCDeletePurchaseOrderScreen(poNumber, "");
	         }
	         else if (prevPage.equals("ad")){
	         	a = new DCDeletePurchaseOrderScreen(poNumber, "ad");;
	         }
            
            a.setVisible(true);	    	
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }//GEN-LAST:event_deleteButtonActionPerformed

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

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
    	if (searchField.getText() == null || searchField.getText() == " "){
            this.displayAll();
        }
        else{
        	String[] columnNames = {"PO NUMBER", "DATE", "CONTACT PERSON", "OUTLET"};

        	DefaultTableModel model = new DefaultTableModel(){
            	public boolean isCellEditable(int row, int column)
            	 {
            	     return false;
            	 }
            };
            model.setColumnIdentifiers(columnNames);
            
            PreparedStatement pst;
            Connection con;
            
            String poNumber = "";
            String date = "";
            String contactPerson = "";
            String outlet = "";
            String status = "";
            
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
                pst = con.prepareStatement("SELECT * FROM psicomims.purchase_order WHERE (purchase_order_number LIKE '%" + searchField.getText() + "%' OR date_Today LIKE '%" + searchField.getText() + "%' OR contact_person LIKE '%" + searchField.getText() + "%' OR outlet LIKE '%" + searchField.getText() + "%') AND po_status='INCOMPLETE' ORDER BY date_today ASC");
                ResultSet rs = pst.executeQuery();
                int i = 0;
                while (rs.next()) {
                    poNumber = rs.getString("purchase_order_number");
                    date = rs.getString("date_Today");
                    contactPerson = rs.getString("contact_person");
                    outlet = rs.getString("outlet");
                    status = rs.getString("po_status");
                    model.addRow(new Object[]{poNumber, date, contactPerson, outlet});
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
            
            purchaseOrdersTable.setModel(model);
            purchaseOrdersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

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

    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeButtonActionPerformed
    	this.dispose();
    	DCCompletePurchaseOrdersTab a = new DCCompletePurchaseOrdersTab("");
    	
        if (prevPage.equals("")){
        	a = new DCCompletePurchaseOrdersTab("");
       	}
    	else if (prevPage.equals("ad")){
    		a = new DCCompletePurchaseOrdersTab("ad");
        	
    	}
        
    	a.setVisible(true);
    }//GEN-LAST:event_completeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DCIncompletePurchaseOrdersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCIncompletePurchaseOrdersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCIncompletePurchaseOrdersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCIncompletePurchaseOrdersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCIncompletePurchaseOrdersTab("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton completeButton;
    private javax.swing.JLabel copyrightLabel1;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel navbarPanel;
    private static javax.swing.JTable purchaseOrdersTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton signOutButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
    
    public static String getData(){
    	int selectedRowIndex = purchaseOrdersTable.getSelectedRow();
    	int selectedColumnIndex = purchaseOrdersTable.getSelectedColumn();
    	String selectedCell = (String) purchaseOrdersTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
    	return selectedCell;
    }
    
    public static String getColumnData(int n){
    	int selectedRowIndex = purchaseOrdersTable.getSelectedRow();
    	int selectedColumnIndex = purchaseOrdersTable.getSelectedColumn() + n;
    	String selectedCell = (String) purchaseOrdersTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
    	return selectedCell;
    }
    
    public void displayAll(){
    	String[] columnNames = {"PO NUMBER", "DATE", "CONTACT PERSON", "OUTLET"};

    	DefaultTableModel model = new DefaultTableModel(){
        	public boolean isCellEditable(int row, int column)
        	 {
        	     return false;
        	 }
        };
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
        PreparedStatement pst2;
        Connection con;
        
        String poNumber = "";
        String date = "";
        String contactPerson = "";
        String outlet = "";
        String status = "";
        String title2 = "";
        String quantity2 = "";
        String state2 = "";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
            pst = con.prepareStatement("SELECT * FROM psicomims.purchase_order WHERE po_status='INCOMPLETE' ORDER BY date_today ASC");
            ResultSet rs = pst.executeQuery();
                      
            int i = 0;                        
            while (rs.next()) {
                poNumber = rs.getString("purchase_order_number");
                date = rs.getString("date_Today");
                contactPerson = rs.getString("contact_person");
                outlet = rs.getString("outlet");
                status = rs.getString("po_status");               
                model.addRow(new Object[]{poNumber, date, contactPerson, outlet});
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
            
            //Stock notification
            int j = 0;
            pst2 = con.prepareStatement("SELECT * FROM psicomims.book");
            ResultSet rs2 = pst2.executeQuery();    
	        while (rs2.next()) {  		            
		        title2 = rs2.getString("title");
		        quantity2 = rs2.getString("quantity");
		        state2 = rs2.getString("state");
		        if (Integer.parseInt(quantity2) < Integer.parseInt(rs2.getString("threshold")) && !state2.equals("new")){
		        	String titleNew = title2;
		        	if (title2.length() > 11){
		        		titleNew = title2.substring(0, 13) + "...";
		        	}
		        	DCStockNotificationScreen d = new DCStockNotificationScreen(titleNew);
		        	d.setVisible(true);
		        }
		        j++;
	        }
	        
                             
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        purchaseOrdersTable = new JTable(model);
        purchaseOrdersTable.setModel(model);
        purchaseOrdersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
}
