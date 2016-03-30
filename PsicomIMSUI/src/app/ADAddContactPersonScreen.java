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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class ADAddContactPersonScreen extends javax.swing.JFrame {

    /**
     * Creates new form ADAddContactPersonScreen
     */
	private int idNumber = 0;
    public ADAddContactPersonScreen() {
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

        addContactPersonLabel = new javax.swing.JLabel();
        contactPersonNameLabel = new javax.swing.JLabel();
        contactPersonNameField = new javax.swing.JTextField();
        dateCreatedLabel = new javax.swing.JLabel();
        dateCreatedChooser = new com.toedter.calendar.JDateChooser();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Contact Person");
        setResizable(false);

        addContactPersonLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addContactPersonLabel.setForeground(new java.awt.Color(255, 255, 255));
        addContactPersonLabel.setText("ADD CONTACT PERSON");

        contactPersonNameLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        contactPersonNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactPersonNameLabel.setText("Contact Person Name");

        contactPersonNameField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        contactPersonNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactPersonNameFieldActionPerformed(evt);
            }
        });

        dateCreatedLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        dateCreatedLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateCreatedLabel.setText("Date Created");

        addButton.setBackground(new java.awt.Color(205, 0, 69));
        addButton.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Contact Person");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(107, Short.MAX_VALUE)
        			.addComponent(addContactPersonLabel)
        			.addGap(98))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(54)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(dateCreatedLabel)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(dateCreatedChooser, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(contactPersonNameField)
        					.addComponent(contactPersonNameLabel)
        					.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        						.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(addContactPersonLabel)
        			.addGap(51)
        			.addComponent(contactPersonNameLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(contactPersonNameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(29)
        			.addComponent(dateCreatedLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(dateCreatedChooser, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(52))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactPersonNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactPersonNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactPersonNameFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    	HashMap map;
        if(!contactPersonNameField.getText().equals("") && dateCreatedChooser.getDate() != null)
        {
        	if(this.isAlpha(contactPersonNameField.getText())){
	    	  try{;
		            String contactPersonName = contactPersonNameField.getText();
		            
		            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		            Date dc = dateCreatedChooser.getDate();
		            String dateCreated = df.format(dc);
		            
		            try{
		                map = doCommand("addContactPerson", contactPersonName, dateCreated);
		                
		            }
		            catch (Exception e){
		                e.printStackTrace();
		            }
		            
		            cancelButton.setEnabled(false);
		            
		        	this.dispose();
		        	ADContactPersonsTab a = new ADContactPersonsTab();
		        	a.setVisible(true);
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
	    	  }
        	else
        	{
        		JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
    	}
        else{
    		JOptionPane.showMessageDialog(null, "Missing input", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    	this.dispose();
    	ADContactPersonsTab a = new ADContactPersonsTab();
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
            java.util.logging.Logger.getLogger(ADAddContactPersonScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADAddContactPersonScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADAddContactPersonScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADAddContactPersonScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADAddContactPersonScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addContactPersonLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField contactPersonNameField;
    private javax.swing.JLabel contactPersonNameLabel;
    private com.toedter.calendar.JDateChooser dateCreatedChooser;
    private javax.swing.JLabel dateCreatedLabel;
    // End of variables declaration//GEN-END:variables
    
    private HashMap doCommand(String command, String contactPersonName, String dateCreated) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("contactPersonName", contactPersonName);
        map.put("dateCreated", dateCreated);

        
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
