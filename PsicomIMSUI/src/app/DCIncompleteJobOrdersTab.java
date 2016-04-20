/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.DCIncompleteJobOrdersTab.printAction;

/**
 *
 * @author Abby
 */
public class DCIncompleteJobOrdersTab extends javax.swing.JFrame {

	String msgAD = "Administrator";
	String msgDC = "Documentation Clerk";
	String prevPage;
	
    /**
     * Creates new form DCIncompleteJobOrdersTab
     */
    public DCIncompleteJobOrdersTab(String page) {
    	initComponents("");
    	if (page.equals("")){
    		initComponents(msgDC);
    	}
    	else if (page.equals("ad")){
    		initComponents(msgAD);
    	}   
        

        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        printButton.addActionListener(new printAction());
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
        titleLabel1 = new javax.swing.JLabel();
        copyrightLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jobOrdersTable = new javax.swing.JTable();
        navbarPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        completeButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Incomplete Job Orders");

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

        titleLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        titleLabel1.setForeground(new java.awt.Color(32, 55, 73));
        titleLabel1.setText("JOB ORDERS");

        copyrightLabel1.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        copyrightLabel1.setForeground(new java.awt.Color(32, 55, 73));
        copyrightLabel1.setText("� 2016 PSICOM Inventory Mgt. System Powered by VIPE Solutions. All Rights Reserved. ");

        jobOrdersTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jobOrdersTable.setForeground(new java.awt.Color(255, 255, 255));
        
        this.displayAll();
        
        jobOrdersTable.setToolTipText("");
        jobOrdersTable.setCellSelectionEnabled(true);
        jobOrdersTable.setGridColor(new java.awt.Color(204, 204, 255));
        jobOrdersTable.setRequestFocusEnabled(false);
        jobOrdersTable.setRowHeight(18);
        jobOrdersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jobOrdersTable);

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
                        .addGap(311, 311, 311)
                        .addComponent(titleLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_createJO.png"))); // NOI18N
        createButton.setBorder(null);
        createButton.setBorderPainted(false);
        createButton.setContentAreaFilled(false);
        createButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createButton.setIconTextGap(0);
        createButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        createButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_createJO2.png"))); // NOI18N
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

        printButton.setBackground(new java.awt.Color(255, 255, 255));
        printButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        printButton.setForeground(new java.awt.Color(255, 255, 255));
        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_print.png"))); // NOI18N
        printButton.setToolTipText("");
        printButton.setAlignmentY(0.0F);
        printButton.setBorder(null);
        printButton.setBorderPainted(false);
        printButton.setContentAreaFilled(false);
        printButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        printButton.setIconTextGap(0);
        printButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        printButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_print2.png"))); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        completeButton4.setBackground(new java.awt.Color(205, 0, 69));
        completeButton4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        completeButton4.setForeground(new java.awt.Color(255, 255, 255));
        completeButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_completeJO1.png"))); // NOI18N
        completeButton4.setBorder(null);
        completeButton4.setBorderPainted(false);
        completeButton4.setContentAreaFilled(false);
        completeButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        completeButton4.setIconTextGap(0);
        completeButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        completeButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_completeJO2.png"))); // NOI18N
        completeButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                completeButton4MouseEntered(evt);
            }
        });
        completeButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButton4ActionPerformed(evt);
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
                        .addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(deleteButton)
                        .addComponent(homeButton))
                    .addComponent(printButton)
                    .addComponent(completeButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        navbarPanelLayout.setVerticalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(completeButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createButton)
                .addGap(68, 68, 68)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
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
            this.displayAll();
        }
        else{
        	String[] columnNames = {"JO NUMBER", "DATE", "ITEM CODE", "TITLE", "STOCKS ON HAND", "ORDER", "REMAINING"};

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
            
            String joNumber = "";
            String date = "";
            String itemCode = "";
            String title = "";
            String stocksOnHand = "";
            String order = "";
            String status = "";
            String remaining = "";
            
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
                pst = con.prepareStatement("SELECT * FROM psicomims.job_order WHERE (jo_number LIKE '%" + searchField.getText() + "%' OR date LIKE '%" + searchField.getText() + "%' OR item_code LIKE '%" + searchField.getText() + "%' OR title LIKE '%" + searchField.getText() + "%' OR quantity LIKE '%" + searchField.getText() + "%') AND jo_status='INCOMPLETE' ORDER BY date ASC");
                ResultSet rs = pst.executeQuery();
                                
                int i = 0;
                while (rs.next()) {
                	joNumber = rs.getString("jo_number");
                	date = rs.getString("date");
                	itemCode = rs.getString("item_code");
                	title = rs.getString("title");
                	
                	pst2 = con.prepareStatement("SELECT * FROM psicomims.book WHERE item_code LIKE '" + itemCode +"'");
                    ResultSet rs2 = pst2.executeQuery();              
                    while (rs2.next()) {
                		if(itemCode.equals(rs2.getString("item_code")))
                		{
                			stocksOnHand = rs2.getString("quantity");
                			break;
                		}
                	 }
                	
                    order = rs.getString("quantity");
                	status = rs.getString("jo_status");
                	remaining = rs.getString("remaining_orders");
                	model.addRow(new Object[]{joNumber, date, itemCode, title, stocksOnHand, order, remaining});
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
            
            jobOrdersTable.setModel(model);
            jobOrdersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void createButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_createButtonMouseEntered

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
    	this.dispose();
    	DCAddJobOrderScreen a = new DCAddJobOrderScreen("");
    	
        if (prevPage.equals("")){
        	a = new DCAddJobOrderScreen("");
        }
        else if (prevPage.equals("ad")){
        	a = new DCAddJobOrderScreen("ad");
        }
        
        a.setVisible(true);
    }//GEN-LAST:event_createButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
    	if (jobOrdersTable.getSelectedRowCount() == 1 && jobOrdersTable.getSelectedColumn() == 0){
    		int row = jobOrdersTable.getSelectedRow();
    		String joNumber = jobOrdersTable.getValueAt(row, 0).toString();
    		String date = jobOrdersTable.getValueAt(row, 1).toString();
    		String itemCode = jobOrdersTable.getValueAt(row, 2).toString();
    		String title = jobOrdersTable.getValueAt(row, 3).toString();
    		String quantity = jobOrdersTable.getValueAt(row, 5).toString();
    		this.dispose();
	    	DCEditJobOrderScreen a = new DCEditJobOrderScreen(joNumber, date, itemCode, title, quantity, "");
	    	
	         if (prevPage.equals("")){
	         	a = new DCEditJobOrderScreen(joNumber, date, itemCode, title, quantity, "");
	         }
	         else if (prevPage.equals("ad")){
	         	a = new DCEditJobOrderScreen(joNumber, date, itemCode, title, quantity, "ad");
	         }
            
            a.setVisible(true);
    	} 
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    	if (jobOrdersTable.getSelectedRowCount() == 1 && jobOrdersTable.getSelectedColumn() == 0){
    		int row = jobOrdersTable.getSelectedRow();
    		String joNumber = jobOrdersTable.getValueAt(row, 0).toString();
    		this.dispose();
            DCDeleteJobOrderScreen a = new DCDeleteJobOrderScreen(joNumber, "");
            
	         if (prevPage.equals("")){
	         	a = new DCDeleteJobOrderScreen(joNumber, "");
	         }
	         else if (prevPage.equals("ad")){
	         	a = new DCDeleteJobOrderScreen(joNumber, "ad");
	         }
            
            a.setVisible(true);
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

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonActionPerformed

    private void completeButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_completeButton4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_completeButton4MouseEntered

    private void completeButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeButton4ActionPerformed
    	this.dispose();
        DCCompleteJobOrdersTab a = new DCCompleteJobOrdersTab("");
        
        if (prevPage.equals("")){
        	a = new DCCompleteJobOrdersTab("");
       	}
    	else if (prevPage.equals("ad")){
    		a = new DCCompleteJobOrdersTab("ad");
        	
    	}
        
    	a.setVisible(true);
    }//GEN-LAST:event_completeButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(DCIncompleteJobOrdersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCIncompleteJobOrdersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCIncompleteJobOrdersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCIncompleteJobOrdersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCIncompleteJobOrdersTab("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton completeButton;
    private javax.swing.JButton completeButton1;
    private javax.swing.JButton completeButton2;
    private javax.swing.JButton completeButton3;
    private javax.swing.JButton completeButton4;
    private javax.swing.JLabel copyrightLabel1;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jobOrdersTable;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel navbarPanel;
    private javax.swing.JButton printButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton signOutButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel titleLabel1;

    // End of variables declaration//GEN-END:variables
    
    public void displayAll(){
    	String[] columnNames = {"JO NUMBER", "DATE", "ITEM CODE", "TITLE", "STOCKS ON HAND", "ORDER", "REMAINING"};

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
        
        String joNumber = "";
        String date = "";
        String itemCode = "";
        String title = "";
        String stocksOnHand = "";
        String order = "";
        String status = "";
        String remaining ="";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
            pst = con.prepareStatement("SELECT * FROM psicomims.job_order WHERE jo_status='INCOMPLETE' ORDER BY date ASC");
            ResultSet rs = pst.executeQuery();
            
            int i = 0;
            while (rs.next()) {
            	joNumber = rs.getString("jo_number");
            	date = rs.getString("date");
            	itemCode = rs.getString("item_code");
            	title = rs.getString("title");
            	
            	pst2 = con.prepareStatement("SELECT * FROM psicomims.book WHERE item_code LIKE '" + itemCode +"'");
                ResultSet rs2 = pst2.executeQuery();              
                while (rs2.next()) {
            		if(itemCode.equals(rs2.getString("item_code")))
            		{
            			stocksOnHand = rs2.getString("quantity");
            			break;
            		}
            	 }     	
            	
            	order = rs.getString("quantity");
            	status = rs.getString("jo_status");
            	remaining = rs.getString("remaining_orders");
            	model.addRow(new Object[]{joNumber, date, itemCode, title, stocksOnHand, order, remaining});
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
        
        jobOrdersTable = new JTable(model);
        jobOrdersTable.setModel(model);
        jobOrdersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    private HashMap doCommand(String command, String title, String itemCode, String price, String author, String releaseDate ) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("title", title);
        map.put("itemCode", itemCode);
        map.put("price", price);
        map.put("author", author);
        map.put("releaseDate", releaseDate);

        
        // CONVERT JAVA DATA TO JSON
        ObjectMapper mapper = new ObjectMapper();
        String json1 = mapper.writeValueAsString(map);
        
        
        // SEND TO SERVICE
        String reply = NetUtil.postJsonDataToUrl(url1, json1);
        System.out.println("REPLY = "+reply);
        
        
        try
        {
            // CONVERT REPLY JSON STRING TO A JAVA OBJECT 
            HashMap replyMap = (HashMap) mapper.readValue(reply, HashMap.class);
            return replyMap;
        }
        catch(Exception e)
        {
            //System.out.println(reply);
            HashMap replyMap = new HashMap();
            replyMap.put("message", reply);
            return replyMap; 
        }
    }
    
    public static class printAction implements ActionListener, Printable{
    	public int print(Graphics gx, PageFormat pf, int page) throws PrinterException { 
   		 if (page>0){return NO_SUCH_PAGE;} 
   		     Graphics2D g = (Graphics2D)gx; 
   		     g.translate(pf.getImageableX(), pf.getImageableY()); 
   		     g.drawString ("Hello world", 100, 100); 
   		     return PAGE_EXISTS; 
   		     }
    	

   	@Override
   	public void actionPerformed(ActionEvent arg0) {
   		PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this); 
            if (job.printDialog() == true) { 
                try {job.print();} catch (PrinterException ex){ 		                   		
                }
            }
   		}

   }
}
