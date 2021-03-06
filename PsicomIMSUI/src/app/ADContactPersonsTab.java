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
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Frame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class ADContactPersonsTab extends javax.swing.JFrame {

    /**
     * Creates new form ADContactPersonsTab
     */
    public ADContactPersonsTab() {
    	setExtendedState(Frame.MAXIMIZED_BOTH);
        initComponents();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
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
        titleLabel = new javax.swing.JLabel();
        copyrightLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contactPersonsTable = new javax.swing.JTable();
        navbarPanel = new javax.swing.JPanel();
        addContactPersonButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();
        greetingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Contact Persons");
        setResizable(false);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/VS2.1.png"))); // NOI18N

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setAlignmentX(0.0F);
        tablePanel.setAlignmentY(0.0F);

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(32, 55, 73));
        titleLabel.setText("CONTACT PERSONS");

        copyrightLabel1.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        copyrightLabel1.setForeground(new java.awt.Color(32, 55, 73));
        copyrightLabel1.setText("� 2016 PSICOM Inventory Mgt. System Powered by VIPE Solutions. All Rights Reserved. ");

        contactPersonsTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        contactPersonsTable.setForeground(new java.awt.Color(255, 255, 255));
        
        this.displayAll();
        
        contactPersonsTable.setToolTipText("");
        contactPersonsTable.setCellSelectionEnabled(true);
        contactPersonsTable.setGridColor(new java.awt.Color(204, 204, 255));
        contactPersonsTable.setRequestFocusEnabled(false);
        contactPersonsTable.setRowHeight(18);
        contactPersonsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(contactPersonsTable);
        contactPersonsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanelLayout.setHorizontalGroup(
        	tablePanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(tablePanelLayout.createSequentialGroup()
        			.addGroup(tablePanelLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(tablePanelLayout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(tablePanelLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        						.addComponent(copyrightLabel1)))
        				.addGroup(tablePanelLayout.createSequentialGroup()
        					.addGap(299)
        					.addComponent(titleLabel)))
        			.addGap(26))
        );
        tablePanelLayout.setVerticalGroup(
        	tablePanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(tablePanelLayout.createSequentialGroup()
        			.addGap(22)
        			.addComponent(titleLabel)
        			.addGap(29)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(copyrightLabel1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addGap(7))
        );
        tablePanel.setLayout(tablePanelLayout);

        navbarPanel.setBackground(new java.awt.Color(227, 234, 245));
        navbarPanel.setAlignmentX(0.0F);

        addContactPersonButton.setBackground(new java.awt.Color(205, 0, 69));
        addContactPersonButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        addContactPersonButton.setForeground(new java.awt.Color(255, 255, 255));
        addContactPersonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_addContact.png"))); // NOI18N
        addContactPersonButton.setBorder(null);
        addContactPersonButton.setBorderPainted(false);
        addContactPersonButton.setContentAreaFilled(false);
        addContactPersonButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addContactPersonButton.setIconTextGap(0);
        addContactPersonButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addContactPersonButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_addContact2.png"))); // NOI18N
        addContactPersonButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addContactPersonButtonMouseEntered(evt);
            }
        });
        addContactPersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContactPersonButtonActionPerformed(evt);
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

        javax.swing.GroupLayout navbarPanelLayout = new javax.swing.GroupLayout(navbarPanel);
        navbarPanel.setLayout(navbarPanelLayout);
        navbarPanelLayout.setHorizontalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteButton)
                    .addComponent(homeButton)
                    .addComponent(addContactPersonButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        navbarPanelLayout.setVerticalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(addContactPersonButton)
                .addGap(156, 156, 156)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
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
        greetingLabel.setText("Hello, Administrator  | ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(tablePanel, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(navbarPanel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(logoLabel)
        			.addPreferredGap(ComponentPlacement.RELATED, 503, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(greetingLabel)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(signOutButton))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(searchField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
        			.addGap(20))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(logoLabel))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(25)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(signOutButton, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        						.addComponent(greetingLabel))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(searchButton))))
        			.addGap(28)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(navbarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(tablePanel, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addContactPersonButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContactPersonButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addContactPersonButtonMouseEntered

    private void addContactPersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContactPersonButtonActionPerformed
    	this.dispose();
    	ADAddContactPersonScreen a = new ADAddContactPersonScreen();
    	a.setVisible(true);
    }//GEN-LAST:event_addContactPersonButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
    	if (contactPersonsTable.getSelectedRowCount() == 1 && contactPersonsTable.getSelectedColumn() == 0){
	    	this.getFirstColumnData();
	    	this.dispose();
	    	ADEditContactPersonScreen a = new ADEditContactPersonScreen();
	    	a.setVisible(true);
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Please select item to edit.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    	if (contactPersonsTable.getSelectedRowCount() == 1 && contactPersonsTable.getSelectedColumn() == 0){
	    	this.getFirstColumnData();
	    	this.dispose();
	    	ADDeleteContactPersonScreen a = new ADDeleteContactPersonScreen();
	    	a.setVisible(true);
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Please select item to delete.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
    	this.dispose();
    	ADHomeScreen a = new ADHomeScreen();
    	a.setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
    	if (searchField.getText() == null || searchField.getText() == " "){
    		this.displayAll();
    	}
    	else{
        	String[] columnNames = { "CONTACT PERSONS","CONTACT PERSON ID", "DATE CREATED"};

        	DefaultTableModel model = new DefaultTableModel(){
            	public boolean isCellEditable(int row, int column)
            	 {
            	     return false;
            	 }
            };
            model.setColumnIdentifiers(columnNames);
            
            PreparedStatement pst;
            Connection con;
            
            String contactPersonId = "";
            String contactPersonName = "";
            String dateCreated = "";
            
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
                pst = con.prepareStatement("SELECT * FROM psicomims.contact_person WHERE contact_person_id LIKE '%" + searchField.getText() + "%' OR contact_person_name LIKE '%" + searchField.getText() + "%' OR date_created LIKE '%" + searchField.getText() + "%'");
                ResultSet rs = pst.executeQuery();
                int i = 0;
                while (rs.next()) {
                	contactPersonId = rs.getString("contact_person_id");
                	contactPersonName = rs.getString("contact_person_name");
                    dateCreated = rs.getString("date_created");
                    model.addRow(new Object[]{ contactPersonName,contactPersonId, dateCreated});
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
            
            contactPersonsTable.setModel(model);
            contactPersonsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
    	this.dispose();
    	ADLogInScreen a = new ADLogInScreen();
    	a.setVisible(true);
    }//GEN-LAST:event_signOutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ADContactPersonsTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADContactPersonsTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADContactPersonsTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADContactPersonsTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADContactPersonsTab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addContactPersonButton;
    private static javax.swing.JTable contactPersonsTable;
    private javax.swing.JLabel copyrightLabel1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel navbarPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton signOutButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    
    public static String getFirstColumnData(){ 
    	int selectedRowIndex = contactPersonsTable.getSelectedRow();
    	int selectedColumnIndex = contactPersonsTable.getSelectedColumn();
    	String selectedCell = (String) contactPersonsTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
    	return selectedCell;
    	
    }
    
    public static String getSecondColumnData(){ 
    	int selectedRowIndex = contactPersonsTable.getSelectedRow();
    	int selectedColumnIndex = contactPersonsTable.getSelectedColumn() + 1;
    	String selectedCell = (String) contactPersonsTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
    	return selectedCell;
    	
    }
    
    public static String getThirdColumnData(){ 
    	int selectedRowIndex = contactPersonsTable.getSelectedRow();
    	int selectedColumnIndex = contactPersonsTable.getSelectedColumn() + 2;
    	String selectedCell = (String) contactPersonsTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
    	return selectedCell;
    	
    }
    
    public void displayAll(){
    	String[] columnNames = { "CONTACT PERSONS", "CONTACT PERSON ID", "DATE CREATED"};

    	DefaultTableModel model = new DefaultTableModel(){
        	public boolean isCellEditable(int row, int column)
        	 {
        	     return false;
        	 }
        };
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
        Connection con;
        
        String contactPersonId = "";
        String contactPersonName = "";
        String dateCreated = "";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
            pst = con.prepareStatement("SELECT * FROM psicomims.contact_person");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
            	contactPersonId = rs.getString("contact_person_id");
            	contactPersonName = rs.getString("contact_person_name");
                dateCreated = rs.getString("date_created");
                model.addRow(new Object[]{ contactPersonName, contactPersonId, dateCreated});
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
        
        contactPersonsTable = new JTable(model);
        contactPersonsTable.setModel(model);
        contactPersonsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
}
