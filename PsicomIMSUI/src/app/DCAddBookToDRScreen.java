package app;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Cursor;
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class DCAddBookToDRScreen extends javax.swing.JFrame {

    /**
     * Creates new form DCAddBookToDRScreen
     */
	private String drNumber;
	private String dateToday;
	private String totalAmt;
	private String dateDelivery;
	private JComboBox poNumberComboBox = new JComboBox();
	private String poNumber;
	private String []po;
	private static List<String> booksList = new ArrayList<String>();
	private static List<String> quantityList = new ArrayList<String>();
	
    public DCAddBookToDRScreen() {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
    }
    
    public DCAddBookToDRScreen(String drNumber1, String dateToday1, String totalAmt1, String dateDelivery1, List<String> poList1) {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        drNumber = drNumber1;
        dateToday = dateToday1;
        totalAmt = totalAmt1;
        dateDelivery = dateDelivery1;
        po = new String[poList1.size()];
        poList1.toArray(po);
        AutoCompleteSupport.install(poNumberComboBox, GlazedLists.eventListOf(po));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addBookToDRLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        poNumberPanel = new javax.swing.JPanel();
        poNumberLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Book to Delivery Receipt");
        setResizable(false);

        addBookToDRLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addBookToDRLabel.setForeground(new java.awt.Color(255, 255, 255));
        addBookToDRLabel.setText("ADD BOOK TO DELIVERY RECEIPT");

        booksTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        booksTable.setForeground(new java.awt.Color(51, 51, 51));
        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "TITLE", "ITEM CODE", "QUANTITY", "DISCOUNTED PRICE", "SRP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        
        poNumberComboBox.setUI(new BasicComboBoxUI() { // make the down arrow invisible
            protected JButton createArrowButton() {
                return new JButton() {
                    public int getWidth() {
                        return 0;
                    }

                    @Override
                    public synchronized void addMouseListener(MouseListener l) {
                    }
                };
            }
        });

        booksTable.setToolTipText("");
        booksTable.setCellSelectionEnabled(true);
        booksTable.setGridColor(new java.awt.Color(204, 204, 255));
        booksTable.setRequestFocusEnabled(false);
        booksTable.setRowHeight(18);
        booksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(booksTable);
        booksTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        addButton.setBackground(new java.awt.Color(205, 0, 69));
        addButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Book to DR");
        addButton.setBorder(null);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(102, 102, 102));
        cancelButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(null);
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        poNumberPanel.setBackground(new java.awt.Color(58, 80, 98));

        poNumberLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        poNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        poNumberLabel.setText("PO Number:");
        poNumberComboBox.setFont(new Font("Calibri", Font.PLAIN, 12));
        
        poNumberComboBox.setUI(new BasicComboBoxUI() { // make the down arrow invisible
            protected JButton createArrowButton() {
                return new JButton() {
                    public int getWidth() {
                        return 0;
                    }

                    @Override
                    public synchronized void addMouseListener(MouseListener l) {
                    }
                };
            }
        });
        
        JButton poSearchButton = new JButton("");
        poSearchButton.setSelectedIcon(new ImageIcon(DCAddBookToDRScreen.class.getResource("/images/button_search2.png")));
        poSearchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        poSearchButton.setContentAreaFilled(false);
        poSearchButton.setBorder(null);
        poSearchButton.setBorderPainted(false);
        
                poSearchButton.setIcon(new ImageIcon(DCAddBookToDRScreen.class.getResource("/images/button_search.png")));
                // </editor-fold>//GEN-END:initComponents
                
                poSearchButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		poNumber = poNumberComboBox.getSelectedItem().toString();
                	}
                });

        javax.swing.GroupLayout poNumberPanelLayout = new javax.swing.GroupLayout(poNumberPanel);
        poNumberPanelLayout.setHorizontalGroup(
        	poNumberPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(poNumberPanelLayout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(poNumberLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(poNumberComboBox, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(poSearchButton)
        			.addContainerGap(14, Short.MAX_VALUE))
        );
        poNumberPanelLayout.setVerticalGroup(
        	poNumberPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(poNumberPanelLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(poNumberPanelLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(poNumberLabel)
        				.addComponent(poNumberComboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        				.addComponent(poSearchButton))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        poNumberPanel.setLayout(poNumberPanelLayout);
        
      
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(197)
        					.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(261)
        					.addComponent(addBookToDRLabel))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(36)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(poNumberPanel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 675, GroupLayout.PREFERRED_SIZE))))
        			.addGap(36))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(addBookToDRLabel)
        			.addGap(12)
        			.addComponent(poNumberPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(40))
        );
        getContentPane().setLayout(layout);

        pack();
    
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	
        try{
        	booksList = new ArrayList<String>();
        	quantityList = new ArrayList<String>();
        	int rowCount = booksTable.getRowCount();
        	for(int i=0; i<rowCount; i++) {	  
        	    String cellValueBook = (String) booksTable.getValueAt(i,1);
        	    
        	    if(cellValueBook != null)
    	    	{
        	    	booksList.add(cellValueBook); ;
    	    	}
    	    	if (booksTable.getModel().getValueAt(i,2) != null)
    	    	{
    	    		System.out.println("pasok");
    	    		String quantitySelected = (String) booksTable.getModel().getValueAt(i, 2).toString();
    	    		quantityList.add(quantitySelected);
    	    		
    	    	}
        	}
        	
        }
        catch (Exception e){
            e.printStackTrace();
        }
    	this.dispose();
    	DCAddDeliveryReceiptScreen a = new DCAddDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList);
    	a.setVisible(true);
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	this.dispose();
    	DCAddDeliveryReceiptScreen a = new DCAddDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList);
    	a.setVisible(true);
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
            java.util.logging.Logger.getLogger(DCAddBookToDRScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCAddBookToDRScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCAddBookToDRScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCAddBookToDRScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCAddBookToDRScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBookToDRLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JTable booksTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel poNumberLabel;
    private javax.swing.JPanel poNumberPanel;

    //END
    public void displayAll(){
    	String[] columnNames = {"TITLE", "ITEM CODE", "QUANTITY", "DISCOUNTED PRICE", "SRP"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
        Connection con;
        
        String title = "";
        String itemCode = "";
        String price = "";
        String author = "";
        String releaseDate = "";
        List<String> bookList = new ArrayList<String>();
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
            pst = (PreparedStatement) con.prepareStatement("SELECT * FROM specific_po");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                if(rs.getString("po_id") == poNumber)
                {
                	bookList.add(rs.getString("book_id"));
                }
                i++;
            }
            
            pst = (PreparedStatement) con.prepareStatement("SELECT * FROM book");
            ResultSet rs1 = pst.executeQuery();
            
            int j = 0;
            while (rs.next()) {
            	for(int k = 0; k <= bookList.size(); k++ )
            	{
            		if(rs1.getString("item_code") == bookList.get(k))
            		{
            			itemCode = rs1.getString("item_code");
            			title = rs1.getString("title");
            			price = rs1.getString("price");
            		}
            	}
            	model.addRow(new Object[]{title, itemCode, price});
                j++;
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
