package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

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
public class DCEditDeliveryReceiptScreen extends javax.swing.JFrame {

    /**
     * Creates new form DCEditDeliveryReceiptScreen
     */
	private List<String> booksList = new ArrayList<String>();
	private List<String> quantityList= new ArrayList<String>();
	private String poNumber = "";
	private String outlet = "";
    public DCEditDeliveryReceiptScreen() {
        initComponents();
        
         Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        editBooksButton.setOpaque(false);
        editBooksButton.setContentAreaFilled(false);
        editBooksButton.setBorderPainted(false);
        editBooksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            Font originalFont = null;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                originalFont = editBooksButton.getFont();
                Map attributes = originalFont.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                editBooksButton.setFont(originalFont.deriveFont(attributes));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editBooksButton.setFont(originalFont);
            }
        });
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
    }
    
    public DCEditDeliveryReceiptScreen(String drNumber, String dateTodayStr, String totalAmt, String deliveryDateStr) {
        initComponents();
        
         Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        editBooksButton.setOpaque(false);
        editBooksButton.setContentAreaFilled(false);
        editBooksButton.setBorderPainted(false);
        editBooksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            Font originalFont = null;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                originalFont = editBooksButton.getFont();
                Map attributes = originalFont.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                editBooksButton.setFont(originalFont.deriveFont(attributes));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editBooksButton.setFont(originalFont);
            }
        });
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        deliveryReceiptNumberField.setText(drNumber);
        deliveryReceiptNumberField.setEditable(false);
        
        try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date dateToday = df.parse(dateTodayStr);
			dateTodayChooser.setDate(dateToday);
			

			java.util.Date deliveryDate = df.parse(deliveryDateStr);
			deliveryDateChooser.setDate(deliveryDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        totalAmountField.setText(totalAmt);
        totalAmountField.setEditable(false);
    }

    public DCEditDeliveryReceiptScreen(String drNumber, String dateTodayStr, String totalAmt, String deliveryDateStr, List<String> booksList1, List<String> quantityList1, String poNumber) {
        initComponents();
        
         Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        editBooksButton.setOpaque(false);
        editBooksButton.setContentAreaFilled(false);
        editBooksButton.setBorderPainted(false);
        editBooksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            Font originalFont = null;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                originalFont = editBooksButton.getFont();
                Map attributes = originalFont.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                editBooksButton.setFont(originalFont.deriveFont(attributes));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editBooksButton.setFont(originalFont);
            }
        });
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        deliveryReceiptNumberField.setText(drNumber);
        deliveryReceiptNumberField.setEditable(false);
        
        try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date dateToday = df.parse(dateTodayStr);
			dateTodayChooser.setDate(dateToday);
			

			java.util.Date deliveryDate = df.parse(deliveryDateStr);
			deliveryDateChooser.setDate(deliveryDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        totalAmountField.setText(totalAmt);
        totalAmountField.setEditable(false);

        booksList = booksList1;
        quantityList = quantityList1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editDeliveryReceiptLabel = new javax.swing.JLabel();
        deliveryReceiptNumberLabel = new javax.swing.JLabel();
        dateTodayLabel = new javax.swing.JLabel();
        deliveryReceiptNumberField = new javax.swing.JTextField();
        dateTodayChooser = new com.toedter.calendar.JDateChooser();
        editBooksButton = new javax.swing.JButton();
        totalAmountLabel = new javax.swing.JLabel();
        totalAmountField = new javax.swing.JTextField();
        deliveryDateLabel = new javax.swing.JLabel();
        deliveryDateChooser = new com.toedter.calendar.JDateChooser();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Delivery Receipt");
        setResizable(false);

        editDeliveryReceiptLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        editDeliveryReceiptLabel.setForeground(new java.awt.Color(255, 255, 255));
        editDeliveryReceiptLabel.setText("EDIT DELIVERY RECEIPT");

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

        editBooksButton.setBackground(new java.awt.Color(255, 255, 255));
        editBooksButton.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        editBooksButton.setForeground(new java.awt.Color(255, 255, 255));
        editBooksButton.setText("Click here to edit books");
        editBooksButton.setToolTipText("");
        editBooksButton.setBorder(null);
        editBooksButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBooksButtonActionPerformed(evt);
            }
        });

        totalAmountLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        totalAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalAmountLabel.setText("Total Amount");

        totalAmountField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        totalAmountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountFieldActionPerformed(evt);
            }
        });

        deliveryDateLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        deliveryDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        deliveryDateLabel.setText("Delivery Date");

        editButton.setBackground(new java.awt.Color(205, 0, 69));
        editButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Delivery Receipt");
        editButton.setToolTipText("");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalAmountLabel))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deliveryDateLabel)
                            .addComponent(deliveryDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deliveryReceiptNumberLabel)
                            .addComponent(deliveryReceiptNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTodayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateTodayLabel))))
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(editDeliveryReceiptLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editBooksButton)
                        .addGap(249, 249, 249))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(editDeliveryReceiptLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deliveryReceiptNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTodayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deliveryReceiptNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTodayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(editBooksButton)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deliveryDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deliveryDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deliveryReceiptNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryReceiptNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deliveryReceiptNumberFieldActionPerformed

    private void editBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
         DCEditBookToDRScreen b = new DCEditBookToDRScreen(drNumber, dateTodayStr, totalAmt, deliveryDateStr, poNumber);
         b.setVisible(true);
    }

    private void totalAmountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	HashMap map;
         
         try{
        	String drNumber = "";
         	String quantityListStr = "";
         	String listString = "";
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
             java.util.Date dateToday = dateTodayChooser.getDate();
             String dateTodayStr = df.format(dateToday);
             
             String totalAmt = totalAmountField.getText();
             
             java.util.Date deliveryDate = deliveryDateChooser.getDate();
             String deliveryDateStr = df.format(deliveryDate);
             
             if (booksList != null || quantityList != null)
             {

             String[] strarray = booksList.toArray(new String[0]);
             listString = Arrays.toString(strarray);
             
             String[] quantityArr = quantityList.toArray(new String[0]);
             quantityListStr = Arrays.toString(quantityArr);
             }


             try{
            	 if (go == true)
            	 {
                map = doCommand("editDeliveryReceipt", drNumber, dateTodayStr, totalAmt, deliveryDateStr, listString, quantityListStr);
             	this.dispose();
             	DCIncompleteDeliveryReceiptsTab a = new DCIncompleteDeliveryReceiptsTab("", poNumber);
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
            java.util.logging.Logger.getLogger(DCEditDeliveryReceiptScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCEditDeliveryReceiptScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCEditDeliveryReceiptScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCEditDeliveryReceiptScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCEditDeliveryReceiptScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser dateTodayChooser;
    private javax.swing.JLabel dateTodayLabel;
    private com.toedter.calendar.JDateChooser deliveryDateChooser;
    private javax.swing.JLabel deliveryDateLabel;
    private javax.swing.JTextField deliveryReceiptNumberField;
    private javax.swing.JLabel deliveryReceiptNumberLabel;
    private javax.swing.JButton editBooksButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel editDeliveryReceiptLabel;
    private javax.swing.JTextField totalAmountField;
    private javax.swing.JLabel totalAmountLabel;
    // End of variables declaration//GEN-END:variables
    
    private HashMap doCommand(String command, String drNumber, String dateToday, String totalAmt, String dateDelivery, String booksList, String quantityList) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("drNumber", drNumber);
        map.put("dateToday", dateToday);
        map.put("totalAmt", totalAmt);
        map.put("dateDelivery", dateDelivery);
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
}
