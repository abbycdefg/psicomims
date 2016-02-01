package app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.databind.ObjectMapper;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class ADUsersTab extends javax.swing.JFrame {

    /**
     * Creates new form ADUSersTab
     */
    public ADUsersTab() {
        initComponents();
        
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
    private void initComponents() {

        logoLabel = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        titleLabel1 = new javax.swing.JLabel();
        copyrightLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        navbarPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        updatePasswordButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        greetingLabel = new javax.swing.JLabel();
        signOutButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Users");
        setResizable(false);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/VS2.1.png"))); // NOI18N

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setAlignmentX(0.0F);
        tablePanel.setAlignmentY(0.0F);

        titleLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        titleLabel1.setForeground(new java.awt.Color(32, 55, 73));
        titleLabel1.setText("USERS");

        copyrightLabel1.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        copyrightLabel1.setForeground(new java.awt.Color(32, 55, 73));
        copyrightLabel1.setText("� 2016 PSICOM Inventory Mgt. System Powered by VIPE Solutions. All Rights Reserved. ");

        usersTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        usersTable.setForeground(new java.awt.Color(255, 255, 255));
        
        this.displayAll();
        
        usersTable.setToolTipText("");
        usersTable.setCellSelectionEnabled(true);
        usersTable.setGridColor(new java.awt.Color(204, 204, 255));
        usersTable.setRequestFocusEnabled(false);
        usersTable.setRowHeight(18);
        usersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(usersTable);
        usersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        

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
                        .addGap(333, 333, 333)
                        .addComponent(titleLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
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
        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_createUser.png"))); // NOI18N
        createButton.setBorder(null);
        createButton.setBorderPainted(false);
        createButton.setContentAreaFilled(false);
        createButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createButton.setIconTextGap(0);
        createButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        createButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_createUser2.png"))); // NOI18N
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

        updatePasswordButton.setBackground(new java.awt.Color(255, 255, 255));
        updatePasswordButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        updatePasswordButton.setForeground(new java.awt.Color(255, 255, 255));
        updatePasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_updatePassword.png"))); // NOI18N
        updatePasswordButton.setAlignmentY(0.0F);
        updatePasswordButton.setBorder(null);
        updatePasswordButton.setBorderPainted(false);
        updatePasswordButton.setContentAreaFilled(false);
        updatePasswordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatePasswordButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_updatePassword2.png"))); // NOI18N
        updatePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePasswordButtonActionPerformed(evt);
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

        javax.swing.GroupLayout navbarPanelLayout = new javax.swing.GroupLayout(navbarPanel);
        navbarPanel.setLayout(navbarPanelLayout);
        navbarPanelLayout.setHorizontalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(homeButton)
                        .addComponent(createButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updatePasswordButton))
                .addContainerGap())
        );
        navbarPanelLayout.setVerticalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(createButton)
                .addGap(18, 18, 18)
                .addComponent(updatePasswordButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        greetingLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        greetingLabel.setForeground(new java.awt.Color(255, 255, 255));
        greetingLabel.setText("Hello, Administrator | ");

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


    private void createButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_createButtonMouseEntered

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
    	this.dispose();
    	ADAddUserScreen a = new ADAddUserScreen();
    	a.setVisible(true);
    }

    private void updatePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePasswordButtonActionPerformed
    	if (usersTable.getSelectedRowCount() == 1 && usersTable.getSelectedColumn() == 0){
	    	this.getData();
	    	this.dispose();
	    	ADUpdatePasswordScreen a = new ADUpdatePasswordScreen();
	    	a.setVisible(true);
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
    	this.dispose();
    	ADHomeScreen a = new ADHomeScreen();
    	a.setVisible(true);
    }

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
    	this.dispose();
    	ADLogInScreen a = new ADLogInScreen();
    	a.setVisible(true);
    }

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
    	if (searchField.getText() == null || searchField.getText() == " "){
    		this.displayAll();
    	}
    	else{
	    	String[] columnNames = {"USERNAME", "PASSWORD", "DATE CREATED"};
	
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columnNames);
	        
	    	PreparedStatement pst;
	        Connection con;
	        
	        String username = "";
	        String password = "";
	        String dateCreated = "";
	        
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
	            pst = con.prepareStatement("SELECT * FROM psicomims.user WHERE username LIKE '%" + searchField.getText() + "%' OR password LIKE '%" + searchField.getText() + "%'");
	            ResultSet rs = pst.executeQuery();
	            int i = 0;
	            while (rs.next()) {
	                username = rs.getString("username");
	                password = rs.getString("password");
	                model.addRow(new Object[]{username, password, dateCreated});
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
	        
	        usersTable.setModel(model);
	        usersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	}
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
            java.util.logging.Logger.getLogger(ADUsersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADUsersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADUsersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADUsersTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADUsersTab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel copyrightLabel1;
    private javax.swing.JButton createButton;
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
    private javax.swing.JButton updatePasswordButton;
    private static javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables

    
    public static String getData(){
    	int selectedRowIndex = usersTable.getSelectedRow();
    	int selectedColumnIndex = usersTable.getSelectedColumn();
    	String selectedCell = (String) usersTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
    	return selectedCell;
    }
    
    public void displayAll(){
    	String[] columnNames = {"USERNAME", "PASSWORD", "DATE CREATED"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
        Connection con;
        
        String username = "";
        String password = "";
        String dateCreated = "";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
            pst = con.prepareStatement("SELECT * FROM psicomims.user");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                username = rs.getString("username");
                password = rs.getString("password");
                model.addRow(new Object[]{username, password, dateCreated});
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
        
        usersTable = new JTable(model);
        usersTable.setModel(model);
        usersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
}
