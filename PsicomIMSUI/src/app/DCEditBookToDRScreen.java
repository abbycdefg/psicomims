package app;
import java.awt.Color;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class DCEditBookToDRScreen extends javax.swing.JFrame {

	String prevPage;
	
    /**
     * Creates new form DCEditBookToDRScreen
     */
	private String drNumber;
	private String dateToday;
	private String totalAmt;
	private float totalAmtInt;
	private String quantityCount;
	private Integer quantityCountInt;
	private String dateDelivery;
	private JComboBox poNumberComboBox = new JComboBox();
	private String poNumber;
	private String []po;
	private List<String> poList = new ArrayList<String>();
	private static List<String> booksList = new ArrayList<String>();
	private static List<String> quantityList = new ArrayList<String>();
	
    public DCEditBookToDRScreen(String page) {
        initComponents();
        
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
    }
    
    public DCEditBookToDRScreen(String drNumber1, String dateToday1, String totalAmt1, String dateDelivery1, String poNumber1, String page) {
        initComponents();
        
        prevPage = page;

        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
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
            totalAmtInt = Float.parseFloat(totalAmt);
            }
            else {
            totalAmtInt = 0;
            }      
            poNumber = poNumber1;
            System.out.println(poNumber + "check");
            if(!poNumber.equals(""))
            {
            	displayAll(poNumber);
            	poNumberComboBox.setSelectedItem(poNumber);
            }
            else {
            	displayAll("000");
            	
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

        editBookToDRLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Book to Delivery Receipt");
        setResizable(false);

        editBookToDRLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        editBookToDRLabel.setForeground(new java.awt.Color(255, 255, 255));
        editBookToDRLabel.setText("EDIT BOOK TO DELIVERY RECEIPT");

        booksTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        booksTable.setForeground(new java.awt.Color(51, 51, 51));
        booksTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
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
        editButton.setText("Edit Book to DR");
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
        
        JPanel poNumberPanel = new JPanel();
        poNumberPanel.setBackground(new Color(58, 80, 98));
        
        JLabel poNumberLabel = new JLabel();
        poNumberLabel.setText("PO Number:");
        poNumberLabel.setForeground(Color.WHITE);
        poNumberLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        
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
        poNumberComboBox.setEditable(true);
        

        poNumberComboBox.setFont(new Font("Calibri", Font.PLAIN, 12));
        
        JButton poSearchButton = new JButton("");
        poSearchButton.setIcon(new ImageIcon(DCEditBookToDRScreen.class.getResource("/images/button_search.png")));
        poSearchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        poSearchButton.setSelectedIcon(new ImageIcon(DCEditBookToDRScreen.class.getResource("/images/button_search2.png")));
        poSearchButton.setContentAreaFilled(false);
        poSearchButton.setBorderPainted(false);
        poSearchButton.setBorder(null);
        GroupLayout gl_poNumberPanel = new GroupLayout(poNumberPanel);
        gl_poNumberPanel.setHorizontalGroup(
        	gl_poNumberPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_poNumberPanel.createSequentialGroup()
        			.addGap(20)
        			.addComponent(poNumberLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(poNumberComboBox, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(poSearchButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(14, Short.MAX_VALUE))
        );
        gl_poNumberPanel.setVerticalGroup(
        	gl_poNumberPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_poNumberPanel.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_poNumberPanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(poSearchButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_poNumberPanel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(poNumberLabel)
        					.addComponent(poNumberComboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        poNumberPanel.setLayout(gl_poNumberPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(197)
        					.addComponent(editButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(261)
        					.addComponent(editBookToDRLabel))
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
        			.addComponent(editBookToDRLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(poNumberPanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(editButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
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
    }// </editor-fold>//GEN-END:initComponents
    

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
   	    		float quantInt = Float.parseFloat(quantitySelected);
   	    		quantityList.add(quantitySelected);     
       	    	if(booksTable.getModel().getValueAt(i,3) != null)
       	    	{
       	    		float amountSelected = Float.parseFloat(booksTable.getModel().getValueAt(i,3).toString());
       	    		totalAmtInt += amountSelected*quantInt;
       	    	}
   	    	}
         	}
         	
         	totalAmt = Float.toString(totalAmtInt);
         	
         }
         catch (Exception e){
             e.printStackTrace();
         }
     	this.dispose();
     	DCEditDeliveryReceiptScreen a = new DCEditDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList, poNumber, "");
     	
        if (prevPage.equals("")){
        	a = new DCEditDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList, poNumber, "");
        }
        else if (prevPage.equals("ad")){
        	a = new DCEditDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList, poNumber, "ad");
        }
        
        a.setVisible(true);
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	this.dispose();
     	DCEditDeliveryReceiptScreen a = new DCEditDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList, poNumber, "");

     	if (prevPage.equals("")){
        	a = new DCEditDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList, poNumber, "");
        }
        else if (prevPage.equals("ad")){
        	a = new DCEditDeliveryReceiptScreen(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList, poNumber, "ad");
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
            java.util.logging.Logger.getLogger(DCEditBookToDRScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCEditBookToDRScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCEditBookToDRScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCEditBookToDRScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCEditBookToDRScreen("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable booksTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel editBookToDRLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    
    public void getPoList()
    {
			PreparedStatement pst;
			Connection con;
			
			try {

				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
				pst = (PreparedStatement) con.prepareStatement("SELECT po_id FROM specific_po");
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
    public void getBookList()
    {
			PreparedStatement pst;
			Connection con;
			
			try {

				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
				pst = (PreparedStatement) con.prepareStatement("SELECT * FROM specific_dr");
				ResultSet rs = pst.executeQuery();
				int i = 0;
			    Set<String> bookSetList = new HashSet();
			    Set<String> quantitySetList = new HashSet();
				while (rs.next()) {
					if(rs.getString("dr_id").equals(drNumber))
					{
						bookSetList.add(rs.getString("book_id"));
						quantitySetList.add(rs.getString("quantity"));
					}
					i++;
				}
				booksList = new ArrayList<String>();
				quantityList = new ArrayList<String>();
				
				booksList.addAll(bookSetList);
				quantityList.addAll(quantitySetList);
				System.out.println(booksList + "bookList");
				System.out.println(quantityList+ "quantityList");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public void displayAll(String poNumber){
    	String[] columnNames = {"TITLE", "ITEM CODE", "QUANTITY", "SALES PRICE", "SRP"};

        DefaultTableModel model = new DefaultTableModel(){
        	@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
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
        	int i = 0;
        	Class.forName("com.mysql.jdbc.Driver");
        	con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
        	if(!poNumber.equals("000"))
        	{
            pst = (PreparedStatement) con.prepareStatement("SELECT b.title, b.item_code, p.quantity, o.discount_percent, b.price FROM psicomims.book b, psicomims.specific_po p, psicomims.purchase_order po, psicomims.outlet o WHERE b.item_code=p.book_id AND p.po_id=po.purchase_order_number AND o.outlet_name=po.outlet AND p.po_id='" + poNumber + "'");
            ResultSet rs = pst.executeQuery();
            

            while (rs.next()) {
            	title = rs.getString("title");
                itemCode = rs.getString("item_code");
                srp = rs.getString("price");
                quantity = rs.getString("quantity");
                discountedPrice = Float.toString(Float.parseFloat(rs.getString("price")) - (Float.parseFloat(rs.getString("price")) * Float.parseFloat(rs.getString("discount_percent")))/100);
                model.addRow(new Object[]{title, itemCode, quantity, discountedPrice, srp});
                i++;
            }
        	}
        	else {
        		 pst = (PreparedStatement) con.prepareStatement("SELECT b.title, b.item_code, d.quantity, o.discount_percent, b.price FROM psicomims.book b, psicomims.specific_dr d, psicomims.delivery_receipt dr, psicomims.outlet o WHERE b.item_code=d.book_id AND d.dr_id=dr.delivery_receipt_number AND o.outlet_name=dr.outlet AND d.dr_id='" + drNumber + "'");
                 ResultSet rs = pst.executeQuery();

                 while (rs.next()) {
                 	title = rs.getString("title");
                     itemCode = rs.getString("item_code");
                     srp = rs.getString("price");
                     quantity = rs.getString("quantity");
                     discountedPrice = Float.toString(Float.parseFloat(rs.getString("price")) - (Float.parseFloat(rs.getString("price")) * Float.parseFloat(rs.getString("discount_percent")))/100);
                     model.addRow(new Object[]{title, itemCode, quantity, discountedPrice, srp});
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
        jScrollPane1.setColumnHeaderView(booksTable.getTableHeader());
        jScrollPane1.getViewport().add(booksTable);
       
    }
}
