package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
public class DCAddDeliveryReceiptScreen extends javax.swing.JFrame {

	String prevPage;
	
    /**
     * Creates new form DCAddDeliveryReceiptScreen
     */
	private List<String> booksList;
	private List<String> quantityList;
	private static String poNumber = "";
	private String outlet = "";
	private String drCount;
	public DCAddDeliveryReceiptScreen(String page) {
	        initComponents();
	        
	        prevPage = page;
	        
	        Color x = new Color(32, 55, 73);
	        this.getContentPane().setBackground(x);
	        
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
	        
	        Color y = new Color(205, 0, 69);
	        addButton.setBackground(y);
	        
	        Color z = new Color(102, 102, 102);
	        cancelButton.setBackground(z);
	        Date now = new Date();
	        dateTodayChooser.setDate(now);
	        deliveryDateChooser.setDate(now);
	        totalAmountField.setEditable(false);
	        dateTodayChooser.setEnabled(false);
	        getDrNumber();
	        deliveryReceiptNumberField.setText(drCount);
	    }
	   
    public DCAddDeliveryReceiptScreen(String page, String poNumber1) {
        initComponents();
        
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
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
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        Date now = new Date();
        dateTodayChooser.setDate(now);
        deliveryDateChooser.setDate(now);
        totalAmountField.setEditable(false);
        poNumber = poNumber1;
        getDrNumber();
        getOutlet(poNumber);
        deliveryReceiptNumberField.setText(drCount);
    }
    
    public DCAddDeliveryReceiptScreen(String drNumber, String dateTodayStr, String totalAmt, String deliveryDateStr, List<String> booksList1, List<String> quantityList1, String poNumber1, String page) {
        initComponents();
        
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
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
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        

        deliveryReceiptNumberField.setText(drNumber);
        
        try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date dateToday = df.parse(dateTodayStr);
			dateTodayChooser.setDate(dateToday);
			

			java.util.Date deliveryDate = df.parse(deliveryDateStr);
			deliveryDateChooser.setDate(deliveryDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        totalAmountField.setText(totalAmt);
        totalAmountField.setEditable(false);
        dateTodayChooser.setEnabled(false);
        booksList = booksList1;
        quantityList = quantityList1;
        poNumber = poNumber1;
        getOutlet(poNumber);
        getDrNumber();
        deliveryReceiptNumberField.setText(drCount);
        System.out.println(drCount);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addDeliveryReceiptLabel = new javax.swing.JLabel();
        deliveryReceiptNumberLabel = new javax.swing.JLabel();
        dateTodayLabel = new javax.swing.JLabel();
        dateTodayChooser = new com.toedter.calendar.JDateChooser();
        deliveryReceiptNumberField = new javax.swing.JTextField();
        deliveryDateChooser = new com.toedter.calendar.JDateChooser();
        deliveryDateLabel = new javax.swing.JLabel();
        totalAmountField = new javax.swing.JTextField();
        totalAmountLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        addBooksButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Delivery Receipt");
        setResizable(false);

        addDeliveryReceiptLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addDeliveryReceiptLabel.setForeground(new java.awt.Color(255, 255, 255));
        addDeliveryReceiptLabel.setText("ADD DELIVERY RECEIPT");

        deliveryReceiptNumberLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        deliveryReceiptNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        deliveryReceiptNumberLabel.setText("Delivery Receipt Number");

        dateTodayLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        dateTodayLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateTodayLabel.setText("Date Today");

        deliveryReceiptNumberField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        deliveryReceiptNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryReceiptNumberFieldActionPerformed(evt);
            }
        });

        deliveryDateLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        deliveryDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        deliveryDateLabel.setText("Delivery Date");

        totalAmountField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        totalAmountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountFieldActionPerformed(evt);
            }
        });

        totalAmountLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        totalAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalAmountLabel.setText("Total Amount");

        addButton.setBackground(new java.awt.Color(205, 0, 69));
        addButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Delivery Receipt");
        addButton.setToolTipText("");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalAmountLabel)
                    .addComponent(deliveryReceiptNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deliveryReceiptNumberLabel)
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTodayLabel)
                            .addComponent(dateTodayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deliveryDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deliveryDateLabel))))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(addDeliveryReceiptLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addBooksButton)
                .addGap(252, 252, 252))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addDeliveryReceiptLabel)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateTodayLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deliveryReceiptNumberLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateTodayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deliveryReceiptNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(addBooksButton)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalAmountLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deliveryDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deliveryDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(totalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        
        
    }// </editor-fold>//GEN-END:initComponents


    private void deliveryReceiptNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryReceiptNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deliveryReceiptNumberFieldActionPerformed

    private void totalAmountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 HashMap map;
         
         try{
        	String drNumber = "";
         	String quantityListStr = "";
         	String listString = "";
         	String order = "";
         	String dateTodayStr = "";
         	String deliveryDateStr = "";
         	int orderInt = 0;
         	boolean go = true;
         	
              
             
             if(checkNumber(deliveryReceiptNumberField.getText()) == true && checkCharacters(deliveryReceiptNumberField.getText()) == false )
             {
            	 drNumber = deliveryReceiptNumberField.getText();
             }
             else {
            	 go = false;
            	 JOptionPane.showMessageDialog(null, "Please enter a numeric delivery receipt code value.", "Error", JOptionPane.ERROR_MESSAGE);
             }
             DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
             Date now = new Date();
             java.util.Date dateToday = dateTodayChooser.getDate();
             
             dateTodayStr = df.format(dateToday);


             String totalAmt = totalAmountField.getText();
             
             java.util.Date deliveryDate = deliveryDateChooser.getDate();
             if(!deliveryDate.before(now))
             {
              deliveryDateStr = df.format(deliveryDate);
             }
             else {
            	 go = false;
            	 JOptionPane.showMessageDialog(null, "Please enter valid date.", "Error", JOptionPane.ERROR_MESSAGE);
             }
             if (booksList != null || quantityList != null)
             {
             String[] strarray = booksList.toArray(new String[0]);
             listString = Arrays.toString(strarray);
             
             String[] quantityArr = quantityList.toArray(new String[0]);
             quantityListStr = Arrays.toString(quantityArr);
             for(int i = 0 ; i < quantityList.size(); i++) {
            	 int quant = Integer.parseInt(quantityList.get(i).toString());
            	 orderInt += quant;
             	}
             
             order = Integer.toString(orderInt);
             }


             try{
            	 if (go == true)
            	 {
	                map = doCommand("addDeliveryReceipt", drNumber, dateTodayStr, totalAmt, deliveryDateStr, poNumber, order, outlet, listString, quantityListStr);
	             	this.dispose();
	             	DCIncompleteDeliveryReceiptsTab a = new DCIncompleteDeliveryReceiptsTab(poNumber, "");
	             	
		   	         if (prevPage.equals("")){
		   	         	a = new DCIncompleteDeliveryReceiptsTab(poNumber, "");		             	
		   	         }
		   	         else if (prevPage.equals("ad")){
		   	        	a = new DCIncompleteDeliveryReceiptsTab(poNumber, "ad");
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
       
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
     	this.dispose();
     	DCIncompleteDeliveryReceiptsTab a = new DCIncompleteDeliveryReceiptsTab("");
     	
        if (prevPage.equals("")){
        	a = new DCIncompleteDeliveryReceiptsTab("");
       	}
    	else if (prevPage.equals("ad")){
    		a = new DCIncompleteDeliveryReceiptsTab("ad");
     	}
        
        a.setVisible(true);
    }
   
    private void addBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 String drNumber = deliveryReceiptNumberField.getText();
         
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
         java.util.Date dateToday = dateTodayChooser.getDate();
         String dateTodayStr = df.format(dateToday);
         
         String totalAmt = totalAmountField.getText();
         if(drNumber.equals(null) ||drNumber.equals(totalAmt))
         {
        	 drNumber.equals("");
        	 totalAmt.equals("");
         }
         java.util.Date deliveryDate = deliveryDateChooser.getDate();
         String deliveryDateStr = df.format(deliveryDate);
         
         this.dispose();
         DCAddBookToDRScreen b = new DCAddBookToDRScreen(drNumber, dateTodayStr, totalAmt, deliveryDateStr, poNumber, "");
         
         if (prevPage.equals("")){
         	b = new DCAddBookToDRScreen(drNumber, dateTodayStr, totalAmt, deliveryDateStr, poNumber, "");
         }
         else if (prevPage.equals("ad")){
        	b = new DCAddBookToDRScreen(drNumber, dateTodayStr, totalAmt, deliveryDateStr, poNumber, "ad");
         }
         
         b.setVisible(true);

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
            java.util.logging.Logger.getLogger(DCAddDeliveryReceiptScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCAddDeliveryReceiptScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCAddDeliveryReceiptScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCAddDeliveryReceiptScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCAddDeliveryReceiptScreen("", poNumber).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBooksButton;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addDeliveryReceiptLabel;
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser dateTodayChooser;
    private javax.swing.JLabel dateTodayLabel;
    private com.toedter.calendar.JDateChooser deliveryDateChooser;
    private javax.swing.JLabel deliveryDateLabel;
    private javax.swing.JTextField deliveryReceiptNumberField;
    private javax.swing.JLabel deliveryReceiptNumberLabel;
    private javax.swing.JTextField totalAmountField;
    private javax.swing.JLabel totalAmountLabel;
    // End of variables declaration//GEN-END:variables
    
    private HashMap doCommand(String command, String drNumber, String dateToday, String totalAmt, String dateDelivery, String poNumber, String order, String outlet, String booksList, String quantityList) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("drNumber", drNumber);
        map.put("dateToday", dateToday);
        map.put("totalAmt", totalAmt);
        map.put("dateDelivery", dateDelivery);
        map.put("booksList", booksList);
        map.put("quantityList", quantityList);
        map.put("poNumber", poNumber);
        map.put("order", order);
        map.put("outlet", outlet);

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
    public void getOutlet(String poNumber1)
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM purchase_order");
    			ResultSet rs = pst.executeQuery();
    			while (rs.next()) {
    				if(poNumber1.equals(rs.getString("purchase_order_number")))
    				{
    					outlet = rs.getString("outlet");
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
    public void getDrNumber()
    {
    		String last = "";
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT delivery_receipt_number FROM psicomims.delivery_receipt ORDER BY delivery_receipt_number DESC LIMIT 1");
    			ResultSet rs = pst.executeQuery();
    			while (rs.next()) {
    				last = rs.getString("delivery_receipt_number");
    				int drCountInt = Integer.parseInt(last);
    				drCount = Integer.toString(drCountInt + 1);
    			}
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    	
    }    

}

