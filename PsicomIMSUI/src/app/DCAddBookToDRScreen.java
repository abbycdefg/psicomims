package app;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import javax.swing.table.TableModel;

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
	private Integer totalAmtInt;
	private String quantityCount;
	private Integer quantityCountInt;
	private String dateDelivery;
	private JComboBox poNumberComboBox = new JComboBox();
	private String poNumber;
	private String []po;
	private List<String> poList = new ArrayList<String>();
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
    
    public DCAddBookToDRScreen(String drNumber1, String dateToday1, String totalAmt1, String dateDelivery1, String poNumber1) {
        initComponents();

        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        drNumber = drNumber1;
        dateToday = dateToday1;
        dateDelivery = dateDelivery1;
        getPoList();
        po = new String[poList.size()];
        poList.toArray(po);
        AutoCompleteSupport.install(poNumberComboBox, GlazedLists.eventListOf(po));
        totalAmt = totalAmt1;

        if(!totalAmt.equals("")){
        totalAmtInt = Integer.parseInt(totalAmt);
        }
        else {
        totalAmtInt = 0;
        }      
        poNumber = poNumber1;
        if(!poNumber.equals(""))
        {
        	displayAll(poNumber);
        }
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
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        poNumberPanel = new javax.swing.JPanel();
        poNumberLabel = new javax.swing.JLabel();
        booksTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Book to Delivery Receipt");
        setResizable(false);

        addBookToDRLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addBookToDRLabel.setForeground(new java.awt.Color(255, 255, 255));
        addBookToDRLabel.setText("ADD BOOK TO DELIVERY RECEIPT");
        
        
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
        poSearchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		poNumber = poNumberComboBox.getSelectedItem().toString();
        		displayAll(poNumber);
        		
        	}
        });
    
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	
        try{
            totalAmt = "";
            totalAmtInt = 0;
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
    	    	if(booksTable.getModel().getValueAt(i,4) != null)
    	    	{
    	    		Integer amountSelected = Integer.parseInt(booksTable.getModel().getValueAt(i,4).toString());
    	    		totalAmtInt += amountSelected;
    	    	}
        	}
        	
        	totalAmt = totalAmtInt.toString();
        	
        }
        catch (Exception e){
            e.printStackTrace();
        }
    	this.dispose();
    	DCAddDeliveryReceiptScreen a = new DCAddDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList, poNumber);
    	a.setVisible(true);
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	this.dispose();
    	DCAddDeliveryReceiptScreen a = new DCAddDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList, "");
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
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel poNumberLabel;
    private javax.swing.JPanel poNumberPanel;
    private JTable booksTable;

    //END
    public void displayAll(String poNumber){
    	String[] columnNames = {"TITLE", "ITEM CODE", "QUANTITY", "DISCOUNTED PRICE", "SRP"};

        DefaultTableModel model = new DefaultTableModel(){
        	@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
        PreparedStatement pst2;
        Connection con;
        
        String title = "";
        String itemCode = "";
        String discountedPrice = "";
        String srp = "";
        String quantity = "";
        List<String> listBooks = new ArrayList<String>();
        List<String> quantityList = new ArrayList<String>();
        int row = booksTable.getRowCount();
        int column = booksTable.getColumnCount();
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
            pst = (PreparedStatement) con.prepareStatement("SELECT * FROM specific_po");
            ResultSet rs = pst.executeQuery();
            int i = 0;

            while (rs.next()) {
            	if(poNumber.equals(rs.getString("po_id")))
            	{
            		System.out.println("adding inside");
            		listBooks.add(rs.getString("book_id"));
            		quantityList.add(rs.getString("quantity"));
            	}
                //model.addRow(new Object[]{title, itemCode, price, author, releaseDate});
                i++;               
            }
            
            pst2 = (PreparedStatement) con.prepareStatement("SELECT * FROM book");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                for(int k = 0; k < listBooks.size(); k++)
                {
                	
                	if(listBooks.get(k).equals(rs2.getString("item_code")))
                	{
                		System.out.println(listBooks);
                		title = rs2.getString("title");
                        itemCode = rs2.getString("item_code");
                        srp = rs2.getString("price");
                        quantity = quantityList.get(k);
                        System.out.println(quantity);
                        model.addRow(new Object[]{title, itemCode, quantity, "", srp}); 
                        break;
                	}
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
        
        booksTable = new JTable(model);
        booksTable.setModel(model);
        booksTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        booksTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        booksTable.setForeground(Color.BLACK);       
        booksTable.setToolTipText("");
        booksTable.setRowHeight(18);
        booksTable.setRequestFocusEnabled(false);
        booksTable.setGridColor(new Color(204, 204, 255));
        booksTable.setCellSelectionEnabled(true);
        booksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setColumnHeaderView(booksTable);
       
    }
    public void getPoList()
    {
			PreparedStatement pst;
			Connection con;
			
			try {

				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
				pst = (PreparedStatement) con.prepareStatement("SELECT * FROM specific_po");
				ResultSet rs = pst.executeQuery();
				int i = 0;
			    Set<String> poSetList = new HashSet();
				while (rs.next()) {
					if(!rs.getString("po_id").equals(null))
					{
						poSetList.add(rs.getString("po_id"));
					}
					i++;
				}
				poList.addAll(poSetList);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
    }
}
