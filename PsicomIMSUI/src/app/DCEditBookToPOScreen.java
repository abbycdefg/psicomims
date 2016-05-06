package app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.event.KeyAdapter;

import javax.swing.JLabel;
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
public class DCEditBookToPOScreen extends javax.swing.JFrame {

	String prevPage;
	private static String purchaseOrderNumber;
	private static String contactPerson;
	private static String outlet;
	private static String dateToday;
	private static List<String> booksList = new ArrayList<String>();
	private static List<String> quantityList = new ArrayList<String>();
	private String []co;
	private String []ti;
	private List<String> bookAutoList  = new ArrayList<String>();
	private List<String> titleAutoList  = new ArrayList<String>();
	private  JComboBox comboBox = new JComboBox();
	private  JComboBox comboBox1 = new JComboBox();
	private String title;
	private String stocksOnHand;
	private String itemCode;
	
	
    public DCEditBookToPOScreen(String page) {
        initComponents();
        
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
    }
    /**
     * @wbp.parser.constructor
     */
    public DCEditBookToPOScreen(String purchaseOrderNumber1, String dateToday1, String contactPerson1, String outlet1, List<String> booksList1, List<String> quantityList1, String page) {

        initComponents();
        
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        purchaseOrderNumber = purchaseOrderNumber1;
        contactPerson = contactPerson1;
        outlet = outlet1;
        dateToday = dateToday1;
        booksList = booksList1;
        quantityList = quantityList1;
        System.out.println(booksList +"booksList");
        System.out.println(quantityList + "quantityList");       
        if(booksList != null && quantityList !=null)
        {
        	System.out.println("pasok dito");  
        	displayTable2(booksList, quantityList);
        }
        
        getItemCodeList();
        getTitleList();
        co = new String[bookAutoList.size()];
        ti = new String[titleAutoList.size()];
        bookAutoList.toArray(co);
        titleAutoList.toArray(ti);
        AutoCompleteSupport.install(comboBox, GlazedLists.eventListOf(co));
        AutoCompleteSupport.install(comboBox1, GlazedLists.eventListOf(ti));
        TableColumn itemCodeColumn = booksTable.getColumnModel().getColumn(0);

        itemCodeColumn.setCellEditor(new DefaultCellEditor(comboBox));
        
        comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

					System.out.println(comboBox.getSelectedIndex());
				
				String s = (String) comboBox.getSelectedItem();
				int row = booksTable.getSelectedRow();
				if(s != null)
				{
					getItemCode(s);
					System.out.println(title);
					booksTable.remove(row);
			       booksTable.setValueAt(title, row, 1);
			       booksTable.setValueAt(stocksOnHand, row, 2);
				}
			}
		});

        
        TableColumn titleColumn = booksTable.getColumnModel().getColumn(1);

        titleColumn.setCellEditor(new DefaultCellEditor(comboBox1));
        
        comboBox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = (String) comboBox1.getSelectedItem();
				int row = booksTable.getSelectedRow();
				if(s != null && comboBox1.getSelectedIndex() != -1)
				{
					getTitle(s);
			       booksTable.setValueAt(itemCode, row, 0);
			       booksTable.setValueAt(stocksOnHand, row, 2);
				}
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

        editBookToPOLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Book to Purchase Order");
        setResizable(false);

        editBookToPOLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        editBookToPOLabel.setForeground(new java.awt.Color(255, 255, 255));
        editBookToPOLabel.setText("EDIT BOOK TO PURCHASE ORDER");

        booksTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        booksTable.setForeground(new java.awt.Color(51, 51, 51));
        booksTable.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"ITEM CODE", "TITLE", "STOCKS ON HAND", "ORDER"
        	}
        ));
        

        booksTable.setToolTipText("");
        booksTable.setCellSelectionEnabled(true);
        booksTable.setGridColor(new java.awt.Color(204, 204, 255));
        booksTable.setRequestFocusEnabled(false);
        booksTable.setRowHeight(18);
        booksTable.getTableHeader().setReorderingAllowed(false);
        
       
        
        
        jScrollPane1.setViewportView(booksTable);
        editButton.setBackground(new java.awt.Color(205, 0, 69));
        editButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Book to PO");
        editButton.setBorder(null);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(editBookToPOLabel)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(editBookToPOLabel)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	boolean go = true;
    	try{
        	booksList = new ArrayList<String>();
        	quantityList = new ArrayList<String>();
        	
        	int rowCount = booksTable.getRowCount();
        	for(int i=0; i<rowCount; i++) {
        	    	String selectedBook = (String) booksTable.getModel().getValueAt(i, 0);
        	    	if(!selectedBook.equals(""))
        	    	{
        	    	booksList.add(selectedBook);
        	    	if (!booksTable.getModel().getValueAt(i,3).equals(""))
        	    	{
        	    		String quantitySelected = (String) booksTable.getModel().getValueAt(i, 3).toString();
        	    		quantityList.add(quantitySelected); 
        	    	}
        	    	else {
        	    		go = false;
        	           	 JOptionPane.showMessageDialog(null, "Please enter quantity value.", "Error", JOptionPane.ERROR_MESSAGE);
        	    	}
        	    	
        	    	}  
        	    	
        	    	
        	    	else {
        	    		break;
        	    	}
   	    
        	}

        	
        }
        catch (Exception e){
            e.printStackTrace();
        };
        
        if(go == true)
        {
	        this.dispose();
	        DCEditPurchaseOrderScreen a = new DCEditPurchaseOrderScreen(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList, "" );
	    	
	        if (prevPage.equals("")){
	        	a = new DCEditPurchaseOrderScreen(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList, "");
	        }
	        else if (prevPage.equals("ad")){
	        	a = new DCEditPurchaseOrderScreen(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList, "ad");
	        }
	        
	        a.setVisible(true);
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    	this.dispose();
     	DCEditPurchaseOrderScreen a = new DCEditPurchaseOrderScreen(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList, "");
     	
        if (prevPage.equals("")){
        	a = new DCEditPurchaseOrderScreen(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList, "");
        }
        else if (prevPage.equals("ad")){
        	a = new DCEditPurchaseOrderScreen(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList, "ad");
        }
        
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
            java.util.logging.Logger.getLogger(DCEditBookToPOScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCEditBookToPOScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCEditBookToPOScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCEditBookToPOScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCEditBookToPOScreen("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable booksTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel editBookToPOLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    public static boolean checkNumber(String stringNumber)  
    {  
      try  
      {  
        double d = Double.parseDouble(stringNumber);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }

    public void getItemCodeList()
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM book");
    			ResultSet rs = pst.executeQuery();
    		    Set<String> itemCodeSet = new HashSet();
    		    int i = 0;
    			while (rs.next()) {
    				if(!rs.getString("item_code").equals(null))
    				{
    					itemCodeSet.add(rs.getString("item_code"));
    				}
    				i++;
    			}
    			bookAutoList.addAll(itemCodeSet);
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    	
    }   
    public void getItemCode(String itemCode1)
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM book");
    			ResultSet rs = pst.executeQuery();
    			while (rs.next()) {
    				if(rs.getString("item_code").equals(itemCode1))
    				{ 
    					title = rs.getString("title");
    					stocksOnHand = rs.getString("quantity");
    					System.out.println("got it");
    					break;
    				}
    			}
    			
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}		
    }
    
    private void addRow()
    {
        DefaultTableModel model = (DefaultTableModel)booksTable.getModel();

       if (model != null) {
       Vector v = new Vector(1);
       for (int j = 0; j < booksTable.getColumnCount(); j++){
                v.add("");
            }
            model.addRow(v);
            }

    }
    public void getTitleList()
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM book");
    			ResultSet rs = pst.executeQuery();
    		    Set<String> titleSet = new HashSet();
    		    int i = 0;
    			while (rs.next()) {
    				if(!rs.getString("title").equals(null))
    				{
    					titleSet.add(rs.getString("title"));
    				}
    				i++;
    			}
    			titleAutoList.addAll(titleSet);
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    	
    }   
    public void getTitle(String title1)
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM book");
    			ResultSet rs = pst.executeQuery();
    			while (rs.next()) {
    				if(rs.getString("title").equals(title1))
    				{ 
    					itemCode = rs.getString("item_code");
    					stocksOnHand = rs.getString("quantity");
    					break;
    				}
    			}
    			
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}		
    }
   
    public void displayTable2(List<String> booksList, List<String> quantityList){
    	String[] columnNames = { "ITEM CODE", "TITLE", "STOCKS ON HAND", "ORDER"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        PreparedStatement pst;
		PreparedStatement pst2;
        Connection con;
        
        String itemCode1 = "";
        String quantity1 = "";
        String title1 = "";
        String stocksOnHand1 = "";
        try {
        Class.forName("com.mysql.jdbc.Driver");
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");

   
            int i = 0;
            for(int j = 0; j<booksList.size(); j++)
            {
                itemCode = booksList.get(j).toString();
                pst = con.prepareStatement("SELECT * FROM psicomims.book WHERE item_code='" +booksList.get(j)+"'");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
            			title1 = rs.getString("title");
            			itemCode1 = rs.getString("item_code");
            			stocksOnHand1 = rs.getString("quantity");      			
            	}
                pst2 = con.prepareStatement("SELECT * FROM psicomims.specific_po WHERE book_id='" +booksList.get(j)+"' AND po_id='" + purchaseOrderNumber+"'");
                ResultSet rs2 = pst2.executeQuery();
                while (rs2.next()) {
            			quantity1 = rs2.getString("quantity");
            	}
                model.addRow(new Object[]{itemCode1, title1, stocksOnHand1, quantity1});    
                i++;
            }
            
            if (i < 1) {
            	booksTable = new javax.swing.JTable();
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
        booksTable.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if(e.getKeyCode() == KeyEvent.VK_ENTER )
    			{
    		        System.out.println("Enter pressed");
    		        addRow();
    			}
    		}
    	});
        booksTable.setModel(model);
        booksTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        booksTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        booksTable.setForeground(new java.awt.Color(51, 51, 51));
        
        booksTable.setToolTipText("");
        booksTable.setRowHeight(18);
        booksTable.setRequestFocusEnabled(false);
        booksTable.setGridColor(new Color(204, 204, 255));
        booksTable.setCellSelectionEnabled(true);
        booksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setColumnHeaderView(booksTable.getTableHeader());
        jScrollPane1.setViewportView(booksTable);
        
    }
    
}
