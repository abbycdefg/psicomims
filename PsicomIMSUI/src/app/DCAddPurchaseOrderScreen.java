package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.matchers.Matcher;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicComboBoxUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class DCAddPurchaseOrderScreen extends javax.swing.JFrame {

	
	private List<String> booksList;	
	private List<String> quantityList;
	private List<String> contactList  = new ArrayList<String>();
	private List<String> outletsList  = new ArrayList<String>();
    private JComboBox contactsComboBox = new JComboBox();    
    private JComboBox outletComboBox = new JComboBox();
	private String []co;
	private String []ou;
	private String poCount = "0";
	
	String prevPage;
	
    /**
     * Creates new form DCAddPurchaseOrderScreen
     */
    public DCAddPurchaseOrderScreen(String page) {
        initComponents();
        
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        addBooksButton.setOpaque(false);
        addBooksButton.setContentAreaFilled(false);
        addBooksButton.setBorderPainted(false);
        addBooksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            Font originalFont = null;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                originalFont = addBooksButton.getFont();
                Map attributes = originalFont.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                addBooksButton.setFont(originalFont.deriveFont(attributes));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBooksButton.setFont(originalFont);
            }
        });
        
        getContactPersonList();
        getOutletList();
        getPoNumber();
        
        int po = Integer.parseInt(poCount) + 1;

        purchaseOrderNumberField.setText(Integer.toString(po));
        
        co = new String[contactList.size()];
        contactList.toArray(co);
        AutoCompleteSupport.install(contactsComboBox, GlazedLists.eventListOf(co));
        
        ou = new String[outletsList.size()];
        outletsList.toArray(ou);
        AutoCompleteSupport.install(outletComboBox, GlazedLists.eventListOf(ou));
        
        Date now = new Date();
        jDateChooser1.setDate(now);
    }

    public DCAddPurchaseOrderScreen(String purchaseOrderNumber1,  String dateToday1, String contactPerson1, String outlet1, List<String> booksList1, List<String> quantityList1, String page) {
        initComponents();
        
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        addBooksButton.setOpaque(false);
        addBooksButton.setContentAreaFilled(false);
        addBooksButton.setBorderPainted(false);
        addBooksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            Font originalFont = null;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                originalFont = addBooksButton.getFont();
                Map attributes = originalFont.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                addBooksButton.setFont(originalFont.deriveFont(attributes));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBooksButton.setFont(originalFont);
            }
        });
        getContactPersonList();
        getOutletList();
        
        co = new String[contactList.size()];
        contactList.toArray(co);
        AutoCompleteSupport.install(contactsComboBox, GlazedLists.eventListOf(co));
        
        ou = new String[outletsList.size()];
        outletsList.toArray(ou);
        AutoCompleteSupport.install(outletComboBox, GlazedLists.eventListOf(ou));
        
        
       purchaseOrderNumberField.setText(purchaseOrderNumber1);
       contactsComboBox.setSelectedItem(contactPerson1);
       outletComboBox.setSelectedItem(outlet1);
        
        booksList = booksList1;
        quantityList = quantityList1;
        System.out.println(quantityList + "quantityList3");
        
        try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date dateToday = df.parse(dateToday1);
			jDateChooser1.setDate(dateToday);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

        addPurchaseOrderLabel = new javax.swing.JLabel();
        purchaseOrderNumberLabel = new javax.swing.JLabel();
        purchaseOrderNumberField = new javax.swing.JTextField();
        dateTodayLabel = new javax.swing.JLabel();
        outletLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        contactPersonLabel = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        addBooksButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Purchase Order");
        setResizable(false);

        addPurchaseOrderLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addPurchaseOrderLabel.setForeground(new java.awt.Color(255, 255, 255));
        addPurchaseOrderLabel.setText("ADD PURCHASE ORDER");

        purchaseOrderNumberLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        purchaseOrderNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        purchaseOrderNumberLabel.setText("Purchase Order Number");

        purchaseOrderNumberField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        purchaseOrderNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseOrderNumberFieldActionPerformed(evt);
            }
        });

        dateTodayLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        dateTodayLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateTodayLabel.setText("Date Today");

        outletLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        outletLabel.setForeground(new java.awt.Color(255, 255, 255));
        outletLabel.setText("Outlet");

        addButton.setBackground(new java.awt.Color(205, 0, 69));
        addButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Purchase Order");
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

        contactPersonLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        contactPersonLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactPersonLabel.setText("Contact Person");

        addBooksButton.setBackground(new java.awt.Color(255, 255, 255));
        addBooksButton.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        addBooksButton.setForeground(new java.awt.Color(255, 255, 255));
        addBooksButton.setText("Click here to add books");
        addBooksButton.setBorder(null);
        addBooksButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBooksButtonActionPerformed(evt);
            }
        });
        
        contactsComboBox.setUI(new BasicComboBoxUI() { // make the down arrow invisible
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
        outletComboBox.setUI(new BasicComboBoxUI() { // make the down arrow invisible
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(235)
        					.addComponent(addPurchaseOrderLabel))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(135)
        					.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(62)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(contactPersonLabel)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(contactsComboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(purchaseOrderNumberLabel, Alignment.LEADING)
        							.addComponent(purchaseOrderNumberField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
        					.addGap(54)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(outletComboBox, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
        						.addComponent(outletLabel)
        						.addComponent(dateTodayLabel)
        						.addComponent(jDateChooser1, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))))
        			.addContainerGap())
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(267, Short.MAX_VALUE)
        			.addComponent(addBooksButton)
        			.addGap(214))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(addPurchaseOrderLabel)
        			.addGap(28)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(purchaseOrderNumberLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        				.addComponent(dateTodayLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jDateChooser1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(purchaseOrderNumberField, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(contactPersonLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        				.addComponent(outletLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(contactsComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(outletComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        			.addComponent(addBooksButton)
        			.addGap(30)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(40))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseOrderNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseOrderNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseOrderNumberFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    	HashMap map;

        try{
        	String contactPerson = "";
        	String outlet = "";
        	String quantityListStr = "";
        	String listString = "";
        	String purchaseOrderNumber = "";
        	boolean error = false;

            
            
            if(contactsComboBox.getSelectedIndex() != -1 && outletComboBox.getSelectedIndex() != -1 && !purchaseOrderNumberField.getText().equals("")){
              if( checkString(purchaseOrderNumberField.getText().toString())== false)
             {contactPerson = contactsComboBox.getSelectedItem().toString();
             outlet = outletComboBox.getSelectedItem().toString();
             purchaseOrderNumber = purchaseOrderNumberField.getText();
             }
              
              else{
              	JOptionPane.showMessageDialog(null, "Invalid characters.", "Error", JOptionPane.ERROR_MESSAGE);
                error = true;
              }
            }
            else 
            {
            	JOptionPane.showMessageDialog(null, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
                       

            
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date dc = jDateChooser1.getDate();
            String dateToday = df.format(dc);
            
            if (booksList != null || quantityList != null)
            {
            String[] strarray = booksList.toArray(new String[0]);
            listString = Arrays.toString(strarray);
            
            String[] quantityArr = quantityList.toArray(new String[0]);
            quantityListStr = Arrays.toString(quantityArr);
            }
            else {
            	listString = "";
            	quantityListStr = "";
            }


            try{
            	if(error == false)
            	{
                map = doCommand("addPurchaseOrder", purchaseOrderNumber, dateToday, contactPerson, outlet, listString, quantityListStr);
                String output = (String) map.get("message"); 
                

                	this.dispose();
                	DCIncompletePurchaseOrdersTab a = new DCIncompletePurchaseOrdersTab("");
                	
	       	        if (prevPage.equals("")){
	       	        	a = new DCIncompletePurchaseOrdersTab("");
	       	        }
	       	        else if (prevPage.equals("ad")){
	       	        	a = new DCIncompletePurchaseOrdersTab("ad");
	       	        }
                    
                    a.setVisible(true);
            	}
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
     	this.dispose();
    	DCIncompletePurchaseOrdersTab a = new DCIncompletePurchaseOrdersTab("");
    	
        if (prevPage.equals("")){
        	a = new DCIncompletePurchaseOrdersTab("");
       	}
    	else if (prevPage.equals("ad")){
    		a = new DCIncompletePurchaseOrdersTab("ad");
     	}
        
        a.setVisible(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBooksButtonActionPerformed
    	String purchaseOrderNumber = "";
    	String contactPerson = "";
    	String outlet ="";

    	purchaseOrderNumber = purchaseOrderNumberField.getText();

    	
    	if(contactsComboBox.getSelectedIndex() != -1){
        contactPerson = contactsComboBox.getSelectedItem().toString();
    	}
    	if(outletComboBox.getSelectedIndex() != -1) {
        outlet = outletComboBox.getSelectedItem().toString();
    	}
        
        
        System.out.println(quantityList + "quantityList2");
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date dc = jDateChooser1.getDate();
        String dateToday = df.format(dc);
        
        
        if(purchaseOrderNumber.equals(null))
        {
        	purchaseOrderNumber.equals("");
        }
        
        this.dispose();    
        DCAddBookToPOScreen a = new DCAddBookToPOScreen(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList, "");
    	
        if (prevPage.equals("")){
        	a = new DCAddBookToPOScreen(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList, "");
        }
        else if (prevPage.equals("ad")){
        	a = new DCAddBookToPOScreen(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList, "ad");
        }
        
        a.setVisible(true);
    	
    	
    }//GEN-LAST:event_addBooksButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DCAddPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCAddPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCAddPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCAddPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCAddPurchaseOrderScreen("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBooksButton;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addPurchaseOrderLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel contactPersonLabel;
    private javax.swing.JLabel dateTodayLabel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel outletLabel;
    private javax.swing.JTextField purchaseOrderNumberField;
    private javax.swing.JLabel purchaseOrderNumberLabel;
    // End of variables declaration//GEN-END:variables
    
    private HashMap doCommand(String command, String purchaseOrderNumber, String dateToday, String contactPerson, String outlet, String booksList, String quantityList) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("purchaseOrderNumber", purchaseOrderNumber);
        map.put("dateToday", dateToday);
        map.put("contactPerson", contactPerson);
        map.put("outlet", outlet);
        map.put("booksList", booksList);
        map.put("quantityList", quantityList);
        
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

    private boolean checkNumber(String text) {
    	try{
    		 Integer.parseInt( text );
    	      return true;
    	}
    	catch (Exception e){
    		return false;
    	}
    }
    
    private boolean checkCharacters(String text) {
    	try{
    		String thePattern = "[^A-Za-z0-9]+"; 
    		Pattern.compile(thePattern).matcher(text).find();
    	      return false;
    	}
    	catch (Exception e){
    		return true;
    	}
    }
    private static void printMessage(HashMap map)
    {
        System.out.println(map.get("message"));
    }
    public void getContactPersonList()
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM contact_person LIMIT 5");
    			ResultSet rs = pst.executeQuery();
    		    Set<String> contactPersonSet = new HashSet();
    		    int i = 0;
    			while (rs.next()) {
    				if(!rs.getString("contact_person_name").equals(null))
    				{
    					contactPersonSet.add(rs.getString("contact_person_name"));
    				}
    				i++;
    			}
    			contactList.addAll(contactPersonSet);
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }  
    
    public void getPoNumber()
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT purchase_order_number FROM psicomims.purchase_order ORDER BY purchase_order_number DESC LIMIT 1");
    			ResultSet rs = pst.executeQuery();
    			while (rs.next()) {
    				poCount = rs.getString("purchase_order_number");
    			}
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    	
    }    

    public void getOutletList()
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT outlet_name FROM outlet");
    			ResultSet rs = pst.executeQuery();
    		    Set<String> outletSet = new HashSet();
    			while (rs.next()) {
    				if(!rs.getString("outlet_name").equals(null))
    				{
    					outletSet.add(rs.getString("outlet_name"));
    				}
    			}
    			outletsList.addAll(outletSet);
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}		
    }
    private boolean checkString(String string)
    {
    	Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    	java.util.regex.Matcher m = p.matcher(string);
    	boolean b = m.find();
    	return b;
    }
}
