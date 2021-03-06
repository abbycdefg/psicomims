package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import ca.odell.glazedlists.impl.filter.SearchTerm;
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
public class WCUpdateStocksTab extends javax.swing.JFrame {

    /**
     * Creates new form WCUpdateStocksTab
     */
    public WCUpdateStocksTab() {
    	setExtendedState(Frame.MAXIMIZED_BOTH);
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
             
             this.addWindowListener( new WindowAdapter() {
                 public void windowOpened( WindowEvent e ){
                     searchField.requestFocus();
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
        stocksTable = new javax.swing.JTable();
        navbarPanel = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        greetingLabel = new javax.swing.JLabel();
        signOutButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Stocks");
        setResizable(false);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/VS2.1.png"))); // NOI18N

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setAlignmentX(0.0F);
        tablePanel.setAlignmentY(0.0F);

        titleLabel.setFont(new Font("Calibri", Font.PLAIN, 22)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(32, 55, 73));
        titleLabel.setText("UPDATE STOCKS");

        copyrightLabel1.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        copyrightLabel1.setForeground(new java.awt.Color(32, 55, 73));
        copyrightLabel1.setText("� 2016 PSICOM Inventory Mgt. System Powered by VIPE Solutions. All Rights Reserved. ");

        stocksTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        stocksTable.setForeground(new java.awt.Color(255, 255, 255));
        
        this.displayAll();
        
        stocksTable.setToolTipText("");
        stocksTable.setCellSelectionEnabled(true);
        stocksTable.setGridColor(new java.awt.Color(204, 204, 255));
        stocksTable.setRequestFocusEnabled(false);
        stocksTable.setRowHeight(18);
        stocksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(stocksTable);
        stocksTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanelLayout.setHorizontalGroup(
        	tablePanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(tablePanelLayout.createSequentialGroup()
        			.addContainerGap(318, Short.MAX_VALUE)
        			.addComponent(titleLabel)
        			.addGap(316))
        		.addGroup(Alignment.LEADING, tablePanelLayout.createSequentialGroup()
        			.addGap(18)
        			.addGroup(tablePanelLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE)
        				.addComponent(copyrightLabel1))
        			.addContainerGap(26, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
        	tablePanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(tablePanelLayout.createSequentialGroup()
        			.addGap(19)
        			.addComponent(titleLabel)
        			.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(copyrightLabel1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addGap(7))
        );
        tablePanel.setLayout(tablePanelLayout);

        navbarPanel.setBackground(new java.awt.Color(227, 234, 245));
        navbarPanel.setAlignmentX(0.0F);

        updateButton.setBackground(new java.awt.Color(205, 0, 69));
        updateButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_update.png"))); // NOI18N
        updateButton.setBorder(null);
        updateButton.setBorderPainted(false);
        updateButton.setContentAreaFilled(false);
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButton.setIconTextGap(0);
        updateButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        updateButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_update2.png"))); // NOI18N
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateButtonMouseEntered(evt);
            }
        });
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
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
                    .addComponent(homeButton)
                    .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        navbarPanelLayout.setVerticalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        greetingLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        greetingLabel.setForeground(new java.awt.Color(255, 255, 255));
        greetingLabel.setText("Hello, Warehouse Clerk  | ");

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
        
        searchField.getDocument().addDocumentListener(new DocumentListener() {
        	  public void changedUpdate(DocumentEvent e) {
        		  if (searchField.getText().length() >= 9)
                  {
                  	System.out.println("searching");
                  	search();
                  }
                  else {
                  	System.out.println("no");
                  }
        	  }

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	  
        	});

        
        searchField.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if(e.getKeyCode() == KeyEvent.VK_ENTER )
    			{
    				if (stocksTable.getRowCount() != 0)
    		        {
    				search();
    				stocksTable.changeSelection(0, 0, false, false);
    		        open();    		 
    		        }
    			}
    		}
    	});
        

        stocksTable.changeSelection(0, 0, false, false);
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
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 786, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(navbarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(logoLabel)
        			.addPreferredGap(ComponentPlacement.RELATED, 521, Short.MAX_VALUE)
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
        						.addComponent(signOutButton)
        						.addComponent(greetingLabel))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(searchButton))))
        			.addGap(57)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(navbarPanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        				.addComponent(tablePanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)))
        );
        getContentPane().setLayout(layout);
        pack();

    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonMouseEntered

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
    	if (stocksTable.getSelectedRowCount() == 1 && stocksTable.getSelectedColumn() == 0){
    		this.dispose();
    		WCUpdateStockLevelScreen a = new WCUpdateStockLevelScreen();
	        a.setVisible(true);
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
    	}   	

    }//GEN-LAST:event_updateButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
    	this.dispose();
        WCHomeScreen a = new WCHomeScreen();
        a.setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
    	this.dispose();
        WCLogInScreen a = new WCLogInScreen();
        a.setVisible(true);
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (searchField.getText() == null || searchField.getText() == " "){
            this.displayAll();
        }
        else
        {
        	
        		search();
	        }
    }
	        

	     

    //GEN-LAST:event_searchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(WCUpdateStocksTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WCUpdateStocksTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WCUpdateStocksTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WCUpdateStocksTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WCUpdateStocksTab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel copyrightLabel1;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel navbarPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton signOutButton;
    private static javax.swing.JTable stocksTable;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private static int selectedRowIndex;
	private static int selectedColumnIndex;
	
    public static String getFirstColumnData(){ 
    	selectedRowIndex = stocksTable.getSelectedRow();
    	selectedColumnIndex = stocksTable.getSelectedColumn();
    	String selectedCell = (String) stocksTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
    	return selectedCell;   	
    }
    
    public static String getSecondColumnData(){ 
    	String selectedCell = (String) stocksTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex + 1);
    	return selectedCell;
    }
    
    public static String getThirdColumnData(){ 
    	String selectedCell = (String) stocksTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex + 2);
    	return selectedCell;
    }

    public void search(){
    	String[] columnNames = {"ITEM CODE", "TITLE", "QUANTITY", "DATE MODIFIED"};
    	
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
        String itemCode = "";
        String title = "";
        String quantity = "";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
            pst = con.prepareStatement("SELECT * FROM psicomims.book WHERE item_code LIKE '%" + searchField.getText() + "%' OR title LIKE '%"  + searchField.getText() + "%' OR quantity LIKE '%"  + searchField.getText() + "%' OR release_date LIKE '%"  + searchField.getText() + "%'");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                itemCode = rs.getString("item_code");
                title = rs.getString("title");
                quantity = rs.getString("quantity");
                date = rs.getString("release_date");
                model.addRow(new Object[]{itemCode, title, quantity, date});
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
        

        stocksTable.setModel(model);
        stocksTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    
    }
    
    public void displayAll(){
    	String[] columnNames = {"ITEM CODE", "TITLE", "QUANTITY"};

    	DefaultTableModel model = new DefaultTableModel(){
        	public boolean isCellEditable(int row, int column)
        	 {
        	     return false;
        	 }
        };
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
        Connection con;
        
        String itemCode = "";
        String title = "";
        String quantity = "";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
            pst = con.prepareStatement("SELECT * FROM psicomims.book");
            ResultSet rs = pst.executeQuery();
            
            int i = 0;
            while (rs.next()) {
                itemCode = rs.getString("item_code");
                title = rs.getString("title");
                quantity = rs.getString("quantity");
                model.addRow(new Object[]{itemCode, title, quantity});
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
        
        stocksTable = new JTable(model);
        stocksTable.setModel(model);
        stocksTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    private void open()
    {
    	this.dispose();
		WCUpdateStockLevelScreen a = new WCUpdateStockLevelScreen();
        a.setVisible(true);
    }
}
