package app;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
public class ADEditContactPersonScreen extends javax.swing.JFrame {

    /**
     * Creates new form ADEditContactPersonScreen
     */
    public ADEditContactPersonScreen() {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        String contactPersonId = ADContactPersonsTab.getSecondColumnData();
    	String contactPersonName =  ADContactPersonsTab.getFirstColumnData();
    	String date = ADContactPersonsTab.getThirdColumnData();
        
    	
        contactPersonIDField.setText(contactPersonId);
        contactPersonIDField.setEnabled(false);
        contactPersonNameField.setText(contactPersonName);        

        try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date dateCreated = df.parse(date);
			dateCreatedChooser.setDate(dateCreated);
			dateCreatedChooser.setEnabled(false);
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

        addContactPersonLabel = new javax.swing.JLabel();
        contactPersonIDLabel = new javax.swing.JLabel();
        contactPersonIDField = new javax.swing.JTextField();
        contactPersonNameLabel = new javax.swing.JLabel();
        contactPersonNameField = new javax.swing.JTextField();
        dateCreatedLabel = new javax.swing.JLabel();
        dateCreatedChooser = new com.toedter.calendar.JDateChooser();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Contact Person");
        setResizable(false);

        addContactPersonLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addContactPersonLabel.setForeground(new java.awt.Color(255, 255, 255));
        addContactPersonLabel.setText("EDIT CONTACT PERSON");

        contactPersonIDLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        contactPersonIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactPersonIDLabel.setText("Contact Person ID");

        contactPersonIDField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        contactPersonIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactPersonIDFieldActionPerformed(evt);
            }
        });

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

        editButton.setBackground(new java.awt.Color(205, 0, 69));
        editButton.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Contact Person");
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
        cancelButton.setToolTipText("");
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
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contactPersonIDLabel)
                    .addComponent(contactPersonNameLabel)
                    .addComponent(contactPersonIDField)
                    .addComponent(contactPersonNameField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(dateCreatedLabel))
                    .addComponent(dateCreatedChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addContactPersonLabel)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addContactPersonLabel)
                .addGap(29, 29, 29)
                .addComponent(contactPersonIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactPersonIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contactPersonNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactPersonNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateCreatedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateCreatedChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactPersonIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactPersonIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactPersonIDFieldActionPerformed

    private void contactPersonNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactPersonNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactPersonNameFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
    	HashMap map;
    	
        if(!contactPersonIDField.getText().equals("") && !contactPersonNameField.getText().equals(""))
        {
        	if(this.isAlpha(contactPersonNameField.getText()) && this.isNumeric(contactPersonIDField.getText())){
        		try{
                	String contactPersonId = contactPersonIDField.getText();
                    String contactPersonName = contactPersonNameField.getText();         

                    try{
                        map = doCommand("editContactPerson", contactPersonId, contactPersonName);
                        
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
    	
    	
        
    }//GEN-LAST:event_editButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ADEditContactPersonScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADEditContactPersonScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADEditContactPersonScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADEditContactPersonScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADEditContactPersonScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addContactPersonLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField contactPersonIDField;
    private javax.swing.JLabel contactPersonIDLabel;
    private javax.swing.JTextField contactPersonNameField;
    private javax.swing.JLabel contactPersonNameLabel;
    private com.toedter.calendar.JDateChooser dateCreatedChooser;
    private javax.swing.JLabel dateCreatedLabel;
    private javax.swing.JButton editButton;
    // End of variables declaration//GEN-END:variables
    
    private HashMap doCommand(String command, String contactPersonId, String contactPersonName) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("contactPersonId", contactPersonId);
        map.put("contactPersonName", contactPersonName);

        
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
