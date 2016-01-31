package app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Abby
 */
public class DCBooksTab extends javax.swing.JFrame {

    /**
     * Creates new form BookTabDC
     */
    public DCBooksTab() {
        
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
        greetingLabel = new javax.swing.JLabel();
        signOutButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();
        copyrightLabel = new javax.swing.JLabel();
        navbarPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Books");
        setResizable(false);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/VS2.1.png"))); // NOI18N

        greetingLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        greetingLabel.setForeground(new java.awt.Color(255, 255, 255));
        greetingLabel.setText("Hello, Documentation Clerk  | ");

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

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setAlignmentX(0.0F);
        tablePanel.setAlignmentY(0.0F);

        booksTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        booksTable.setForeground(new java.awt.Color(255, 255, 255));
        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ITEM CODE", "TITLE", "RELEASE DATE", "PRICE", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        this.displayAll();
        
        booksTable.setToolTipText("");
        booksTable.setCellSelectionEnabled(true);
        booksTable.setGridColor(new java.awt.Color(204, 204, 255));
        booksTable.setRequestFocusEnabled(false);
        booksTable.setRowHeight(18);
        booksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(booksTable);

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(32, 55, 73));
        titleLabel.setText("LIST OF BOOKS");

        copyrightLabel.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        copyrightLabel.setForeground(new java.awt.Color(32, 55, 73));
        copyrightLabel.setText("© 2016 PSICOM Inventory Mgt. System Powered by VIPE Solutions. All Rights Reserved. ");

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(titleLabel))
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(copyrightLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(copyrightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        navbarPanel.setBackground(new java.awt.Color(227, 234, 245));
        navbarPanel.setAlignmentX(0.0F);

        addButton.setBackground(new java.awt.Color(205, 0, 69));
        addButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_addBook.png"))); // NOI18N
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setIconTextGap(0);
        addButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_addBook2.png"))); // NOI18N
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButtonMouseEntered(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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

        javax.swing.GroupLayout navbarPanelLayout = new javax.swing.GroupLayout(navbarPanel);
        navbarPanel.setLayout(navbarPanelLayout);
        navbarPanelLayout.setHorizontalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteButton)
                    .addComponent(homeButton)
                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        navbarPanelLayout.setVerticalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(addButton)
                .addGap(109, 109, 109)
                .addComponent(viewButton)
                .addGap(18, 18, 18)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
        // TODO add your handling code here:
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
       	this.dispose();
    	DCAddBookScreen a = new DCAddBookScreen();
    	a.setVisible(true);
    }

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if (booksTable.getSelectedRowCount() == 1 && booksTable.getSelectedColumn() == 0){
	    	this.getData();
	    	this.dispose();
	    	DCViewBookScreen a = new DCViewBookScreen();
	    	a.setVisible(true);
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if (booksTable.getSelectedRowCount() == 1 && booksTable.getSelectedColumn() == 0){
    		int row = booksTable.getSelectedRow();
    		String title = booksTable.getValueAt(row, 0).toString();
    		String itemCode = booksTable.getValueAt(row, 1).toString();
    		String price = booksTable.getValueAt(row, 2).toString();
    		String author = booksTable.getValueAt(row, 3).toString();
    		String releaseDate = booksTable.getValueAt(row, 4).toString();
    		
	    	this.dispose();
	    	DCEditBookScreen a = new DCEditBookScreen(title, itemCode, price, author, releaseDate);
	    	a.setVisible(true); 
    		}

    	else{
    		JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if (booksTable.getSelectedRowCount() == 1 && booksTable.getSelectedColumn() == 0){
    		int row = booksTable.getSelectedRow();
    		String itemCode = booksTable.getValueAt(row, 1).toString();
    		
    		this.dispose();
    		DCDeleteBookScreen a = new DCDeleteBookScreen(itemCode);
	    	a.setVisible(true); 
    		}
    }

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_addButtonMouseEntered

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
            java.util.logging.Logger.getLogger(DCBooksTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCBooksTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCBooksTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCBooksTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCBooksTab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private static javax.swing.JTable booksTable;
    private javax.swing.JLabel copyrightLabel;
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
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
    
    public static String getData(){
    	int selectedRowIndex = booksTable.getSelectedRow();
    	int selectedColumnIndex = booksTable.getSelectedColumn();
    	String selectedCell = (String) booksTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
    	return selectedCell;
    }
    
    
    public void displayAll(){
    	String[] columnNames = {"TITLE", "ITEM CODE", "PRICE", "AUTHOR", "RELEASE DATE"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
        Connection con;
        
        String title = "";
        String itemCode = "";
        String price = "";
        String author = "";
        String releaseDate = "";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
            pst = con.prepareStatement("SELECT * FROM book");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                title = rs.getString("title");
                itemCode = rs.getString("item_code");
                price = rs.getString("price");
                author = rs.getString("author");
                releaseDate = rs.getString("release_date");
                model.addRow(new Object[]{title, itemCode, price, author, releaseDate});
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
        
        booksTable = new JTable(model);
        booksTable.setModel(model);
        booksTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

}

