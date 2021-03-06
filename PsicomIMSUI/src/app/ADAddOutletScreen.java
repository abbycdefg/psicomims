package app;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class ADAddOutletScreen extends javax.swing.JFrame {

    /**
     * Creates new form ADAddOutletTab
     */
	
    public ADAddOutletScreen() {
        initComponents();
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        Date now = new Date();
        dateCreatedChooser.setDate(now);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addOutletLabel = new javax.swing.JLabel();
        outletNameLabel = new javax.swing.JLabel();
        outletNameField = new javax.swing.JTextField();
        dateCreatedLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        dateCreatedChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Outlet");
        setResizable(false);

        addOutletLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addOutletLabel.setForeground(new java.awt.Color(255, 255, 255));
        addOutletLabel.setText("ADD OUTLET");

        outletNameLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        outletNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        outletNameLabel.setText("Outlet Name");

        outletNameField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        outletNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outletNameFieldActionPerformed(evt);
            }
        });

        dateCreatedLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        dateCreatedLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateCreatedLabel.setText("Date Created");

        addButton.setBackground(new java.awt.Color(205, 0, 69));
        addButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Outlet");
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
        cancelButton.setToolTipText("");
        cancelButton.setBorder(null);
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        
        discountField = new JTextField();
        discountField.setFont(new Font("Calibri", Font.PLAIN, 12));
        
        discountLabel = new JLabel();
        discountLabel.setText("Discount (in per cent)");
        discountLabel.setForeground(Color.WHITE);
        discountLabel.setFont(new Font("Calibri", Font.PLAIN, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(135)
        					.addComponent(addOutletLabel))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(58)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(outletNameField)
        						.addGroup(layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(dateCreatedChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
        								.addComponent(dateCreatedLabel)
        								.addComponent(discountField, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
        								.addComponent(discountLabel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(outletNameLabel))))
        			.addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(addOutletLabel)
        			.addGap(50)
        			.addComponent(outletNameLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(outletNameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(discountLabel)
        			.addGap(7)
        			.addComponent(discountField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(dateCreatedLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addGap(4)
        			.addComponent(dateCreatedChooser, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(57, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void outletNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outletNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outletNameFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    	HashMap map;
        if( !outletNameField.getText().equals("") && dateCreatedChooser.getDate() != null && !discountField.getText().equals("") && isNumeric(discountField.getText()) == true)
        {
        	
        		try{
                    String outletName = outletNameField.getText();
                    
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date dc = dateCreatedChooser.getDate();
                    String dateCreated = df.format(dc);
                    
                    String discountPercent = discountField.getText();
                    
                    try{                   	
                        map = doCommand("addOutlet", outletName, dateCreated, discountPercent);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    
                    cancelButton.setEnabled(false);
                    
                	this.dispose();
                	ADOutletsTab a = new ADOutletsTab();
                	a.setVisible(true);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
	    	  }
        	else if (!discountField.getText().equals("") && isNumeric(discountField.getText()) == false)
        	{
        		JOptionPane.showMessageDialog(null, "Please enter a numeric discount value.", "Error", JOptionPane.ERROR_MESSAGE);
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null, "All field are required.", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
    	}

    
    //GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    	this.dispose();
    	ADOutletsTab a = new ADOutletsTab();
    	a.setVisible(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ADAddOutletScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADAddOutletScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADAddOutletScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADAddOutletScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADAddOutletScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addOutletLabel;
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser dateCreatedChooser;
    private javax.swing.JLabel dateCreatedLabel;
    private javax.swing.JTextField outletNameField;
    private javax.swing.JLabel outletNameLabel;
    private JTextField discountField;
    private JLabel discountLabel;
    // End of variables declaration//GEN-END:variables
    
    private HashMap doCommand(String command, String outletName, String dateCreated, String discountPercent) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("outletName", outletName);
        map.put("dateCreated", dateCreated);
        map.put("discountPercent", discountPercent);

        
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


    private static void printMessage(HashMap map)
    {
        System.out.println(map.get("message"));
    }
    
    public boolean isAlpha(String s) {
    	String s1 = s.replaceAll("\\s+","");
        return s1.matches("[a-zA-Z]+");
    }
    
    public static boolean isNumeric(String s)
    {
      return s.matches("-?\\d+(\\.\\d+)?");
    }
}
